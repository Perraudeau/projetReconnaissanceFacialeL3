package projetreconnaissancefaciale.Controleurs;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author Perraudeau
 */

public class SHA1Handler {
 
    /**
     * @param args
     * @throws NoSuchAlgorithmException
     */
    static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }
}
