package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Form extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        if(request.getParameter("width").equalsIgnoreCase("choose")){
            request.setAttribute("besked", "Længde og bredde på carport skal vælges.");
            return "index";
        }
        if(request.getParameter("length").equalsIgnoreCase("choose")){
            request.setAttribute("besked", "Længde og bredde på carport skal vælges.");
            return "index";
        }
        //        Width
        int width = Integer.parseInt(request.getParameter("width"));
        request.setAttribute("width", width);
        //        Length
            int length = Integer.parseInt(request.getParameter("length"));
            request.setAttribute("length", length);
        //        Slope
            int slope = Integer.parseInt(request.getParameter("slope"));
            request.setAttribute("slope", slope);
        //        Shed width
            String shedW = request.getParameter("shedW");
            request.setAttribute("shedW", shedW);
        //        Shed length
            String shedL = request.getParameter("shedL");
            request.setAttribute("shedL", shedL);
        //        Flat roof
            String roofFMat = request.getParameter("roofFMat");
            request.setAttribute("roofF", roofFMat);
        //        Sloped roof
            String roofSMat = request.getParameter("roofSMat");
            request.setAttribute("roofS", roofSMat);

            String cladding = request.getParameter("cladding");
            request.setAttribute("cladding", cladding);


            //Hvis rooftype er true, er taget med rejsning, false= fladt tag
            boolean rooftype = true;
            String roofMat = "";
            int shedLInt = 0;
            int shedWInt = 0;

        if (roofFMat.isEmpty()) {
            rooftype = true;
            roofMat = roofSMat;
        } else if (roofFMat.contains("choose")) {
            rooftype = true;
            roofMat = roofSMat;
        } else {
            rooftype = false;
            roofMat = roofFMat;
        }
        if (shedL.equalsIgnoreCase("choose")){
            shedL = null;
            shedW = null;
            cladding = null;
        } else{
            shedLInt = Integer.parseInt(shedL);
            shedWInt = Integer.parseInt(shedW);
        }

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

            //String email, int width, int length, String cladding, boolean rooftype, String roofmat, int slopeangle, int lengthS, int widthS
            Request carportRequest = new Request(email, width, length, cladding, rooftype, roofMat, slope, shedLInt, shedWInt);
            request.setAttribute("carportRequest", carportRequest);


        return "form" + "page";
    }
}
