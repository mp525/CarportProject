package DBAccess;

import FunctionLayer.Log;
import FunctionLayer.Material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**

 Indeholder metoder der opererer på databasen inde for matriale listerne. (Matflat,Matslop,Materials)
 Den kan skabe og finde data på adskellige materialer fra disse 3 tabeller.
 @author Matti
 @author Mathias

 */

public class MaterialMapper {
    /**
     *
     * @param mat - material object
     * Denne metode indsætter et materiale i matflat tabellen.
     *
     */
    public static void insertFlat(Material mat){
        try {
            Connection con = Connector.connection();
            String query = "insert into matflat (category, description, length, unit, usagedesc, price)" +
                    "values (?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString( 1, mat.getKategori());
            ps.setString( 2, mat.getNavn());
            ps.setInt( 3, mat.getLaengde());
            ps.setString( 4, mat.getEnhed());
            ps.setString( 5, mat.getBeskrivelse());
            ps.setDouble( 6, mat.getPris());
            ps.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.finest("MaterialMapper insertFlat "+e);
        } catch (SQLException e) {
            Log.finest("MaterialMapper"+" There was a SQL Exception");

            e.printStackTrace();
        }
    }
    /**
     *
     * @param mat - material object
     * Denne metode indsætter et materiale i matslope tabellen.
     *
     */
    public static void insertSlope(Material mat){
        try {
            Connection con = Connector.connection();
            String query = "insert into matslope (catagory, description, length, unit, usagedesc, price)" +
                    "values (?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString( 1, mat.getKategori());
            ps.setString( 2, mat.getNavn());
            ps.setInt( 3, mat.getLaengde());
            ps.setString( 4, mat.getEnhed());
            ps.setString( 5, mat.getBeskrivelse());
            ps.setDouble( 6, mat.getPris());
            ps.execute();

        } catch (ClassNotFoundException e) {
            Log.finest("MaterialMapper insertSlope "+e);
            e.printStackTrace();
        } catch (SQLException e) {
            Log.finest("MaterialMapper"+" There was a SQL Exception");

            e.printStackTrace();
        }
    }

    /**
     *
     * @param mat - material object
     * Denne metode indsætter et materiale i materials tabellen.
     *
     */
    public static void insertMat(Material mat){
        try {
            Connection con = Connector.connection();
            String query = "insert into materials (category, description, length, unit, usagedesc, price)" +
                    "values (?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString( 1, mat.getKategori());
            ps.setString( 2, mat.getNavn());
            ps.setInt( 3, mat.getLaengde());
            ps.setString( 4, mat.getEnhed());
            ps.setString( 5, mat.getBeskrivelse());
            ps.setDouble( 6, mat.getPris());
            ps.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.finest("MaterialMapper insertMat "+e);
        } catch (SQLException e) {
            Log.finest("MaterialMapper"+" There was a SQL Exception");

            e.printStackTrace();
        }
    }

    /**
     *
     * @return ArrayList - materialer fra matflat tabellen.
     *
     * Denne metode henter alle materialer fra matflat tabellen.
     */
    public static ArrayList<String> getFlat(){
        ArrayList<String> flatList = new ArrayList();
        try {
            Connection con = Connector.connection();
            String query = "select description from matflat";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tmpFlat = rs.getString("description");
                flatList.add(tmpFlat);
            }

        } catch (ClassNotFoundException e) {
            Log.finest("MaterialMapper getFlat "+e);
            e.printStackTrace();
        } catch (SQLException e) {
            Log.finest("MaterialMapper"+" There was a SQL Exception");

            e.printStackTrace();
        }

        return flatList;
    }
    /**
     *
     * @return ArrayList - materialer fra matslope tabellen.
     *
     * Denne metode henter alle materialer fra matslope tabellen.
     */
    public static ArrayList<String> getSlope(){
        ArrayList<String> slopeList = new ArrayList();
        try {
            Connection con = Connector.connection();
            String query = "select description from matslope";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tmpSlope = rs.getString("description");
                slopeList.add(tmpSlope);
            }

        } catch (ClassNotFoundException e) {
            Log.finest("MaterialMapper getSlope "+e);
            e.printStackTrace();
        } catch (SQLException e) {
            Log.finest("MaterialMapper getSlope"+" There was a SQL Exception");

            e.printStackTrace();
        }

        return slopeList;
    }
    /**
     *
     * @return ArrayList - materialer fra materials tabellen.
     *
     * Denne metode henter alle materialer fra materials tabellen.
     */
    public static ArrayList<String> getMats(){
        ArrayList<String> matList = new ArrayList();
        try {
            Connection con = Connector.connection();
            String query = "select description from materials";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tmpMat = rs.getString("description");
                matList.add(tmpMat);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            Log.finest("MaterialMapper getMats"+" There was a SQL Exception");

            e.printStackTrace();
        }

        return matList;
    }


}
