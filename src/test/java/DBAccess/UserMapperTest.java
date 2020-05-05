package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;

import static DBAccess.MaterialMapper.*;
import static org.junit.Assert.*;
import org.junit.Before;

import javax.validation.constraints.AssertTrue;

public class UserMapperTest {

    private static Connection testConnection;
    private static String USER = "root";
    private static String USERPW = "Matti12345h";
    private static String DBNAME = "carbaseTest";
    private static String HOST = "localhost";
    @Before
    public void setUp() {
        try {
            // awoid making a new connection for each test
            if ( testConnection == null ) {
                String url = String.format( "jdbc:mysql://%s:3306/%s", HOST, DBNAME );
                Class.forName( "com.mysql.cj.jdbc.Driver" );

                testConnection = DriverManager.getConnection( url, USER, USERPW );
                // Make mappers use test 
                Connector.setConnection( testConnection );
            }
            // reset test database
            try ( Statement stmt = testConnection.createStatement() ) {
                stmt.execute( "drop table if exists materials" );
                stmt.execute( "create table materials like carbase.materials" );
                stmt.execute( "insert into materials select * from carbase.materials" );
                Material m = new Material("Super sejt materiale", "kan bruges på alt", "stk", "træ", 200, 25);
                insertMat(m);
            }

        } catch ( ClassNotFoundException | SQLException ex ) {
            testConnection = null;
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }

    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull( testConnection );
        System.out.println("Der er forbindelse");
    }

    @Test
    public void testOmMaterialeKanKommeInd(){

        assertTrue(getMats().contains("Super sejt materiale"));

        System.out.println("Materialer kan sættes ind");
    }
/*

    @Test
    public void testLogin01() throws LoginSampleException {
        // Can we log in
        User user = UserMapper.login( "jens@somewhere.com", "jensen" );
        assertTrue( user != null );
    }

    @Test( expected = LoginSampleException.class )
    public void testLogin02() throws LoginSampleException {
        // We should get an exception if we use the wrong password
        User user = UserMapper.login( "jens@somewhere.com", "larsen" );
    }

    @Test
    public void testLogin03() throws LoginSampleException {
        // Jens is supposed to be a customer
        User user = UserMapper.login( "jens@somewhere.com", "jensen" );
        assertEquals( "customer", user.getRole() );
    }

    @Test
    public void testCreateUser01() throws LoginSampleException {
        // Can we create a new user - Notice, if login fails, this will fail
        // but so would login01, so this is OK
        User original = new User( "king@kong.com", "uhahvorhemmeligt", "konge" );
        UserMapper.createUser( original );
        User retrieved = UserMapper.login( "king@kong.com", "uhahvorhemmeligt" );
        assertEquals( "konge", retrieved.getRole() );
    }*/
}
