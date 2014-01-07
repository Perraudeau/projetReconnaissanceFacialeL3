package projetreconnaissancefaciale.Modeles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import projetreconnaissancefaciale.main;

/**
 *
 * @author perraudeau
 */
public class Utilisateur {

    /**
     * Verification de la connection à l'application
     *
     * @param login String
     * @param pass String pass hashé en SHA1
     * @return un tableau qui contient l'id de l'utilisateur en case 0
     * et son niveau d'utilisateur en case 1 : 
     * 0: pas autorisé 1: utilisateur 2: administrateur
     */
    public static String[] verificationUtilisateur(String login, String pass) {
        String[] retour = new String[2];
        retour[0] = "0";
        try {
            Statement statement = ConnexionBdd.getInstance().createStatement();
            ResultSet result = statement.executeQuery("SELECT id,niveauUtilisateur "
                    + "FROM utilisateur "
                    + "WHERE login  = \"" + login + "\" "
                    + "AND password = \"" + pass + "\"");

            if (result.next()) {
                retour[0] = result.getString(1);
                retour[1] = result.getString(2);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur dans la requête de connection");
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);

        }
        return retour;
    }
}
