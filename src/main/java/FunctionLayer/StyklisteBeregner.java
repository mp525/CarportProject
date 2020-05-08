package FunctionLayer;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StyklisteBeregner {
    public static void main(String[] args) {
        StyklisteBeregner s = new StyklisteBeregner();
        Request r = new Request(1,"matti@gmail.com",500,500,"oak",true,"oak",20,200,200);
        System.out.println(s.stolpeAntalWidth(r));
    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static int antalSpær(int length) {
        double antal = Math.ceil((length / 55.0)) + 1.0; //length/antalspær (får regning af arne?)
        int spær = (int) antal;
        return spær;
    }
    public static int længdeSpær(int width){
        int længde = width;
        /*if (width > 600){
        * længde = (width/2);
        * }
        * Spærlængder må ikke overskride 6m? Er det ligemeget i vores tilfælde, og så bare lave spær
        * længere end 6m? Behøves længdeSpær metoden, hvis spærets længde bare kan være width?
        */
        /*switch(width){
            case 240: længde = 420;
            case 270: længde = 420;
            case 300: længde = 420;
            case 330: længde = 420;
            case 360: længde = 420;
            case 390: længde = 420;
            case 420: længde = 420;
            case 450: længde = 540;
            case 480: længde = 540;
            case 510: længde = 540;
            case 540: længde = 540;
            case 570: længde = 600;
            case 600: længde = 600;
            case 630: længde = 600;
            case 660: længde = 660;
            case 690: længde = 600;
            case 720: længde = 600;
            case 750: længde = 600;
        }*/
        return længde;
    }
    public static double spærPris(int spærLængde, int spærAntal){
        double spærPris = round((spærLængde/100) * spærAntal * 54.95,2); //meterprisen
        return spærPris;
    }
    public static double remPris(int remLængde, int remAntal){
        double remPris = round((remLængde/100) * remAntal * 54.95,2); //meterprisen
        return remPris;
    }
    public static int beslagSkrueAntal(int længde){
        int antalPakker = 0;
        if(længde <= 260){
            antalPakker = 1;
        } else if(længde <= 520){
            antalPakker = 2;
        } else if(længde <= 780){
            antalPakker = 3;
        }
        return antalPakker;
    }

    public int stolpeAntal(Request r) {
        //starter med en i hvert hjørne så 4
        int stolpeAntal = 4;
        int stolpeAntalBcLength = 0;
        int stolpeAntalBcWidth = 0;
        int stolpeAntalShed = 0;

        int lengths = r.getLengthS();
        boolean shed = false;
        if (lengths != 0) {
            shed = true;
        }
//340 højde
        //set i brochuren... //Forreste stolper skal være 208 cm. Høje og bagerste skal være 202 cm.

        //bredde

        stolpeAntalBcWidth = stolpeAntalBcWidth;

        // længde

        stolpeAntalBcLength = stolpeAntalLength(r);

        //leder videoen første møde havde det her info.. //20 kvadrat meter = 4 stolper // 30 kvadrat meter = 6 stolper
        //teknisk møde med håndværker gav denne information... //hver tredje meter skal der være en stolpe(i hver side)

        if (shed == true) {
            //hver hjørne af skuret

            //hver side af døren ved skuret
            stolpeAntalShed = 6;
        }

        //+ alt
        stolpeAntal = stolpeAntal + stolpeAntalBcLength + stolpeAntalBcWidth + stolpeAntalShed;
        return stolpeAntal;
    }
    public int stolpeAntalWidth(Request r){
        int width = r.getWidth();

        //bredde

        int stolpeAntalBcWidth = width / 300;
        return stolpeAntalBcWidth;
    }
    public int stolpeAntalLength(Request r){
        int length = r.getLength();
        int stolpeAntalBcLength = length / 300;
        stolpeAntalBcLength = stolpeAntalBcLength + stolpeAntalBcLength;
        return stolpeAntalBcLength;
    }
    public double prisStolpe(Request r) {
        int antal = stolpeAntal(r);
        double pris = antal * 3.40 * 41.95;
        return pris;
    }


    
    // @Vibeke
    // Antagelser og værdier:
    // Skur højde i meter
    private double shedH = 2.5;

    // Test mål i meter:
    // Obsolete !!
    private int length = 180;
    private int width = 240;

    // Brædder for væggene:
    public int amountWood(int length, int width) {
        // Bræder bredde og afstand mellem dem i cm:
        double woodWidth = 10.0;
        double distanceBetWood = 6.0;

        double wallL = length / (woodWidth + distanceBetWood);
        double restL = wallL%1;
        double wallW = width / (woodWidth + distanceBetWood);
        double restW = wallW%1;

        // Inderste lag for længde:
        double lag1L;
        if(restL != 0) {
            double addOn = 1 - restL;
            lag1L = wallL + addOn;
        } else {
            lag1L = wallL;
        }

        // Yderste lag for længde:
        double lag2L = lag1L - 1;


        // Inderste lag for bredde:
        double lag1W;
        if(restW != 0) {
            double addOn = 1 - restW;
            lag1W = wallW + addOn;
        } else {
            lag1W = wallW;
        }

        // Yderste lag for bredde:
        double lag2W = lag1W - 1;


        // Brædder ialt:
        int ialt = 0;
        ialt += (lag1L + lag2L)*2;
        ialt += (lag1W + lag2W)*2;

        return ialt;
    }

    // Pris for en af længde siderne, begge lag:
    public double priceWood(double amount) {
        double shedH = 2.5;
        double woodPriceM = 22.95;
        // Pris for ét bræt med shedH længde:
        double woodPriceOne = shedH * woodPriceM;

        double price = amount * woodPriceOne;

        return price;
    }

    // Mængden af skruer der skal bruges til lag 1:
    public int amountScrewsInner(double amountWood) {
        int amtScrews = 0;
        double innerLayer = (amountWood / 2);

        if(innerLayer != (int)innerLayer) {
            innerLayer = Math.ceil(innerLayer);
        }

        double amtScrewsInner = innerLayer * 3;
        amtScrews += amtScrewsInner;

        return amtScrews;
    }

    // Mængden af skruer der skal bruges til lag 2:
    public int amountScrewsOuter(double amountWood) {
        int amtScrews = 0;
        double outerLayer = (amountWood / 2);

        if(outerLayer != (int)outerLayer) {
            outerLayer = Math.ceil(outerLayer);
        }

        double amtScrewsOuter = outerLayer * 6;
        amtScrews += amtScrewsOuter;

        return amtScrews;
    }

    // Mængde af pakker med skruer der skal bestilles til lag 1:
    public int amtBoxScrewIn(int amountScrewIn) {
        int box = 0;

        if(amountScrewIn <= 300) {
            box = 1;
        } else if(301 <= amountScrewIn && amountScrewIn <= 600) {
            box = 2;
        }

        return box;
    }

    // Mængde af pakker med skruer der skal bestilles til lag 2:
    public int amtBoxScrewOut(int amountScrewOut) {
        int box = 0;

        if (amountScrewOut <= 200) {
            box = 1;
        } else if (201 <= amountScrewOut && amountScrewOut <= 400) {
            box = 2;
        } else if (401 <= amountScrewOut && amountScrewOut <= 600) {
            box = 3;
        } else if (601 <= amountScrewOut && amountScrewOut <= 800) {
            box = 4;
        } else if (801 <= amountScrewOut && amountScrewOut <= 1000) {
            box = 5;
        } else if (1001 <= amountScrewOut && amountScrewOut <= 1200) {
            box = 6;
        }

        return box;
    }

    // Mængden af løsholter brædder:
    public int losholter() {
        int amount = 0;

        amount += 4 * 3;

        return amount;
    }

    // Prisen for løsholter brædder:
    public double priceLosholter(int length) {
        double price = 0.0;
        double priceM = 59.95;

        double lengthM = length / 100;

        double priceLengthWood = (lengthM * priceM) * 3;
        //double priceWidthWood = (width * priceM) * 3;

        price += (priceLengthWood * 2);

        double x = round(price, 2);

        return x;
    }

    public double doorABPrice(int angleBracket) {
        double abPrice = 7.95;
        double price = angleBracket * abPrice;
        return price;
    }

    public double doorHPrice(int hinge) {
        double hingePrice = 99.95;
        double price = hinge * hingePrice;
        return price;
    }

    public double doorABScrewPrice(int abScrews) {
        double abScrewsPrice = 259.0;
        double price = abScrews * abScrewsPrice;
        return price;
    }

    public double doorHandlePrice(int doorHandle) {
        double dhPrice = 189.0;
        double price = doorHandle * dhPrice;
        return price;
    }

    // Pris for skruerne:
    // En tredjedel cirka går til de inderste brædder, resten til de yderste
    public double priceScrewIn(int boxAmt) {
        double priceScrewsTotal = 0.0;
        double inScrPrice = 99.95;

        // Max is 600 screws!
        if(boxAmt == 1) {
            priceScrewsTotal += inScrPrice * boxAmt;
        } else if(boxAmt == 2) {
            priceScrewsTotal += inScrPrice * boxAmt;
        }

        return priceScrewsTotal;
    }

    // Pris for skruerne:
    // En tredjedel cirka går til de inderste brædder, resten til de yderste
    public double priceScrewOut(int boxAmt) {
        double priceScrewsTotal = 0.0;
        double outScrPrice = 199.0;

        // Max is 1200 screws!
        if(boxAmt == 1) {
            priceScrewsTotal += outScrPrice * boxAmt;
        } else if(boxAmt == 2) {
            priceScrewsTotal += outScrPrice * boxAmt;
        } else if(boxAmt == 3) {
            priceScrewsTotal += outScrPrice * boxAmt;
        } else if(boxAmt == 4) {
            priceScrewsTotal += outScrPrice * boxAmt;
        } else if(boxAmt == 5) {
            priceScrewsTotal += outScrPrice * boxAmt;
        } else if(boxAmt == 6) {
            priceScrewsTotal += outScrPrice * boxAmt;
        }

        return priceScrewsTotal;
    }

    // Tag Beregner 33000


    public static int roofPlateLengths(Request req) {
        // I antagelse af at der anvendes plader på L.600 W.109, derfor


        int Mat = 0;
        String tagmat = req.getRoofmat();


        switch (tagmat) {

            case "Plasttrapezplader":
                Mat = 600;
            case "StÃ¥ltag":
                Mat = 250;
            case "Tagpap":
                Mat = 750;
        }



        return Mat;
    }


    public static int numRofPlatesSingls(Request req) {
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



    public static double roofMatPrice(Request req){


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

    public static int numOfRofScrews(Request req) {

        double l = req.getLength();
        double w = req.getWidth();
        double LcW = l + w;

        int Rscrews = (int) (LcW / 460);

        if (Rscrews < 1) {
            Rscrews = 1;
        }

        return Rscrews;
    }

    public static double RofScrewPrice(Request req) {

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



    public static int Cal25x200x300FnB(Request req) {
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

    public static double Cal25x200x300FnBPrice(Request req) {
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




    public static int Cal25x125x300Front(Request req) {
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

    public static double Cal25x125x300FrontPrice(Request req) {
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

    public static int Cal25x125x360Sides(Request req) {
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

    public static double Cal25x125x360SidesPrice(Request req) {
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

    public static int CaL19x100x480(Request req){

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

    public static double CaL19x100x480Price(Request req){

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

    public static int CaL19x100x420Forend(Request req){

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


    public static double CaL19x100x420ForendPrice(Request req){

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


}
