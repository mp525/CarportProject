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
//in progress...


        SVG sideSVG = new SVG(width+100, length+100, "0,0,1300,1000",0,0);
        //Carport


        //Set fra siden begynder her

        sideSVG.rectTemplateRotate(0,0,20,width);
        sideSVG.rectTemplateRotate(0,20,20,width);
        sideSVG.rectTemplateRotate(0,20,(length/2)-20,widthS);

        //stolper
        sideSVG.rectTemplateRotate(width-10,40,length/2 - 20,10);
        sideSVG.rectTemplateRotate(0,40,length/2 - 20,10);
        //stolperekstrapgalængde
       /* int fordelLængde =width/s.stolpeAntalLength(reviewReq);
        for (int i = 0; i < s.stolpeAntalLength(reviewReq)-1; i++) {
            if(s.stolpeAntalLength(reviewReq)==1){
                fordelLængde=fordelLængde/2;
            }
            if(s.stolpeAntalLength(reviewReq)==2){
                fordelLængde=fordelLængde-width/2;
            }
            sideSVG.addRect(fordelLængde,20,length/2,10);

            fordelLængde=+width/2+width/4;
        }*/
        int fordelLængde =width/s.stolpeAntalWidth(reviewReq);
        for (int i = 0; i < s.stolpeAntalWidth(reviewReq)-1; i++) {
            if(s.stolpeAntalWidth(reviewReq)==1){
                fordelLængde= width/2;
            }
            sideSVG.addRect(fordelLængde,40,(length/2) - 20,10);

            fordelLængde=+s.stolpeAntalWidth(reviewReq);
        }

        //Skur brædder:
        sideSVG.rectTemplateRotate(10, 40, (length/2)-20, widthS-10);
        int xStart = 10;
        int xEnd = widthS-10;
        if(xStart<=xEnd) {
            sideSVG.addLine(10, 40, 10, (length/2)+20);
        }
        for (int i = 18; i < xEnd; i+=16) {
            sideSVG.addLine(i, 40, i, (length/2)+20);
            sideSVG.addLine(i+10, 40, i+10, (length/2)+20);
        }
        /*for (int i = 18; i < xEnd; i+=16) {
            sideSVG.addLine(i+10, 40, i+10, (length/2)+20);
        }*/
        /*int x = 10;
        while (x < xEnd) {
            sideSVG.addLine(x+10, 40, x+10, (length/2)+20);
            x+=16;
        }*/

        //Målelinjer
        sideSVG.markerDef();
        sideSVG.addArrowLine(0, (length/2)+40, width, (length/2)+40);
        sideSVG.addText(width / 2, (length/2)+60, 0, width);

        sideSVG.addArrowLine(width + 50, 0, width + 50, (length/2)+20);
        sideSVG.addTextRotate(width + 70, ((length/2)+20)/2, 90, 250);
        //sideSVG.addTextRotate(width + 70, (length/3), 90, (length/2)+20);


        request.setAttribute("svgdrawing2", sideSVG.toString());


        return "Drawing2";

//in progress..
    }
}