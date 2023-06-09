/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projekt_kino;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class Lista_Filmow extends javax.swing.JFrame {

    GUI1 mainGUI;
    private EkranDodawanieFilmow addFilm;
    /**
     * Creates new form Lista_Filmow
     */
    public Lista_Filmow(GUI1 gui) {
        initComponents();
        mainGUI = gui;
        addFilm = new EkranDodawanieFilmow(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableFilm = new javax.swing.JTable();
        jButBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButDelete = new javax.swing.JButton();
        jButAdd = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jDeleteMes = new javax.swing.JLabel();

        jLabel2.setText("Wybierz ID filmu");

        jLabel3.setText("Wybierz ID filmu");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableFilm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Tytuł", "Gatunek", "Rok", "Czas trwania"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableFilm);
        if (jTableFilm.getColumnModel().getColumnCount() > 0) {
            jTableFilm.getColumnModel().getColumn(0).setResizable(false);
            jTableFilm.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTableFilm.getColumnModel().getColumn(1).setResizable(false);
            jTableFilm.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTableFilm.getColumnModel().getColumn(2).setResizable(false);
            jTableFilm.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTableFilm.getColumnModel().getColumn(3).setResizable(false);
            jTableFilm.getColumnModel().getColumn(3).setPreferredWidth(40);
            jTableFilm.getColumnModel().getColumn(4).setResizable(false);
            jTableFilm.getColumnModel().getColumn(4).setPreferredWidth(40);
        }
        //Wyjustowanie na środku danych na środku komórek tabeli
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int i=0; i < 5; i++){
            jTableFilm.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
        }

        jButBack.setText("Cofnij");
        jButBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButBackActionPerformed(evt);
            }
        });

        jLabel1.setText("Wybierz film");

        jButDelete.setText("Usuń film");
        jButDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButDeleteActionPerformed(evt);
            }
        });

        jButAdd.setText("Dodaj film");
        jButAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButAddActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Tytuł", "Gatunek", "Rok", "Czas trwania" }));

        jCheckBox1.setText("Odwrotnie");

        jButton1.setText("Sortuj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jDeleteMes, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jButDelete)
                        .addGap(18, 18, 18)
                        .addComponent(jButAdd)
                        .addGap(18, 18, 18)
                        .addComponent(jDeleteMes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButBack)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addComponent(jButton1))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButBackActionPerformed
        this.setVisible(false);
        mainGUI.activate();
    }//GEN-LAST:event_jButBackActionPerformed

    private void jButAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButAddActionPerformed
        this.setVisible(false);
        addFilm.activate();
    }//GEN-LAST:event_jButAddActionPerformed

    private void jButDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButDeleteActionPerformed
        
        try{
            checkSelectedRow(jTableFilm.getSelectedRow(), jTableFilm.getRowCount());
            
            int id = (int) jTableFilm.getValueAt(jTableFilm.getSelectedRow(), 0);

            int response = JOptionPane.showConfirmDialog(this, "Czy na pewno chcesz usunąć film?", "Potwierdź", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if(response == JOptionPane.YES_OPTION){
                try {
                if(mainGUI.kino.usunFilm(id)){
                    JOptionPane.showMessageDialog(this, "Film zostal usuniety");           
                    addSortFilmListToJTable(0, true);
                }
                else{
                    JOptionPane.showMessageDialog(this, "Nie znalezniono filmuy");
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Lista_Filmow.class.getName()).log(Level.SEVERE, null, ex);
            }

            jDeleteMes.setVisible(true);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(jScrollPane2, "Wybierz jeden seans z tabeli!", "Warning",
        JOptionPane.WARNING_MESSAGE);   
        }
        
        
    }//GEN-LAST:event_jButDeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean con =! jCheckBox1.isSelected();
        
        addSortFilmListToJTable(jComboBox1.getSelectedIndex(), con);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void activate(){
        addSortFilmListToJTable(0, true);
        jDeleteMes.setText("");
        jDeleteMes.setVisible(false);
        this.setVisible(true);
    }
    
    private void addSortFilmListToJTable(int swit, boolean con)
    {
        //posortowanie LinkedHashMap według kryteriow
        mainGUI.kino.sort_film(swit, con);
        
        //Stworzenie modelu tabeli i określenie jej ilości kolumn
        DefaultTableModel model = (DefaultTableModel) jTableFilm.getModel();
        Object rowData[] = new Object[5];
        
        //czyszczenie tablicy
        model.getDataVector().removeAllElements();;
        
        //Ustawienie iteratora do HashMapy
        Set<Map.Entry<Integer, Film>> entries = mainGUI.kino.sort_mapa_filmow.entrySet();
        Iterator<Map.Entry<Integer, Film>> filmyIterator = entries.iterator();
       
        //Odczyt kolejnych danych z LinkedHashMapy i umieszczenie ich w wierszach tabeli
        while(filmyIterator.hasNext()) {
            Map.Entry<Integer, Film> entry = filmyIterator.next();
            rowData[0] = entry.getKey();
            rowData[1] = entry.getValue().getName();
            rowData[2] = entry.getValue().getGenre();
            rowData[3] = entry.getValue().getAge();
            rowData[4] = entry.getValue().getTime();
            
            model.addRow(rowData);
       }
    }
    
    private static void checkSelectedRow(int selectedRow, int tableLength) throws MyException{
        if(selectedRow < 0 || selectedRow > tableLength){
            throw new MyException("\n" + "Musisz wybrać jeden seans z tablicy");
        }
        else{
            
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButAdd;
    private javax.swing.JButton jButBack;
    private javax.swing.JButton jButDelete;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jDeleteMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableFilm;
    // End of variables declaration//GEN-END:variables
}
