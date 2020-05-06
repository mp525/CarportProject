package DBAccess;

import FunctionLayer.Material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaterialMapper {
    public static void main(String[] args) {
        ArrayList<String>materialeNavn =findmaterials();
        System.out.println(getMatsStykliste(materialeNavn));

    }
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

    //får for meget info, overvejer om vi skal bruge det fordi jeg tror jeg har fundet på noget andet
    public static ArrayList<Material> getMatsStykliste(ArrayList<String>materialeNavn){
        ArrayList<Material> materialList = new ArrayList();
        for (int i = 0; i < materialeNavn.size(); i++) {
            String materialenavnet=materialeNavn.get(i);

            try {
                Connection con = Connector.connection();
                String query = "select * from materials where description = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, materialenavnet);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String navn = rs.getString("description");
                    String beskrivelse = rs.getString("usagedesc");
                    String enhed = rs.getString("unit");
                    String kategori = rs.getString("category");
                    int laengde = rs.getInt("length");
                    double pris = rs.getDouble("price");

                    Material m = new Material(navn, beskrivelse, enhed, kategori, laengde, pris);
                    materialList.add(m);

                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return materialList;
    }
    public static ArrayList<String> findmaterials(){
        ArrayList<String> materials= new ArrayList<>();
        materials.add("97x97 mm. trykimp. Stolpe");

        //TBD
        return materials;
    }
}
