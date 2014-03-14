package projetreconnaissancefaciale.Controleurs;

import java.util.regex.Pattern;

/**
 *
 * @author Alexis
 */
public class InscriHandler {

    public static boolean NomIsValid(String nom){
        
        String rx;
        rx = "";
        if (nom != null && nom.trim().length() > 0) {
            return nom.matches(rx);
        } else {
            return false;
        }
    }
    public static boolean EmailIsValid(String email) {
        if (email != null && email.trim().length() > 0) {
            return email.matches("^[a-zA-Z0-9\\.\\-\\_]+@([a-zA-Z0-9\\-\\_\\.]+\\.)+([a-zA-Z]{2,4})$");
        } else {
            return false;
        }
    }
}
