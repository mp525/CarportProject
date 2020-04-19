package FunctionLayer;

public class Request {


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
        return  "Request ID: " + requestID +
                "Email: " + getEmail() +
                "Width: " + getWidth() +
                "Length: " + getLength() +
                "Cladding: " + getCladding() +
                "Roof type: " + getRooftype() +
                "Roof material: " + getRoofmat() +
                "Slope angle: " + getSlopeangle() +
                "Shed Length: " + getLengthS() +
                "Shed Width: " + getWidthS();
    }


}
