package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Form extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        //Width
        String width = request.getParameter("width");
        //Length
        String length = request.getParameter("length");
        //Slope
        String slope = request.getParameter("slope");
        //Shed width
        String shedW = request.getParameter("shedW");
        //Shed length
        String shedL = request.getParameter("shedL");
        //Flat roof
        String roofF = request.getParameter("roofFMat");
        //Sloped roof
        String roofS = request.getParameter("roofSMat");
        //Cladding
        String clad = request.getParameter("cladding");

        if (shedW.equalsIgnoreCase("Ingen")) {
            shedL = "Ingen";
            clad = "Ingen";
        } else if (shedL.equalsIgnoreCase("Ingen")) {
            shedW = "Ingen";
            clad = "Ingen";
        } else if (clad.equalsIgnoreCase("Ingen")) {
            shedL = "Ingen";
            shedW = "Ingen";
        }

        if (shedL.equalsIgnoreCase("choose") && shedW.equalsIgnoreCase("choose") && clad.equalsIgnoreCase("choose")) {
            shedL = null;
            shedW = null;
            clad = null;
        }

        request.setAttribute("width", width);
        request.setAttribute("length", length);
        request.setAttribute("slope", slope);
        request.setAttribute("shedW", shedW);
        request.setAttribute("shedL", shedL);
        request.setAttribute("roofF", roofF);
        request.setAttribute("roofS", roofS);
        request.setAttribute("cladding", clad);

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
