package DBAccess;

import FunctionLayer.Request;

import java.sql.*;
import java.util.ArrayList;

public class RequestMapper {


    public static void insertRequest(Request request){
        try {
            Connection con = Connector.connection();
            String query = "insert into requests (email, width, length, cladding, rooftype, roofmat, slope, lengthS, widthS)" +
                    "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString( 1, request.getEmail());
            ps.setInt( 2, request.getWidth());
            ps.setInt( 3, request.getLength());
            ps.setString( 4, request.getCladding());
            ps.setBoolean( 5, request.getRooftype());
            ps.setString( 6, request.getRoofmat());
            ps.setInt( 7, request.getSlopeangle());
            ps.setInt( 8, request.getLengthS());
            ps.setInt( 9, request.getWidthS());
            ps.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Request> getRequests(){
        ArrayList<Request> reqList = new ArrayList();
        try {
            Connection con = Connector.connection();
            String query = "select * from requests";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                String email = rs.getString("email");
                int id = rs.getInt("requestID");
                int width = rs.getInt("width");
                int length = rs.getInt("length");
                String cladding = rs.getString("cladding");
                boolean rooftype = rs.getBoolean("rooftype");
                String roofmat = rs.getString("roofmat");
                int slope = rs.getInt("slope");
                int lengthS = rs.getInt("lengthS");
                int widthS = rs.getInt("widthS");
                Request tmpRequest = new Request(id, email, width, length, cladding, rooftype, roofmat, slope, lengthS, widthS);
                reqList.add(tmpRequest);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reqList;
    }
    public static ArrayList<Request> searchRequest(){
        ArrayList<Request> reqList = new ArrayList();
        try {
            Connection con = Connector.connection();
            String query = "select * from requests where email ?";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                String email = rs.getString("email");

                int id = rs.getInt("requestID");
                int width = rs.getInt("width");
                int length = rs.getInt("length");

                String cladding = rs.getString("cladding");
                boolean rooftype = rs.getBoolean("rooftype");
                String roofmat = rs.getString("roofmat");

                int slope = rs.getInt("slope");
                int lengthS = rs.getInt("lengthS");
                int widthS = rs.getInt("widthS");

                Request tmpRequest = new Request(id, email, width, length, cladding, rooftype, roofmat, slope, lengthS, widthS);
                reqList.add(tmpRequest);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reqList;
    }
}
