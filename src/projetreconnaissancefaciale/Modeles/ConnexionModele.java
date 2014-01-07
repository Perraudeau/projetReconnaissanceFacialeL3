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
public class ConnexionModele {

    /**
     * Verification de la connection à l'application
     *
     * @param login String
     * @param pass String pass hashé en SHA1
     * @return un int qui correspond au niveau de l'utilisateur : 0: pas
     * autorisé 1: utilisateur 2: administrateur
     */
    public static int verificationUtilisateur(String login, String pass) {
        int $return = 0;
        try {
            Statement statement = ConnexionBddModele.getInstance().createStatement();
            System.out.println("SELECT login,password,niveauUtilisateur "
                    + "FROM utilisateur "
                    + "WHERE login  = \"" + login + "\" "
                    + "AND password = \"" + pass + "\"");
            ResultSet result = statement.executeQuery("SELECT login,password,niveauUtilisateur "
                    + "FROM utilisateur "
                    + "WHERE login  = \"" + login + "\" "
                    + "AND password = \"" + pass + "\"");
            if (result.next()) {
                $return = result.getInt(3);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur dans la requête de connection");
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);

        }
        return $return;
    }
}
