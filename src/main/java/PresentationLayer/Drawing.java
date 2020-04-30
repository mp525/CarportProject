package PresentationLayer;



import FunctionLayer.LoginSampleException;
import FunctionLayer.Request;
import FunctionLayer.SVG;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Drawing extends Command {
    private int area;
    private int requestID;
    private String email;
    private int width;
    private int length;
    private String cladding;
    private boolean rooftype;
    private String roofmat;
    private int slopeangle;
    private int lengthS;
    private int widthS;

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        Request r = new Request(requestID,  email,  width,  length,  cladding,  rooftype,  roofmat,  slopeangle,  lengthS,  widthS);
        int length = r.getLength();
        int width = r.getWidth();
        int lengthS = r.getLengthS();
        int widthS = r.getWidthS();


//in progress...

        SVG svg = new SVG(800, 600, "0,0,800,600",0,0);
        SVG frame = new SVG(900,800,"0,0,900,800",0,0);
        svg.addRect(0,0,length,width);
        svg.addRect(0,35,lengthS,widthS);
        svg.addRect(0,565,4,780);
        request.setAttribute("svgdrawing", svg.toString());
        return "drawing";

//in progress...


    }


}