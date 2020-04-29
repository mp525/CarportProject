package PresentationLayer;

import DBAccess.RequestMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class GetOnesRequests extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String emaill = request.getParameter("emaill");

        try {

        ArrayList<Request> requestsSolo = RequestMapper.searchEmailRequest(emaill);
        request.setAttribute("requests", requestsSolo);
        } catch (Exception e) {
            request.setAttribute("errorDel", e.getMessage() );
            e.printStackTrace();
            return "employee" + "page";
        }

        return "solist";


    }
}
