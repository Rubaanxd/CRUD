package Ventanas;

import db.Conexion;
import javax.swing.JTextField;
import misc.Usuario;

/**
 *
 * @author Ruben Angeles
 */
public class Registro extends javax.swing.JFrame {
    
    public Usuario usuario;
    
    /**
     * Creates new form Registro
     */
    public Registro() {
        usuario = Opciones.usuario;
        initComponents();
        pnlGlass.setVisible(false);
        GrupoBotonesSexo.add(rbtnHombre);
        GrupoBotonesSexo.add(rbtnMujer);
        GrupoBotonesSexo.add(rbtnOtro);
        this.setLocationRelativeTo(null);
        swing.MiSwing.iconoJFrame(this, "/images/iconoCalavera.png");
    }
    
    private void limpiarCampos(){
        tfUsername.setText("");
        jPasswordField1.setText("");
        tfNombre.setText("");
        tfApellido.setText("");
        tfCorreo.setText("");
        SliderAños.setValue(0);
        GrupoBotonesSexo.clearSelection();
    }
    
    private void getDatos(){
        pnlGlass.setVisible(true);
        blEstado.setText("Cargado Valores...");
        blEstado.setBusy(true);
        Usuario u =  new Usuario();
        u.setUsername(tfUsername.getText());
        u.setPass(org.apache.commons.codec.digest.DigestUtils.shaHex(new String(jPasswordField1.getPassword())));
        u.setTipo("Lector");//Por DEFECTO solo Consultas 1
        u.setNombre(tfNombre.getText());
        u.setApellido(tfApellido.getText());
        u.setEdad(SliderAños.getValue());
        u.setCorreo(tfCorreo.getText());
        if(rbtnHombre.isSelected()){
            u.setSexo("Hombre");
        }else if(rbtnMujer.isSelected()){
            u.setSexo("Mujer");
        }else{
            u.setSexo("Otro");
        }
        System.out.println(u.getPass());
        blEstado.setText("Actualizando Base de Datos...");
        subirUsuario(u);
        blEstado.setText("Completado");
        blEstado.setBusy(false);
        pnlGlass.setVisible(false);
    }
    private void subirUsuario(Usuario user){
        Conexion cn = new Conexion();
        cn.conectar();
        try {
            cn.insertar("INSERT INTO Usuarios VALUES ('"+user.getUsername()+"', '"+user.getPass()+"', '"+user.getCorreo()+"', '"+user.getNombre()+"', '"+user.getApellido()+"', '"+user.getSexo()+"', '"+user.getEdad()+"', '"+user.getTipo()+"')");
            javax.swing.JOptionPane.showMessageDialog(rootPane, "Usuario Creado Con Exito");
            cn.desconectar();
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private boolean ValidarRegistro(){
        if(!es.discoduroderoer.swing.Validacion.comprobarVacios(new JTextField[]{tfUsername,jPasswordField1,tfCorreo,tfNombre,tfApellido})){
            if(es.discoduroderoer.expresiones_regulares.ExpresionesRegulares.validar_Mail_Exp(tfCorreo.getText())){
                if(es.discoduroderoer.expresiones_regulares.ExpresionesRegulares.validaNombre_Exp(tfNombre.getText())){
                    if (es.discoduroderoer.expresiones_regulares.ExpresionesRegulares.validaNombre_Exp(tfApellido.getText())) {
                            if (GrupoBotonesSexo.getSelection()!= null) {
                                if (SliderAños.getValue() != 0) {
                                    return true;
                                }else{javax.swing.JOptionPane.showMessageDialog(rootPane, "Debes Seleccionar una edad Valida");}
                            }else{javax.swing.JOptionPane.showMessageDialog(rootPane, "Debes Seleccionar un Sexo");}
                    }else{javax.swing.JOptionPane.showMessageDialog(rootPane, "Debes Introducir un Apellido Paterno Valido");}
                }else{javax.swing.JOptionPane.showMessageDialog(rootPane, "Debes Introducir un Nombre Valido");}
            }else{javax.swing.JOptionPane.showMessageDialog(rootPane, "Debes Introducir un Email Valido");}
        }else{javax.swing.JOptionPane.showMessageDialog(rootPane, "Todos los Campos son obligatorios");}//Comprobacion Datos Completos
        return false;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoBotonesSexo = new javax.swing.ButtonGroup();
        pnlGlass = new javax.swing.JPanel();
        blEstado = new org.jdesktop.swingx.JXBusyLabel();
        pnlDatos = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        tfApellido = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        tfCorreo = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        lblEdad = new javax.swing.JLabel();
        SliderAños = new javax.swing.JSlider();
        lblAños = new javax.swing.JLabel();
        rbtnHombre = new javax.swing.JRadioButton();
        rbtnMujer = new javax.swing.JRadioButton();
        rbtnOtro = new javax.swing.JRadioButton();
        lblSexo = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        BtnEnviar = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlGlass.setOpaque(false);
        pnlGlass.setLayout(new java.awt.GridBagLayout());

        blEstado.setForeground(new java.awt.Color(255, 255, 255));
        blEstado.setFocusable(false);
        blEstado.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        pnlGlass.add(blEstado, new java.awt.GridBagConstraints());

        getContentPane().add(pnlGlass, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 440));

        pnlDatos.setOpaque(false);

        lblUsername.setBackground(new java.awt.Color(255, 255, 255));
        lblUsername.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("Username:");

        tfUsername.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblPassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("PassWord:");

        tfNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre (s):");

        tfApellido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfApellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblApellido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblApellido.setForeground(new java.awt.Color(255, 255, 255));
        lblApellido.setText("Apellido:");

        tfCorreo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfCorreo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblCorreo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreo.setText("Email:");

        jPasswordField1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPasswordField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField1.setPreferredSize(new java.awt.Dimension(120, 23));

        lblEdad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblEdad.setForeground(new java.awt.Color(255, 255, 255));
        lblEdad.setText("Edad:");

        SliderAños.setValue(0);
        SliderAños.setOpaque(false);
        SliderAños.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderAñosStateChanged(evt);
            }
        });

        lblAños.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblAños.setForeground(new java.awt.Color(255, 255, 255));
        lblAños.setText("0 Años");

        rbtnHombre.setForeground(new java.awt.Color(255, 255, 255));
        rbtnHombre.setText("Hombre");
        rbtnHombre.setOpaque(false);

        rbtnMujer.setForeground(new java.awt.Color(255, 255, 255));
        rbtnMujer.setText("Mujer");
        rbtnMujer.setOpaque(false);

        rbtnOtro.setForeground(new java.awt.Color(255, 255, 255));
        rbtnOtro.setText("No Especificado");
        rbtnOtro.setOpaque(false);

        lblSexo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblSexo.setForeground(new java.awt.Color(255, 255, 255));
        lblSexo.setText("Sexo:");

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEdad, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSexo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblApellido, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCorreo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblUsername, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCorreo)
                    .addComponent(tfNombre)
                    .addComponent(tfApellido)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(rbtnHombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnMujer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnOtro))
                    .addComponent(tfUsername)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(lblAños)
                        .addComponent(SliderAños, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo)
                    .addComponent(tfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido)
                    .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnHombre)
                    .addComponent(rbtnMujer)
                    .addComponent(rbtnOtro)
                    .addComponent(lblSexo))
                .addGap(12, 12, 12)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SliderAños, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEdad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAños)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(pnlDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 370, 290));

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Registro");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        btnLogOut.setBackground(new java.awt.Color(153, 204, 255));
        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit32.png"))); // NOI18N
        btnLogOut.setToolTipText("Regresar a Menú principal");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, -1));

        btnCancel.setBackground(new java.awt.Color(153, 204, 255));
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel32.png"))); // NOI18N
        btnCancel.setToolTipText("Limpiar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, -1, -1));

        BtnEnviar.setBackground(new java.awt.Color(153, 204, 255));
        BtnEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/check32.png"))); // NOI18N
        BtnEnviar.setToolTipText("Enviar");
        BtnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, -1, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondoRegistro.png"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        Opciones o = new Opciones();
        o.setUsuario(usuario);
        o.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void BtnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEnviarActionPerformed
        if(ValidarRegistro()){
            getDatos();
        }
    }//GEN-LAST:event_BtnEnviarActionPerformed

    private void SliderAñosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderAñosStateChanged
        lblAños.setText(String.valueOf(SliderAños.getValue())+" Años");
    }//GEN-LAST:event_SliderAñosStateChanged

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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEnviar;
    private javax.swing.ButtonGroup GrupoBotonesSexo;
    private javax.swing.JSlider SliderAños;
    private org.jdesktop.swingx.JXBusyLabel blEstado;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblAños;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlGlass;
    private javax.swing.JRadioButton rbtnHombre;
    private javax.swing.JRadioButton rbtnMujer;
    private javax.swing.JRadioButton rbtnOtro;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfCorreo;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
