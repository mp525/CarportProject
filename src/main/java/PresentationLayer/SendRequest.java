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


        Contact carportContact = (Contact) request.getAttribute("carportContact");
        ContactMapper.insertContact(carportContact);

        Request carportRequest = (Request) request.getAttribute("carportRequest");
        RequestMapper.insertRequest(carportRequest);

        return "receiptpage";
    }
}
