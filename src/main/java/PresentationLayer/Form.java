package PresentationLayer;

import DBAccess.ContactMapper;
import FunctionLayer.Contact;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Vibeke
 * @author Mathias
 *
 * Denne klasse henter informationer fra en udfyldt form på Carport.jsp
 *
 */

public class Form extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();

        //Width
        int width = Integer.parseInt(request.getParameter("width"));
        //Length
        int length = Integer.parseInt(request.getParameter("length"));
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

        int shedWInt = 0;
        int shedLInt = 0;

        if (shedW.equalsIgnoreCase("1")) {
            shedL = "Ingen";
            clad = "Ingen";
        } else if (shedL.equalsIgnoreCase("1")) {
            shedW = "Ingen";
            clad = "Ingen";
        } else if (clad.equalsIgnoreCase("Ingen")) {
            shedL = "Ingen";
            shedW = "Ingen";
        } else{
            shedWInt = Integer.parseInt(shedW);
            shedLInt = Integer.parseInt(shedL);
        }

        if (shedL.equalsIgnoreCase("0") && shedW.equalsIgnoreCase("0") && clad.equalsIgnoreCase("0")) {
            shedL = null;
            shedW = null;
            clad = null;
        }

        int slopeInt = 0;
        if(slope == null){

        } else {
            slopeInt =  Integer.parseInt(slope);
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

        String telefon = request.getParameter("telefon");
        request.setAttribute("telefon", telefon);

        String husnummer = request.getParameter("husnummer");
        request.setAttribute("husnummer", husnummer);

        boolean rooftype = true;
        String roofmat = "";
        //Hvis rooftype er true, er der rejsning på taget

        if(roofF == null){
            rooftype = true;
            roofmat = roofS;
        } else{
            rooftype = false;
            roofmat = roofF;
        }
        int telefonInt = 0;
        if(telefon.equals("")){

        }else {
            telefonInt = Integer.parseInt(telefon);
        }
        int zipInt = 0;
        if(zip.equals("")){

        }else{
            zipInt = Integer.parseInt(zip);
        }

        Contact carportContact = new Contact(email, name, telefonInt, adress, husnummer, zipInt);
        session.setAttribute("carportContact", carportContact);

        Request carportRequest = new Request(email, width, length, clad, rooftype, roofmat, slopeInt, shedLInt, shedWInt);
        session.setAttribute("carportRequest", carportRequest);


        return "form" + "page";
    }
}
