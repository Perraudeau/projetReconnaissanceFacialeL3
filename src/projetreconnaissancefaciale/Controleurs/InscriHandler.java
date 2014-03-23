package projetreconnaissancefaciale.Controleurs;

import java.util.regex.Pattern;
import projetreconnaissancefaciale.Vues.InscriptionView;

/**
 *
 * @author Leroux
 */
public class InscriHandler {

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

                default:
                    return false;
            }
        } else {
            return false;
        }
    }

    public static boolean areSame(String mdp1,String mdp2) {
        if (mdp1.equals(mdp2)) {
            return true;
        } else {
            return false;
        }
        

    }
}
