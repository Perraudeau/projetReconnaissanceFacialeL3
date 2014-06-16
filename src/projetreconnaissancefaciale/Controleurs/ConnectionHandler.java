package projetreconnaissancefaciale.Controleurs;

import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import projetreconnaissancefaciale.Modeles.UtilisateurModel;

/**
 *
 * @author Perraudeau
 */
public class ConnectionHandler {
    
    
     /**
     * Verification de la connection à l'application
     *
     * @param email String
     * @param pass String pass hashé en SHA1Handler
     * @return un tableau qui contient l'id de l'utilisateur en case 0
     * et son niveau d'utilisateur en case 1 : 
     * 0: pas autorisé 1: utilisateur 2: administrateur
     */

    public static String[] sha1ToVerificationUtilisateur(String email, String pass) {
        String[] retour = new String[2];
        retour[0] = "0";
        retour[1] = "0";
        try {
            pass = SHA1Handler.sha1(pass);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        /**
         * Appel du modele
         */
        retour = UtilisateurModel.verificationUtilisateur(email, pass);
        return retour;
    }
}
