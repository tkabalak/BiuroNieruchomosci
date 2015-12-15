package nieruchomosci.biuro;

import com.nieruchomosci.biuro.biuroniruchomoscitest.BazaBiura;
import com.nieruchomosci.biuro.biuroniruchomoscitest.Constrant;
import nieruchomosci.biuro.view.OfertTable;
import nieruchomosci.biuro.view.Kalendarz;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BiuroNieruchomosci extends javax.swing.JFrame {
    private Logowanie logowanie;
    private Rejestracja rejestracja;
    private StatusServera status;
    private DodawanieOferty dodawanieOferty;
    private Kalendarz kalendarz;
    private OfertTable oferty;
    private SettingsForm settingsF;
    private int Id_user;
    private static Settings setting;
    private final BiuroNieruchomosci bn = this;
    private BazaBiura sc = null;
    private ReturnConnection rc;
    Container pane;
    classDB db;
    classCheck ch;
    server server;

    public BazaBiura getSc() {
        return sc;
    }

    public void setSc(BazaBiura sc) {
        this.sc = sc;
    }

    
    
    public BiuroNieruchomosci() throws Exception {
        initComponents();
        
        Registry rs = LocateRegistry.getRegistry("127.0.0.1", Constrant.PORT);
        //BazaBiura sc = null;
        try{
            sc = (BazaBiura) rs.lookup(Constrant.RMI_ID);
            logowanie = new Logowanie(sc ,this);
            rejestracja= new Rejestracja(sc);
            status= new StatusServera();
            dodawanieOferty=new DodawanieOferty(sc,Id_user,this);
            kalendarz=new Kalendarz(sc,Id_user);
            rc = new ReturnConnection(bn);
            rc.start();
            
        } catch (RemoteException | NotBoundException e){
            //Logger.getLogger(BiuroNieruchomosci.class.getName()).log(Level.INFO," elo ",  e);
            System.out.printf("brak po³¹czenia z serverem");
            db = new classDB();
            logowanie = new Logowanie(db,this);
            rejestracja= new Rejestracja(db);
            status= new StatusServera();
            
            dodawanieOferty=new DodawanieOferty(db,Id_user,this);
            kalendarz=new Kalendarz(db,Id_user);
        }
        
        pane = getContentPane();
        ch= new classCheck(sc, status);
        ch.start();
        
        setManuActions();
        settingsF = new SettingsForm();
    }
    
    private void setManuActions(){
        showMenuItem.addActionListener((ActionEvent e) -> {
            long start = System.currentTimeMillis();
            pane.removeAll();
            oferty = new OfertTable(db.getStatus(), db);
            oferty.setLayout(this);
            pane.add(status);
            pane.add(oferty);
            oferty.setVisible(true);
            this.repaint();
            this.validate();
            long end = System.currentTimeMillis();
            System.out.println((end - start)/1000);
        });
        logInMenuItem.addActionListener((ActionEvent e) -> {
            pane.removeAll();
            pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
            pane.add(status);
            pane.add(logowanie ,BorderLayout.PAGE_START);
            logowanie.setVisible(true);
            this.repaint();
            this.validate(); 
        });
        registerMenuItem.addActionListener((ActionEvent e) -> {
            pane.removeAll();
            pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
            pane.add(status);
            pane.add(rejestracja ,BorderLayout.PAGE_START);
            rejestracja.setVisible(true);
            this.repaint();
            this.validate();
        });
        
        settingMenuOpt.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                pane.removeAll();
                pane.add(status);
                pane.add(settingsF);
                settingsF.setVisible(true);
                bn.repaint();
                bn.validate();
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        logInMenuItem = new javax.swing.JMenuItem();
        registerMenuItem = new javax.swing.JMenuItem();
        logOutMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        closeMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        addMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        showMenuItem = new javax.swing.JMenuItem();
        calendarMenu = new javax.swing.JMenu();
        settingMenuOpt = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        jMenu1.setText("Logowanie");

        logInMenuItem.setText("Zaloguj");
        jMenu1.add(logInMenuItem);

        registerMenuItem.setText("Zarejestruj");
        jMenu1.add(registerMenuItem);

        logOutMenuItem.setText("Wyloguj");
        logOutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(logOutMenuItem);
        jMenu1.add(jSeparator2);

        closeMenuItem.setText("Zamknij");
        closeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(closeMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ofety");

        addMenuItem.setText("Dodaj");
        addMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(addMenuItem);
        jMenu2.add(jSeparator1);

        showMenuItem.setText("Wyœwietl");
        jMenu2.add(showMenuItem);

        jMenuBar1.add(jMenu2);
        jMenu2.setVisible(false);

        calendarMenu.setText("Kalendarz");
        calendarMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calendarMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(calendarMenu);

        settingMenuOpt.setText("Ustawienia");
        jMenuBar1.add(settingMenuOpt);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 337, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenuItemActionPerformed
            pane.removeAll();
            dodawanieOferty = new DodawanieOferty(db,Id_user,this);
            pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
            pane.add(status);
            pane.add(dodawanieOferty,BorderLayout.PAGE_START);
            dodawanieOferty.setVisible(true);
            this.repaint();
            this.validate();   
    }//GEN-LAST:event_addMenuItemActionPerformed

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentHidden

    private void logOutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutMenuItemActionPerformed
        pane.removeAll();
        pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
        pane.add(status);
        pane.add(logowanie ,BorderLayout.PAGE_START);
        logowanie.setVisible(true);
        jMenu2.setVisible(false);
        calendarMenu.setVisible(false);
        logInMenuItem.setVisible(true);
        registerMenuItem.setVisible(true);
        logOutMenuItem.setVisible(false);
        this.repaint();
        this.validate(); 
    }//GEN-LAST:event_logOutMenuItemActionPerformed

    private void closeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeMenuItemActionPerformed
        try {
            db.close();
        } catch (SQLException ex) {
            Logger.getLogger(BiuroNieruchomosci.class.getName()).log(Level.SEVERE, null, ex);
        }
       System.exit(this.EXIT_ON_CLOSE);
    }//GEN-LAST:event_closeMenuItemActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setExtendedState(this.MAXIMIZED_BOTH); 
        jMenu2.setVisible(false);
        calendarMenu.setVisible(false);
        logowanie.setSize(378, 224);
              // System.out.println(this.getPreferredSize());
              // System.out.println(logowanie.getPreferredSize());
               //[378, 224]
        pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
        logowanie.setVisible(true);

        pane.add(logowanie,BorderLayout.PAGE_START);
        jMenu2.setVisible(false);
        logOutMenuItem.setVisible(false);
        //this.remove(rejestracja);
        //this.add(logowanie);

        pane.setLayout(new BoxLayout(pane,BoxLayout.PAGE_AXIS));
        status.setVisible(true);
        pane.add(status,BorderLayout.PAGE_END);

    }//GEN-LAST:event_formWindowOpened
    
    
    private void calendarMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calendarMenuMouseClicked
        pane.removeAll();
        pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
        pane.add(status);
        pane.add(kalendarz,BorderLayout.PAGE_START);
        kalendarz.setVisible(true);
        this.repaint();
        this.validate(); 
    }//GEN-LAST:event_calendarMenuMouseClicked

    public int getIDUser(){
        return Id_user;
    }
    public void setIDUser(int user){
        Id_user=user;
    }
    public static void main(String args[]) throws InterruptedException {
        setting = SettingFile.readFile();
        if ( setting == null){
            java.awt.EventQueue.invokeLater(() -> {
                final JFrame frame = new JFrame("Ustawienia");
                JPanel panel = new SettingsForm();
                frame.add(panel);
                frame.setSize(600, 600);
                panel.setVisible(true);
                frame.setVisible(true);
                //frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        if(SettingFile.readFile() != null){
                            BiuroNieruchomosci.initMainWind();
                            frame.setVisible(false);
                        }

                    }
                });
            });
        } else if (setting != null){
            BiuroNieruchomosci.initMainWind();
        }
    }

    private static void initMainWind(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BiuroNieruchomosci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BiuroNieruchomosci().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(BiuroNieruchomosci.class.getName()).log(Level.SEVERE, null, ex);
                }


            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addMenuItem;
    public javax.swing.JMenu calendarMenu;
    private javax.swing.JMenuItem closeMenuItem;
    public javax.swing.JMenu jMenu1;
    public javax.swing.JMenu jMenu2;
    public javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    public javax.swing.JMenuItem logInMenuItem;
    public javax.swing.JMenuItem logOutMenuItem;
    public javax.swing.JMenuItem registerMenuItem;
    private javax.swing.JMenu settingMenuOpt;
    private javax.swing.JMenuItem showMenuItem;
    // End of variables declaration//GEN-END:variables
}
