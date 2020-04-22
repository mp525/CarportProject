package PresentationLayer;

import DBAccess.ContactMapper;
import DBAccess.RequestMapper;
import FunctionLayer.Contact;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendRequest extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        Contact carportContact = (Contact) request.getSession().getAttribute("carportContact");
        ContactMapper.insertContact(carportContact);

        Request carportRequest = (Request) request.getSession().getAttribute("carportRequest");
        RequestMapper.insertRequest(carportRequest);

        return "formpage";
    }
}
