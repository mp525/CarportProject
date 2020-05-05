package PresentationLayer;

import DBAccess.RequestMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class RequestById extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String ide = request.getParameter("ide");
        int idus = Integer.parseInt(request.getParameter("ide"));

        try {

            //ArrayList<Request> requestsSolo = RequestMapper.searchIDRequest();
           // request.setAttribute("requests", requestsSolo);
        } catch (Exception e) {
            request.setAttribute("errorDel", e.getMessage() );
            e.printStackTrace();
            return "employee" + "page";
        }

        return "idest";
    }
}
