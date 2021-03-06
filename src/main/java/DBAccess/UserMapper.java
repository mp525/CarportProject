package DBAccess;

import FunctionLayer.Log;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 @author kasper
 Denne klasse håndterer databasekommunikation omhandlende User-objekter.


 */
public class UserMapper {

    /**
     *
     * @param email
     * @param password
     * @return User, som er logget ind.
     * @throws LoginSampleException
     * Denne metode tjekker om logininformationerne eksisterer i databasen, og lader brugeren logge ind, hvis de gør.
     */

    public static User login( String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM carbase.users "
                    + "WHERE user=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "id" );
                User user = new User( email, password, role );
                user.setId( id );
                return user;
            } else {
                Log.info("UserMapper"+" Could not validate user");
                throw new LoginSampleException( "UserMapper Login "+"Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

}
