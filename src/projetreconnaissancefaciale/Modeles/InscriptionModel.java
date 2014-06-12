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
public class InscriptionModel {
    /**
     * Inscription d'un utilisateur dans la base de données.
     * @param name string
     * @param surname string
     * @param email string
     * @param password string en sha1
     */
    public static boolean Inscription(String name,String surname,String email,String password){
        boolean retour = false;
        String userId = "";
        
        try {
            /**
             * requete pour recuperer l'id de l'enregistrement precedement cree 
             */
            PreparedStatement psMailUser = ConnectionBddModel.getInstance().prepareStatement
                ("SELECT email FROM utilisateur WHERE email = ?");
            psMailUser.setString(1,email);
            //On execute la requete
            ResultSet rsMail = psMailUser.executeQuery();
            
            //On recuper l'id dans la variable userId
            if(rsMail.next()){
                retour=false;
                return retour;
            }else{
                retour=true;
            }
            /**
             * Requete pour l'insertion d'informations dans la table utilisateur
             */
            PreparedStatement psUser = ConnectionBddModel.getInstance().prepareStatement
                ("INSERT INTO reconnaissancefaciale.utilisateur "
                + "(id ,password,email ,niveauUtilisateur,dateInscription) "
                + "VALUES (NULL ,?,?, '1',CURRENT_TIMESTAMP)");
            
            psUser.setString(1,password);
            psUser.setString(2,email);

            //On execute la requete
            psUser.executeUpdate();
            
            /**
             * requete pour recuperer l'id de l'enregistrement precedement cree 
             */
            PreparedStatement psIdUser = ConnectionBddModel.getInstance().prepareStatement
                ("SELECT id FROM utilisateur WHERE email = ?");
            psIdUser.setString(1,email);
            //On execute la requete
            ResultSet rs = psIdUser.executeQuery();
            
            //On recuper l'id dans la variable userId
            while(rs.next()){
                userId = rs.getString(1);
            }
            
            

            /**
             * Requete pour inserer des informations dans la table information a
             * partir de l'userId
             */
            PreparedStatement psInfo = ConnectionBddModel.getInstance().prepareStatement
                ("INSERT INTO reconnaissancefaciale.information "
                + "(id ,idUtilisateur ,nom ,prenom ,dateDeNaissance ,ville ,pays ,remarque)"
                + "VALUES (NULL ,?,?,?, '1900-01-01', '', '', '');");
            psInfo.setString(1,userId);
            psInfo.setString(2,name);
            psInfo.setString(3,surname);
            
            //On execute la requete
            psInfo.executeUpdate();
            retour=true;
        } catch (SQLException ex) {
            System.out.println("Erreur dans la requête d'ajout d'utilisateur");
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retour;
    }
}
