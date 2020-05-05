package FunctionLayer;

public class TagBeregner {







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

    public int Cal25x200x300FnB(Request req) {
        // for the front and back stern
        //Taken from the example of 780 x 600, and here using the 25x200x300
        int max = 600;
        int half = max / 2;
        int quart = half / 2;
        double w = req.getWidth();

        if (w < quart){
            return 1;
        } else if (w >= quart && w <= half){
            return 2;
        }else if (w >= half && w <= max){
            return 4;
        }else { return 4;
        }
    }


    public int Cal25x200x360Sides(Request req) {
        // for the side sterns
        //Taken from the example of 780 x 600, and here using the 25x200x360
        int max = 780;
        int half = max / 2;
        int quart = half / 2;
        double l = req.getLength();

        if (l < quart){
            return 2;
        } else if (l >= quart && l <= half){
            return 4;
        }else if (l >= half && l <= max){
            return 6;
        }else
            {return 6;}
    }

    public int Cal25x125x300Front(Request req) {
        // it calculates via a number of 300, because it will measure so it fits the length. Using

        int max = 780;
        int half = max / 2;
        int quart = half / 2;
        double w = req.getWidth();
        int numbOfPlanks = 0;

        if(w <= 300){
            numbOfPlanks = 1;
        } else if (w > 300 && w <= 600){
            numbOfPlanks = 2;
        } else if (w>600){
            numbOfPlanks = 3;
        }
        return  numbOfPlanks;
    }



}

