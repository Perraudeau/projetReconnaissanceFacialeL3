/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetreconnaissancefaciale.Controleurs;

import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import projetreconnaissancefaciale.Modeles.UtilisateurModele;

/**
 *
 * @author Maison
 */
public class UtilisateurHandler {
    /**
     * Verification de la connection à l'application
     *
     * @param login String
     * @param pass String pass hashé en SHA1
     * @return un tableau qui contient l'id de l'utilisateur en case 0
     * et son niveau d'utilisateur en case 1 : 
     * 0: pas autorisé 1: utilisateur 2: administrateur
     */
    public static String[] sha1ToVerificationUtilisateur(String login, String pass) {
        String[] retour = new String[2];
        retour[0] = "0";
        try {
            pass = SHA1.sha1(pass);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UtilisateurHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        /**
         * Appel du modèle
         */
        retour = UtilisateurModele.verificationUtilisateur(login, pass);
        return retour;
    }
}
