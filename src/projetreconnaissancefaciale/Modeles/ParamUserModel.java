/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetreconnaissancefaciale.Modeles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
    private static String userDateNaiss;
    private static String userInfo;
    private static String userVille;
    private static String userPays;

    public static String getUserNom() {
        return userNom;
    }

    public static String getUserPrenom() {
        return userPrenom;
    }

    public static String getUserPass() {
        return userPass;
    }

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

    public static void setUserNom(String userNom) {
        ParamUserModel.userNom = userNom;
    }

    public static void setUserPrenom(String userPrenom) {
        ParamUserModel.userPrenom = userPrenom;
    }

    public static void setUserPass(String userPass) {
        ParamUserModel.userPass = userPass;
    }

    public static void setUserDateNaiss(String userDateNaiss) {
        ParamUserModel.userDateNaiss = userDateNaiss;
    }

    public static void setUserVille(String userVille) {
        ParamUserModel.userVille = userVille;
    }

    public static void setUserPays(String userPays) {
        ParamUserModel.userPays = userPays;
    }

    public static void setUserInfo(String userInfo) {
        ParamUserModel.userInfo = userInfo;
    }

    public static void RecupInfoUser(String login) throws SQLException {
        try {
            /**
             * requete pour recuperer l'id de l'enregistrement precedement cree
             */
            PreparedStatement psRecup = ConnectionBddModel.getInstance().prepareStatement(
                    "SELECT information.nom,information.prenom,utilisateur.password ,information.dateDeNaissance,information.ville , information.pays, information.remarque"
                    + " FROM utilisateur,information "
                    + "WHERE information.idUtilisateur=utilisateur.id "
                    + "AND email = ?");
            psRecup.setString(1, login);
            System.out.println(psRecup);
            //On execute la requete

            ResultSet rsRecup = psRecup.executeQuery();
            while (rsRecup.next()) {
                userNom = rsRecup.getString(1);
                userPrenom = rsRecup.getString(2);
                userPass = rsRecup.getString(3);
                userDateNaiss = rsRecup.getString(4);
                userVille = rsRecup.getString(5);
                userPays = rsRecup.getString(6);
                userInfo = rsRecup.getString(7);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur dans la requête de recuperation d'info user");
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }

        setUserNom(userNom);
        setUserPrenom(userPrenom);
        setUserPass(userPass);
        setUserVille(userVille);
        setUserPays(userPays);
        setUserDateNaiss(userDateNaiss);
        setUserInfo(userInfo);

    }
        public static boolean ModifCompte(int num,String nom,String prenom,String email,String password, String dateNaiss, String ville, String pays, String remarque){
        boolean retour = false;
        String userId = "";

        try {
            /**
             * requete pour recuperer l'id de l'enregistrement precedement cree 
             */
            PreparedStatement psMailUser = ConnectionBddModel.getInstance().prepareStatement
                ("SELECT email FROM utilisateur WHERE email = ?");
            psMailUser.setString(1,email);
            System.out.println(psMailUser);
            //On execute la requete
            ResultSet rsMail = psMailUser.executeQuery();
            
            //On recuper l'id dans la variable userId
            if(rsMail.next()){
                
            }else{
                
                return retour=false;
                
            }
            /**
             * Requete pour l'insertion d'informations dans la table utilisateur
             */
            if (num==1){
            PreparedStatement psUser = ConnectionBddModel.getInstance().prepareStatement
                ("UPDATE reconnaissancefaciale.utilisateur "
                + "SET password = ? "
                + "WHERE email = ?");
            
            psUser.setString(1,password);
            psUser.setString(2,email);

            //On execute la requete
            psUser.executeUpdate();
                
            }
            
            /**
             * requete pour recuperer l'id de l'enregistrement precedement cree 
             */
            PreparedStatement psIdUser = ConnectionBddModel.getInstance().prepareStatement
                ("SELECT id FROM utilisateur WHERE email = ?");
            psIdUser.setString(1,email);
            System.out.println(psIdUser);
            //On execute la requete
            ResultSet rs = psIdUser.executeQuery();
            
            //On recuper l'id dans la variable userId
            while(rs.next()){
                userId = rs.getString(1);
                System.out.println("variable récupérer userId");
            }
            
            

            /**
             * Requete pour inserer des informations dans la table information a
             * partir de l'userId
             */
            PreparedStatement psInfo = ConnectionBddModel.getInstance().prepareStatement
                ("UPDATE reconnaissancefaciale.information "
                + "SET nom = ? ,prenom =? ,dateDeNaissance=? ,ville=? ,pays=? ,remarque=? "
                + "WHERE idUtilisateur='"+userId+"'");
            System.out.println(psInfo);
            psInfo.setString(1,nom);
            psInfo.setString(2,prenom);
            psInfo.setString(3,dateNaiss);
            psInfo.setString(4,ville);
            psInfo.setString(5,pays);
            psInfo.setString(6,remarque);
            
            //On execute la requete
            psInfo.executeUpdate();
            retour=true;
        } catch (SQLException ex) {
            System.out.println("Erreur dans la requête update d'utilisateur");
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retour;
    }
}
