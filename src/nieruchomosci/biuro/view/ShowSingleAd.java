package nieruchomosci.biuro.view;

import nieruchomosci.biuro.FileTypeFilter;
import nieruchomosci.biuro.PDFSetting;
import com.itextpdf.text.DocumentException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class ShowSingleAd extends javax.swing.JPanel {
    private List<JLabel> labalList = new ArrayList<JLabel>();

    public List<JLabel> getLabalList() {
        return labalList;
    }
    
    private String getProperPath(File file){
        String path = file.getPath();
        String sub = path.substring(path.length() - 4, path.length());
        if (!sub.toLowerCase().equals(".pdf")){
            path += ".pdf";
        }
        return path;
    }
    
    public ShowSingleAd() {
        initComponents();
        
        drukujBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser saveFileDialog = new JFileChooser("C:\\");
                saveFileDialog.setDialogTitle("Zapisz plik jako");
                saveFileDialog.setFileFilter(new FileTypeFilter(".pdf", "Pliki PDF"));
                int result = saveFileDialog.showSaveDialog(null);
                
                if (result == JFileChooser.APPROVE_OPTION){
                    try {
                        new PDFSetting().print(labalList, getProperPath(saveFileDialog.getSelectedFile()));
                    } catch (FileNotFoundException | DocumentException ex) {
                        Logger.getLogger(ShowSingleAd.class.getName()).log(Level.FINE, ex.getMessage());
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
//                } else {
//                    JOptionPane.showMessageDialog(null, "Podczas próby zapisania pliku wystąpił nieoczekiwany błąd.\n"
//                            + "Skontaktuj się z administratorem aplikacji w celu rozwiązania nieprawidłowości.");
//                }
            }
        });
        
        labalList.add(imieL);
        labalList.add(nazwiskoL);
        labalList.add(panstwoL);
        labalList.add(miastoL);
        labalList.add(wojewodztwaL);
        labalList.add(transakcjaL);
        labalList.add(czynszL);
        labalList.add(powierzchniaL);
        labalList.add(pietroL);
        labalList.add(iloscPieterL);
        labalList.add(rokBudowyL);
        labalList.add(rodzajWlasnosciL);
        labalList.add(stanTechL);
        labalList.add(oknaL);
        labalList.add(ogrzewanieL);
        labalList.add(cieplaWodaL);
        labalList.add(lazienkaL);
        labalList.add(wcL);
        labalList.add(kuchniaL);
        labalList.add(garazL);
        labalList.add(miejsceParkingoweL);
        labalList.add(piwnicaL);
        labalList.add(balkonL);
        labalList.add(windaL);
        labalList.add(zsypL);
        labalList.add(umeblowanieL);
        
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        imieL = new javax.swing.JLabel();
        nazwiskoL = new javax.swing.JLabel();
        panstwoL = new javax.swing.JLabel();
        miastoL = new javax.swing.JLabel();
        wojewodztwaL = new javax.swing.JLabel();
        transakcjaL = new javax.swing.JLabel();
        czynszL = new javax.swing.JLabel();
        powierzchniaL = new javax.swing.JLabel();
        pietroL = new javax.swing.JLabel();
        iloscPieterL = new javax.swing.JLabel();
        rokBudowyL = new javax.swing.JLabel();
        rodzajWlasnosciL = new javax.swing.JLabel();
        stanTechL = new javax.swing.JLabel();
        oknaL = new javax.swing.JLabel();
        ogrzewanieL = new javax.swing.JLabel();
        cieplaWodaL = new javax.swing.JLabel();
        lazienkaL = new javax.swing.JLabel();
        wcL = new javax.swing.JLabel();
        kuchniaL = new javax.swing.JLabel();
        garazL = new javax.swing.JLabel();
        miejsceParkingoweL = new javax.swing.JLabel();
        piwnicaL = new javax.swing.JLabel();
        balkonL = new javax.swing.JLabel();
        windaL = new javax.swing.JLabel();
        zsypL = new javax.swing.JLabel();
        umeblowanieL = new javax.swing.JLabel();
        drukujBtn = new javax.swing.JButton();

        jLabel1.setText("Dane klienta:");

        jLabel2.setText("Imię: ");

        jLabel3.setText("Nazwisko: ");

        jLabel6.setText("Państwo: ");

        jLabel7.setText("Miasto: ");

        jLabel8.setText("Województwa: ");

        jLabel9.setText("Szczegóły:");

        jLabel10.setText("Transakcja: ");

        jLabel11.setText("Czynsz: ");

        jLabel12.setText("Powierzchnia: ");

        jLabel13.setText("Piętro: ");

        jLabel14.setText("Ilość pięter: ");

        jLabel15.setText("Rok budowy: ");

        jLabel16.setText("Rodzaj własności: ");

        jLabel17.setText("Stan techniczny: ");

        jLabel18.setText("Okna: ");

        jLabel19.setText("Ogrzewanie: ");

        jLabel20.setText("Ciepła woda: ");

        jLabel21.setText("Łazienka: ");

        jLabel22.setText("WC: ");

        jLabel23.setText("Kuchnia: ");

        jLabel24.setText("Garaż: ");

        jLabel25.setText("Miejsce parkingowe: ");

        jLabel26.setText("Piwnica: ");

        jLabel27.setText("Balkon: ");

        jLabel28.setText("Winda: ");

        jLabel29.setText("Zsyp: ");

        jLabel30.setText("Umeblowanie: ");

        imieL.setText(" ");

        nazwiskoL.setText(" ");

        panstwoL.setText(" ");

        miastoL.setText(" ");

        wojewodztwaL.setText(" ");

        transakcjaL.setText(" ");

        czynszL.setText(" ");

        powierzchniaL.setText(" ");

        pietroL.setText(" ");

        iloscPieterL.setText(" ");

        rokBudowyL.setText(" ");

        rodzajWlasnosciL.setText(" ");

        stanTechL.setText(" ");

        oknaL.setText(" ");

        ogrzewanieL.setText(" ");

        cieplaWodaL.setText(" ");

        lazienkaL.setText(" ");

        wcL.setText(" ");

        kuchniaL.setText(" ");

        garazL.setText(" ");

        miejsceParkingoweL.setText(" ");

        piwnicaL.setText(" ");

        balkonL.setText(" ");

        windaL.setText(" ");

        zsypL.setText(" ");

        umeblowanieL.setText(" ");

        drukujBtn.setText("Drukuj");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel2))
                                        .addGap(16, 16, 16)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nazwiskoL)
                                            .addComponent(imieL)
                                            .addComponent(panstwoL)
                                            .addComponent(miastoL)
                                            .addComponent(wojewodztwaL))
                                        .addGap(87, 87, 87))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(transakcjaL)
                                            .addComponent(czynszL)
                                            .addComponent(powierzchniaL)
                                            .addComponent(pietroL)
                                            .addComponent(iloscPieterL)
                                            .addComponent(rokBudowyL))
                                        .addGap(86, 86, 86))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel15)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(rodzajWlasnosciL))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel17)
                                                    .addComponent(jLabel18)
                                                    .addComponent(jLabel19))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(ogrzewanieL)
                                                    .addComponent(oknaL)
                                                    .addComponent(stanTechL)
                                                    .addComponent(cieplaWodaL))))
                                        .addGap(102, 102, 102)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel22)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(wcL))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel21)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lazienkaL))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel30)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(umeblowanieL))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel23)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(kuchniaL))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel24)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(garazL))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel25)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                                                .addComponent(miejsceParkingoweL))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel26)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(piwnicaL))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel27)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(balkonL))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel28)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(windaL))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel29)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(zsypL)))))
                                .addGap(37, 37, 37))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(drukujBtn)
                                .addGap(51, 51, 51)))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(imieL)))
                    .addComponent(drukujBtn))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nazwiskoL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(panstwoL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(miastoL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(wojewodztwaL))
                .addGap(47, 47, 47)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel21)
                    .addComponent(transakcjaL)
                    .addComponent(lazienkaL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel22)
                    .addComponent(czynszL)
                    .addComponent(wcL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel23)
                    .addComponent(powierzchniaL)
                    .addComponent(kuchniaL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel24)
                    .addComponent(pietroL)
                    .addComponent(garazL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel25)
                    .addComponent(iloscPieterL)
                    .addComponent(miejsceParkingoweL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel26)
                    .addComponent(rokBudowyL)
                    .addComponent(piwnicaL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel27)
                    .addComponent(rodzajWlasnosciL)
                    .addComponent(balkonL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel28)
                    .addComponent(stanTechL)
                    .addComponent(windaL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel29)
                    .addComponent(oknaL)
                    .addComponent(zsypL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel30)
                    .addComponent(ogrzewanieL)
                    .addComponent(umeblowanieL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(cieplaWodaL))
                .addContainerGap(154, Short.MAX_VALUE))
        );

        imieL.getAccessibleContext().setAccessibleName("Imie");
        nazwiskoL.getAccessibleContext().setAccessibleName("Nazwisko");
        panstwoL.getAccessibleContext().setAccessibleName("Państwo");
        miastoL.getAccessibleContext().setAccessibleName("Miasto");
        wojewodztwaL.getAccessibleContext().setAccessibleName("Województwo");
        transakcjaL.getAccessibleContext().setAccessibleName("Tranzakcja");
        czynszL.getAccessibleContext().setAccessibleName("Czynsz");
        powierzchniaL.getAccessibleContext().setAccessibleName("Powierzchnia");
        pietroL.getAccessibleContext().setAccessibleName("Piętro");
        iloscPieterL.getAccessibleContext().setAccessibleName("Ilość Pięter");
        rokBudowyL.getAccessibleContext().setAccessibleName("Rok budowy");
        rodzajWlasnosciL.getAccessibleContext().setAccessibleName("Rodzaj własności");
        stanTechL.getAccessibleContext().setAccessibleName("Stan techniczny");
        oknaL.getAccessibleContext().setAccessibleName("Okna");
        ogrzewanieL.getAccessibleContext().setAccessibleName("Ogrzewanie");
        cieplaWodaL.getAccessibleContext().setAccessibleName("Ciepła woda");
        lazienkaL.getAccessibleContext().setAccessibleName("Łazięka");
        wcL.getAccessibleContext().setAccessibleName("Toaleta");
        kuchniaL.getAccessibleContext().setAccessibleName("Kuchnia");
        garazL.getAccessibleContext().setAccessibleName("Garaż");
        miejsceParkingoweL.getAccessibleContext().setAccessibleName("Miejsce parkingowe");
        piwnicaL.getAccessibleContext().setAccessibleName("Piwnica");
        balkonL.getAccessibleContext().setAccessibleName("Balkon");
        windaL.getAccessibleContext().setAccessibleName("Winda");
        zsypL.getAccessibleContext().setAccessibleName("Zsyp");
        umeblowanieL.getAccessibleContext().setAccessibleName("Umeblowanie");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel balkonL;
    private javax.swing.JLabel cieplaWodaL;
    private javax.swing.JLabel czynszL;
    private javax.swing.JButton drukujBtn;
    private javax.swing.JLabel garazL;
    private javax.swing.JLabel iloscPieterL;
    private javax.swing.JLabel imieL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kuchniaL;
    private javax.swing.JLabel lazienkaL;
    private javax.swing.JLabel miastoL;
    private javax.swing.JLabel miejsceParkingoweL;
    private javax.swing.JLabel nazwiskoL;
    private javax.swing.JLabel ogrzewanieL;
    private javax.swing.JLabel oknaL;
    private javax.swing.JLabel panstwoL;
    private javax.swing.JLabel pietroL;
    private javax.swing.JLabel piwnicaL;
    private javax.swing.JLabel powierzchniaL;
    private javax.swing.JLabel rodzajWlasnosciL;
    private javax.swing.JLabel rokBudowyL;
    private javax.swing.JLabel stanTechL;
    private javax.swing.JLabel transakcjaL;
    private javax.swing.JLabel umeblowanieL;
    private javax.swing.JLabel wcL;
    private javax.swing.JLabel windaL;
    private javax.swing.JLabel wojewodztwaL;
    private javax.swing.JLabel zsypL;
    // End of variables declaration//GEN-END:variables
}
