package projetreconnaissancefaciale.Vues;

import java.awt.Color;
import java.util.Arrays;
import projetreconnaissancefaciale.Controleurs.InscriHandler;

/**
 *
 * @author Leroux
 */
public class InscriptionView extends javax.swing.JFrame {
    String nom, prenom, email, pass;
    /**
     * Creates new form Inscription
     */
    public InscriptionView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labTitre = new javax.swing.JLabel();
        butAnnuler = new javax.swing.JButton();
        labInscri = new javax.swing.JLabel();
        labNom = new javax.swing.JLabel();
        labPrenom = new javax.swing.JLabel();
        labMail = new javax.swing.JLabel();
        labMDP1 = new javax.swing.JLabel();
        labMDP2 = new javax.swing.JLabel();
        textPrenom = new javax.swing.JTextField();
        textMail = new javax.swing.JTextField();
        textMdp2 = new javax.swing.JPasswordField();
        textMdp1 = new javax.swing.JPasswordField();
        butValider = new javax.swing.JButton();
        erreurMail = new javax.swing.JLabel();
        textNom = new javax.swing.JTextField();
        erreurNom = new javax.swing.JLabel();
        erreurPrenom = new javax.swing.JLabel();
        erreurMdp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setOpacity(0.9F);

        labTitre.setFont(new java.awt.Font("Chiller", 1, 48)); // NOI18N
        labTitre.setForeground(new java.awt.Color(62, 96, 111));
        labTitre.setText("RecoFace");

        butAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetreconnaissancefaciale/Vues/Images/gtk-cancel.png"))); // NOI18N
        butAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAnnulerActionPerformed(evt);
            }
        });

        labInscri.setFont(new java.awt.Font("Chiller", 0, 24)); // NOI18N
        labInscri.setText("Inscription");

        labNom.setText("Nom :");

        labPrenom.setText("Prénom :");

        labMail.setText("Adresse Email :");

        labMDP1.setText("Mot de passe :");

        labMDP2.setText("Réécrivez votre mot de passe :");

        textMdp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMdp1ActionPerformed(evt);
            }
        });

        butValider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetreconnaissancefaciale/Vues/Images/ip_icon_02_Ok.png"))); // NOI18N
        butValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butValiderActionPerformed(evt);
            }
        });

        erreurMail.setForeground(new java.awt.Color(255, 0, 0));

        erreurNom.setForeground(new java.awt.Color(255, 0, 0));

        erreurPrenom.setForeground(new java.awt.Color(255, 0, 0));

        erreurMdp.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(butAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butValider, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labTitre)
                .addContainerGap(265, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(labInscri))
                    .addComponent(labMail)
                    .addComponent(labMDP1)
                    .addComponent(labMDP2)
                    .addComponent(labPrenom)
                    .addComponent(labNom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(textPrenom, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(textMail)
                    .addComponent(textMdp1)
                    .addComponent(textMdp2)
                    .addComponent(textNom))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(erreurMail, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(erreurNom, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(erreurPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(erreurMdp, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labTitre)
                .addGap(18, 18, 18)
                .addComponent(labInscri, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(erreurNom, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labNom)
                        .addComponent(textNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labPrenom)
                            .addComponent(textPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labMail)
                            .addComponent(textMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(erreurMail, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(erreurPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labMDP1)
                            .addComponent(textMdp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textMdp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labMDP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(erreurMdp, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butValider, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAnnulerActionPerformed
        System.exit(0);
    }//GEN-LAST:event_butAnnulerActionPerformed

    private void butValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butValiderActionPerformed
        //Si le nom n'est pas valide, on arrête
        if (InscriHandler.isValid(1, textNom.getText()) == false) {
            erreurNom.setText("Faux");
            return;
        } else {
            nom=textNom.getText();
        }

        if (InscriHandler.isValid(1, textPrenom.getText()) == false) {
            erreurPrenom.setText("Faux");
            return;
        } else {
            prenom=textPrenom.getText();
        }

        if (InscriHandler.isValid(2, textMail.getText()) == false) {
            erreurMail.setText("E-mail faux");
            return;
        } else {
            email=textMail.getText();
        }
        String stringMdp1=Arrays.toString(textMdp1.getPassword());
        String stringMdp2=Arrays.toString(textMdp2.getPassword());
        
        if (InscriHandler.areSame(stringMdp1, stringMdp2)==false){
            erreurMdp.setText("Mdp différents");
            return;
        }else{
            pass=stringMdp1;
        }
        if (InscriHandler.envoiInscription(nom, prenom, email, textMdp1.getText())){
            ApresInscriView frame = new ApresInscriView();
            frame.getContentPane().setBackground(new Color(226, 226, 226));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }else{
            System.out.println("Erreur au niveau de l'ajout");
        }
        this.setVisible(false);
        
        
    }//GEN-LAST:event_butValiderActionPerformed

    private void textMdp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMdp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMdp1ActionPerformed

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
            java.util.logging.Logger.getLogger(InscriptionView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InscriptionView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InscriptionView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InscriptionView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InscriptionView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAnnuler;
    private javax.swing.JButton butValider;
    private javax.swing.JLabel erreurMail;
    private javax.swing.JLabel erreurMdp;
    private javax.swing.JLabel erreurNom;
    private javax.swing.JLabel erreurPrenom;
    private javax.swing.JLabel labInscri;
    private javax.swing.JLabel labMDP1;
    private javax.swing.JLabel labMDP2;
    private javax.swing.JLabel labMail;
    private javax.swing.JLabel labNom;
    private javax.swing.JLabel labPrenom;
    private javax.swing.JLabel labTitre;
    private javax.swing.JTextField textMail;
    private javax.swing.JPasswordField textMdp1;
    private javax.swing.JPasswordField textMdp2;
    private javax.swing.JTextField textNom;
    private javax.swing.JTextField textPrenom;
    // End of variables declaration//GEN-END:variables
}
