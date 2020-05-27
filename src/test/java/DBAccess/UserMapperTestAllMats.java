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

public class UserMapperTestAllMats {

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
                stmt.execute( "drop table if exists materials" );
                stmt.execute( "create table materials like carbase.materials" );
                stmt.execute( "insert into materials select * from carbase.materials" );

                stmt.execute( "drop table if exists matflat" );
                stmt.execute( "create table matflat like carbase.matflat" );
                stmt.execute( "insert into matflat select * from carbase.matflat" );

                stmt.execute( "drop table if exists matslope" );
                stmt.execute( "create table matslope like carbase.matslope" );
                stmt.execute( "insert into matslope select * from carbase.matslope" );


                Material m = new Material("Super sejt materiale", "kan bruges på alt", "stk", "træ", 200, 25);
                insertMat(m);
                insertFlat(m);
                insertSlope(m);
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
    @Test (expected = java.lang.AssertionError.class)
    public void testOmMaterialeKanKommeIndNegativ(){

        assertTrue(getMats().contains("Super ikke sejt materiale"));

    }


    @Test
    public void testOmslopeKanKommeInd(){

        assertTrue(getSlope().contains("Super sejt materiale"));

        System.out.println("Matslope kan sættes ind");
    }
    @Test (expected = java.lang.AssertionError.class)
    public void testOmslopeTagKanKommeIndNegativ(){

        assertTrue(getSlope().contains("Super ikke sejt materiale"));

    }


    @Test
    public void testOmfladtKanKommeInd(){

        assertTrue(getFlat().contains("Super sejt materiale"));

        System.out.println("Matfladt kan sættes ind");
    }
    @Test (expected = java.lang.AssertionError.class)
    public void testOmfladtKanKommeIndNegativ(){

        assertTrue(getFlat().contains("Super ikke sejt materiale"));

    }

}
