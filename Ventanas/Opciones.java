/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import misc.Usuario;

/**
 *
 * @author Ruben Angeles
 */
public class Opciones extends javax.swing.JFrame {
    
    public static Usuario usuario;
    
    public void setUsuario(Usuario u){
        this.usuario = u;
    }

    /**
     * Creates new form Opciones
     */
    public Opciones() {
        usuario = Login.usuario;
        initComponents();
        this.setLocationRelativeTo(null);
        if (!"Admin".equals(usuario.getTipo())) {
            pnlBotonesABC.setVisible(false);
            btnUser.setVisible(false);
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

        pnlBotonesBusquedas = new javax.swing.JPanel();
        btnBuscarTicket = new javax.swing.JButton();
        btnBuscarEquipo = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        pnlBotonesABC = new javax.swing.JPanel();
        btnAltaDoc = new javax.swing.JButton();
        btnAltaToner = new javax.swing.JButton();
        btnBajaToner = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBotonesBusquedas.setOpaque(false);
        pnlBotonesBusquedas.setLayout(new java.awt.GridBagLayout());

        btnBuscarTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BuscarDoc96.png"))); // NOI18N
        btnBuscarTicket.setToolTipText("Buscar Ticket");
        pnlBotonesBusquedas.add(btnBuscarTicket, new java.awt.GridBagConstraints());

        btnBuscarEquipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa96.png"))); // NOI18N
        btnBuscarEquipo.setToolTipText("Buscar Numero de Serie");
        btnBuscarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEquipoActionPerformed(evt);
            }
        });
        pnlBotonesBusquedas.add(btnBuscarEquipo, new java.awt.GridBagConstraints());

        btnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user96.png"))); // NOI18N
        btnUser.setToolTipText("Registro de usuarios");
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });
        pnlBotonesBusquedas.add(btnUser, new java.awt.GridBagConstraints());

        getContentPane().add(pnlBotonesBusquedas, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 440, 110));

        pnlBotonesABC.setOpaque(false);
        pnlBotonesABC.setLayout(new java.awt.GridBagLayout());

        btnAltaDoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AltaDoc96.png"))); // NOI18N
        btnAltaDoc.setToolTipText("Alta Documento Falla o Bitacora");
        pnlBotonesABC.add(btnAltaDoc, new java.awt.GridBagConstraints());

        btnAltaToner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AltaToner96.png"))); // NOI18N
        btnAltaToner.setToolTipText("Alta Toner en el inventario");
        pnlBotonesABC.add(btnAltaToner, new java.awt.GridBagConstraints());

        btnBajaToner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BajaToner96.png"))); // NOI18N
        btnBajaToner.setToolTipText("Cambio y Baja de Toner del inventario");
        pnlBotonesABC.add(btnBajaToner, new java.awt.GridBagConstraints());

        getContentPane().add(pnlBotonesABC, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 440, 110));

        btnLogOut.setBackground(new java.awt.Color(153, 204, 255));
        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit32.png"))); // NOI18N
        btnLogOut.setToolTipText("LogOut");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, -1, -1));

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Menú Principal");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoOpciones.png"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        Registro r = new Registro();
        this.dispose();
        r.setVisible(true);
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        this.dispose();
        Login l = new Login();
        l.setVisible(true);
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnBuscarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEquipoActionPerformed
        BuscarEquipo b =  new BuscarEquipo();
        this.dispose();
        b.setVisible(true);
    }//GEN-LAST:event_btnBuscarEquipoActionPerformed

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
            java.util.logging.Logger.getLogger(Opciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Opciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Opciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Opciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Opciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAltaDoc;
    private javax.swing.JButton btnAltaToner;
    private javax.swing.JButton btnBajaToner;
    private javax.swing.JButton btnBuscarEquipo;
    private javax.swing.JButton btnBuscarTicket;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnUser;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBotonesABC;
    private javax.swing.JPanel pnlBotonesBusquedas;
    // End of variables declaration//GEN-END:variables
}