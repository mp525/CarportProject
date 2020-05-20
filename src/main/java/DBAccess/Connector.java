package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 Formålet med connector er at skabe en forbindelse til databasen.
 Både på produktionen og lokalt.
 @author kasper
 */
public class Connector {



    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;
    //private static final String PASSWORD = "cph39178";
    //private static final String PASSWORD = "Matti12345h";
    //private static final String PASSWORD = "AtM12K13BoC185";



    private static Connection singleton;

    public static void setConnection( Connection con ) {
        singleton = con;
    }

    /**
     *
     * @return den returnerer en forbindelse
     * @throws ClassNotFoundException
     * @throws SQLException
     *
     */
    public static Connection connection() throws ClassNotFoundException, SQLException {
        if ( singleton == null ) {
            setDBCredentials();
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            singleton = DriverManager.getConnection( URL, USERNAME, PASSWORD );
        }
        return singleton;
    }

    /**
     * Denne sætter JDBC connection, hvis det er på produktion.
     * Hvis ikke det er muligt, så prøver den med localhost.
     *
     */

    public static void setDBCredentials() {

        String deployed = System.getenv("DEPLOYED");
        if (deployed != null) {
            //Prod: hent variabler fra setenv.sh
            URL = System.getenv("JDBC_CONNECTION_STRING");
            USERNAME = System.getenv("JDBC_USER");
            PASSWORD = System.getenv("JDBC_PASSWORD");

        } else {
            //Localhost
            URL = "jdbc:mysql://localhost:3306/carbase?serverTimezone=CET&useSSL=false";
            USERNAME = "root";
            //PASSWORD = "SwordsAndSandals1337";
            //PASSWORD = "Matti12345h";
            PASSWORD = "cph39178";
            //PASSWORD = "AtM12K13BoC185";



        }
    }

}
