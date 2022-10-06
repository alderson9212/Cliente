/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principalCliente;

import com.digitalpersona.uareu.Engine;
import com.digitalpersona.uareu.Fid;
import com.digitalpersona.uareu.Fmd;
import com.digitalpersona.uareu.Reader;
import com.digitalpersona.uareu.UareUException;
import com.digitalpersona.uareu.UareUGlobal;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

/**
 *
 * @author gerardo
 */
public class Enrolar extends JPanel implements ActionListener {

    private static final long serialVersionUID = 6;

    private static final String ACT_BACK = "Regresar";

    private final EnrollmentThread m_enrollment;
    private final Reader m_reader;
    private JDialog m_dlgParent;
    private final JTextArea m_text;
    private boolean m_bJustStarted;
    private final JLabel m_jLabelCapturaHuella;
    private final JLabel m_jLabelManos;
    private final ImagePanel m_image;
    private final UtilidadesLector_1 utilidadesLector;
    private static List<Object> template;
    int intentos = 0;
    int dedoMarcado = 0;

    public class EnrollmentThread extends Thread implements Engine.EnrollmentCallback {

        public static final String ACT_PROMPT = "enrollment_prompt";
        public static final String ACT_CAPTURE = "enrollment_capture";
        public static final String ACT_FEATURES = "enrollment_features";
        public static final String ACT_DONE = "enrollment_done";
        public static final String ACT_CANCELED = "enrollment_canceled";

        public class EnrollmentEvent extends ActionEvent {

            private static final long serialVersionUID = 102;

            public Reader.CaptureResult capture_result;
            public Reader.Status reader_status;
            public UareUException exception;
            public Fmd enrollment_fmd;

            public EnrollmentEvent(Object source, String action, Fmd fmd, Reader.CaptureResult cr, Reader.Status st, UareUException ex) {
                super(source, ActionEvent.ACTION_PERFORMED, action);
                capture_result = cr;
                reader_status = st;
                exception = ex;
                enrollment_fmd = fmd;
            }
        }

        private final Reader m_reader;
        private CaptureThread m_capture;
        private final ActionListener m_listener;
        private boolean m_bCancel;

        protected EnrollmentThread(Reader reader, ActionListener listener) {
            m_reader = reader;
            m_listener = listener;
        }

        @Override
        public Engine.PreEnrollmentFmd GetFmd(Fmd.Format format) {
            Engine.PreEnrollmentFmd prefmd = null;

            while (null == prefmd && !m_bCancel) {
                //start capture thread
                m_capture = new CaptureThread(m_reader, false, Fid.Format.ANSI_381_2004, Reader.ImageProcessing.IMG_PROC_DEFAULT);
                m_capture.start(null);

                //prompt for finger
                SendToListener(ACT_PROMPT, null, null, null, null);

                //wait till done
                m_capture.join(0);

                //check result
                CaptureThread.CaptureEvent evt = m_capture.getLastCaptureEvent();
                if (null != evt.capture_result) {
                    if (Reader.CaptureQuality.CANCELED == evt.capture_result.quality) {
                        //capture canceled, return null
                        break;
                    } else if (null != evt.capture_result.image && Reader.CaptureQuality.GOOD == evt.capture_result.quality) {

                        //acquire engine
                        Engine engine = UareUGlobal.GetEngine();

                        try {
                            //estrae las caracteristicas
                            Fmd fmd = engine.CreateFmd(evt.capture_result.image, Fmd.Format.DP_PRE_REG_FEATURES);

                            // Agrega al aaray el Fid capturado del lector
                            template.add(evt.capture_result.image);

                            //return prefmd
                            prefmd = new Engine.PreEnrollmentFmd();
                            prefmd.fmd = fmd;
                            prefmd.view_index = 0;

                            // Muestra la imagen de la huella
                            m_image.showImage(evt.capture_result.image);
                            // Retorna la imagen al jLabel
                            Image img = new ImageIcon(utilidadesLector.createImage(m_image)).getImage();

                            //Aqui pinta la imagen en el label
                            m_jLabelCapturaHuella.setIcon(new ImageIcon(img.getScaledInstance(m_jLabelCapturaHuella.getPreferredSize().width, m_jLabelCapturaHuella.getPreferredSize().height, Image.SCALE_DEFAULT)));
                            jLabelIntentos.setText(String.valueOf(++intentos));
                            PintarDedos pinta = new PintarDedos();

                            //Guardamos la huella final
                            if (Integer.parseInt(jLabelIntentos.getText()) == 4) {
                                pinta.imagenManos();
                                switch (dedoMarcado) {
                                    case 0:
                                        pinta.cargarDedo(dedoMarcado, m_jLabelManos);
                                        pinta.cargarDedoSiguiente(dedoMarcado + 1, m_jLabelManos);
                                        break;
                                    case 1:
                                        pinta.cargarDedo(dedoMarcado, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 1, m_jLabelManos);
                                        pinta.cargarDedoSiguiente(dedoMarcado + 1, m_jLabelManos);
                                        break;
                                    case 2:
                                        pinta.cargarDedo(dedoMarcado, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 1, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 2, m_jLabelManos);
                                        pinta.cargarDedoSiguiente(dedoMarcado + 1, m_jLabelManos);
                                        break;
                                    case 3:
                                        pinta.cargarDedo(dedoMarcado, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 1, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 2, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 3, m_jLabelManos);                                        
                                        pinta.cargarDedoSiguiente(dedoMarcado + 1, m_jLabelManos);
                                        break;
                                    case 4:
                                        pinta.cargarDedo(dedoMarcado, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 1, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 2, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 3, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 4, m_jLabelManos);
                                        pinta.cargarDedoSiguiente(dedoMarcado + 1, m_jLabelManos);
                                        break;
                                    case 5:
                                        pinta.cargarDedo(dedoMarcado, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 1, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 2, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 3, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 4, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 5, m_jLabelManos);
                                        pinta.cargarDedoSiguiente(dedoMarcado + 1, m_jLabelManos);
                                        break;
                                    case 6:
                                        pinta.cargarDedo(dedoMarcado, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 1, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 2, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 3, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 4, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 5, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 6, m_jLabelManos);
                                        pinta.cargarDedoSiguiente(dedoMarcado + 1, m_jLabelManos);
                                        break;
                                    case 7:
                                        pinta.cargarDedo(dedoMarcado, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 1, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 2, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 3, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 4, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 5, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 6, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 7, m_jLabelManos);
                                        pinta.cargarDedoSiguiente(dedoMarcado + 1, m_jLabelManos);
                                        break;
                                    case 8:
                                        pinta.cargarDedo(dedoMarcado, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 1, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 2, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 3, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 4, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 5, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 6, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 7, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 8, m_jLabelManos);
                                        pinta.cargarDedoSiguiente(dedoMarcado + 1, m_jLabelManos);
                                        break;
                                    case 9:
                                        pinta.cargarDedo(dedoMarcado, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 1, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 2, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 3, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 4, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 5, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 6, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 7, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 8, m_jLabelManos);
                                        pinta.cargarDedo(dedoMarcado - 9, m_jLabelManos);
                                        break;
                                }

                            }

                            //send success
                            SendToListener(ACT_FEATURES, null, null, null, null);
                        } catch (UareUException e) {
                            //send extraction error
                            SendToListener(ACT_FEATURES, null, null, null, e);
                        }
                    } else {
                        //send quality result
                        SendToListener(ACT_CAPTURE, null, evt.capture_result, evt.reader_status, evt.exception);
                    }
                } else {
                    //send capture error
                    SendToListener(ACT_CAPTURE, null, evt.capture_result, evt.reader_status, evt.exception);
                }
            }

            return prefmd;
        }

        public void cancel() {
            m_bCancel = true;
            if (null != m_capture) {
                m_capture.cancel();
            }
        }

        private void SendToListener(String action, Fmd fmd, Reader.CaptureResult cr, Reader.Status st, UareUException ex) {
            if (null == m_listener || null == action || action.equals("")) {
                return;
            }

            final EnrollmentEvent evt = new EnrollmentEvent(this, action, fmd, cr, st, ex);

            //invoke listener on EDT thread
            try {
                javax.swing.SwingUtilities.invokeAndWait(() -> {
                    m_listener.actionPerformed(evt);
                });
            } catch (InvocationTargetException | InterruptedException e) {
                System.out.println("Error: Enrollment - SendToListener \n" + e.getMessage());
            }
        }

        @Override
        public void run() {
            //acquire engine
            Engine engine = UareUGlobal.GetEngine();

            try {
                m_bCancel = false;
                while (!m_bCancel) {
                    //run enrollment
                    Fmd fmd = engine.CreateEnrollmentFmd(Fmd.Format.DP_REG_FEATURES, this);

                    //send result
                    if (null != fmd) {
                        SendToListener(ACT_DONE, fmd, null, null, null);
                    } else {
                        SendToListener(ACT_CANCELED, null, null, null, null);
                        break;
                    }
                }
            } catch (UareUException e) {
                SendToListener(ACT_DONE, null, null, null, e);
            }
        }
    }

    private Enrolar(Reader reader, JTextArea jTextAreaMensajes, JLabel jLabelCapturaHuella, JLabel label, int dedo) {

        m_reader = reader;
        m_bJustStarted = true;
        m_enrollment = new EnrollmentThread(m_reader, this);
        m_text = jTextAreaMensajes;
        m_jLabelCapturaHuella = jLabelCapturaHuella;
        m_jLabelManos = label;
        dedoMarcado = dedo;
        initComponents();

        utilidadesLector = new UtilidadesLector_1();
        m_image = new ImagePanel();
        Dimension dm = new Dimension(350, 380);
        m_image.setPreferredSize(dm);
        Enrolar.this.add(m_image);

        jButtonCerrar.setActionCommand(ACT_BACK);
        jButtonCerrar.addActionListener(Enrolar.this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(ACT_BACK)) {
            //destroy dialog to cancel enrollment
            //m_dlgParent.setVisible(false);
            m_dlgParent.dispose();
        } else {
            EnrollmentThread.EnrollmentEvent evt = (EnrollmentThread.EnrollmentEvent) e;

            switch (e.getActionCommand()) {
                case EnrollmentThread.ACT_PROMPT:
                    if (m_bJustStarted) {
                        m_text.append("La inscripción comenzó\n");
                        m_text.append("  poner cualquier dedo en el lector\n");
                    } else {
                        m_text.append("  poner el mismo dedo en el lector\n");
                    }
                    m_bJustStarted = false;
                    break;
                case EnrollmentThread.ACT_CAPTURE:
                    if (null != evt.capture_result) {
                        MessageBox.BadQuality(evt.capture_result.quality);
                    } else if (null != evt.exception) {
                        MessageBox.DpError("Captura", evt.exception);
                    } else if (null != evt.reader_status) {
                        MessageBox.BadStatus(evt.reader_status);
                    }
                    m_bJustStarted = false;
                    break;
                case EnrollmentThread.ACT_FEATURES:
                    if (null == evt.exception) {
                        m_text.append("  Características extraídas\n\n");
                    } else {
                        MessageBox.DpError("Extracción de características", evt.exception);
                    }
                    m_bJustStarted = false;
                    break;
                case EnrollmentThread.ACT_DONE:
                    if (null == evt.exception) {
                        String str = String.format("  Plantilla creada, tamaño: %d\n", evt.enrollment_fmd.getData().length);
                        template.add(evt.enrollment_fmd.getData());
                        m_text.append(str);
                        m_enrollment.cancel();
                        m_dlgParent.setVisible(false);
                    } else {
                        template = null;
                        MessageBox.DpError("No fue creada la plantillas:", evt.exception);
                    }
                    m_bJustStarted = true;
                    break;
                case EnrollmentThread.ACT_CANCELED:
                    //canceled, destroy dialog
                    m_dlgParent.setVisible(false);
                    break;
            }
            //cancel enrollment if any exception or bad reader status
            if (null != evt.exception || (null != evt.reader_status && Reader.ReaderStatus.READY != evt.reader_status.status && Reader.ReaderStatus.NEED_CALIBRATION != evt.reader_status.status)) {
                //m_dlgParent.setVisible(false);
                m_dlgParent.dispose();
            }
        }
    }

    private void doModal(JDialog dlgParent) {
        template = new ArrayList<>();
        boolean bOk = true;
        //open reader
        try {
            m_reader.Open(Reader.Priority.COOPERATIVE);
        } catch (UareUException e) {
            bOk = false;
            MessageBox.DpError("Reader.Open()", e);
        }

        if (bOk) {
            //start enrollment thread
            m_enrollment.start();

            //bring up modal dialog
            m_dlgParent = dlgParent;
            m_dlgParent.setResizable(false);
            m_dlgParent.setContentPane(this);
            m_dlgParent.pack();
            eventoComponente();
            m_dlgParent.setLocationRelativeTo(null);
            m_dlgParent.setVisible(true);

            //stop enrollment thread
            m_enrollment.cancel();

            //close reader
            closeReader();
        }
    }

    private void cierraTodo() {
        try {
            m_reader.StopStreaming();
            System.out.println("deteniendo Stream +1");
        } catch (Exception e) {
            System.out.println("deteniendo Stream -1");
        }
        try {
            m_reader.CancelCapture();
            System.out.println("deteniendo Captura +1");
        } catch (Exception e) {
            System.out.println("deteniendo Captura -1");
        }
        try {
            m_reader.Close();
            System.out.println("cerrando lector +1");
        } catch (Exception e) {
            System.out.println("cerrando lector -1");
        }
    }

    private void closeReader() {
        //close reader
        /*try {
            m_reader.Close();
        } catch (UareUException e) {
            MessageBox.DpError("Reader.Close()", e);
        }*/
        cierraTodo();
    }

    private static JDialog ventana() {
        return new JDialog((JDialog) null, "En espera....", true);
    }

    public static List<Object> Run(Reader reader, JTextArea jTextAreaMensajes, JLabel jLabelCapturaHuella, JLabel label, int dedo) {
        Enrolar enrollment = new Enrolar(reader, jTextAreaMensajes, jLabelCapturaHuella, label, dedo);
        enrollment.doModal(ventana());

        return template;
    }

    public static List<Object> Run(Reader reader, JLabel jLabelCapturaHuella, JLabel lblManos, JLabel label, int dedo) {
        Enrolar enrollment = new Enrolar(reader, new JTextArea(), jLabelCapturaHuella, label, dedo);
        enrollment.doModal(ventana());
        return template;
    }

    public void pintaDedo(int dedo) {
        //System.out.println("siiiiiiiiiiiiiiiiiiiiiiiii:"+new Run().dedoCap.getText());
    }

    // -------------------------------------------------------------------------
    // --- EVENTOS -------------------------------------------------------------
    // -------------------------------------------------------------------------
    private void eventoComponente() {
        // AL PRESIONAR ESC SE CIERRA LA VENTANA
        m_dlgParent.getRootPane().registerKeyboardAction(e -> {
            m_dlgParent.dispose();
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelIntentos = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setRequestFocusEnabled(false);

        jButtonCerrar.setText("Cerrar");

        jLabel1.setText("Coloque el dedo en el lector.");
        jLabel1.setPreferredSize(new java.awt.Dimension(204, 22));

        jLabel2.setText("Intentos:");
        jLabel2.setPreferredSize(new java.awt.Dimension(65, 22));

        jLabelIntentos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelIntentos.setText("0");
        jLabelIntentos.setPreferredSize(new java.awt.Dimension(0, 22));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelIntentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCerrar))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCerrar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelIntentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelIntentos;
    // End of variables declaration//GEN-END:variables
}
