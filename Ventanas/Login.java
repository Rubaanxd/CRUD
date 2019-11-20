/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import db.Conexion;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;
import misc.Usuario;


/**
 *
 * @author Ruben Angeles
 */
public class Login extends javax.swing.JFrame {
    
    public static Usuario usuario =  new Usuario();
    private Conexion cn = new Conexion();
    private ResultSet rs;
    
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        pnlGlass.setVisible(false);
        this.setLocationRelativeTo(null);
        this.pnlDatos.getRootPane().setDefaultButton(btnLogin);
    }
    /**
     * Funcion que en principio cifra la contraseña y despues busca el nombre de
     * usuario en la base de datos si no encuentra al usuario devuelve un 
     * jOptionPane para avisar que el usuario no fue encontrado, despues compara
     * el checksum de la contraseña local con la de DB si no coinciden devuelve
     * un jOptionPane para avisar que la contraseña es incorrecta; Si la 
     * contraseña es correcta, Obtiene todos los valores del usuario y los
     * guarda en un objeto tipo Usuario para poder tener acceso a esa informacion
     * una vez entrado al programa. 
     */
    private void LogIn(){
        pnlGlass.setVisible(true);
        blEstado.setText("Iniciando Sesion...");
        blEstado.setBusy(true);
        String pass = new String(tfPass.getPassword());//Obtienes Password
        pass = org.apache.commons.codec.digest.DigestUtils.shaHex(pass);//Calcula SHA 160-bit checksum para comparar con la DB
        cn.conectar();
        try {
            //System.out.println("Generando Consulta");
            rs = cn.consulta("SELECT * from Usuarios where username = '"+this.tfUsername.getText()+"'");
            System.out.println("Obteniendo datos");
            if (rs.next()) {
                String passDB = rs.getNString(2);
//                System.out.println("Comparando Pass");
                System.out.println("Pass app:" +pass+"  Pass DB: "+passDB);
                if (pass.equals(passDB)) {
                    usuario.setUsername(rs.getNString(1));
                    usuario.setPass(rs.getNString(2));
//                    System.out.println("Obteniendo Informacion de Usuario");
                    usuario.setCorreo(rs.getNString(3));
                    usuario.setNombre(rs.getNString(4));
                    usuario.setApellido(rs.getNString(5));
                    usuario.setSexo(rs.getNString(6));
                    usuario.setEdad(rs.getInt(7));
                    usuario.setTipo(rs.getNString(8));
                    cn.desconectar();
                    Opciones o =  new Opciones();
                    o.setVisible(true);
                    this.dispose();
//                    System.out.println("Valores Obtenidos");
                    blEstado.setText("Completado");
                    blEstado.setBusy(false);
                    pnlGlass.setVisible(false);
                }
                else{
                    cn.desconectar();
                    javax.swing.JOptionPane.showMessageDialog(rootPane, "Contraseña Incorrecta");
                    blEstado.setText("ERROR");
                    blEstado.setBusy(false);
                    pnlGlass.setVisible(false);
                }
            }
            else{
                cn.desconectar();
                javax.swing.JOptionPane.showMessageDialog(rootPane, "Usuario no Encontrado");
                blEstado.setText("ERROR");
                blEstado.setBusy(false);
                pnlGlass.setVisible(false);
                }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalir = new javax.swing.JButton();
        pnlDatos = new javax.swing.JPanel();
        lblUsernamer = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        tfPass = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();
        pnlGlass = new javax.swing.JPanel();
        blEstado = new org.jdesktop.swingx.JXBusyLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setBackground(new java.awt.Color(255, 51, 51));
        btnSalir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, -1, -1));

        pnlDatos.setOpaque(false);

        lblUsernamer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsernamer.setText("Username:");

        tfUsername.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblPassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblPassword.setText("Password:");

        tfPass.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnLogin.setBackground(new java.awt.Color(153, 255, 255));
        btnLogin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsernamer, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPassword, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfUsername)
                            .addComponent(tfPass, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)))
                    .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsernamer)
                    .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(tfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLogin)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        getContentPane().add(pnlDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 260, 160));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondoLogin.png"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlGlass.setLayout(new java.awt.GridBagLayout());

        blEstado.setFocusable(false);
        blEstado.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        blEstado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pnlGlass.add(blEstado, new java.awt.GridBagConstraints());

        getContentPane().add(pnlGlass, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if (!es.discoduroderoer.swing.Validacion.comprobarVacios(new JTextField[]{this.tfUsername,this.tfPass})) {
            LogIn();
        }else{
            javax.swing.JOptionPane.showMessageDialog(rootPane, "Usuario y/o Contraseña Vacios");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

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
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXBusyLabel blEstado;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsernamer;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlGlass;
    private javax.swing.JPasswordField tfPass;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
