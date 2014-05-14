/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetreconnaissancefaciale.Controleurs;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import projetreconnaissancefaciale.Modeles.ParamUserModel;

/**
 *
 * @author Alexis
 */
public class ParamUserHandler {
    private static String login;
    private static String userNom;
    private static String userPrenom;
    private static String userPass;

    public static String getUserNom() {
        return userNom;
    }

    public static String getUserPrenom() {
        return userPrenom;
    }

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login) {
        ParamUserHandler.login = login;
    }
    
    public static void RechercheInfoUser(){
        try {
            ParamUserModel.RecupInfoUser(login);
            userNom=ParamUserModel.getUserNom();
            userPrenom=ParamUserModel.getUserPrenom();
            userPass=ParamUserModel.getUserPass();
           
           
         
            
        } catch (SQLException ex) {
            Logger.getLogger(ParamUserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static boolean Valider(String mdp, String mdp1 , String mdp2) throws NoSuchAlgorithmException{
        mdp=SHA1Handler.sha1(mdp);
        if (InscriHandler.areSame(userPass,mdp)){
        }else{
            return false;
        }
        if (InscriHandler.isValid(3, mdp1)){
        }else{ 
            return false;
        }
        if (InscriHandler.isValid(3, mdp2)){
        }else{
            return false;
        }
        
        return true;
    }
}
