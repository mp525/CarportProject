package PresentationLayer;

import DBAccess.RequestMapper;
import FunctionLayer.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;

public class Review extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        ArrayList<Material> stykliste = new ArrayList();
        HttpSession s = request.getSession();
        String reqIDBefore = request.getParameter("reqID");
        String reqIDAfter = reqIDBefore.replace("Se forespoergsel ", "");
        int reqID = Integer.parseInt(reqIDAfter);
        Request reviewReq = RequestMapper.searchIDRequest(reqID);
        s.setAttribute("reviewReq", reviewReq);

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
        MaterialHelper.udregnSpær(stykliste, reviewReq);
        MaterialHelper.udregnStolpe(stykliste, reviewReq);

        //Vibeke test:
        MaterialHelper.udregnNoget(stykliste, reviewReq);


        double samletPris = 0.0;
        for (Material mat: stykliste) {
            samletPris += mat.getPris();
        }
        samletPris = StyklisteBeregner.round(samletPris,2);
        request.setAttribute("samletPris", samletPris);

        request.setAttribute("stykliste", stykliste);

        return "requestReview";
    }
}
