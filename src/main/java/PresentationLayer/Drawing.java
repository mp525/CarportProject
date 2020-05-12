package PresentationLayer;



import DBAccess.RequestMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Request;
import FunctionLayer.SVG;
import FunctionLayer.StyklisteBeregner;

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


        //StolperLængde
        int fordelLængde =width/s.stolpeAntalWidth(reviewReq);
        for (int i = 0; i < s.stolpeAntalWidth(reviewReq)-1; i++) {
            if(s.stolpeAntalWidth(reviewReq)==1){
                fordelLængde= fordelLængde/2;
            }
            svg.addRect(fordelLængde,20,10,10);

            fordelLængde=+s.stolpeAntalWidth(reviewReq);
        }

        int fordelLængde2 =width/s.stolpeAntalWidth(reviewReq);
        for (int i = 0; i < s.stolpeAntalWidth(reviewReq)-1; i++) {
            if(s.stolpeAntalWidth(reviewReq)==1){
                fordelLængde2= fordelLængde2/2;
            }
            svg.addRect(fordelLængde2,width-30,10,10);
            fordelLængde2=+s.stolpeAntalWidth(reviewReq);
        }

        //Stolper bredde
        if(reviewReq.getWidthS() == 0){
            int fordelBredde= length/s.stolpeAntalWidth(reviewReq);
            for (int i = 0; i < s.stolpeAntalWidth(reviewReq)-1; i++) {
                if(s.stolpeAntalWidth(reviewReq)==1){
                    fordelBredde= fordelBredde/2;
                }
                svg.addRect(length - 30,fordelBredde,10,10);
                fordelBredde=+s.stolpeAntalLength(reviewReq);
            }
        }


        //Stolper hjørner
        svg.addRect(20,width-30,10,10);
        svg.addRect(length-30,width-30,10,10);
        svg.addRect(20,20,10,10);


        //Skuret
        if(widthS!=0) {
            //selve skuret
            svg.addRect(length - lengthS - 20, 20, widthS, lengthS);

            //Stolper hjørner
            svg.addRect(length - lengthS - 20, widthS + 10, 10, 10);
            svg.addRect(length - 30, widthS + 10, 10, 10);
            svg.addRect(length - lengthS - 20, 20, 10, 10);
        }

        svg.addRect(length-30,20,10,10);

        //remme
        svg.addRect(0,20, 5, length);
        svg.addRect(0,width-30, 5, length);

        //Målelinjer
        //svg.addLine( 0,length +50,width,length +50);
        svg.markerDef();
        svg.addArrowLine(0, length + 50, width, length + 50);
        //svg.addText(width+50, length/2, 30, length);
        //svg.addTextRotate(width+100, length/2, 30, length/2);
        svg.addTextRotate(width+70, length/2, 90, length);
        svg.addArrowLine(width + 50, 0,width + 50, length);
        svg.addText(width/2, length+70, 0, width);
        //svg.addLine( width + 50, 0,width + 50,length);

        svg.addLine( 0,width +50,length,width +50);
        svg.addArrowLine(0,width+50, length, width+50);
        svg.addLine( length + 50, 0,length + 50,width);

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

        request.setAttribute("svgdrawing", svg.toString());

            return "Drawing";

//in progress...



    }


}