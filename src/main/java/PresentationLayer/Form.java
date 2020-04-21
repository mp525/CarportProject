package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Form extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        //Width
        String width = request.getParameter("width");
        request.setAttribute("width", width);
        //Length
        String length = request.getParameter("length");
        request.setAttribute("length", length);
        //Roof
        String roof = request.getParameter("roof");
        request.setAttribute("roof", roof);
        //Slope
        String slope = request.getParameter("slope2");
        request.setAttribute("slope", slope);
        //Shed width
        String shedW = request.getParameter("shedW");
        request.setAttribute("shedW", shedW);
        //Shed length
        String shedL = request.getParameter("shedL");
        request.setAttribute("shedL", shedL);
        //Flat roof
        String roofF = request.getParameter("roofF");
        request.setAttribute("roofF", roofF);
        //Sloped roof
        String roofS = request.getParameter("roofS");
        request.setAttribute("roofS", roofS);

        //Name
        String name = request.getParameter("Navn");
        request.setAttribute("name", name);
        //Email
        String email = request.getParameter("Email");
        request.setAttribute("email", email);
        //Age
        String age = request.getParameter("Alder");
        request.setAttribute("age", age);
        //Adress
        String adress = request.getParameter("Adresse");
        request.setAttribute("adr", adress);
        //City
        String city = request.getParameter("by");
        request.setAttribute("city", city);
        //Postal code
        String zip = request.getParameter("postNR");
        request.setAttribute("zip", zip);

        return "form" + "page";
    }
}
