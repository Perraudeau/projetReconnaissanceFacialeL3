/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetreconnaissancefaciale.Controleurs;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private static String userDateNaiss;
    private static String userVille;
    private static String userPays;
    private static String userInfo;

    public static String getUserDateNaiss() {
        return userDateNaiss;
    }

    public static String getUserVille() {
        return userVille;
    }

    public static String getUserPays() {
        return userPays;
    }

    public static String getUserInfo() {
        return userInfo;
    }
    

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
            userDateNaiss=ParamUserModel.getUserDateNaiss();
            userVille=ParamUserModel.getUserVille();
            userPays=ParamUserModel.getUserPays();
            userInfo=ParamUserModel.getUserInfo();
         
            
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
        if (InscriHandler.areSame(mdp1, mdp2)){
        }else{
            return false;
        }
        return true;
    }

    public static String AjoutDateFRtoUS(Date dateFr) throws ParseException {

        DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat destinationFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = dateFr;
        String dateUS = destinationFormat.format(date);
        Date d= destinationFormat.parse(dateUS);
        return dateUS;
    }

    public static String AjoutDateUStoFR(Date dateUS) throws ParseException {

        DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat destinationFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date date = dateUS;
        String dateFR = destinationFormat.format(date);
        Date d= destinationFormat.parse(dateFR);
        return dateFR;
    }
       public static boolean envoiInscription(String nom, String prenom, String mail, String pass,String dateNaiss,String ville, String pays, String remarque) {
        boolean retour = false;
        try {
            retour = ParamUserModel.ModifCompte(nom, prenom, mail, SHA1Handler.sha1(pass),dateNaiss,ville,pays,remarque);
           
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(InscriHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retour;
    }
}

