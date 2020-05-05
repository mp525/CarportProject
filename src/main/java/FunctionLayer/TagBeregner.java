package FunctionLayer;

public class TagBeregner {


    //private ArrayList<Material> matList = new ArrayList();

    public static double Area(Request req) {
        double areal = req.getArea();
        return areal;
    }


    public int numRofPlatesSingls(Request req) {
        // I antagelse af at der anvendes plader på L.600 W.109, derfor

        double l = req.getLength();
        double w = req.getWidth();
        double LnW = l * w;
        String tagmat = req.getRoofmat();

        int LTW = 0;
        // tallet 65400 er længde gange bredde af plastplade, altså 600 * 109

        //Anvender den største af hver slags plade lige pt
        switch (tagmat) {

            case "Plasttrapezplader":
                LTW = 600 * 109;
            case "StÃ¥ltag":
                LTW = 250 * 105;
            case "Tagpap":
                LTW = 750 * 60;
        }
        double stks = LnW / LTW;

        int Pladtal = (int) Math.ceil(stks);
        return Pladtal;
    }

    public int numOfRofScrews(Request req) {

        double l = req.getLength();
        double w = req.getWidth();
        double LcW = l + w;

        int Rscrews = (int) (LcW / 460);

        if (Rscrews < 1) {
            Rscrews = 1;
        }

        return Rscrews;
    }


}