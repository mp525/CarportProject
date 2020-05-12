package PresentationLayer;



import DBAccess.RequestMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Request;
import FunctionLayer.SVG;
import FunctionLayer.StyklisteBeregner;
import sun.security.util.Length;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Drawing extends Command {


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
         int area;
         int requestID;
         String email;
         int width;
         int length;
         String cladding;
         boolean rooftype;
         String roofmat;
         int slopeangle;
         int lengthS;
         int widthS;

        StyklisteBeregner s = new StyklisteBeregner();

        Request reviewReq= (Request) request.getSession().getAttribute("reviewReq");
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

        length = reviewReq.getLength();
        width = reviewReq.getWidth();
        lengthS = reviewReq.getLengthS();
        widthS = reviewReq.getWidthS();
//in progress...

        SVG svg = new SVG(length, width, "0,0,1300,1000",0,0);
        SVG sideSVG = new SVG(1300, 1000, "0,0,1300,1000",0,0);

        //Carport
        svg.addRect(0,0,width,length);

        //remme
        svg.addRect(0,20, 5, length);
        svg.addRect(0,width-30, 5, length);

        //Målelinjer
        svg.markerDef();
        svg.addArrowLine(0,width+50, length, width+50);
        svg.addText(length/2, width+70, 0, length);
        svg.addArrowLine(length + 50, 0, length + 50, width);
        svg.addTextRotate(length+70, width/2, 90, width);

        //Set fra siden begynder her

        //Spær begynder her (remme skal laves først da spær ligger op remmene
        int xPosition = 0;
        for (int i = 0; i < s.antalSpær(length); i++){
            svg.addRect(xPosition, 0, width, 5);
            xPosition += s.spærAfstand(length);
        }

        svg.addLine(20,20,length - lengthS - 20,width - 20);
        svg.addLine(20,width - 20,length - lengthS - 20,20);
        /*sideSVG.rectTemplateRotate(0,0,20,width);
        sideSVG.rectTemplateRotate(0,20,20,width);*/
        //StolperLængde


        //Skuret
        if(widthS!=0) {
            //selve skuret
            svg.addRect(length - lengthS - 20, 20, widthS, lengthS);

            //Stolper hjørner
            svg.addRect(length - lengthS - 20, widthS + 10, 10, 10);
            svg.addRect(length - 30, widthS + 10, 10, 10);
            svg.addRect(length - lengthS - 20, 20, 10, 10);
        }

        int fordelLængde =length/s.stolpeAntalLength(reviewReq);
        for (int i = 0; i < s.stolpeAntalWidth(reviewReq); i++) {
            if(s.stolpeAntalWidth(reviewReq)==1){
                fordelLængde= length/2;
            }
            svg.addRect(fordelLængde,20,10,10);

            fordelLængde=+s.stolpeAntalWidth(reviewReq);
        }

        int fordelLængde2 = length /s.stolpeAntalLength(reviewReq);
        for (int i = 0; i < s.stolpeAntalWidth(reviewReq); i++) {
            if(s.stolpeAntalWidth(reviewReq)==1){
                fordelLængde2= length/2;
            }
            svg.addRect(fordelLængde2,width-30,10,10);
            fordelLængde2=+s.stolpeAntalWidth(reviewReq);
        }

        //Stolper bredde
        int fordelBredde= width/s.stolpeAntalWidth(reviewReq);
        for (int i = 0; i < s.stolpeAntalWidth(reviewReq); i++) {
            if(s.stolpeAntalWidth(reviewReq)==1){
                fordelBredde= width/2;
            }
            svg.addRect(length - 30,fordelBredde,10,10);
            fordelBredde=+s.stolpeAntalLength(reviewReq);
        }
        //Stolper hjørner
        svg.addRect(20,width-30,10,10);
        svg.addRect(length-30,width-30,10,10);
        svg.addRect(20,20,10,10);
        svg.addRect(length-30,20,10,10);
        //stolper Hjørner

        request.setAttribute("svgdrawing", svg.toString());

            return "Drawing";

//in progress...



    }


}