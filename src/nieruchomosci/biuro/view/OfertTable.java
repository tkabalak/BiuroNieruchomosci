package nieruchomosci.biuro.view;

import nieruchomosci.biuro.entity.Oferta;
import nieruchomosci.biuro.models.SingleAdModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JFrame;
import javax.swing.JTextField;
import nieruchomosci.biuro.classDB;
import nieruchomosci.biuro.entity.Szczegoly;

public class OfertTable extends javax.swing.JPanel {
    private final Map<Integer, SingleAdModel> windows = new HashMap<>();
    private Query q1;
    private Query q2;
    private String databaseName;
    private classDB dB;
    public OfertTable(boolean whichDatabase, classDB dB) {
        this.dB = dB;
        databaseName = whichDatabase ? "WSI_REMOTE" : "WSI_LOCAL";
        
        initComponents();
        
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ( e.getClickCount() == 2)
                    showAdvert();
            }
        });
        
        searchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                wyszukajOferte();
                jTable2.updateUI();
                jTable2.repaint();
            }
        });
        resetButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ((classDB.ResultListJPA)list1).setQueries(getRowsCount, getRowsQuery);
                jTable2.updateUI();
            }
        });
        
        deleteAdBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = jTable2.getSelectedRow();
                if (i != -1){
                    entityManager1.getTransaction().begin();
                    entityManager1.remove(list1.get(i));
                    TypedQuery<Szczegoly> q = entityManager1.createQuery("SELECT s FROM Szczegoly s WHERE s.iDoferty=" + list1.get(i).getId() , Szczegoly.class);
                    entityManager1.remove(q.getSingleResult());
                    entityManager1.getTransaction().commit();
                    jTable2.updateUI();
                }
            }
        });
    }
    
    public void setDatabase(boolean whichDatabase){
        databaseName = whichDatabase ? "WSI_REMOTE" : "WSI_LOCAL";
        initComponents();
    }
    
    private void showAdvert(){
        SingleAdModel toReturn = windows.get(jTable2.getSelectedRow());
        if (toReturn != null){
            toReturn.setMaxSizeWindow();
        } else {
            SingleAdModel zm = new SingleAdModel(entityManager1, 
                    list1.get(jTable2.getSelectedRow()), 
                    windows, 
                    jTable2.getSelectedRow(),
                    dB);

            windows.put(jTable2.getSelectedRow(), zm);
            zm.start();
        }
    }
    
    private List<Oferta> getList(){
//        ResultListJPA<Oferta> toReturn = new ResultListJPA<>(getRowsCount, getRowsQuery);
        return dB.getResultListJPA(getRowsCount, getRowsQuery);
    }
    
    private boolean wyszukajOferte(){
        StringBuilder selectQuery = new StringBuilder("SELECT o FROM Oferta o");
        StringBuilder countQuery = new StringBuilder("SELECT COUNT(o) FROM Oferta o");
        
        StringBuilder sd = new StringBuilder();
        
        computeQueryForSearch(idField, sd, "id");
        computeQueryForSearch(czynszField, sd, "czynsz");
        computeQueryForSearch(powierzchniaField, sd, "powM2");
        computeQueryForSearch(piertoField, sd, "pietro");
        computeQueryForSearch(ilePieterField, sd, "iloscpieter");
        
        String str = (String) transakcjaCombo.getSelectedItem();
        
        if ( !str.equals(transakcjaCombo.getItemAt(0))){
           if (!sd.toString().equals("")) 
                sd.append(" AND");
           sd.append("  LOWER(o.transakcja) LIKE '").append(str.toLowerCase()).append("'");  
        }
        
        if (!sd.toString().isEmpty()) {
            selectQuery.append(" WHERE ").append(sd);
            countQuery.append(" WHERE ").append(sd);
        }
        
        q2 = entityManager1.createQuery(selectQuery.toString());
        q1 = entityManager1.createQuery(countQuery.toString());
        
        ((classDB.ResultListJPA)list1).setQueries(q1, q2);
        jTable2.removeAll();
        jTable2.repaint();
        jTable2.updateUI();
        return true;
    }
    
    private void computeQueryForSearch(JTextField field, StringBuilder queryBuilder, String rowName){
        StringBuilder sb = new StringBuilder();
        if (field != null && !field.getText().equals("") && isInteger(field.getText()) ){
            sb.append(" o.").append(rowName).append("=").append(field.getText());
            if ( !queryBuilder.toString().equals(""))
                queryBuilder.append(" AND");
        }
        queryBuilder.append(sb);
    }
    
    private boolean isInteger( String input ) {
        try {
            Integer.parseInt( input );
            return true;
        } catch( Exception ex ) {
            Logger.getLogger(Integer.class.getName()).log(Level.WARNING, null, ex);
            return false;
        }
    }    
    
        
        
    @SuppressWarnings("unchecked")
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager1 = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory(databaseName).createEntityManager();
        getRowsQuery = java.beans.Beans.isDesignTime() ? null : entityManager1.createQuery("SELECT o FROM Oferta o");
        getRowsCount = java.beans.Beans.isDesignTime() ? null : entityManager1.createQuery("SELECT COUNT(o) FROM Oferta o");
        list1 = getList();
        getSearchQuery = java.beans.Beans.isDesignTime() ? null : entityManager1.createQuery("SELECT o FROM Oferta o");
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        idField = new javax.swing.JTextField();
        czynszField = new javax.swing.JTextField();
        powierzchniaField = new javax.swing.JTextField();
        piertoField = new javax.swing.JTextField();
        ilePieterField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        transakcjaCombo = new javax.swing.JComboBox();
        resetButton = new javax.swing.JButton();
        deleteAdBtn = new javax.swing.JButton();

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list1, jTable2);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("ID");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${transakcja}"));
        columnBinding.setColumnName("Transakcja");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${czynsz}"));
        columnBinding.setColumnName("Czynsz");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${powM2}"));
        columnBinding.setColumnName("Powierzchnia(m2)");
        columnBinding.setColumnClass(Float.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${pietro}"));
        columnBinding.setColumnName("Piêtro");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${iloscpieter}"));
        columnBinding.setColumnName("Iloœæ piêter");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${datautworzenia}"));
        columnBinding.setColumnName("Data dodania");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setText("ID");

        jLabel2.setText("transakcja");

        jLabel3.setText("Wyszukiwanie:");

        jLabel4.setText("czynsz");

        jLabel5.setText("powierzchnia");

        searchButton.setText("Szukaj");

        jLabel6.setText("pietro");

        jLabel7.setText("ilosc pieter");

        transakcjaCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-------", "Sprzedaz", "Zamiana", "Wynajem" }));

        resetButton.setText("Reset");

        deleteAdBtn.setText("Usun");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(transakcjaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(czynszField, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(powierzchniaField, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(piertoField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ilePieterField, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resetButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteAdBtn))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(czynszField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(powierzchniaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(piertoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ilePieterField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(transakcjaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetButton)
                    .addComponent(deleteAdBtn))
                .addGap(28, 28, 28))
        );
        
        bindingGroup.bind();
    }
    
    public void pack(JFrame frame){
        frame.pack();
    }
    public void setLayout(JFrame frame){
        if (frame != null){
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
            frame.getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
            );
        }
    }

    private javax.swing.JTextField czynszField;
    private javax.swing.JButton deleteAdBtn;
    private javax.persistence.EntityManager entityManager1;
    private javax.persistence.Query getRowsCount;
    private javax.persistence.Query getRowsQuery;
    private javax.persistence.Query getSearchQuery;
    private javax.swing.JTextField idField;
    private javax.swing.JTextField ilePieterField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private java.util.List<Oferta> list1;
    private javax.swing.JTextField piertoField;
    private javax.swing.JTextField powierzchniaField;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox transakcjaCombo;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
}