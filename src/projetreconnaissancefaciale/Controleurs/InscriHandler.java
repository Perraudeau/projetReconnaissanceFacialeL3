package projetreconnaissancefaciale.Controleurs;

import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import projetreconnaissancefaciale.Modeles.InscriptionModel;

/**
 *
 * @author Leroux
 */
public class InscriHandler {

    /**
     * Verifie que l'adresse email est valide
     * @param numero int
     * @param text string
     * @return  boolean
     */
    public static boolean isValid(int numero, String text) {
        String regex;
        if (text != null && text.trim().length() > 0) {
            switch (numero) {
                case 1:
                    /*Renvoi true, si le champs nom est rempli et que
                     * le nom comporte que des lettres ou des tirets ou des accents
                     */
                    regex = "[\\p{L}-\\s]*\\b";
                    return text.matches(regex);
                case 2:
                    regex = "^[a-zA-Z0-9\\.\\-\\_]+@([a-zA-Z0-9\\-\\_\\.]+\\.)+([a-zA-Z]{2,4})$";
                    return text.matches(regex);

                case 3:
                    if (text.trim().length() < 6) {
                        return false;
                    } else {
                        return true;
                    }
                default:
                    return false;
            }
        } else {
            return false;
        }
    }

    /**
     * methode qui renvoi vrais si les mots de passe sont identiques
     * @param mdp1 string
     * @param mdp2 string
     * @return boolean
     */
    public static boolean areSame(String mdp1, String mdp2) {
        if (mdp1.equals(mdp2)) {
            return true;
        } else {
            return false;
        }

    }
    /**
     * Methode qui envoi l'inscription au modele
     * @param nom string
     * @param prenom string
     * @param mail string
     * @param pass string
     * @return boolean
     */
    public static boolean envoiInscription(String nom, String prenom, String mail, String pass) {
        boolean retour = false;
        try {
            //On chiffre le mot de passe en sha1
            retour = InscriptionModel.Inscription(nom, prenom, mail, SHA1Handler.sha1(pass));
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Erreur au niveau du controleur de l'envoi d'inscription");
            Logger.getLogger(InscriHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retour;
    }
}
