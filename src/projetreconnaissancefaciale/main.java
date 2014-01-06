package projetreconnaissancefaciale;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import projetreconnaissancefaciale.Modeles.ConnexionBdd;
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
        try {
            Statement state = (Statement) ConnexionBdd.getInstance().createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM utilisateur");
            ResultSetMetaData resultMeta = (ResultSetMetaData) result.getMetaData();
            System.out.println(resultMeta);
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connexion frame = new Connexion();
        frame.getContentPane().setBackground(new Color(226, 226, 226));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
