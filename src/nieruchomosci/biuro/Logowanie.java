/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nieruchomosci.biuro;

import com.nieruchomosci.biuro.biuroniruchomoscitest.BazaBiura;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Tomasz
 */
public class Logowanie extends javax.swing.JPanel {
    BazaBiura _db;
    BiuroNieruchomosci _bn;
    server _server;
    /**
     * Creates new form Logowanie
     */
    public Logowanie(BazaBiura db,BiuroNieruchomosci bn)  {
        initComponents();
        _db=db;
        _bn=bn;
    }
    
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        TextLogin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ButtonZaloguj = new javax.swing.JButton();
        TextPassword = new javax.swing.JPasswordField();

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Logowanie");
        jLabel3.setToolTipText("");
        jLabel3.setAlignmentX(0.5F);

        TextLogin.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel1.setText("Wpisz login:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel2.setText("Wpisz has�o:");

        ButtonZaloguj.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        ButtonZaloguj.setText("Zaloguj");
        ButtonZaloguj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonZalogujMouseClicked(evt);
            }
        });

        TextPassword.setToolTipText("");
        TextPassword.setName("TextPassword"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(TextPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(TextLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(4, 4, 4))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(ButtonZaloguj, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(TextPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ButtonZaloguj, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonZalogujMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonZalogujMouseClicked
        // TODO add your handling code here:
        String password = String.valueOf(TextPassword.getPassword());
            if(password.length() == 0 || TextLogin.getText().length() ==0){
                JOptionPane.showMessageDialog(this, "Nie wype�niono odpowiednich p�l");
            }else{
                int ID = 0;
                boolean flaga = false;
                try{
                flaga=_bn.server.Request_Is_userIhaslo(TextLogin.getText(), password);
                ID=_bn.server.getUserID(TextLogin.getText());
                }catch (Exception ex) {
                    try {
                        flaga=_db.Is_userIhaslo(TextLogin.getText(), password);
                        ID=_db.getUserID(TextLogin.getText());

                    } catch (RemoteException ex1) {
                    }
                }
            if( flaga ){
           this.setVisible(false);
           _bn.logInMenuItem.setVisible(false);
           _bn.registerMenuItem.setVisible(false);
           _bn.logOutMenuItem.setVisible(true);
           _bn.jMenu2.setVisible(true);
           _bn.calendarMenu.setVisible(true);
           _bn.setIDUser(ID);
        }else{
             JOptionPane.showMessageDialog(this, "B��dnie wype�nione pola Login lub Has�o");
        }
    }//GEN-LAST:event_ButtonZalogujMouseClicked
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonZaloguj;
    private javax.swing.JTextField TextLogin;
    private javax.swing.JPasswordField TextPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}