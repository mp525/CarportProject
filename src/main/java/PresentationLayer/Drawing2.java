package PresentationLayer;



import DBAccess.RequestMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Request;
import FunctionLayer.SVG;
import FunctionLayer.StyklisteBeregner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Drawing2 extends Command {


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

        Request reviewReq = (Request) request.getSession().getAttribute("reviewReq");
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

        SVG sideSVG = new SVG(length+100, width+100, "0,0,1300,1000",0,0);

        //stolper
        sideSVG.addRect(length-30,60,length/2 - 20,10);
        sideSVG.addRect(20,50,length/2 - 10,10);
        //stolperekstrapgalængde
        int fordelLængde =width/s.stolpeAntalWidth(reviewReq);
        for (int i = 0; i < s.stolpeAntalWidth(reviewReq)-1; i++) {
            if(s.stolpeAntalWidth(reviewReq)==1){
                fordelLængde= length/2;
            }
            sideSVG.addRect(fordelLængde,50,(length/2) - 10,10);

            fordelLængde=+s.stolpeAntalWidth(reviewReq);
        }

        //Skur brædder:
        sideSVG.addRect(length-lengthS - 20, 56, (length/2)-16, lengthS-10);
        int xStart = length - lengthS - 10;
        int xEnd = widthS-10;
        if(xStart<=xEnd) {
            sideSVG.addLine(10, 40, 10, (length/2)+20);
        }
        for (int i = xStart; i < length-30; i+=16) {
            sideSVG.addLine(i, 56, i, (length/2)+40);
            sideSVG.addLine(i+10, 56, i+10, (length/2)+40);
        }

        //tag
        sideSVG.rectTemplateRotate(0,20,20,length, 1, length - 20,0);
        sideSVG.rectTemplateRotate(4,40,20,length-8, 1, length - 20, 0);

        //Målelinjer
        sideSVG.markerDef();
        sideSVG.addArrowLine(0, (length/2)+60, length, (length/2)+60);
        sideSVG.addText(length / 2, (length/2)+80, 0, width);

        sideSVG.addArrowLine(length + 50, 20, length + 50, (length/2)+40);
        sideSVG.addTextRotate(length + 70, ((length/2)+20)/2 + 20, 90, 250);
        //sideSVG.addTextRotate(width + 70, (length/3), 90, (length/2)+20);


        request.setAttribute("svgdrawing2", sideSVG.toString());


        return "Drawing2";

//in progress..
    }
}