/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principalCliente;

import com.fenoreste.saicoop.httpService.OrigenesService;
import com.fenoreste.saicoop.httpService.UsuariosService;
import com.fenoreste.saicoop.modelos.UsuarioDTO;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import util.Guardar_datos;
import util.UtilVariablesEntorno;

/**
 *
 * @author root
 */
public class Login_1 extends javax.swing.JFrame {

    //Run runn = new Run();
    UsuarioDTO user = null;

    /**
     * Creates new form Login
     */
    Guardar_datos datosTxt = new Guardar_datos();
    String ip = "";
    UsuariosService usuarioService = new UsuariosService();

    public Login_1() {
        initComponents();
        datosTxt.LlenarCombo(jComboBox1);
        habilitarFieldsLogin(false);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        nouser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nameuser = new javax.swing.JTextField();
        datework = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        inicio = new javax.swing.JButton();
        estconexion = new javax.swing.JLabel();
        passuser = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setAutoscrolls(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/init.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Usuario"));

        jLabel2.setText("Conectar con : ");

        jLabel3.setText("Usuario :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---SELECCIONA---" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        nouser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nouserKeyTyped(evt);
            }
        });

        jLabel4.setText("Contrase??a :");

        nameuser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameuserFocusGained(evt);
            }
        });
        nameuser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameuserKeyReleased(evt);
            }
        });

        datework.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dateworkFocusGained(evt);
            }
        });
        datework.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dateworkKeyReleased(evt);
            }
        });

        jLabel5.setText("Fecha de trabajo : ");

        inicio.setText("Acceder");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });

        estconexion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estconexion.setText("ghf");
        estconexion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        passuser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passuserKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(nouser, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameuser))
                    .addComponent(datework)
                    .addComponent(passuser))
                .addGap(14, 14, 14))
            .addComponent(estconexion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(inicio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nouser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datework, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(estconexion, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inicio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 4, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        // runn.setVisible(true);
        new Run1(ip, jComboBox1.getSelectedItem().toString(), String.valueOf(user.getIdusuario())).setVisible(true);
        dispose();
    }//GEN-LAST:event_inicioActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        UtilVariablesEntorno env = new UtilVariablesEntorno();
        if (jComboBox1.getSelectedIndex() > 0) {
            OrigenesService serviceOrigenes = new OrigenesService();
            String[] datos = new Guardar_datos().lista(jComboBox1.getSelectedItem().toString());

            if (serviceOrigenes.obtenerSession(datos[0], datos[1])) {
                ip = datos[0];
                habilitarFieldsLogin(true);
                jComboBox1.transferFocus();
            } else {
                jComboBox1.transferFocus();
                habilitarFieldsLogin(false);
                JOptionPane.showMessageDialog(null, "NO ES POSIBLE CONECTARSE A \n" + datos[1], "ERROR DE CONEXION", JOptionPane.ERROR_MESSAGE);
                //estconexion.setText("Error de conexion");
            }

        } else {
            habilitarFieldsLogin(false);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void nameuserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameuserKeyReleased


    }//GEN-LAST:event_nameuserKeyReleased

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


    private void dateworkKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateworkKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            datework.transferFocus();
        }
    }//GEN-LAST:event_dateworkKeyReleased

    private void nameuserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameuserFocusGained
        nameuser.transferFocus();
    }//GEN-LAST:event_nameuserFocusGained

    private void dateworkFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateworkFocusGained
        datework.transferFocus();
    }//GEN-LAST:event_dateworkFocusGained

    private void nouserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nouserKeyTyped
        char caracter = evt.getKeyChar();
        if (caracter == KeyEvent.VK_ENTER) {
            user = usuarioService.buscarPorId(Integer.parseInt(nouser.getText()), ip, jComboBox1.getSelectedItem().toString());
            if (user.getIdusuario() != null) {
                nameuser.setText(user.getNombre());
                passuser.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "NO EXISTE USUARIO:" + nouser.getText(), "ERROR DE BUSQUEDA", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_nouserKeyTyped

    private void passuserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passuserKeyTyped
        char caracter = evt.getKeyChar();
        if (caracter == KeyEvent.VK_ENTER) {
            String contrase??a1 = user.getPasswd().trim();
            String contrase??a2 = nouser.getText().trim() + passuser.getText().trim();
            if (contrase??a1.equals(getMD5(contrase??a2))) {
                datework.setText(new OrigenesService().findMatriz(ip, jComboBox1.getSelectedItem().toString()).getFechatrabajo());
                inicio.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "CONTRASE??A INCORRECTA PARA:" + nouser.getText(), "ERROR DE CONTRASE??A", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_passuserKeyTyped

    public void guarda_cons() {
        try {
            String user = System.getProperty("user.home");
            String ruta = user + "/Conexion.txt";
            String ip = "";
            String base = "";
            String[] arr = new Guardar_datos().lista(jComboBox1.getSelectedItem().toString());
            ip = arr[0];
            base = arr[1];
            System.out.println("Ip guardada:" + ip + ", Base Guardada:" + base);
            String contenido = "ip_conexion=" + ip + "\nbase_conexion=" + base;
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void habilitarFieldsLogin(boolean bandera) {
        if (bandera) {
            nouser.setEnabled(true);
            nameuser.setEnabled(true);
            passuser.setEnabled(true);
            datework.setEnabled(true);
            estconexion.setText("Connectado...");
        } else {
            nouser.setEnabled(false);
            nameuser.setEnabled(false);
            passuser.setEnabled(false);
            datework.setEnabled(false);
            estconexion.setText("");

        }

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField datework;
    private javax.swing.JLabel estconexion;
    private javax.swing.JButton inicio;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField nameuser;
    private javax.swing.JTextField nouser;
    private javax.swing.JPasswordField passuser;
    // End of variables declaration//GEN-END:variables
}
