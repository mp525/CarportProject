package PresentationLayer;

import DBAccess.ContactMapper;
import FunctionLayer.LoginSampleException;
import DBAccess.RequestMapper;
import FunctionLayer.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author Nikolaj
 *
 *
 * Denne klasse sender brugeren til requestlists.jsp
 *
 */

public class RequestLists extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        ArrayList<Request> requests = RequestMapper.getRequests();

        request.setAttribute("requests", requests);

        return "request" + "lists";
    }
}
