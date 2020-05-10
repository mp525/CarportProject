package FunctionLayer;

public class TagBeregnerSlop {


//Tagpakken

    public static int antalBnCDob(Request req) {

        int enTinDel = 56250;
        int width = req.getWidth();
        int length = req.getLength();
        double amount = 1.0;
        double LnW = length * width;


        amount = Math.ceil(LnW/enTinDel);
        int montus = (int) amount * 60;
        return montus;
    }

    public static int antalRygsten(Request req){

        int enTinDel = 56250;
        int width = req.getWidth();
        int length = req.getLength();
        double amount = 1.0;
        double LnW = length * width;


        amount = Math.ceil(LnW/enTinDel);
        double montus = amount * 2.1;

        montus = Math.ceil(montus);
        int mallus = (int) montus;

        return mallus;
    }

public static int topLaegHolds(Request req){

    int enTinDel = 56250;
    int width = req.getWidth();
    int length = req.getLength();
    double amount = 1.0;
    double LnW = length * width;


    amount = Math.ceil(LnW/enTinDel);
    double montus = amount * 0.8;

    montus = Math.ceil(montus);
    int mallus = (int) montus;

    switch (mallus){
        case 1:
            mallus = 2;
            break;
        case 3:
            mallus = 4;
            break;
        case 5:
            mallus = 6;
            break;
        case 7:
            mallus = 8;
            break;
        case 9:
            mallus = 10;
            break;
    }


    return mallus;
}

    public static int antalRygstensBeslag(Request req){

        int enTinDel = 56250;
        int width = req.getWidth();
        int length = req.getLength();
        double amount = 1.0;
        double LnW = length * width;


        amount = Math.ceil(LnW/enTinDel);
        double montus = amount * 2.1;

        montus = Math.ceil(montus);
        int mallus = (int) montus;

        return mallus;
    }

    public static int bindsNNakrog(Request req){

        return 2;
    }


    //tree


    // der skal bruges 2 af dem her
    public static int strlseSternSidder25n150nx(Request req){

        int width = req.getWidth();

        int size = 100;

        switch (width){
            case 240:
            case 270:
            case 300:
            case 330:
            case 360:
                size = 300;
                break;

            case 390:
            case 420:
                size = 360;
                break;

            case 450:
            case 480:
                size = 420;
                break;

            case 510:
            case 540:
                size = 480;
                break;

            case 570:
            case 600:
                size = 540;
                break;

            case 630:
            case 660:
            case 690:
            case 720:
            case 750:
                size = 600;
                break;
        }
                    //Measurements
                        //240
                        //270
                        //300
        //300
                        //330
                        //360
                        //390
        //360
                        //420
                        //450
                        //480
        //420
                        //510
                        //540
                        //570
        //480
                        //600
                        //630
                        //660
        //540
                        //690
                        //720
                        //750
        //600
return size;
    }

    public static int SternSidderAntal(Request req){
        int width = req.getWidth();
        int etellerto = 2;
        if(width < 300){
            etellerto = 1;
        }

        return etellerto;
    }



    /*

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



    public double roofMatPrice(Request req){


        double l = req.getLength();
        double w = req.getWidth();
        double LnW = l * w;
        String tagmat = req.getRoofmat();
        double LTW = 0.0;
        double stks = 0;

        double PladTal = 0;
        double PladPris = 0;


        switch (tagmat) {

        case "Plasttrapezplader":
            LTW = 600.0 * 109.0;
            stks = LnW / LTW;
            PladTal = Math.ceil(stks);
            PladPris = PladTal * 250.0;
            break;
        case "Ståltag":
            LTW = 250.0 * 105.0;
            stks = LnW / LTW;
            PladTal = Math.ceil(stks);
            PladPris = PladTal * 239.0;
            break;
        case "Tagpap":
            LTW = 750.0 * 60.0;
            stks = LnW / LTW;
            PladTal = Math.ceil(stks);
            PladPris = PladTal * 299.0;
            break;
       }
       return PladPris;

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

    public double RofScrewPrice(Request req) {

        double l = req.getLength();
        double w = req.getWidth();
        double LcW = l + w;

        int Rscrews = (int) (LcW / 460);

        if (Rscrews < 1) {
            Rscrews = 1;
        }

        double ScrPrice = 409.0 * Rscrews;

        return ScrPrice;
    }



    public int Cal25x200x300FnB(Request req) {
        // for the front and back stern, here i have taken the smallest as examples
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

    public double Cal25x200x300FnBPrice(Request req) {
        // for the front and back stern, here i have taken the smallest as examples
        //Taken from the example of 780 x 600, and here using the 25x200x300
        int max = 600;
        int half = max / 2;
        int quart = half / 2;
        double w = req.getWidth();
        double pricePlank = 33.95;

        if (w < quart){
            return pricePlank;
        } else if (w >= quart && w <= half){
            pricePlank = pricePlank * 2;
            return pricePlank;
        }else if (w >= half && w <= max){
            pricePlank = pricePlank * 4;
            return pricePlank;
        }else {
            return pricePlank;
        }
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

    public double Cal25x125x300FrontPrice(Request req) {
        // it calculates via a number of 300, because it will measure so it fits the length. Using

        int max = 780;
        int half = max / 2;
        int quart = half / 2;
        double w = req.getWidth();
        int numbOfPlanks = 0;
        double pricePlank = 27.95;

        if(w <= 300){
            return pricePlank;
        } else if (w > 300 && w <= 600){
            pricePlank = pricePlank * 2;
            return pricePlank;
        } else if (w>600){
            pricePlank = pricePlank * 3;
            return pricePlank;
        }
        return pricePlank;
    }

    public int Cal25x125x360Sides(Request req) {
        // it calculates via a number of 300, because it will measure so it fits the length. Using

        int max = 600;
        int half = max / 2;
        int quart = half / 2;
        double w = req.getWidth();
        int numbOfPlanks = 0;

        if(w <= 300){
            numbOfPlanks = 2;
        } else if (w > 300 && w <= 600){
            numbOfPlanks = 4;
        } else if (w>600){
            numbOfPlanks = 6;
        }
        return  numbOfPlanks;
    }

    public double Cal25x125x360SidesPrice(Request req) {
        // it calculates via a number of 300, because it will measure so it fits the length. Using

        int max = 600;
        int half = max / 2;
        int quart = half / 2;
        double w = req.getWidth();
        int numbOfPlanks = 2;
        double pricePlank = 27.95;

        if(w <= 300){
            pricePlank = pricePlank * 2;
        } else if (w > 300 && w <= 600){
            pricePlank = pricePlank * 4;
        } else if (w>600){
            pricePlank = pricePlank * 6;
        }
        return pricePlank;
    }

    public int CaL19x100x480(Request req){

       // Lige pt, formodes det at brugeren saver til på matrialerne.
        int max = 600;
        int half = max / 2;
        int quart = half / 2;
        double w = req.getWidth();
        int numbOfPlanks = 0;

        if(w <= half){
            numbOfPlanks = 1;
        } else if (w > half && w <= max){
            numbOfPlanks = 2;
        } else if (w>half){
            numbOfPlanks = 5;
        }
        return numbOfPlanks;
    }

    public double CaL19x100x480Price(Request req){

        // Lige pt, formodes det at brugeren saver til på matrialerne.
        int max = 600;
        int half = max / 2;
        int quart = half / 2;
        double w = req.getWidth();
        int numbOfPlanks = 0;
        double pricePlank = 22.95;

        if(w <= half){
            numbOfPlanks = 1;
            pricePlank = 22.95 * numbOfPlanks;
        } else if (w > half && w <= max){
            numbOfPlanks = 2;
            pricePlank = 22.95 * numbOfPlanks;
        } else if (w>half){
            numbOfPlanks = 5;
            pricePlank = 22.95 * numbOfPlanks;
        }
        return pricePlank;
    }

    public int CaL19x100x420Forend(Request req){

        // Lige pt, formodes det at brugeren saver til på matrialerne.
        //Der bruges her 19x100x420
        int max = 780;
        int half = max / 2;
        int quart = half / 2;
        double w = req.getWidth();
        int numbOfFlanks = 0;

        if(w <= 325){
            numbOfFlanks = 1;
        } else if (w > 325 && w <= 600){
            numbOfFlanks = 2;
        } else if (w>600){
            numbOfFlanks = 2;
        }
        return numbOfFlanks;
    }


    public double CaL19x100x420ForendPrice(Request req){

        // Lige pt, formodes det at brugeren saver til på matrialerne.
        //Der bruges her 19x100x420
        int max = 780;
        int half = max / 2;
        int quart = half / 2;
        double w = req.getWidth();
        int numbOfFlanks = 0;
        double pricePlank = 22.95;

        if(w <= 325){
            numbOfFlanks = 1;

        } else if (w > 325 && w <= 600){
            numbOfFlanks = 2;
        } else if (w>600){
            numbOfFlanks = 2;
        }

        pricePlank = pricePlank * numbOfFlanks;

        return pricePlank;
    }
*/
}