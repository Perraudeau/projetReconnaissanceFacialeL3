package projetreconnaissancefaciale.Modeles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Connection a la base de donnee en singleton
 *
 * @author Perraudeau
 */
public class ConnectionBddModel {
    /**
     * Informations de connection a la base de donnee
     */
    private static final String url = "jdbc:mysql://localhost:3306/reconnaissancefaciale";
    private static final String user = "root";
    private static final String password = "";
    private static Connection connect;

    public static Connection getInstance() {
        if (connect == null) {
            try {
                connect = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionBddModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connect;
    }
}
