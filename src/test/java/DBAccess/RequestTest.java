package DBAccess;

import FunctionLayer.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;

import static DBAccess.ContactMapper.insertContact;
import static DBAccess.MaterialMapper.*;
import static DBAccess.RequestMapper.getRequests;
import static DBAccess.RequestMapper.insertRequest;
import static org.junit.Assert.*;
import org.junit.Before;

import javax.validation.constraints.AssertTrue;

public class RequestTest {

    private static Connection testConnection;
    private static String USER = "root";
    private static String USERPW = "cph39178";
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
                stmt.execute( "drop table if exists requests" );
                stmt.execute( "create table requests like carbase.requests" );
                stmt.execute( "insert into requests select * from carbase.requests" );

                stmt.execute( "drop table if exists contactinf" );
                stmt.execute( "create table contactinf like carbase.contactinf" );
                stmt.execute( "insert into contactinf select * from carbase.contactinf" );


                Contact c = new Contact("testklasse@mail.com","Matti",60909090,"Ellebusken","27",2750);
                //Key Constraints is weird please help jesus
                insertContact(c);

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
    public void testInsertRequest(){
        Request request = new Request(1,"testklasse@mail.com",500,500,"oak",true,"oak",20,200,200);
        insertRequest(request);
      //assertTrue(getRequests().contains(request));
    }
    @Test(expected =java.lang.AssertionError.class)
    public void testInsertRequestFail(){
        Request request = new Request(1,"motti@gmail.com",500,500,"oak",true,"oak",20,200,200);

        assertTrue(getRequests().contains(request));
    }
}
