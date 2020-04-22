package DBAccess;

import FunctionLayer.Contact;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContactMapper {
    public static void insertContact(Contact contact){
        try {
            Connection con = Connector.connection();
            String query = "insert into contactsinf (email, name, phonenumber, streetname, housenumber, postalcode)" +
                    "values (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString( 1, contact.getEmail());
            ps.setString( 1, contact.getName());
            ps.setInt( 1, contact.getPhoneNumber());
            ps.setString( 1, contact.getStreetName());
            ps.setInt( 1, contact.getHouseNumber());
            ps.setInt( 1, contact.getPostalCode());

            ps.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Contact> getContacts(){
        ArrayList<Contact> conList = new ArrayList();
        try {
            Connection con = Connector.connection();
            String query = "select * from contactinf";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                String email = rs.getString("email");
                String name = rs.getString("name");
                int phonenumber = rs.getInt("phonenumber");
                String streetname = rs.getString("streetname");
                int housenumber = rs.getInt("housenumber");
                int postalcode = rs.getInt("postalcode");

                Contact tmpContact = new Contact(email, name, phonenumber, streetname, housenumber, postalcode);
                conList.add(tmpContact);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conList;
    }

}
