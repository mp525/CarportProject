package PresentationLayer;



import FunctionLayer.LoginSampleException;
import FunctionLayer.Request;
import FunctionLayer.SVG;

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

        Request r = new Request(1,  "mattemanden@gmail.com",  400,  400,  "oak",  true,  "wood",  40,  400,  400);
          length = r.getLength();
          width = r.getWidth();
          lengthS = r.getLengthS();
          widthS = r.getWidthS();


//in progress...

        SVG svg = new SVG(800, 600, "0,0,800,600",0,0);
        SVG svgInnerDrawing = new SVG(900,800,"0,0,900,800",0,0);
        svg.addRect(0,0,length,width);
        svg.addRect(0,35,lengthS,widthS);
        svg.addRect(0,565,4,780);
        request.setAttribute("svgdrawing", svg.toString());
        return "drawing";

//in progress...


    }


}