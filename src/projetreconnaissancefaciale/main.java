package projetreconnaissancefaciale;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Perraudeau Victor
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connexion frame = new Connexion(); 
        frame.getContentPane().setBackground(new Color(226,226,226));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
}
