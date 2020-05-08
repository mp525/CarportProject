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

        SVG svg = new SVG(800, 600, "0,0,800,600",0,0);
        SVG sideSVG = new SVG(800, 600, "0,0,800,600",0,0);
        //Carport
        svg.addRect(0,0,length,width);

        //StolperLængde
        int fordelLængde =length/s.stolpeAntalLength(reviewReq);
        for (int i = 0; i < s.stolpeAntalLength(reviewReq)-1; i++) {
            if(s.stolpeAntalLength(reviewReq)==1){
                fordelLængde= fordelLængde/2;
            }
            svg.addRect(0,fordelLængde,10,10);

            fordelLængde=+s.stolpeAntalLength(reviewReq);
        }

        int fordelLængde2 =length/s.stolpeAntalLength(reviewReq);
        for (int i = 0; i < s.stolpeAntalLength(reviewReq)-1; i++) {
            if(s.stolpeAntalLength(reviewReq)==1){
                fordelLængde2= fordelLængde2/2;
            }
            svg.addRect(width-10,fordelLængde2,10,10);
            fordelLængde2=+s.stolpeAntalLength(reviewReq);
        }

        //Stolper bredde
        int fordelBredde= width/s.stolpeAntalWidth(reviewReq);
        for (int i = 0; i < s.stolpeAntalWidth(reviewReq)-1; i++) {
            if(s.stolpeAntalWidth(reviewReq)==1){
                fordelBredde= fordelBredde/2;
            }
            svg.addRect(fordelBredde,0,10,10);
            fordelBredde=+s.stolpeAntalWidth(reviewReq);
        }

        //Stolper hjørner
        svg.addRect(0,length-10,10,10);
        svg.addRect(width-10,length-10,10,10);

        svg.addRect(width-10,0,10,10);

        //Skuret
        if(widthS!=0) {
            //selve skuret
            svg.addRect(0, 0, lengthS, widthS);

            //Stolper hjørner
            svg.addRect(widthS - 10, lengthS - 10, 10, 10);
            svg.addRect(0, lengthS - 10, 10, 10);
            svg.addRect(widthS - 10, 0, 10, 10);
        }
        svg.addRect(0,0,10,10);

        //de der linjer som jeg kom til at starte på, sorry vibeke :-/
        svg.addLine( 0,length +50,width,length +50);
        svg.addLine( width, 0,width,length);

        //Set fra siden begynder her
        sideSVG.rectTemplateRotate(0,0,20,width);
        sideSVG.rectTemplateRotate(0,20,20,width);
        request.setAttribute("svgdrawing", svg.toString()+sideSVG.toString());



            return "Drawing";

//in progress...



    }


}