package DBAccess;

import FunctionLayer.Material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaterialMapper {

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flatList;
    }

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
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return slopeList;
    }

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
            e.printStackTrace();
        }

        return matList;
    }

}
