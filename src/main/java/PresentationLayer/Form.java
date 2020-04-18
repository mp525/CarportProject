package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Form extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

//        Width
        String bot = request.getParameter("bot");
        request.setAttribute("bot", bot);
//        Length
        String length = request.getParameter("length");
        request.setAttribute("length", length);
//        Roof
        String roof = request.getParameter("roof");
        request.setAttribute("roof", roof);
//        Slope
        String slope = request.getParameter("slope");
        request.setAttribute("slope", slope);
//        Shed width
        String shedW = request.getParameter("shedW");
        request.setAttribute("shedW", shedW);
//        Shed length
        String shedL = request.getParameter("shedL");
        request.setAttribute("shedL", shedL);
//        Test, will be deleted
        String country = request.getParameter("country"); // will give you selected country name
        request.setAttribute("country", country);

        return "form" + "page";
    }
}
