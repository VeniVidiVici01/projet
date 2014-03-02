/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gc.gui;

import gc.dao.ClientDAO;
import gc.dao.CommentaireDAO;
import gc.dao.PrestataireDAO;
import gc.dao.ReclamationDAO;
import gc.entities.Client;
import gc.entities.Commentaire;
import gc.entities.Globale;
import gc.entities.Prestataire;
import gc.entities.Reclamation;
import gc.entities.ResCommentaire;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author mohamed
 */
public class ConsulterCommentaire extends javax.swing.JFrame {
    List<Integer> idcom=new ArrayList<Integer>();

    /**
     * Creates new form ConsulterCommentaire
     */
    public ConsulterCommentaire() {
        initComponents();
        load();
        comm.setVisible(false);
        commente.setVisible(false);
        Valider.setVisible(false);
        jScrollPane2.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        commente = new javax.swing.JLabel();
        Ajouter = new javax.swing.JButton();
        Valider = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentaire = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        comm = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        commente.setText("Commentaire :");

        Ajouter.setText("Ajouter");
        Ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterActionPerformed(evt);
            }
        });

        Valider.setText("Valider");
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });

        commentaire.setEditable(false);
        jScrollPane1.setViewportView(commentaire);

        comm.setBorder(null);
        comm.setContentType("text"); // NOI18N
        jScrollPane2.setViewportView(comm);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(commente)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(Valider))
                    .addComponent(Ajouter))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(commente)
                        .addGap(54, 54, 54))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Ajouter)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Valider))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                .addContainerGap())))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterActionPerformed
comm.setVisible(true);

commente.setVisible(true);
Ajouter.setVisible(false);
Valider.setVisible(true);
jScrollPane2.setVisible(true);

    }//GEN-LAST:event_AjouterActionPerformed

    private void ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValiderActionPerformed
        CommentaireDAO comme = new CommentaireDAO();
        Globale gl = new Globale();
              Commentaire commentaire = new Commentaire(0,0, 0,"","");
              commentaire.setType(gl.type);
              commentaire.setId_user(gl.id);
              commentaire.setCommentaire(comm.getText());
             
              comme.insertCommentaire(commentaire);
             
            comm.setVisible(false);
commente.setVisible(false);
Ajouter.setVisible(true);
Valider.setVisible(false);    
    }//GEN-LAST:event_ValiderActionPerformed

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
            java.util.logging.Logger.getLogger(ConsulterCommentaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsulterCommentaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsulterCommentaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsulterCommentaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsulterCommentaire().setVisible(true);
            }
        });
    }
       public void  load()
    {
     
        CommentaireDAO comment = new CommentaireDAO();
           
        PrestataireDAO prestataire = new PrestataireDAO();
        ClientDAO client = new ClientDAO();
        Prestataire pres = new Prestataire(0,"","",0,"","","",0, "","");
       Client cl = new Client(0, "", "", 0, "", "", "", 0);
         List<ResCommentaire> comm;
        comm = new  ArrayList<ResCommentaire>();
         comm = comment.DisplayAllCommentaire();
        for(int i=0;i<comm.size();i++)
        {
           commentaire.setText(commentaire.getText()+" "+comm.get(i).getNomc()+"\n"+comm.get(i).getComm()+"\n");
            commentaire.setText(commentaire.getText()+" "+comm.get(i).getNomp()+"\n"+comm.get(i).getComm()+"\n");
     
            /*if(comm.get(i).getType().equals("prestataire"))
            {
                pres = prestataire.findPrestataireById(comm.get(i).getId_user());
               idcom.add(comm.get(i).getId_comm());
                
                commentaire.setText(commentaire+"\n"+pres.getNom()+"\n"+comm.get(i).getCommentaire());
              }
              if(comm.get(i).getType().equals("client"))
            {
                cl = client.findClientById(comm.get(i).getId_user());
                 idcom.add(comm.get(i).getId_comm());
                commentaire.setText(commentaire+"\n"+cl.getNom()+"\n"+comm.get(i).getCommentaire());
              }
           */
        }
        
        
                
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ajouter;
    private javax.swing.JButton Valider;
    private javax.swing.JTextPane comm;
    private javax.swing.JTextPane commentaire;
    private javax.swing.JLabel commente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
