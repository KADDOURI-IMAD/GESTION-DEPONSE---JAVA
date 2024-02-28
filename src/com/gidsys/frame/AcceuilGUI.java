/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gidsys.frame;

import java.beans.PropertyVetoException;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AcceuilGUI extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    public static String t3;
    String t1;
    public AcceuilGUI() {
        initComponents();
        conn = ConnectionDB.Conexion();
        datecourante();
        recuperutlisateur();
        showform();
    }

    public void showform(){
     this.desk.removeAll();
        this.desk.repaint();
        Note nt = new Note();
        this.desk.add(nt);
         try {
            nt.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AcceuilGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        nt.show();
    
    }
     public void datecourante() {
        Thread clock = new Thread() {
            public void run() {
                for (;;) {
                    Calendar Cal = new GregorianCalendar();
                    int sconde = Cal.get(Calendar.SECOND);
                    int minute = Cal.get(Calendar.MINUTE);
                    int heure = Cal.get(Calendar.HOUR);
                    int AM_PM = Cal.get(Calendar.AM_PM);  
                    String pa;
                    if(AM_PM==1){
                        pa="PM";
                    }else{
                        pa="AM";
                    }                          
                    datetxt1.setText( + heure + ":" + (minute) + ":" + sconde +" "+pa  );
                    
                 int mois = Cal.get(Calendar.MONTH);
                    int annee = Cal.get(Calendar.YEAR);
                    int jour = Cal.get(Calendar.DAY_OF_MONTH);
                    datetxt2.setText( + jour + "/" + (mois+1) + "/" + annee);              
                   
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Calendar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        
           clock.start();
    }
     
        
   public void recuperutlisateur() {
    LoginGUI log = new LoginGUI();
    try {  
 
        String recp = log.getLoggedInUser();
        System.out.println("la valuer de recp " +recp);
        String requet = "select * from logintable where login = '"+recp+"'";
        ps = conn.prepareStatement(requet);
        rs = ps.executeQuery();
        if (rs.next()) {
                String t1 = rs.getString("nom");
                String t2 = rs.getString("prenom");
                jLabel6.setText(t2 + " "+ t1);
                String t3 = rs.getString("type");
                jLabel5.setText(t3);
                System.out.println("t1 est"+t1);
                System.out.println("t2 est"+t2);
                System.out.println("t3 est"+t3);
            if (t3.equals("Gouverneur")) {
                  btnCrDep.setEnabled(true);
                  btnRens.setEnabled(true);
                  btnEngag.setEnabled(true);
                  btnJus.setEnabled(true);
                  btnSgn.setEnabled(true);
                  btnTrans.setEnabled(true);
                  btnUtili.setEnabled(true);
                  btnParam.setEnabled(true);
                  btnScomp.setEnabled(false);
            } else if (t3.equals("Utilisateur")) {
                 btnCrDep.setEnabled(true);
                  btnRens.setEnabled(true);
                  btnEngag.setEnabled(true);
                  btnJus.setEnabled(true);
                  btnSgn.setEnabled(false);
                  btnTrans.setEnabled(true);
                  btnUtili.setEnabled(false);
                  btnParam.setEnabled(false);
                  btnScomp.setEnabled(false);
            } else if (t3.equals("Comptable")) {
                 btnCrDep.setEnabled(false);
                  btnRens.setEnabled(false);
                  btnEngag.setEnabled(false);
                  btnJus.setEnabled(false);
                  btnSgn.setEnabled(false);
                  btnTrans.setEnabled(false);
                  btnUtili.setEnabled(false);
                  btnParam.setEnabled(false);
                  btnScomp.setEnabled(true);
            }
        }
    } catch (Exception e) {
        System.out.println(e);
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erreur BD");
        }
    }
}
     public String utilisateurs() {
    return t3;
      }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnCrDep = new javax.swing.JButton();
        btnRens = new javax.swing.JButton();
        btnEngag = new javax.swing.JButton();
        btnJus = new javax.swing.JButton();
        btnSgn = new javax.swing.JButton();
        btnTrans = new javax.swing.JButton();
        btnUtili = new javax.swing.JButton();
        btnParam = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        btnScomp = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        datetxt2 = new javax.swing.JLabel();
        datetxt1 = new javax.swing.JLabel();
        desk = new javax.swing.JDesktopPane();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 300));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnCrDep.setBackground(new java.awt.Color(204, 255, 255));
        btnCrDep.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        btnCrDep.setText("Créer de la déponse");
        btnCrDep.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255)));
        btnCrDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrDepActionPerformed(evt);
            }
        });

        btnRens.setBackground(new java.awt.Color(153, 255, 255));
        btnRens.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        btnRens.setText("Renseigne");
        btnRens.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 255), new java.awt.Color(153, 153, 255)));
        btnRens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRensActionPerformed(evt);
            }
        });

        btnEngag.setBackground(new java.awt.Color(102, 255, 255));
        btnEngag.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        btnEngag.setText("Engagement");
        btnEngag.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(102, 102, 255), new java.awt.Color(102, 102, 255)));
        btnEngag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEngagActionPerformed(evt);
            }
        });

        btnJus.setBackground(new java.awt.Color(51, 255, 255));
        btnJus.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        btnJus.setText("Justificatives");
        btnJus.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(51, 102, 255), new java.awt.Color(51, 102, 255)));
        btnJus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJusActionPerformed(evt);
            }
        });

        btnSgn.setBackground(new java.awt.Color(0, 255, 255));
        btnSgn.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        btnSgn.setText("Signé / Visa");
        btnSgn.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 255), new java.awt.Color(0, 102, 255)));
        btnSgn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSgnActionPerformed(evt);
            }
        });

        btnTrans.setBackground(new java.awt.Color(0, 204, 204));
        btnTrans.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        btnTrans.setText("Transmission");
        btnTrans.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 204), new java.awt.Color(0, 102, 204)));
        btnTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransActionPerformed(evt);
            }
        });

        btnUtili.setBackground(new java.awt.Color(0, 204, 204));
        btnUtili.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        btnUtili.setText("Utilisateurs");
        btnUtili.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 153), new java.awt.Color(0, 102, 153)));
        btnUtili.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUtiliActionPerformed(evt);
            }
        });

        btnParam.setBackground(new java.awt.Color(0, 204, 204));
        btnParam.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        btnParam.setText("Parametre");
        btnParam.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        btnParam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParamActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(0, 51, 51));
        jButton9.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Log Out");
        jButton9.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 51, 51), new java.awt.Color(0, 51, 51)));

        btnScomp.setBackground(new java.awt.Color(0, 102, 102));
        btnScomp.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        btnScomp.setText("Session Comptable");
        btnScomp.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        btnScomp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScompActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCrDep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSgn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnJus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEngag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTrans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUtili, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnParam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnScomp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCrDep, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRens, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEngag, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnJus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSgn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnScomp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUtili, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnParam, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 153, 255));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Acceuil");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        datetxt2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        datetxt2.setForeground(new java.awt.Color(255, 255, 255));

        datetxt1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        datetxt1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(datetxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(919, Short.MAX_VALUE)
                    .addComponent(datetxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(279, 279, 279)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(datetxt2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(datetxt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        desk.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout deskLayout = new javax.swing.GroupLayout(desk);
        desk.setLayout(deskLayout);
        deskLayout.setHorizontalGroup(
            deskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1147, Short.MAX_VALUE)
        );
        deskLayout.setVerticalGroup(
            deskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText(":");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(desk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(desk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        setSize(new java.awt.Dimension(1353, 729));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrDepActionPerformed
        this.desk.removeAll();
        this.desk.repaint();
        Deponse ds = new Deponse();
        this.desk.add(ds);
        try {
            ds.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AcceuilGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        ds.show();
       
    }//GEN-LAST:event_btnCrDepActionPerformed

    private void btnRensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRensActionPerformed
        this.desk.removeAll();
        this.desk.repaint();
        Renseigne rsg = new Renseigne();
        this.desk.add(rsg);
         try {
            rsg.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AcceuilGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        rsg.show();
    }//GEN-LAST:event_btnRensActionPerformed

    private void btnEngagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEngagActionPerformed
        this.desk.removeAll();
        this.desk.repaint();
        Engagement en = new Engagement();
        this.desk.add(en);
         try {
            en.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AcceuilGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        en.show();
    }//GEN-LAST:event_btnEngagActionPerformed

    private void btnJusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJusActionPerformed
        this.desk.removeAll();
        this.desk.repaint();
        Justification js = new Justification();
        this.desk.add(js);
         try {
            js.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AcceuilGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        js.show();
    }//GEN-LAST:event_btnJusActionPerformed

    private void btnSgnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSgnActionPerformed
        this.desk.removeAll();
        this.desk.repaint();
        Signe sg = new Signe();
        this.desk.add(sg);
         try {
            sg.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AcceuilGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        sg.show();
    }//GEN-LAST:event_btnSgnActionPerformed

    private void btnTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransActionPerformed
        this.desk.removeAll();
        this.desk.repaint();
        Transmission tr = new Transmission();
        this.desk.add(tr);
         try {
            tr.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AcceuilGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        tr.show();
    }//GEN-LAST:event_btnTransActionPerformed

    private void btnUtiliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUtiliActionPerformed
        this.desk.removeAll();
        this.desk.repaint();
        Utilisateur ut = new Utilisateur();
        this.desk.add(ut);
         try {
            ut.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AcceuilGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        ut.show();
    }//GEN-LAST:event_btnUtiliActionPerformed

    private void btnParamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParamActionPerformed
        this.desk.removeAll();
        this.desk.repaint();
        Parametre pr = new Parametre();
        this.desk.add(pr);
         try {
            pr.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AcceuilGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        pr.show();
    }//GEN-LAST:event_btnParamActionPerformed

    private void btnScompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScompActionPerformed
        this.desk.removeAll();
        this.desk.repaint();
        comptable cm = new comptable();
        this.desk.add(cm);
         try {
            cm.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AcceuilGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        cm.show();
    }//GEN-LAST:event_btnScompActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
          this.desk.removeAll();
        this.desk.repaint();
        Note nt = new Note();
        this.desk.add(nt);
         try {
            nt.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AcceuilGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        nt.show();
    }//GEN-LAST:event_jLabel2MouseClicked


    public static void main(String args[]) {
   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AcceuilGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrDep;
    private javax.swing.JButton btnEngag;
    private javax.swing.JButton btnJus;
    private javax.swing.JButton btnParam;
    private javax.swing.JButton btnRens;
    private javax.swing.JButton btnScomp;
    private javax.swing.JButton btnSgn;
    private javax.swing.JButton btnTrans;
    private javax.swing.JButton btnUtili;
    private javax.swing.JLabel datetxt1;
    private javax.swing.JLabel datetxt2;
    private javax.swing.JDesktopPane desk;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
