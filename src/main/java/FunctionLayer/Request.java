package FunctionLayer;
/**

 @author Matti
 @author Nikolaj
 @author Mathias
Denne klasse indeholder information om en request/forespørgsel fra en kunde.
 */
public class Request {


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

    public Request(int requestID, String email, int width, int length, String cladding, boolean rooftype, String roofmat, int slopeangle, int lengthS, int widthS){
        this.requestID = requestID;
        this.email = email;
        this.width = width;
        this.length = length;
        this.cladding = cladding;
        this.rooftype = rooftype;
        this.roofmat = roofmat;
        this.slopeangle = slopeangle;
        this.lengthS = lengthS;
        this.widthS = widthS;
        this.area=findArea(length,width);
    }


    private int findArea(int length, int width) {
        int area = 0;
        area=(length/100)*(width/100);
        return area;
    }

    public Request(String email, int width, int length, String cladding, boolean rooftype, String roofmat, int slopeangle, int lengthS, int widthS){
        this.email = email;
        this.width = width;
        this.length = length;
        this.cladding = cladding;
        this.rooftype = rooftype;
        this.roofmat = roofmat;
        this.slopeangle = slopeangle;
        this.lengthS = lengthS;
        this.widthS = widthS;
    }

    public int getArea() {
        return area;
    }

    public boolean isRooftype() {
        return rooftype;
    }

    public int getRequestID() { return requestID; }

    public void setRequestID (int requestID) {this.requestID = requestID; }


    public String getEmail  () { return email;}

    public void setEmail (String email) {this.email = email;}


    public int getWidth () { return width;}

    public void setWidth (int width) {this.width = width;}


    public int getLength () { return length;}

    public void setLength (int length) {this.length = length;}


    public String getCladding () { return cladding;}

    public void setCladding (String cladding) {this.cladding = cladding;}


    public boolean getRooftype () { return rooftype;}

    public void setRooftype (boolean rooftype) {this.rooftype = rooftype; }


    public String getRoofmat () { return roofmat;}

    public void setRoofmat(String roofmat) {this.roofmat = roofmat;}


    public int getSlopeangle () { return slopeangle;}

    public void setSlopeangle (int slopeangle) {this.slopeangle = slopeangle;}


    public int getLengthS () { return lengthS;}

    public void setLengthS (int lengthS) {this.lengthS = lengthS;}


    public int getWidthS () { return widthS;}

    public void setWidthS (int widthS) {this.widthS = widthS;}

    @Override
    public String toString() {
        return  "Anmodning " + getRequestID() + ": " + "\n" +
                "Email for anmodningen: " + getEmail() +
                "\n" + "Brede på carporten : " + getWidth() +
                "\n" + "Længden af carporten: " + getLength() +
                "\n" + "Belægning på carporten: " + getCladding() +
                "\n" + "Tagets type: " + getRooftype() +
                "\n" + "Tagets marteriale: " + getRoofmat() +
                "\n" + "Tagets hældning i grader: " + getSlopeangle() +
                "\n" + "Skurets længde: " + getLengthS() +
                "\n" + "Skurets bredde: " + getWidthS();
    }


}
