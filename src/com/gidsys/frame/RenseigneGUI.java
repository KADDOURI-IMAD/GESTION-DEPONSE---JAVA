/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gidsys.frame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class RenseigneGUI extends javax.swing.JFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    static String test;
    String delai;
    String typecomt;
    
    public RenseigneGUI() {
        initComponents();
        conn = ConnectionDB.Conexion();
        Recuper();
        rempircombox();
    }

    
  public void cleardata(){
      
  }
     public void Recuper() {
        Renseigne info = new Renseigne();
        info.deplace();

        String recv = info.gettableresults();
        try {
            String rec = info.gettableresulto();
            String requet = "select * from deponse where nomber = '" + rec + "'";
            ps = conn.prepareStatement(requet);
            rs = ps.executeQuery();
            if (rs.next()) {
                String t1 = rs.getString("nomber");
                jLabel5.setText(t1);
                
                
                String statut = rs.getString("statut");
            if (statut.equals("Rensigne")) {
                jButton1.setEnabled(false);
            }

            }
            
            
            
            
            String requet2 = "select * from rensigneref where deponse_nomber = '" + rec + "'";
            ps = conn.prepareStatement(requet2);
            rs = ps.executeQuery();
            if (rs.next()) {
                String t1 = rs.getString("modePassation");
                jComboBox1.setSelectedItem(t1);
                String t2 = rs.getString("reference");
                jTextField1.setText(t2);
                String t3 = rs.getString("object");
                jTextField2.setText(t3);
                String t4 = rs.getString("distination");
                jTextField3.setText(t4);
                String t5 = rs.getString("montant");
                jTextField4.setText(t5);
                String t6 = rs.getString("delai");
                String vbn = t6;
                if(vbn.equals("jour")){
                    jRadioButton1.setSelected(true);
                }else if(vbn.equals("mois")){
                    jRadioButton2.setSelected(true);
                }
                String t7 = rs.getString("nomber");
                jTextField5.setText(t7);
                String t8 = rs.getString("naturPrix");
                 jComboBox2.setSelectedItem(t8);
                String t9 = rs.getString("interetMor");
                 jTextField8.setText(t9);
                
            }
            
            
            
            
            String requet3 = "select * from rensignerege where deponse_nomber = '" + rec + "'";
            ps = conn.prepareStatement(requet3);
            rs = ps.executeQuery();
            if (rs.next()) {
                   String t1 = rs.getString("modePaim");
                   jComboBox3.setSelectedItem(t1);
                   String t2 = rs.getString("typeComp");
                   String vbn = t2;
                if(vbn.equals("Compte comptable")){
                    jRadioButton4.setSelected(true);
                }else if(vbn.equals("Compte étranger")){
                    jRadioButton5.setSelected(true);
                }else if(vbn.equals("Compte ribé")){
                    jRadioButton3.setSelected(true);
                }
                  String t3 = rs.getString("Ncopmte");
                  jTextField9.setText(t3);
             }
          
            
            
            
            
            
              String requet4 = "select * from rensignebene where deponse_nomber = '" + rec + "'";
              ps = conn.prepareStatement(requet4);
              rs = ps.executeQuery();
              if (rs.next()) {
                  String t1 = rs.getString("typeTiers");
                  jComboBox4.setSelectedItem(t1);
                  String t2 = rs.getString("idenfifient");
                  jTextField10.setText(t2);
              }
              
            
        } catch (Exception e) {
            System.out.println(e);
        }

       
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField5 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField8 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jTextField9 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jTextField10 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rensignes les déponse ");
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel1.setText("Modalités de règlement:");

        jLabel15.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel15.setText("Object:");

        jLabel16.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel16.setText("Délai:");

        jLabel17.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel17.setText("Intéréts moratoires:");

        jLabel18.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel18.setText("Destination:");

        jLabel19.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel19.setText("Nomber:");

        jLabel25.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel25.setText("Référance AO:");

        jLabel21.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel21.setText("Montant:");

        jLabel22.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel22.setText("Nature de prix:");

        jLabel24.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel24.setText("Mode de passation:");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("En jour");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("En mois");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel2.setText("Références de la dépense:");

        jLabel10.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel10.setText("Mode de paiement:");

        jLabel11.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel11.setText("Type de compte:");

        jLabel12.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel12.setText("N° de compte:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("Compte ribé");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Compte comptable");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("Compte étranger");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel3.setText("Bénéficiaire:");

        jLabel13.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel13.setText("Type tiers:");

        jLabel14.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel14.setText("Identifiant fiscal:");

        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 204, 255));
        jButton1.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jButton1.setText("Enregistrer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 204, 255));
        jButton2.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jButton2.setText("Initialiser");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel4.setText("Pour déponse N°:");

        jLabel5.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N

        jButton3.setBackground(new java.awt.Color(0, 204, 255));
        jButton3.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jButton3.setText("Enregistrer edit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(28, 28, 28)
                                .addComponent(jRadioButton3)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jRadioButton4)
                        .addGap(64, 64, 64)
                        .addComponent(jRadioButton5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(210, 210, 210)
                                .addComponent(jLabel14)
                                .addGap(36, 36, 36)
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel13))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(jLabel2)
                    .addContainerGap(866, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel19)
                    .addComponent(jLabel22)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(38, 38, 38))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(jLabel2)
                    .addContainerGap(612, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        delai = "jour";
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
      typecomt = "Compte comptable";
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
       typecomt = "Compte étranger";
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
        String modePassation = jComboBox1.getSelectedItem().toString();
        String reference = jTextField1.getText();
        String object = jTextField2.getText();
        String destination = jTextField3.getText();
        String montant = jTextField4.getText();
        String dela = delai; // Set the value of delai here
        String nomber = jTextField5.getText();
        String naturPrix = jComboBox2.getSelectedItem().toString();
        String interetMor = jTextField8.getText();
        if (modePassation.isEmpty() || reference.isEmpty() || object.isEmpty() || destination.isEmpty() || montant.isEmpty() 
                || dela.isEmpty() || nomber.isEmpty() || naturPrix.isEmpty() || interetMor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields");
            return;
        }

        String requete = "INSERT INTO rensigneref (modePassation, reference, object, distination, montant, delai, nomber, naturPrix, interetMor, deponse_nomber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ps = conn.prepareStatement(requete);
        ps.setString(1, modePassation);
        ps.setString(2, reference);
        ps.setString(3, object);
        ps.setString(4, destination);
        ps.setString(5, montant);
        ps.setString(6, dela);
        ps.setString(7, nomber);
        ps.setString(8, naturPrix);
        ps.setString(9, interetMor);  
        ps.setString(10, jLabel5.getText());  // Set the value of the foreign key
        ps.execute();

        String modePaim = jComboBox3.getSelectedItem().toString();
        String typeComp = typecomt;
        String Ncopmte = jTextField9.getText();

        if (modePaim.isEmpty() || typeComp.isEmpty() || Ncopmte.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields");
            return;
        }

        String requete2 = "INSERT INTO rensignerege (modePaim, typeComp, Ncopmte, deponse_nomber) VALUES (?, ?, ?, ?)";
        ps = conn.prepareStatement(requete2);
        ps.setString(1, modePaim); 
        ps.setString(2, typeComp);
        ps.setString(3, Ncopmte);
        ps.setString(4, jLabel5.getText());
        ps.execute();

        String typeTiers = jComboBox4.getSelectedItem().toString();
        String idenfifient = jTextField10.getText();

        if (typeTiers.isEmpty() || idenfifient.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields");
            return;
        }

        String requete3 = "INSERT INTO rensignebene (typeTiers, idenfifient, deponse_nomber) VALUES (?, ?, ?)";
        ps = conn.prepareStatement(requete3);
        ps.setString(1, typeTiers); 
        ps.setString(2, idenfifient);
        ps.setString(3, jLabel5.getText());
        ps.execute();
        
          String req = "Update deponse set statut = 'Rensigne' where nomber = '"+jLabel5.getText()+"'";
          ps = conn.prepareStatement(req);
          ps.execute();
          JOptionPane.showMessageDialog(null, " Edit renseigne avec succès!");
         cleardata();
    } catch (Exception e) {
        System.out.println("--> SQLException: " + e);
    } finally {
        try {
            ps.close();
            rs.close();
        } catch (Exception e) {
            // Handle the exception appropriately
        }
    }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
       delai = "mois";
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        typecomt = "Compte ribé";
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
           try {                                                                  
        String modePassation = jComboBox1.getSelectedItem().toString(); 
        String reference = jTextField1.getText();   
        String object = jTextField2.getText();    
        String destination = jTextField3.getText();   
        String montant = jTextField4.getText(); 
        String dela = delai;  
        String nomber = jTextField5.getText();  
        String naturPrix = jComboBox2.getSelectedItem().toString(); 
        String interetMor = jTextField8.getText();  
        if (modePassation.isEmpty() || reference.isEmpty() || object.isEmpty() || destination.isEmpty() || montant.isEmpty() 
                || dela.isEmpty() || nomber.isEmpty() || naturPrix.isEmpty() || interetMor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields");
            return;
        }

        String requete = "update rensigneref set modePassation = '"+modePassation+"', reference= '"+reference+"', object= '"+object+"', distination= '"+destination+"', montant= '"+montant+"', delai= '"+dela+"', nomber= '"+nomber+"', naturPrix= '"+naturPrix+"', interetMor= '"+interetMor+"' where deponse_nomber = '"+jLabel5.getText()+"'";
        ps = conn.prepareStatement(requete);
        ps.execute();
        

        String modePaim = jComboBox3.getSelectedItem().toString();
        String typeComp = typecomt;
        String Ncopmte = jTextField9.getText();
  
        if (modePaim.isEmpty() || typeComp.isEmpty() || Ncopmte.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields");
            return;
        }

        String requete2 = "update rensignerege set modePaim= '"+modePaim+"', typeComp= '"+typeComp+"', Ncopmte= '"+Ncopmte+"' where deponse_nomber= '"+jLabel5.getText()+"'";
        ps = conn.prepareStatement(requete2);
        ps.execute();
        

        String typeTiers = jComboBox4.getSelectedItem().toString();
        String idenfifient = jTextField10.getText();

        if (typeTiers.isEmpty() || idenfifient.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields");
            return;
        }

        String requete3 = "update rensignebene set typeTiers= '"+typeTiers+"', idenfifient= '"+idenfifient+"' where deponse_nomber= '"+jLabel5.getText()+"'";
        ps = conn.prepareStatement(requete3);
        ps.execute();
         

        
        
          String req = "Update deponse set statut = 'Rensigne' where nomber = '"+jLabel5.getText()+"'";
          ps = conn.prepareStatement(req);
          ps.execute();
           
          JOptionPane.showMessageDialog(null, "La renseigne avec succès!");
        //cleardata();
    } catch (Exception e) {
        System.out.println("--> SQLException: " + e);
    } finally {
        try {
            ps.close();
            rs.close();
        } catch (Exception e) {
            // Handle the exception appropriately
            System.out.println("Exception " + e);
        }
             }
    }//GEN-LAST:event_jButton3ActionPerformed
public void rempircombox(){
      try{
        String requet3 = "select * from parmodepaim";
        ps = conn.prepareStatement(requet3);
        rs = ps.executeQuery();
        while (rs.next()) {
            String value = rs.getString("nameType");
            jComboBox1.addItem(value);
        }  
            
        String requet5 = "select * from parmodepaim";
        ps = conn.prepareStatement(requet5);
        rs = ps.executeQuery();
        while (rs.next()) {
          String value1 = rs.getString("nameType");
          jComboBox3.addItem(value1);
        } 
          
          
        String requet4 = "select * from parnatureprix";
        ps = conn.prepareStatement(requet4);
        rs = ps.executeQuery();
        while (rs.next()) {
            String value2 = rs.getString("nameType");
            jComboBox2.addItem(value2);  
        }
        
        
         String requet6 = "select * from partypetiers";
        ps = conn.prepareStatement(requet6);
        rs = ps.executeQuery();
        while (rs.next()) {
            String value3 = rs.getString("nameType");
            jComboBox4.addItem(value3);
        }
      }catch(Exception e){
          JOptionPane.showMessageDialog(null,e);
      }
      
        
  }  
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed

    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed

    }//GEN-LAST:event_jComboBox4ActionPerformed

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
            java.util.logging.Logger.getLogger(RenseigneGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RenseigneGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RenseigneGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RenseigneGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RenseigneGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
