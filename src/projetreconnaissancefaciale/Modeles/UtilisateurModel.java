package projetreconnaissancefaciale.Modeles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import projetreconnaissancefaciale.main;

/**
 *
 * @author Perraudeau
 */
public class UtilisateurModel {

    /**
     * Verification de la connection à l'application
     *
     * @param email String 
     * @param pass String pass hashé en SHA1
     * @return un tableau qui contient l'id de l'utilisateur en case 0
     * et son niveau d'utilisateur en case 1 : 
     * 0: pas autorisé 1: utilisateur 2: administrateur
     */
    public static String[] verificationUtilisateur(String email, String pass) {
        String[] retour = new String[2];
        retour[0] = "0";
        retour[1] = "0";

        try {
            PreparedStatement psAppli = ConnectionBddModel.getInstance().prepareStatement
                ("SELECT id,niveauUtilisateur "
                    + "FROM utilisateur "
                    + "WHERE email  = ?"
                    + "AND password = ?");

            psAppli.setString(1,email);
            psAppli.setString(2,pass);
            ResultSet result = psAppli.executeQuery();
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
    public static int IdGetter(String email){
        int retour = 0;

        try {
            PreparedStatement psAppli = ConnectionBddModel.getInstance().prepareStatement
                ("SELECT id "
                    + "FROM utilisateur "
                    + "WHERE email  = ?");

            psAppli.setString(1,email);
            ResultSet result = psAppli.executeQuery();
            if (result.next()) {
                retour = result.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur dans la requête de connection");
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);

        }
        return retour;
    }
}
