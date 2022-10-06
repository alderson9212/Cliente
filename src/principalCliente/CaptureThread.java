
package principalCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.digitalpersona.uareu.Fid;
import com.digitalpersona.uareu.Reader;
import com.digitalpersona.uareu.UareUException;

public class CaptureThread extends Thread {

    public static final String ACT_CAPTURE = "capture_thread_captured";

    public class CaptureEvent extends ActionEvent {

        private static final long serialVersionUID = 101;

        public Reader.CaptureResult capture_result;
        public Reader.Status reader_status;
        public UareUException exception;

        public CaptureEvent(Object source, String action, Reader.CaptureResult cr, Reader.Status st, UareUException ex) {
            super(source, ActionEvent.ACTION_PERFORMED, action);
            capture_result = cr;
            reader_status = st;
            exception = ex;
        }
    }

    private ActionListener m_listener;
    private boolean m_bCancel;
    private final Reader m_reader;
    private final boolean m_bStream;
    private final Fid.Format m_format;
    private final Reader.ImageProcessing m_proc;
    private CaptureEvent m_last_capture;

    public CaptureThread(Reader reader, boolean bStream, Fid.Format img_format, Reader.ImageProcessing img_proc) {
        m_bCancel = false;
        m_reader = reader;
        m_bStream = bStream;
        m_format = img_format;
        m_proc = img_proc;
    }

    public void start(ActionListener listener) {
        m_listener = listener;
        super.start();
    }

    public void join(int milliseconds) {
        try {
            super.join(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("Error: CaptureThread - join \n" + e.getMessage());
        }
    }

    public CaptureEvent getLastCaptureEvent() {
        return m_last_capture;
    }

    private void Capture() {
        synchronized (this) {
            try {
                // wait for reader to become ready
                boolean bReady = false;
                OUTER:
                while (!bReady && !m_bCancel) {
                    Reader.Status rs = m_reader.GetStatus();
                    if (null != rs.status) {
                        switch (rs.status) {
                            case BUSY:
                                // if busy, wait a bit
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    System.out.println("Error: CaptureThread - Capture \n" + e.getMessage());
                                    break OUTER;
                                }
                                break;
                            case READY:
                            case NEED_CALIBRATION:
                                // ready for capture
                                bReady = true;
                                break OUTER;
                            default:
                                // reader failure
                                NotifyListener(ACT_CAPTURE, null, rs, null);
                                break OUTER;
                        }
                    }
                }
                if (m_bCancel) {
                    Reader.CaptureResult cr = new Reader.CaptureResult();
                    cr.quality = Reader.CaptureQuality.CANCELED;
                    NotifyListener(ACT_CAPTURE, cr, null, null);
                }

                if (bReady) {
                    //capture
                    Reader.CaptureResult cr = m_reader.Capture(m_format, m_proc, m_reader.GetCapabilities().resolutions[0], -1);
                    NotifyListener(ACT_CAPTURE, cr, null, null);
                }
            } catch (UareUException e) {
                NotifyListener(ACT_CAPTURE, null, null, e);
            }
        }
    }

    private void Stream() {
        try {
            // wait for reader to become ready
            boolean bReady = false;
            OUTER:
            while (!bReady && !m_bCancel) {
                Reader.Status rs = m_reader.GetStatus();
                if (null != rs.status) {
                    switch (rs.status) {
                        case BUSY:
                            // if busy, wait a bit
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                System.out.println("Error: CaptureThread - Stream \n" + e.getMessage());
                                break OUTER;
                            }
                            break;
                        case READY:
                        case NEED_CALIBRATION:
                            // ready for capture
                            bReady = true;
                            break OUTER;
                        default:
                            // reader failure
                            NotifyListener(ACT_CAPTURE, null, rs, null);
                            break OUTER;
                    }
                }
            }

            if (bReady) {
                // start streaming
                m_reader.StartStreaming();

                // get images
                while (!m_bCancel) {
                    Reader.CaptureResult cr = m_reader.GetStreamImage(m_format, m_proc, 500);
                    NotifyListener(ACT_CAPTURE, cr, null, null);
                }

                // stop streaming
                m_reader.StopStreaming();
            }
        } catch (UareUException e) {
            NotifyListener(ACT_CAPTURE, null, null, e);
        }

        if (m_bCancel) {
            Reader.CaptureResult cr = new Reader.CaptureResult();
            cr.quality = Reader.CaptureQuality.CANCELED;
            NotifyListener(ACT_CAPTURE, cr, null, null);
        }
    }

    private void NotifyListener(String action, Reader.CaptureResult cr, Reader.Status st, UareUException ex) {
        final CaptureEvent evt = new CaptureEvent(this, action, cr, st, ex);

        // store last capture event
        m_last_capture = evt;

        if (null == m_listener || null == action || action.equals("")) {
            return;
        }

        // invoke listener on EDT thread
        javax.swing.SwingUtilities.invokeLater(() -> {
            m_listener.actionPerformed(evt);
        });
    }

    public void cancel() {
        m_bCancel = true;
        try {
            if (!m_bStream) {
                m_reader.CancelCapture();
            }
        } catch (UareUException e) {
        }
    }

    @Override
    public void run() {
        if (m_bStream) {
            Stream();
        } else {
            Capture();
        }
    }
    
}
