/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetreconnaissancefaciale.Modeles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import projetreconnaissancefaciale.main;

/**
 *
 * @author Alexis
 */
public class ParamUserModel {
 
    private static String userNom;
    private static String userPrenom;
    private static String userPass;
    
    public static String getUserNom() {
        return userNom;
    }

    public static String getUserPrenom() {
        return userPrenom;
    }

    public static String getUserPass() {
        return userPass;
    }
   
    
    public static void setUserNom(String userNom) {
        ParamUserModel.userNom = userNom;
    }

    public static void setUserPrenom(String userPrenom) {
        ParamUserModel.userPrenom = userPrenom;
    }

    public static void setUserPass(String userPass) {
        ParamUserModel.userPass = userPass;
    }
    

    
    public static void RecupInfoUser(String login) throws SQLException{
         try {
            /**
             * requete pour recuperer l'id de l'enregistrement precedement cree 
             */
            PreparedStatement psRecup = ConnectionBddModel.getInstance().prepareStatement
                ("SELECT information.nom,information.prenom,utilisateur.password "
                    + "FROM utilisateur,information "
                    + "WHERE information.idUtilisateur=utilisateur.id "
                    + "AND email = ?");
            psRecup.setString(1,login);
            System.out.println(psRecup);
            //On execute la requete
            
            ResultSet rsRecup = psRecup.executeQuery();
            while(rsRecup.next()){
                userNom = rsRecup.getString(1);
                userPrenom=rsRecup.getString(2);
                userPass=rsRecup.getString(3);
            }
         } catch (SQLException ex) {
            System.out.println("Erreur dans la requête de recuperation d'info user");
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setUserNom(userNom);
        setUserPrenom(userPrenom);
        setUserPass(userPass);
     
    }
   
}
