package PresentationLayer;

import DBAccess.RequestMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class RequestList extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        ArrayList<Request> requestlist = RequestMapper.getRequests();
        request.setAttribute("requestList", requestlist);

        ArrayList<Request> searchlist = RequestMapper.searchRequest();
        request.setAttribute("searchList", searchlist);

        return "listPage";
    }
}
