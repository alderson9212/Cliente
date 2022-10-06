package principalCliente;

import Vistas.ContabilidadAuxiliarCatalogo;
import Vistas.ContabilidadEstadosFinancieros;
import Vistas.ContabilidadLibroDiario;
import Vistas.JPanelTest;
import Vistas.UtileriasTablas;
import Vistas.UtileriasUsuarios;
import com.fenoreste.saicoop.controller.NotasService;
import com.fenoreste.saicoop.httpService.UsuariosService;
import com.fenoreste.saicoop.modelos.NotaDTO;
import com.fenoreste.saicoop.modelos.UsuarioDTO;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.awt.GridBagConstraints;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.JSONException;
import com.google.gson.JsonObject;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import org.json.JSONObject;
import util.MetodosValidar;

public class Run1 extends javax.swing.JFrame {

    boolean banderaProcesos = false;
    JDialog jd = new JDialog();
    UsuariosService userService = new UsuariosService();
    UsuarioDTO user = new UsuarioDTO();

    String ip = "";
    String base = "";
    String userNumber = "";

    //Iniciamos todos los controladores de servicios
    NotasService notaService = new NotasService();

    public Run1(String ip, String base, String userNumber) {
        initComponents();
        this.setLocationRelativeTo(null);
        setMenuBar();

        /*jTabbedPane1.setUI(new javax.swing.plaf.metal.MetalTabbedPaneUI() {
            protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
                jTabbedPane1.setEnabledAt(1, false);
                jTabbedPane1.setEnabledAt(2, false);
                jTabbedPane1.setEnabledAt(3, false);
                jTabbedPane1.setEnabledAt(4, false);
                jTabbedPane1.setEnabledAt(5, false);

            }

            private final Insets borderInsets = new Insets(0, 0, 0, 0);

            @Override
            protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
            }

            @Override
            protected Insets getContentBorderInsets(int tabPlacement) {
                return borderInsets;
            }
        }); */
        this.ip = ip;
        this.base = base;
        this.userNumber = userNumber;
        lblBase.setText(base);
        lblServidor.setText(ip);
        lblUsuario.setText(userNumber);
        decoracionBotones();
        controlInicial();
        accionBotones();
        accionItems();

    }

    int contBtn1 = 0;
    int contBtn2 = 0;

    //Cambio de estado
    public void StateChanged(WindowEvent e) {
        // minimized
        if ((e.getNewState() & Run1.ICONIFIED) == Run1.ICONIFIED) {
            System.out.println("minimized");
        } // maximized
        else if ((e.getNewState() & Run1.MAXIMIZED_BOTH) == Run1.MAXIMIZED_BOTH) {
            System.out.println("maximized");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDBloquear = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        VistaQuery = new javax.swing.JDialog();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbQueryResult = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtmsj = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        bntBloquear = new javax.swing.JButton();
        panel1 = new javax.swing.JPanel();
        panel2 = new javax.swing.JPanel();
        panel3 = new javax.swing.JPanel();
        panel4 = new javax.swing.JPanel();
        btnPrincipal = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblBase = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblServidor = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        item1 = new javax.swing.JMenuItem();
        item2 = new javax.swing.JMenuItem();
        item3 = new javax.swing.JMenuItem();
        item4 = new javax.swing.JMenuItem();
        item5 = new javax.swing.JMenuItem();
        item6 = new javax.swing.JMenuItem();
        item7 = new javax.swing.JMenuItem();
        item8 = new javax.swing.JMenuItem();
        item9 = new javax.swing.JMenuItem();
        item10 = new javax.swing.JMenuItem();
        item11 = new javax.swing.JMenuItem();
        item12 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        item13 = new javax.swing.JMenuItem();
        item14 = new javax.swing.JMenuItem();
        item15 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        item16 = new javax.swing.JMenuItem();
        item17 = new javax.swing.JMenuItem();
        item18 = new javax.swing.JMenuItem();
        item19 = new javax.swing.JMenuItem();

        jPasswordField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JDBloquearLayout = new javax.swing.GroupLayout(JDBloquear.getContentPane());
        JDBloquear.getContentPane().setLayout(JDBloquearLayout);
        JDBloquearLayout.setHorizontalGroup(
            JDBloquearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        JDBloquearLayout.setVerticalGroup(
            JDBloquearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        tbQueryResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tbQueryResult);

        jButton7.setText("GUARDAR");

        jButton8.setText("IMPRIMIR");

        jButton9.setText("CERRAR");

        javax.swing.GroupLayout VistaQueryLayout = new javax.swing.GroupLayout(VistaQuery.getContentPane());
        VistaQuery.getContentPane().setLayout(VistaQueryLayout);
        VistaQueryLayout.setHorizontalGroup(
            VistaQueryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VistaQueryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VistaQueryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VistaQueryLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE))
                .addContainerGap())
        );
        VistaQueryLayout.setVerticalGroup(
            VistaQueryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VistaQueryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VistaQueryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addGap(22, 22, 22))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowDeiconified(java.awt.event.WindowEvent evt) {
                formWindowDeiconified(evt);
            }
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
        });

        txtmsj.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        txtmsj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtmsj.setText("Usuario:");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel3ComponentResized(evt);
            }
        });

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 959, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(212, 47, 47));
        jPanel6.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel6ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bntBloquear.setFont(new java.awt.Font("Noto Sans", 1, 10)); // NOI18N
        bntBloquear.setText("Huella");
        bntBloquear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bntBloquear.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bntBloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntBloquearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        btnPrincipal.setText("Principal");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(bntBloquear)
                        .addGap(36, 36, 36)))
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 331, Short.MAX_VALUE)
                .addComponent(bntBloquear, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel4.setText("Base de datos:");

        jLabel5.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel5.setText("Servidor :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtmsj, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBase, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtmsj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblServidor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jMenu1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jMenu1.setText("Menu1");
        jMenu1.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N

        item1.setText("jMenuItem1");
        jMenu1.add(item1);

        item2.setText("jMenuItem2");
        jMenu1.add(item2);

        item3.setText("jMenuItem3");
        jMenu1.add(item3);

        item4.setText("jMenuItem4");
        jMenu1.add(item4);

        item5.setText("jMenuItem5");
        jMenu1.add(item5);

        item6.setText("jMenuItem6");
        jMenu1.add(item6);

        item7.setText("jMenuItem7");
        jMenu1.add(item7);

        item8.setText("jMenuItem8");
        jMenu1.add(item8);

        item9.setText("jMenuItem9");
        jMenu1.add(item9);

        item10.setText("jMenuItem10");
        jMenu1.add(item10);

        item11.setText("jMenuItem11");
        jMenu1.add(item11);

        item12.setText("jMenuItem12");
        jMenu1.add(item12);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Menu2");
        jMenu2.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N

        item13.setText("jMenuItem13");
        jMenu2.add(item13);

        item14.setText("jMenuItem1");
        jMenu2.add(item14);

        item15.setText("jMenuItem2");
        jMenu2.add(item15);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Menu3");
        jMenu3.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N

        item16.setText("jMenuItem14");
        item16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item16ActionPerformed(evt);
            }
        });
        jMenu3.add(item16);

        item17.setText("jMenuItem15");
        item17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item17ActionPerformed(evt);
            }
        });
        jMenu3.add(item17);

        item18.setText("jMenuItem16");
        jMenu3.add(item18);

        item19.setText("jMenuItem1");
        jMenu3.add(item19);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntBloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntBloquearActionPerformed
        bloquear();
    }//GEN-LAST:event_bntBloquearActionPerformed


    private void jPanel3ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel3ComponentResized

    }//GEN-LAST:event_jPanel3ComponentResized

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
        System.out.println("Iconified");
    }//GEN-LAST:event_formWindowIconified

    private void formWindowDeiconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeiconified
        System.out.println("Deiconified");
    }//GEN-LAST:event_formWindowDeiconified

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        Component[] comp = jPanel6.getComponents();
        for (Component com : comp) {
            com.setSize(jPanel6.getWidth(), jPanel6.getHeight());
        }
        jPanel6.revalidate();
        jPanel6.repaint();
        //jDesktopPa.setSize(jPanel3.getWidth(), jPanel3.getHeight() - jPanel4.getHeight() - 12);
        //jDesktopPane1.setSize(jPanel3.getWidth(), jPanel3.getHeight() - jPanel4.getHeight() - 12);
        //System.out.println("MEdidad jdesktop:" + jDesktopPane1.getSize().width + "," + jDesktopPane1.getSize().height);
    }//GEN-LAST:event_formComponentResized

    private void jPasswordField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyTyped
        char c = evt.getKeyChar();
        if (c == KeyEvent.VK_ENTER) {

        }
    }//GEN-LAST:event_jPasswordField1KeyTyped

    private void item16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item16ActionPerformed
        ContabilidadLibroDiario conta = new ContabilidadLibroDiario();
        JPanelTest jp = new JPanelTest();
        conta.setSize(jPanel6.getWidth(), jPanel6.getHeight());
        conta.setVisible(true);
        jPanel6.add(conta);
        jPanel6.revalidate();
        jPanel6.repaint();
    }//GEN-LAST:event_item16ActionPerformed

    private void jPanel6ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel6ComponentResized

    }//GEN-LAST:event_jPanel6ComponentResized

    private void item17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item17ActionPerformed
        creaBtn();
    }//GEN-LAST:event_item17ActionPerformed

    public void creaBtn() {
        JButton btn = new JButton("Hola");
        btn.setSize(10, 10);
        btn.setVisible(true);
        accionBtn(btn);
        ImageIcon icono = new ImageIcon(getClass().getResource("/16x16/add.png"));
        btn.setIcon(icono);
        JOptionPane.showMessageDialog(null, btn);

    }

    public void accionBtn(JButton btn) {
        btn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Un click");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Un Pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("un released");
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void controllerProcesos() {
        banderaProcesos = true;
    }

    public void controllerMantenimiento() {
        jMenu1.setVisible(false);
        jMenu2.setText("DEPURACIONES");
        jMenu3.setVisible(false);
        jMenuBar1.setVisible(false);
        banderaProcesos = true;
    }

    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public void bloquear() {
        jd = new JDialog(this, "DESBLOQUEAR", false);
        jd.add(JDBloquear.getContentPane());
        jd.setVisible(true);
        JDBloquear.setTitle("INGRESA CONTRASEÑA");
        jd.setSize(380, 75);
        jd.setLocationRelativeTo(null);
        jd.setDefaultCloseOperation(0);

        jMenuBar1.setEnabled(false);
        jMenu1.setEnabled(false);
        jMenu3.setEnabled(false);
        jMenu2.setEnabled(false);
        bntBloquear.setEnabled(false);

        this.setEnabled(false);
    }

    public void desbloquear() {
        jMenuBar1.setEnabled(true);
        jMenu1.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu2.setEnabled(true);
        bntBloquear.setEnabled(true);
        this.setEnabled(true);
    }

    //Diseñar la barra de  menu
    private void setMenuBar() {
        if (this.jMenuBar1 != null) {
            GridBagConstraints gBconstraints = new GridBagConstraints();
            gBconstraints.gridx = 0;
            gBconstraints.gridy = 0;
            gBconstraints.gridwidth = 1;
            gBconstraints.gridheight = 1;
            gBconstraints.fill = GridBagConstraints.HORIZONTAL;
            gBconstraints.weightx = 1;
            //adding this JMenuBar
            this.jPanel4.add(jMenuBar1, gBconstraints);
        }
    }

    /**
     * *******************************************Controles
     * parentales**********************************************
     */
    JButton boton1 = new JButton();
    JButton boton2 = new JButton();
    JButton boton3 = new JButton();
    JButton boton4 = new JButton();

    public void decoracionBotones() {

        boton1.setFocusable(true);
        boton1.setContentAreaFilled(false);
        boton1.setBounds(0, 0, panel1.getWidth(), panel1.getHeight());
        boton1.setFocusable(true);
        boton1.setVisible(true);
        boton1.setFont(new Font("Arial", Font.BOLD, 10));
        boton1.setOpaque(false);

        //Boton 2
        boton2.setFocusable(true);
        boton2.setContentAreaFilled(false);
        boton2.setBounds(0, 0, panel2.getWidth(), panel2.getHeight());
        boton2.setFocusable(true);
        boton2.setVisible(true);
        boton2.setFont(new Font("Arial", Font.BOLD, 10));
        boton2.setOpaque(false);

        //Boton 3
        boton3.setFocusable(true);
        boton3.setContentAreaFilled(false);
        boton3.setBounds(0, 0, panel3.getWidth(), panel3.getHeight());
        boton3.setFocusable(true);
        boton3.setVisible(true);
        boton3.setFont(new Font("Arial", Font.BOLD, 10));
        boton3.setOpaque(false);

        //Boton 4
        boton4.setFocusable(true);
        boton4.setContentAreaFilled(false);
        boton4.setBounds(0, 0, panel4.getWidth(), panel4.getHeight());
        boton4.setFocusable(true);
        boton4.setVisible(true);
        boton4.setFont(new Font("Arial", Font.BOLD, 10));
        boton4.setOpaque(false);

        //Boton Principal
        btnPrincipal.setFocusable(true);
        btnPrincipal.setContentAreaFilled(false);
        //btnPrincipal.setBounds(0, 0, panel2.getWidth(), panel2.getHeight());
        btnPrincipal.setFocusable(true);
        btnPrincipal.setVisible(true);
        btnPrincipal.setFont(new Font("Arial", Font.BOLD, 10));
        btnPrincipal.setOpaque(false);

    }

    public void controlInicial() {
        boton1.setText("CONTABILIDAD");
        panel1.add(boton1);
        boton2.setText("OPERACIONES");
        panel2.add(boton2);
        boton3.setText("UTILERIAS");
        panel3.add(boton3);
        boton4.setText("PROYECTO BI");
        panel4.add(boton4);
        btnPrincipal.setText("SALIR");

    }

    public void accionBotones() {
        boton1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String op = boton1.getText().toLowerCase().replace("/", "").replace("<", "").replace(">", "").replace("body", "").replace(" ", "").replace("html", "").replace("br", "");
                op = op.toUpperCase();
                switch (op) {
                    case "CONTABILIDAD":
                        boton1.setText("<html><body>LIBRO<br>DIARIO</html><body>");
                        boton2.setText("<html><body>AUXILIAR<br>CATALOGO</html><body>");
                        boton3.setText("<html><body>ESTADOS<br>FINANCIEROS</html><body>");
                        boton4.setText("A PRINCIPAL");
                        btnPrincipal.setVisible(false);
                        break;
                    case "LIODIARIO":
                        jPanel6.removeAll();
                        ContabilidadLibroDiario conta = new ContabilidadLibroDiario();
                        conta.setSize(jPanel6.getWidth(), jPanel6.getHeight());
                        jPanel6.add(conta);
                        jPanel6.revalidate();
                        jPanel6.repaint();
                        break;

                    case "USUARIOS":
                        jPanel6.removeAll();
                        UtileriasUsuarios users = new UtileriasUsuarios();
                        users.setSize(jPanel6.getWidth(), jPanel6.getHeight());
                        jPanel6.add(users);
                        jPanel6.revalidate();
                        jPanel6.repaint();
                        break;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //boton1.setBackground(Color.red);
                boton1.setOpaque(true);
                //boton1.setForeground(Color.red);
                //boton3.setFocusable(true);
                boton1.setContentAreaFilled(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton1.setOpaque(false);
                boton1.setContentAreaFilled(false);
            }
        });

        boton2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String op = boton2.getText().toLowerCase().replace("/", "").replace("<", "").replace(">", "").replace("body", "").replace(" ", "").replace("html", "").replace("br", "");
                op = op.toUpperCase();
                switch (op) {
                    case "OPERACIONES":
                        boton1.setText("VENTANILLA");
                        boton2.setText("APERTURAS");
                        boton3.setText("<html><body>REVISION<br>LIBRETAS</body></html>");
                        boton4.setText("TRASPASOS");
                        btnPrincipal.setText("A PRINCIPAL");
                        break;
                    case "TABLAS":
                        jPanel6.removeAll();
                        UtileriasTablas tablas = new UtileriasTablas();
                        tablas.setSize(jPanel6.getWidth(), jPanel6.getHeight());
                        jPanel6.add(tablas);
                        jPanel6.revalidate();
                        jPanel6.repaint();
                        break;
                    case "AUXILIARCATALOGO":
                        jPanel6.removeAll();
                        ContabilidadAuxiliarCatalogo conta = new ContabilidadAuxiliarCatalogo();
                        conta.setSize(jPanel6.getWidth(), jPanel6.getHeight());
                        jPanel6.add(conta);
                        jPanel6.revalidate();
                        jPanel6.repaint();
                        break;

                       
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //boton1.setBackground(Color.red);
                boton2.setOpaque(true);
                //boton1.setForeground(Color.red);
                //boton3.setFocusable(true);
                boton2.setContentAreaFilled(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton2.setOpaque(false);
                boton2.setContentAreaFilled(false);
            }
        });

        boton3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String op = boton3.getText().toLowerCase().replace("/", "").replace("<", "").replace(">", "").replace("body", "").replace(" ", "").replace("html", "").replace("br", "");
                op = op.toUpperCase();
                switch (op) {
                    case "UTILERIAS":
                        boton1.setText("USUARIOS");
                        boton2.setText("TABLAS");
                        boton3.setText("A PRINCIPAL");
                        panel4.setVisible(false);
                        btnPrincipal.setVisible(false);

                        jMenu1.setText("CATALOGOS");
                        jMenu2.setText("OTROS");
                        jMenu3.setText("DEPURACIONES");

                        item1.setText("USUARIOS");
                        item2.setText("PERFILES DE USUARIOS");
                        item3.setText("CATALOGO DE PERMISOS");
                        item4.setText("TABLAS");
                        item5.setText("EDICION DE FORMATOS");
                        item6.setText("CATALOGO DE ORIGENES");
                        item7.setText("EDICION DE CONTRATOS");
                        item8.setText("ASIGNACION DE REQUISITOS A PRODUCTOS");
                        item9.setText("ATENCION A USUARIOS");
                        item10.setText("estadisticas");
                        item11.setText("TIPO DE CAMBIO PARA MOV RELEVANTES");
                        item12.setText("TASA DE REFERENCIA");

                        item13.setText("EJECUCION DE QUERYS");
                        item14.setText("REPORTE DE BITACORA");
                        item15.setText("BORRADO DE DATOS TEMPORALES");

                        item16.setText("DEPURACION DE MUNICIPIOS");
                        item17.setText("DEPURACION DE COLONIAS");
                        item18.setText("CAPTURA DE AVALES");
                        item19.setText("DEPURACION DE LA BASE DE DATOS");

                        break;
                        
                    case "ESTADOSFINANCIEROS":
                        jPanel6.removeAll();
                        ContabilidadEstadosFinancieros conta = new ContabilidadEstadosFinancieros();
                        conta.setSize(jPanel6.getWidth(),jPanel6.getHeight());
                        jPanel6.add(conta);
                        jPanel6.revalidate();
                        jPanel6.repaint();
                        break;
                    case "APRINCIPAL":
                        panel4.setVisible(true);
                        btnPrincipal.setVisible(true);
                        boton1.setText("CONTABILIDAD");
                        boton2.setText("OPERACIONES");
                        boton3.setText("UTILERIAS");
                        boton4.setText("PROYECTO BI");
                        btnPrincipal.setText("SALIR");
                        break;

                }
            }

            @Override
            public void mousePressed(MouseEvent e
            ) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e
            ) {

            }

            @Override
            public void mouseEntered(MouseEvent e
            ) {
                //boton1.setBackground(Color.red);
                boton3.setOpaque(true);
                //boton1.setForeground(Color.red);
                //boton3.setFocusable(true);
                boton3.setContentAreaFilled(true);

            }

            @Override
            public void mouseExited(MouseEvent e
            ) {
                boton3.setOpaque(false);
                boton3.setContentAreaFilled(false);
            }
        }
        );

        boton4.addMouseListener(
                new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e
            ) {
                String op = boton4.getText().toLowerCase().replace("/", "").replace("<", "").replace(">", "").replace("body", "").replace(" ", "").replace("html", "").replace("br", "");
                op = op.toUpperCase();
                btnPrincipal.setVisible(true);
                switch (op) {
                    case "APRINCIPAL":
                        boton1.setText("CONTABILIDAD");
                        boton2.setText("OPERACIONES");
                        boton3.setText("UTILERIAS");
                        boton4.setText("PROYECTO BI");
                        btnPrincipal.setText("SALIR");
                        break;
                }
            }

            @Override
            public void mousePressed(MouseEvent e
            ) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e
            ) {

            }

            @Override
            public void mouseEntered(MouseEvent e
            ) {
                //boton1.setBackground(Color.red);
                boton3.setOpaque(true);
                //boton1.setForeground(Color.red);
                //boton3.setFocusable(true);
                boton4.setContentAreaFilled(true);

            }

            @Override
            public void mouseExited(MouseEvent e
            ) {
                boton4.setOpaque(false);
                boton4.setContentAreaFilled(false);
            }
        }
        );

        btnPrincipal.addMouseListener(
                new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e
            ) {
                String op = btnPrincipal.getText().toLowerCase().replace("/", "").replace("<", "").replace(">", "").replace("body", "").replace(" ", "").replace("html", "").replace("br", "");
                op = op.toUpperCase();
                btnPrincipal.setVisible(true);
                switch (op) {
                    case "APRINCIPAL":
                        boton1.setText("CONTABILIDAD");
                        boton2.setText("OPERACIONES");
                        boton3.setText("UTILERIAS");
                        boton4.setText("PROYECTO BI");
                        btnPrincipal.setText("SALIR");
                        break;
                    case "SALIR":
                        System.exit(0);
                }
            }

            @Override
            public void mousePressed(MouseEvent e
            ) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e
            ) {

            }

            @Override
            public void mouseEntered(MouseEvent e
            ) {
                //boton1.setBackground(Color.red);
                btnPrincipal.setOpaque(true);
                //boton1.setForeground(Color.red);
                //boton3.setFocusable(true);
                btnPrincipal.setContentAreaFilled(true);

            }

            @Override
            public void mouseExited(MouseEvent e
            ) {
                btnPrincipal.setOpaque(false);
                btnPrincipal.setContentAreaFilled(false);
            }
        }
        );

    }

    public void accionItems() {
        item13.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("cli");
                String op = item13.getText().toUpperCase().replace(" ", "");
                System.out.println("" + op);
                switch (op) {
                    case "EJECUCIONDEQUERYS":
                        break;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Run1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Run1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Run1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Run1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Run1("", "", "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog JDBloquear;
    private javax.swing.JDialog VistaQuery;
    private javax.swing.JButton bntBloquear;
    private javax.swing.JButton btnPrincipal;
    private javax.swing.JMenuItem item1;
    private javax.swing.JMenuItem item10;
    private javax.swing.JMenuItem item11;
    private javax.swing.JMenuItem item12;
    private javax.swing.JMenuItem item13;
    private javax.swing.JMenuItem item14;
    private javax.swing.JMenuItem item15;
    private javax.swing.JMenuItem item16;
    private javax.swing.JMenuItem item17;
    private javax.swing.JMenuItem item18;
    private javax.swing.JMenuItem item19;
    private javax.swing.JMenuItem item2;
    private javax.swing.JMenuItem item3;
    private javax.swing.JMenuItem item4;
    private javax.swing.JMenuItem item5;
    private javax.swing.JMenuItem item6;
    private javax.swing.JMenuItem item7;
    private javax.swing.JMenuItem item8;
    private javax.swing.JMenuItem item9;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    public javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblBase;
    private javax.swing.JLabel lblServidor;
    public javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JTable tbQueryResult;
    public javax.swing.JLabel txtmsj;
    // End of variables declaration//GEN-END:variables
}
