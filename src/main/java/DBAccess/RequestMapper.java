package DBAccess;

import FunctionLayer.Request;

import java.sql.Connection;
import java.sql.SQLException;

public class RequestMapper {


    public static void insertRequest(Request request){
        try {
            Connection con = Connector.connection();
            String query = "insert into ";





        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
