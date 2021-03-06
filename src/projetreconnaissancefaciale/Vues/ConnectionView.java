package projetreconnaissancefaciale.Vues;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import projetreconnaissancefaciale.Controleurs.ConnectionHandler;
import projetreconnaissancefaciale.Controleurs.ParamUserHandler;

/**
 *
 * @author Leroux
 */
public class ConnectionView extends javax.swing.JFrame {
    
    public static String email;
    /**
     * Creates new form Connexion
     */
    public ConnectionView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labID = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        labMDP = new javax.swing.JLabel();
        textMDP = new javax.swing.JPasswordField();
        butValider = new javax.swing.JButton();
        butAnnuler = new javax.swing.JButton();
        labTitre = new javax.swing.JLabel();
        labInsri = new javax.swing.JLabel();
        labErreur = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("Connexion"); // NOI18N
        setUndecorated(true);
        setOpacity(0.9F);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        labID.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        labID.setForeground(new java.awt.Color(25, 52, 65));
        labID.setText("Email :");

        labMDP.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        labMDP.setForeground(new java.awt.Color(25, 52, 65));
        labMDP.setText("Mot de passe :");

        textMDP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textMDPKeyPressed(evt);
            }
        });

        butValider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetreconnaissancefaciale/Vues/Images/ip_icon_02_Ok.png"))); // NOI18N
        butValider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butValiderActionPerformed(evt);
            }
        });

        butAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetreconnaissancefaciale/Vues/Images/gtk-cancel.png"))); // NOI18N
        butAnnuler.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAnnulerActionPerformed(evt);
            }
        });

        labTitre.setFont(new java.awt.Font("Chiller", 1, 48)); // NOI18N
        labTitre.setForeground(new java.awt.Color(62, 96, 111));
        labTitre.setText("RecoFace");

        labInsri.setBackground(new java.awt.Color(51, 204, 255));
        labInsri.setFont(new java.awt.Font("PMingLiU", 1, 14)); // NOI18N
        labInsri.setForeground(new java.awt.Color(0, 51, 255));
        labInsri.setText("Pas encore inscrit ?");
        labInsri.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labInsri.setDisplayedMnemonicIndex(0);
        labInsri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labInsriMouseClicked(evt);
            }
        });

        labErreur.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(butAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butValider, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labMDP)
                            .addComponent(labID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textMDP, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(121, 121, 121))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labInsri)
                        .addGap(181, 181, 181))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labErreur, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labTitre)
                        .addGap(172, 172, 172))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labTitre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labID)
                    .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textMDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labMDP))
                .addGap(18, 18, 18)
                .addComponent(labErreur, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(labInsri)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(butAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butValider, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAnnulerActionPerformed
        System.exit(0);
    }//GEN-LAST:event_butAnnulerActionPerformed

    private void labInsriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labInsriMouseClicked
        this.setVisible(false);
        InscriptionView frame = new InscriptionView();
        frame.getContentPane().setBackground(new Color(226, 226, 226));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }//GEN-LAST:event_labInsriMouseClicked


    private void butValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butValiderActionPerformed
        Valider();
    }//GEN-LAST:event_butValiderActionPerformed
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void textMDPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textMDPKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Valider();
        }
    }//GEN-LAST:event_textMDPKeyPressed

    public void Valider() {
        labErreur.setText("");
        email = textID.getText();
        ParamUserHandler.setLogin(email);
        String mdp = textMDP.getText();
        
        /**
         * On verifie que l'utilisateur est bien dans la base
         */
        if (ConnectionHandler.sha1ToVerificationUtilisateur(email, mdp)[1].contains("1" ) 
                || ConnectionHandler.sha1ToVerificationUtilisateur(email, mdp)[1].contains("2" )) {
            this.setVisible(false);
            ApresConnectionView frame = new ApresConnectionView();
            frame.getContentPane().setBackground(new Color(226, 226, 226));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } else {
            labErreur.setText("Erreur de saisie du login ou du mot de passe.");
        }

    }

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConnectionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConnectionView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAnnuler;
    private javax.swing.JButton butValider;
    private javax.swing.JLabel labErreur;
    private javax.swing.JLabel labID;
    private javax.swing.JLabel labInsri;
    private javax.swing.JLabel labMDP;
    private javax.swing.JLabel labTitre;
    private javax.swing.JTextField textID;
    private javax.swing.JPasswordField textMDP;
    // End of variables declaration//GEN-END:variables

    private JButton butValiderActionPerformed(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
