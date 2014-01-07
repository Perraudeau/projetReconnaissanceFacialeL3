package projetreconnaissancefaciale;

import java.awt.Color;
import projetreconnaissancefaciale.Vues.Connexion;

/**
 *
 * @author perraudeau
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connexion frame = new Connexion();
        frame.getContentPane().setBackground(new Color(226, 226, 226));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
