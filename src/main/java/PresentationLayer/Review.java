package PresentationLayer;

import DBAccess.RequestMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import FunctionLayer.Request;
import FunctionLayer.StyklisteBeregner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Scanner;

public class Review extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        ArrayList<Material> stykliste = new ArrayList();

        String reqIDBefore = request.getParameter("reqID");
        String reqIDAfter = reqIDBefore.replace("Se forespoergsel ", "");
        int reqID = Integer.parseInt(reqIDAfter);
        Request reviewReq = RequestMapper.searchIDRequest(reqID);

        request.setAttribute("reviewEmail", reviewReq.getEmail());
        request.setAttribute("reviewLength", reviewReq.getLength());
        request.setAttribute("reviewWidth", reviewReq.getWidth());
        request.setAttribute("reviewRoofType", reviewReq.getRooftype());
        request.setAttribute("reviewRoofMat", reviewReq.getRoofmat());
        request.setAttribute("reviewArea", reviewReq.getArea());
        request.setAttribute("reviewSlope", reviewReq.getSlopeangle());
        request.setAttribute("reviewLengthS", reviewReq.getLengthS());
        request.setAttribute("reviewWidthS", reviewReq.getWidthS());
        request.setAttribute("reviewID", reviewReq.getRequestID());

        //Spærudregning
        int antalSpær = StyklisteBeregner.antalSpær(reviewReq.getLength());
        int spærLængde = StyklisteBeregner.længdeSpær(reviewReq.getWidth());
        double spærPris = StyklisteBeregner.spærPris(spærLængde, antalSpær); //Her er det den samlede pris
        int antalRemme = 2;
        if(!(reviewReq.getLengthS() == 0)){
            antalRemme++;
        }
        double remPris = StyklisteBeregner.remPris(reviewReq.getLength(), antalRemme);
        double beslagPris = antalSpær * 45.95;
        int beslagSkrueAntal = StyklisteBeregner.beslagSkrueAntal(reviewReq.getLength());
        double beslagSkruePris = beslagSkrueAntal * 259;
        //int remLængde = reviewReq.getLengthS(); RemlængdeS er jeg lidt i tvivl om
        Material spær = new Material("45x195 mm. spærtræ ubh.", "Spær, monteres på rem",
                "stk", "Træ", spærLængde, spærPris, antalSpær);
        Material remme = new Material("45x195 mm. spærtræ ubh.", "Remme i sider, sadles ned i stolper",
                "stk", "Træ", reviewReq.getLength(), remPris, antalRemme);
        Material beslagHøjre = new Material("universal beslag 190mm højre", "Til montering af spær på rem",
                "stk", "Beslag og skruer", 0, beslagPris, antalSpær);
        Material beslagVenstre = new Material("universal beslag 190mm venstre", "Til montering af spær på rem",
                "stk", "Beslag og skruer", 0, beslagPris, antalSpær);
        Material beslagSkruer = new Material("4,0x50mm. beslagskruer 250 stk.", "Til montering af universalbeslag " +
                "+ hulbånd", "pakke", "Beslag og skruer", 0, beslagSkruePris, beslagSkrueAntal);

        stykliste.add(spær);
        stykliste.add(remme);
        stykliste.add(beslagHøjre);
        stykliste.add(beslagVenstre);
        stykliste.add(beslagSkruer);



        return "requestReview";
    }
}
