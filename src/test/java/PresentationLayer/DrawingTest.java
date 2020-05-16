package PresentationLayer;

import FunctionLayer.Request;
import FunctionLayer.SVG;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrawingTest {
    Request reviewReq = new Request("Mattemanden@gmail.com", 780, 780, "oak", true, "oak",20, 200, 200);
    int length = reviewReq.getLength();
    int width = reviewReq.getWidth();
    int lengthS = reviewReq.getLengthS();
    int widthS = reviewReq.getWidthS();
    SVG svg = new SVG(length, width, "0,0,800,600", 0, 0);
    @Test
    public void addRemme() {
        Drawing d = new Drawing();
        d.addRemme(svg, reviewReq);
        String expectedRect = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" height=\"780\" width=\"780\" viewBox=\"0,0,800,600\" preserveAspectRatio=\"xMinYMin\"><rect x=\"0\" y=\"20\" height=\"5\" width=\"780\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"0\" y=\"750\" height=\"5\" width=\"780\" style=\"stroke:#000000; fill: #ffffff\"/></svg>";
        assertEquals(svg.toString(),expectedRect);
    }

    @Test
    public void addStolperminusSkur() {
        Drawing d = new Drawing();
        d.addStolperminusSkur(svg, reviewReq);
        String expectedRect = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" height=\"780\" width=\"780\" viewBox=\"0,0,800,600\" preserveAspectRatio=\"xMinYMin\"><rect x=\"390\" y=\"20\" height=\"10\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"390\" y=\"750\" height=\"10\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"750\" y=\"390\" height=\"10\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"20\" y=\"750\" height=\"10\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"750\" y=\"750\" height=\"10\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"20\" y=\"20\" height=\"10\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\"/></svg>";
        assertEquals(svg.toString(),expectedRect);
    }

    @Test
    public void addSkurplusStolper() {
        Drawing d = new Drawing();
        d.addSkurplusStolper(svg, reviewReq);
        String expectedRect = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" height=\"780\" width=\"780\" viewBox=\"0,0,800,600\" preserveAspectRatio=\"xMinYMin\"><rect x=\"560\" y=\"20\" height=\"200\" width=\"200\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"560\" y=\"210\" height=\"10\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"750\" y=\"210\" height=\"10\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"560\" y=\"20\" height=\"10\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"560\" y=\"150\" height=\"10\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"560\" y=\"50\" height=\"10\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\"/></svg>";
        assertEquals(svg.toString(),expectedRect);
    }

    @Test
    public void addStern() {
        Drawing d = new Drawing();
        d.addStern(svg, reviewReq);
        String expectedRect = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" height=\"780\" width=\"780\" viewBox=\"0,0,800,600\" preserveAspectRatio=\"xMinYMin\"><rect x=\"0\" y=\"0\" height=\"5\" width=\"100\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"0\" y=\"775\" height=\"5\" width=\"100\" style=\"stroke:#000000; fill: #ffffff\"/></svg>";
        assertEquals(svg.toString(),expectedRect);
    }

    @Test
    public void addMålelinjer() {
        Drawing d = new Drawing();
        d.addMålelinjer(svg, reviewReq);
        String expectedRect = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" height=\"780\" width=\"780\" viewBox=\"0,0,800,600\" preserveAspectRatio=\"xMinYMin\"><defs>\n" + " <marker \n" + " \tid=\"beginArrow\" \n" + " \tmarkerWidth=\"12\" \n" + " \tmarkerHeight=\"12\" \n" + " \trefX=\"0\" \n" + " \trefY=\"6\" \n" + " \torient=\"auto\">\n" + "   <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />\n" + " </marker>\n" + " <marker \n" + " \tid=\"endArrow\" \n" + " \tmarkerWidth=\"12\" \n" + " \tmarkerHeight=\"12\" \n" + " \trefX=\"12\" \n" + " \trefY=\"6\" \n" + " \torient=\"auto\">\n" + "   <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" />\n" + " </marker>\n" + "</defs><line x1=\"0\" y1=\"830\" x2=\"780\" y2=\"830\" style=\"stroke:#000000;stroke-width:2;marker-start:url(#beginArrow);marker-end:url(#endArrow);\" /><text x=\"390\" y=\"850\" style=\"text-anchor: middle\" transform=\"rotate(\"0\" \"390\",\"850\")\">780 cm</text><line x1=\"830\" y1=\"0\" x2=\"830\" y2=\"780\" style=\"stroke:#000000;stroke-width:2;marker-start:url(#beginArrow);marker-end:url(#endArrow);\" /><text x=\"0\" y=\"0\" style=\"text-anchor: middle\" transform=\"translate(850, 390) rotate(90)\">780 cm</text></svg>";
        assertEquals(svg.toString(),expectedRect);
    }

    @Test
    public void addSpær() {
        Drawing d = new Drawing();
        d.addSpær(svg, reviewReq);
        String expectedRect = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" height=\"780\" width=\"780\" viewBox=\"0,0,800,600\" preserveAspectRatio=\"xMinYMin\"><line x1=\"20\" y1=\"20\" x2=\"560\" y2=\"760\" style=\"stroke:#000000;stroke-width:2\" /><line x1=\"20\" y1=\"760\" x2=\"560\" y2=\"20\" style=\"stroke:#000000;stroke-width:2\" /></svg>";
        assertEquals(svg.toString(),expectedRect);
    }

    @Test
    public void addSloped() {
        Drawing d = new Drawing();
        d.addSloped(svg, reviewReq);
        String expectedRect ="<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" height=\"780\" width=\"780\" viewBox=\"0,0,800,600\" preserveAspectRatio=\"xMinYMin\"><rect x=\"0\" y=\"388\" height=\"4\" width=\"780\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"4\" y=\"0\" height=\"4\" width=\"390\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"394\" y=\"0\" height=\"4\" width=\"386\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"4\" y=\"34\" height=\"4\" width=\"390\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"394\" y=\"34\" height=\"4\" width=\"386\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"4\" y=\"68\" height=\"4\" width=\"390\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"394\" y=\"68\" height=\"4\" width=\"386\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"4\" y=\"102\" height=\"4\" width=\"390\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"394\" y=\"102\" height=\"4\" width=\"386\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"4\" y=\"136\" height=\"4\" width=\"390\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"394\" y=\"136\" height=\"4\" width=\"386\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"4\" y=\"170\" height=\"4\" width=\"390\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"394\" y=\"170\" height=\"4\" width=\"386\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"4\" y=\"204\" height=\"4\" width=\"390\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"394\" y=\"204\" height=\"4\" width=\"386\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"4\" y=\"238\" height=\"4\" width=\"390\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"394\" y=\"238\" height=\"4\" width=\"386\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"4\" y=\"272\" height=\"4\" width=\"390\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"394\" y=\"272\" height=\"4\" width=\"386\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"4\" y=\"306\" height=\"4\" width=\"390\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"394\" y=\"306\" height=\"4\" width=\"386\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"4\" y=\"340\" height=\"4\" width=\"390\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"394\" y=\"340\" height=\"4\" width=\"386\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"4\" y=\"374\" height=\"4\" width=\"390\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"394\" y=\"374\" height=\"4\" width=\"386\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"4\" y=\"408\" height=\"4\" width=\"390\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"394\" y=\"408\" height=\"4\" width=\"386\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"4\" y=\"442\" height=\"4\" width=\"390\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"394\" y=\"442\" height=\"4\" width=\"386\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"4\" y=\"476\" height=\"4\" width=\"390\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"394\" y=\"476\" height=\"4\" width=\"386\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"4\" y=\"510\" height=\"4\" width=\"390\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"394\" y=\"510\" height=\"4\" width=\"386\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"4\" y=\"544\" height=\"4\" width=\"390\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"394\" y=\"544\" height=\"4\" width=\"386\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"4\" y=\"578\" height=\"4\" width=\"390\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"394\" y=\"578\" height=\"4\" width=\"386\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"4\" y=\"612\" height=\"4\" width=\"390\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"394\" y=\"612\" height=\"4\" width=\"386\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"4\" y=\"646\" height=\"4\" width=\"390\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"394\" y=\"646\" height=\"4\" width=\"386\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"4\" y=\"680\" height=\"4\" width=\"390\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"394\" y=\"680\" height=\"4\" width=\"386\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"4\" y=\"714\" height=\"4\" width=\"390\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"394\" y=\"714\" height=\"4\" width=\"386\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"4\" y=\"748\" height=\"4\" width=\"390\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"394\" y=\"748\" height=\"4\" width=\"386\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"4\" y=\"776\" height=\"4\" width=\"390\" style=\"stroke:#000000; fill: #ffffff\"/><rect x=\"394\" y=\"776\" height=\"4\" width=\"386\" style=\"stroke:#000000; fill: #ffffff\"/></svg>";
        assertEquals(svg.toString(),expectedRect);
    }
}