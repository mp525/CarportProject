package PresentationLayer;

import DBAccess.RequestMapper;
import FunctionLayer.ListSorter;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**

 @author Matti

  Denne klasse sortere listen af requests og sender brugeren til listpage.jsp
    Denne klasse blev ikke implementeret men den planlagte implementering er beskrevet i rapporten.
 */
public class RequestListSorted extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        ListSorter l= new ListSorter();

        String email=request.getParameter("email");
        ArrayList<Request> searchlistEmail = RequestMapper.searchEmailRequest(email);
        request.setAttribute("searchList", searchlistEmail);

        ArrayList<Request> sortWidth=l.getSortedByWidth(RequestMapper.getRequests());
        request.setAttribute("sortWidth", sortWidth);

        ArrayList<Request> sortLength=l.getSortedByLength(RequestMapper.getRequests());
        request.setAttribute("sortLength", sortLength);

        ArrayList<Request> sortArea=l.getSortedByArea(RequestMapper.getRequests());
        request.setAttribute("sortArea", sortArea);

        return "listPage";

    }
}
