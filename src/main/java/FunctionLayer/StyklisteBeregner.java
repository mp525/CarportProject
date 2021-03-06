package FunctionLayer;

import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 *
 * @author Matti
 * @author Nikolaj
 * @author Vibeke
 * @author Mathias
 *
 * Denne klasse beregner alle tal nødvendige for at lave styklisten.
 *
 */

public class StyklisteBeregner {

    /**
     *
     * @param value
     * @param places
     * @return Afrundet tal.
     *
     * Denne metode afrunder en double til antal decimaler, places.
     */
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    /**
     *
     * @param antal - antal spærpakker
     * @param width - caportens bredde
     * @param slope - tagets hældning
     * @param length - carportens længde
     * @return Pris for hele spærpakken
     *
     * Denne metode udregner længden træ der skal bruges til tagpakken, og udregner
     * derefter samlet pris. Denne metode er kun aktuel til tag med rejsning.
     */
    public double spærPakkePris(int antal, int width, int slope, int length){
        double angle = slope;

        double højdeSpær = (width/2)*Math.tan(angle);
        double hypotenusen = højdeSpær/Math.sin(angle);

        double samletSpærLængder = (højdeSpær/100) + (hypotenusen/100) + ((width/2)/100);

        double spærPris = round((samletSpærLængder * 54.95) * antal,2);
        spærPris += (antal * 50.0) + beslagSkrueAntal(length); //For beslag der bruges i tagpakken + skruer der skal til

        return round(spærPris,2);
    }

    /**
     *
     * @param length - carports længde
     * @return antal spær
     *
     * Denne metode returnerer et passende antal spær ud fra længden.
     */
    public int antalSpær(int length) {
        int antal = 0;
        switch(length){
            case 750: antal = 16; break;//spærafstand 50cm
            case 720: antal = 16; break;// 48
            case 690: antal = 16; break;//46
            case 660: antal = 13; break;//55
            case 630: antal = 11; break;//63
            case 600: antal = 11; break;//60
            case 570: antal = 11; break;//57
            case 540: antal = 10; break;//60
            case 510: antal = 7; break;//85
            case 480: antal = 7; break;//80
            case 450: antal = 7; break;//75
            case 420: antal = 7; break;//70
            case 390: antal = 6; break;//78
            case 360: antal = 6; break;//72
            case 330: antal = 6; break;//66
            case 300: antal = 5; break;//75
            case 270: antal = 4; break;//90
            case 240: antal = 4; break;//80
            default: antal = 0; break;
        }
        if(length == 600){
            antal += 2;
        }
        return antal;
    }

    /**
     *
     * @param length - carportens længde
     * @return afstanden mellem spær
     *
     * Denne metode returnerer spærafstanden ud fra længden af carporten
     */
    public int spærAfstand(int length){
        int afstand = 0;

        switch(length) {
            case 750: afstand = 50; break;
            case 720: afstand = 48; break;
            case 690: afstand = 46; break;
            case 660: afstand = 55; break;
            case 630: afstand = 63; break;
            case 600: afstand = 50; break;
            case 570: afstand = 57; break;
            case 540: afstand = 60; break;
            case 510: afstand = 85; break;
            case 480: afstand = 80; break;
            case 450: afstand = 75; break;
            case 420: afstand = 70; break;
            case 390: afstand = 78; break;
            case 360: afstand = 72; break;
            case 330: afstand = 66; break;
            case 300: afstand = 75; break;
            case 270: afstand = 90; break;
            case 240: afstand = 80; break;
            default: afstand = 0; break;
        }
        return afstand;
    }

    /**
     *
     * @param width - carports bredde
     * @return spærlængden
     *
     * Denne metode returnerer den længde spærerne skal være, altså lig med bredden
     */
    public int længdeSpær(int width){
        int længde = width;
        return længde;
    }

    /**
     *
     * @param spærLængde
     * @param spærAntal
     * @return samlet pris på spær
     *
     * Denne metoder udregner prisen på spær. Kun aktuel for carport med fladt tag.
     */
    public double spærPris(int spærLængde, int spærAntal){
        double spærPris = round(((spærLængde/100) * spærAntal * 54.95),2); //meterprisen
        return spærPris;
    }

    /**
     *
     * @param remLængde
     * @param remAntal
     * @return prisen for remmene
     *
     * Denne metode udregner prisen for remmene ud fra remmenes længde og antal
     */
    public double remPris(int remLængde, int remAntal){
        double længde = remLængde;
        double remPris = round(((længde/100) * remAntal * 54.95),2); //meterprisen
        return remPris;
    }

    /**
     *
     * @param længde - carports længde
     * @return antal skrue-pakker til beslag
     *
     * Denne metode returnerer et antal skrue-pakker ud fra carportens længde
     */
    public int beslagSkrueAntal(int længde){
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

    /**
     *
     * @param request - En forespørgsel
     * @return antal stolper
     *
     * Denne metode returnerer et samlet antal stolper
     */
    public int stolpeAntal(Request r) {
        //starter med en i hvert hjørne så 4
        //er kommet i tvivl om det skal være sådan ...
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

        stolpeAntalBcWidth = stolpeAntalWidth(r);

        // længde

        stolpeAntalBcLength = stolpeAntalLength(r);

        //leder videoen første møde havde det her info.. //20 kvadrat meter = 4 stolper // 30 kvadrat meter = 6 stolper
        //teknisk møde med håndværker gav denne information... //hver tredje meter skal der være en stolpe(i hver side)

        if (shed == true) {
            //hver hjørne af skuret

            //hver side af døren ved skuret
            stolpeAntalShed = 5;
        }

        //+ alt
        stolpeAntal = stolpeAntal + stolpeAntalBcLength + stolpeAntalBcWidth + stolpeAntalShed;
        return stolpeAntal;
    }

    /**
     *
     * @param request - En forespørgsel
     * @return antal stolper
     *
     * Denne metode returnerer antal stolper ud fra width
     */
    public int stolpeAntalWidth(Request r){
        int width = r.getWidth();

        //bredde

        int stolpeAntalBcWidth = width / 300;
        return stolpeAntalBcWidth;
    }

    /**
     *
     * @param Request - En forespørgsel
     * @return antal stolper
     *
     * Denne metode returnerer antal stolper ud fra længde
     */
    public int stolpeAntalLength(Request r){
        int length = r.getLength();
        int stolpeAntalBcLength = length / 300;
        stolpeAntalBcLength = stolpeAntalBcLength + stolpeAntalBcLength;
        return stolpeAntalBcLength;
    }

    /**
     *
     * @param Request - En forespørgsel
     * @return antal stolper
     *
     * Denne metode retunere prisen af alle stolper i en carport
     */
    public double prisStolpe(Request r) {
        int antal = stolpeAntal(r);
        double pris = antal * 3.40 * 41.95;
        return pris;
    }


    /**
     * amountWood udregner mængden af brædder der skal bruges til at beklæde et skur.
     * @param length - int i cm
     * @param width - int i cm
     * @return antal brædder
     */
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

    /**
     * priceWood beregner prisen for den mængde brædder der skal bruges til at beklæde skuret.
     * @param amount - int fra metoden amountWood
     * @return - double, prisen for brædderne
     */
    // Pris for en af længde siderne, begge lag:
    public double priceWood(double amount) {
        double shedH = 2.5;
        double woodPriceM = 22.95;
        // Pris for ét bræt med shedH længde:
        double woodPriceOne = shedH * woodPriceM;

        double price = amount * woodPriceOne;

        return price;
    }

    /**
     * amountScrewsInner beregner mængden af skruer der skal bruges til det inderste lag af brædder til skuret.
     * @param amountWood - int fra metoden amountWood
     * @return int, mængde af skruer
     */
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

    /**
     * amountScrewsOuter beregner mængden af skruer der skal bruges til det yderste lag af brædder til skuret.
     * @param amountWood - int fra metoden amountWood
     * @return int, mængde af skruer
     */
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

    /**
     * amtBoxScrewIn beregner hvor mange pakker der skal bestilles til det inderste lag brædder, afhængig af tallet
     * fra amountScrewsInner().
     * @param amountScrewIn - int fra amountScrewsInner()
     * @return int, antal pakker
     */
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

    /**
     * amtBoxScrewOut beregner hvor mange pakker der skal bestilles til det yderste lag brædder, afhængig af tallet
     * fra amountScrewsOuter().
     * @param amountScrewOut - int fra amountScrewsOuter()
     * @return int, antal pakker
     */
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

    /**
     * losholter() udregner hvor mange løsholter (brædder), der skal bruges til skuret.
     * @return - int, antal løsholter
     */
    // Mængden af løsholter brædder:
    public int losholter() {
        int amount = 0;

        amount += 4 * 3;

        return amount;
    }

    /**
     * priceLosholter() udregner prisen for antal løsholter til skuret.
     * @param length - int
     * @return - double, prisen for mængden af løsholter
     */
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

    /**
     * doorABPrice() beregner prisen for vinkelbeslagende til døren i skuret.
     * @param angleBracket - int, antallet af vinkelbeslag til skuret
     * @return - double, prisen for vinkelbeslagende
     */
    public double doorABPrice(int angleBracket) {
        double abPrice = 7.95;
        double price = angleBracket * abPrice;
        return price;
    }

    /**
     * doorHPrice() beregner prisen for hængslerne til døren i skuret.
     * @param hinge - int, antal håndtag (altid 1) til døren
     * @return - double, prisen for hængslerne
     */
    public double doorHPrice(int hinge) {
        double hingePrice = 99.95;
        double price = hinge * hingePrice;
        return price;
    }

    /**
     * doorABScrewPrice() beregner prisen for skruerne til vinkelbeslagende i døren.
     * @param abScrews - int, antal skruer der skal bruges til vinkelbeslagende
     * @return - double, prisen for pakken af skruer
     */
    public double doorABScrewPrice(int abScrews) {
        double abScrewsPrice = 259.0;
        double price = abScrews * abScrewsPrice;
        return price;
    }

    /**
     * doorHandlePrice() beregner prisen for håndtaget til døren i skuret
     * @param doorHandle - int, altid 1 håndtag
     * @return - double, prisen for håndtaget
     */
    public double doorHandlePrice(int doorHandle) {
        double dhPrice = 189.0;
        double price = doorHandle * dhPrice;
        return price;
    }

    /**
     * priceScrewIn() beregner prisen for de pakker af skruer der skal bruges til det inderste lag brædder til skuret.
     * @param boxAmt - int, antal pakker af skruer
     * @return - double, prisen for antal pakker
     */
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

    /**
     * priceScrewOiut() beregner prisen for de pakker af skruer der skal bruges til det yderste lag brædder til skuret.
     * @param boxAmt - int, antal pakker af skruer
     * @return - double, prisen for antal pakker
     */
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





    //Alt nedenuder her, alt med tag, er skrevet af Nikolaj Trankjær

    //Starten af alle kalkulationer til flat tag


    /**
     *
     * @param req
     * @return int Mat
     *
     * Denne metode returnerer tagpladernes størrelse
     */
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


    /**
     *
     * @param req
     * @return int pladtal
     * Denne metode returnerer antallet af plader som skal bruges til taget.
     */
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


    /**
     *
     * @param req
     * @return double pladpris
     * Denne metode returnerer prisen for alle tagpladerne lagt sammen.
     */
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
            case "StÃ¥ltag":
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

    /**
     *
     * @param req
     * @return int f
     * Denne metode returnerer antallet af skruer der skal anvendes for at sætte alle tagpladerne fast.
     */
    public static int numOfRofScrews(Request req) {

        double l = req.getLength();
        double w = req.getWidth();
        double LcW = l + w;

        double Rscrews = LcW / 460;



        if (Rscrews < 1) {
            Rscrews = 1;
        }
        int f = (int) (Math.ceil(Rscrews));
        return f;
    }


    /**
     *
     * @param req
     * @return double scrprice
     * Denne metode returnerer prisen på alle skruepakker der skal anvendes til taget lagt sammen.
     */
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


    /**
     *
     * @param req
     * @return int 1||2||4
     * Denne metode returnerer antallet af sternbrædder med mål 25x200x300 der skal anvendes til carportens for- og bagside.
     */
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
    /**
     *
     * @param req
     * @return double p
     * Denne metode returnerer prisen på alle sternbrædder med mål 25x200x300 samlet.
     */
    public static double Cal25x200x300FnBPrice(Request req) {
        // for the front and back stern, here i have taken the smallest as examples
        //Taken from the example of 780 x 600, and here using the 25x200x300
        int max = 600;
        int half = max / 2;
        int quart = half / 2;
        double w = req.getWidth();
        double pricePlank = 33.95;
        double p = 1.0;

        if (w < quart){
            p = pricePlank;
        } else if (w >= quart && w <= half){
            pricePlank = pricePlank * 2;
            p = pricePlank;
        }else if (w >= half && w <= max) {
            pricePlank = pricePlank * 4;
            p = pricePlank;
        } else if (w > max) {
            pricePlank = pricePlank * 6;
            p = pricePlank;
        }

        pricePlank = round(pricePlank,2);
            return p;

    }
    /**
     *
     * @param req
     * @return int numbofplanks
     * Denne metode returnerer antallet af sterbrædder med mål 25x125x300 der skal bruges til carporten.
     */
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

    /**
     *
     * @param req
     * @return double priceplank
     * Denne metode returnerer prisen på alle sternbrædder med mål 25x125x300 samlet.
     */
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


    /**
     *
     * @param req
     * @return int numbofplanks
     * Denne metode returnerer antallet af brædder med mål 25x125x360 i siderne.
     */
    public static int Cal25x125x360Sides(Request req) {
        // it calculates via a number of 300, because it will measure so it fits the length.

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
    /**
     *
     * @param req
     * @return double priceplank
     * Denne metode returnerer prisen på alle brædder med mål 25x125x360 sammenlagt.
     */
    public static double Cal25x125x360SidesPrice(Request req) {
        // it calculates via a number of 300, because it will measure so it fits the length. Using

        int max = 600;
        int half = max / 2;
        int quart = half / 2;
        double w = req.getWidth();
        int numbOfPlanks = 0;
        double pricePlank = 27.95;

        if(w <= 300){
            numbOfPlanks = 2;
            pricePlank = pricePlank * numbOfPlanks;
            return pricePlank;
        } else if (w > 300 && w <= 600){
            numbOfPlanks = 4;
            pricePlank = pricePlank * numbOfPlanks;
            return pricePlank;
        } else if (w>600){
            numbOfPlanks = 6;
            pricePlank = pricePlank * numbOfPlanks;
            return pricePlank;
        }
        return pricePlank;
    }

    /**
     *
     * @param req
     * @return int numbofplanks
     * Denne metode returnerer antallet af brædder med mål 19x100x480 som skal bruges til carporten.
     */
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


    /**
     *
     * @param req
     * @return double priceplank
     * Denne metode returnerer prisen på alle brædder med mål 19x100x480 tilsammen.
     */
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


    /**
     *
     * @param req
     * @return int numbofflanks
     * Denne metode returnerer antallet af brædder med mål 19x100x420 som skal bruges til carporten.
     */
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

    /**
     *
     * @param req
     * @return double priceplank
     * Denne metode returnerer den samlede pris på alle brædder med mål 19x100x420 der bruges til carporten.
     */
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


//slut på kalkulationer for flat tag




//herefter er kalkulationer for sloped tag


    /**
     *
     * @param req
     * @return int montus
     * Denne metode returnerer antallet af B&C Dobbelt Sort som skal bruges til taget.
     */
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

    /**
     *
     * @param req
     * @return double prisnung
     * Denne metode returnerer prisen på alle B&C Dobbelt sort som skal bruges til taget tilsammen.
     */
    public static double prisBnCDob(Request req){

        int enTinDel = 56250;
        int width = req.getWidth();
        int length = req.getLength();
        double amount = 1.0;
        double LnW = length * width;

        amount = Math.ceil(LnW/enTinDel);
        int montus = (int) amount * 60;
        double prisnung = montus * 5.45;
        return prisnung;

    }

    /**
     *
     * @param req
     * @return int mallus
     * Denne metode returnerer antallet af rygsten der skal bruges til carportens tag.
     */
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
    /**
     *
     * @param req
     * @return double prislus
     * Denne metode returnerer prisen på alle rygsten tilsammen
     */
    public static double prisRygsten(Request req) {

        int enTinDel = 56250;
        int width = req.getWidth();
        int length = req.getLength();
        double amount = 1.0;
        double LnW = length * width;


        amount = Math.ceil(LnW / enTinDel);
        double montus = amount * 2.1;

        montus = Math.ceil(montus);
        int mallus = (int) montus;

        double prislus = mallus * 9.95;

        prislus = round( (int) prislus,2);

        return prislus;
    }

    /**
     *
     * @param req
     * @return mallus
     * Denne metode returnerer antallet af toplægter til taget.
     */
    public static int antalTopLaegHolds(Request req){

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
    /**
     *
     * @param req
     * @return double mallus
     * Denne metode returnerer prisen på alle toplægterne tilsammen.
     */
    public static double prisTopLaegHolds(Request req){

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


        double pris = mallus * 1.1;

        return mallus;
    }



    /**
     *
     * @param req
     * @return int mallus
     * Denne metode returnerer antallet af rygstensbeslag der skal bruges i alt.
     */
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
    /**
     *
     * @param req
     * @return double prislus
     * Denne metode returnerer prisen på alle rygstensbeslag tilsammen
     */
    public static double prisRygstensBeslag(Request req){

        int enTinDel = 56250;
        int width = req.getWidth();
        int length = req.getLength();
        double amount = 1.0;
        double LnW = length * width;


        amount = Math.ceil(LnW/enTinDel);
        double montus = amount * 2.1;

        montus = Math.ceil(montus);
        int mallus = (int) montus;

        double prislus = mallus * 9.95;

        prislus = round((int) prislus, 2);

        return prislus;
    }

    /**
     *
     * @return 2
     * Returnerer 2
     */
    public static int bindsNNakrog(){

        return 2;
    }

    /**
     *
     * @return 2.6
     * Returnerer 2.6
     */
    public static double prisNNakrog(){

        return 2.6;
    }


    /**
     *
     * @param req
     * @return int size
     * Denne metode returnerer størrelsen af brædder med mål 25x150xX til sternene på siderne.
     */
    // der skal bruges 2 af dem her
    public static int strlseSternSidder25n150nx(Request req){

        int length = req.getLength();

        int size = 100;

        switch (length){
            case 240:
                size = 240;
                break;
            case 270:
                size = 270;
                break;

            case 300:
                size = 300;
                break;
            case 330:
                size = 330;
                break;
            case 360:
                size = 360;
                break;

            case 390:
                size = 390;
                break;
            case 420:
                size = 420;
                break;

            case 450:
                size = 450;
                break;
            case 480:
                size = 480;
                break;

            case 510:
                size = 510;
                break;
            case 540:
                size = 540;
                break;

            case 570:
                size = 570;
                break;
            case 600:
                size = 600;
                break;

            case 630:
                size = 630;
                break;
            case 660:
                size = 660;
                break;
            case 690:
                size = 690;
                break;
            case 720:
                size = 720;
                break;
            case 750:
                size = 750;

                break;
        }


        return size;
    }


    /**
     *
     * @param req
     * @return int etellerto
     * Denne metode returnerer antallet af brædder med mål 25x150xX som skal bruges til carporten.
     */
    public static int SternSidderAntal(Request req){
        int width = req.getWidth();
        int etellerto = 2;
        if(width < 300){
            etellerto = 1;
        }

        return etellerto;
    }

    /**
     *
     * @param req
     * @return double prisu
     * Denne metode returnerer prisen på alle brædder med mål 25x150xX tilsammen.
     */
    public static double SternBrædderPris(Request req){
        int width = req.getWidth();
        int etellerto = 2;
        if(width < 300){
            etellerto = 1;
        }

      double prisu = etellerto * 29.95;

        return prisu;

    }

    /**
     *
     * @param req
     * @return int fodSiz
     * Denne metode returnerer størrelsen af tagfodlægterne
     */
    public static int tagFodLægteStørrelse(Request req) {

        int length = req.getLength();
        int fodSiz = 240;
        switch (length) {

            case 240:
                fodSiz = 210;
                break;

            case 270:
                fodSiz = 240;
                break;

            case 300:
            case 330:
            case 390:
                fodSiz = 270;

            case 420:
            case 450:
            case 480:
                fodSiz = 300;

            case 510:
            case 540:
            case 570:
                fodSiz = 360;
                break;

            case 600:
            case 630:
            case 660:
                fodSiz = 450;
                break;

            case 690:
            case 720:
            case 750:
                fodSiz = 540;
                break;
        }
        return fodSiz;
    }


    /**
     *
     * @param req
     * @return int størrelsen
     * Denne metode returnerer størrelsen af døren til carporten.
     */
    public static int doorSize(Request req){
        int length = req.getLength();

        int størrelsen = 240;

        switch(length){
            case 240:
            case 270:
                størrelsen = 300;
                break;
            case 300:
            case 330:
                størrelsen = 330;
                break;
            case 360:
            case 390:
                størrelsen = 360;
                break;
            case 420:
            case 450:
                størrelsen = 390;
                break;
            case 480:
            case 510:
                størrelsen = 420;
                break;
            case 540:
            case 570:
                størrelsen = 450;
                break;
            case 600:
            case 630:
                størrelsen = 480;
                break;
            case 660:
            case 690:
                størrelsen = 510;
                break;
            case 720:
            case 750:
                størrelsen = 540;
                break;

        }

        return  størrelsen;
    }

    //Redundant methods here
    /**
     *
     * @return int 3
     * Denne metode returnerer antallet af tagfodslægter der skal bruges i alt.
     */
    public static int tagFodLægteAntal(){
        return 3;
    }

    /**
     *
     * @return double 26.85
     * Denne metode returnerer 26.85, som er prisen på alle tagfodslægterne samlet, dvs de 3 der er..
     */
    public static double tagFodLægtePris(){


        return 26.85;

    }



    /**
     *
     * @return int 1
     * Denne metode returnerer 1 dør
     */
    public static int doorAmount(){
        return 1;
    }


    /**
     *
     * @return double 22.95
     * Denne metode returnerer prisen på den dør der er.
     */
    public static double doorPrice(){
        return 22.95;
    }
    //Redundant methods end;


    /**
     *
     * @param req
     * @return int amount
     * Denne metode returnerer antallet af taglægter med mål 38x73 som skal bruges i alt.
     */
    public static int antalH38x73mmotaglægteT1HRows(Request req){
        int width = req.getWidth();

        int amount = width / 17;


//OBS
//Fjern det minus 1 hvis at det ser dumt ud på svg
        return amount - 1;


    }

    /**
     *
     * @param req
     * @return double pricee
     * Denne metode returnerer prisen på alle taglægterne med mål 38x73 sammenlagt.
     */
    public static double prisH38x73mmotaglægteT1HRows(Request req){
        int width = req.getWidth();

        int amount = width / 17;



        double pricee = amount * 22.95;

        return pricee;


    }

    /**
     *
     * @param req
     * @return størrelsen
     * Denne metode returnerer størrelsen af Taglægterne med mål 38x73xX til montering på spær.
     */
    public static int sizeH38x73mmotaglægteT1HRows(Request req){
        int length = req.getLength();

        int størrelsen = 240;

        switch(length){
            case 240:
            case 270:
            case 300:
                størrelsen = 240;
                break;
            case 330:
            case 360:
            case 390:
                størrelsen = 360;
                break;
            case 420:
            case 450:
            case 480:
            case 510:
                størrelsen = 420;
                break;
            case 540:
            case 570:
            case 600:
            case 630:
                størrelsen = 480;
                break;
            case 660:
            case 690:
            case 720:
            case 750:
                størrelsen = 540;
                break;

        }

        return  størrelsen;
    }

    /**
     *
     * @param req
     * @return int sizu
     * Denne metode returnerer størrelsen på toplægten med mål 38x73 som anvendes til toplægterne til montering af rygsten.
     */
        public static int sizeH38x73mmotaglægteT1HHolders(Request req){

        int length = req.getLength();
        int sizu = 420;

        if (length <= 420){
            sizu = 240;
        }

        return sizu;
    }
    //Besla og Skruers
    //redundance inbound


    /**
     *
     * @return double 22.95 * 2.
     * Denne metode returnerer prisen på alle taglægte holderne med mål 38x73 i alt.
     */
    public static double priceH38x73mmotaglægteT1HHolders(){
        return 22.95 * 2;
    }
    /**
     *
     * @return int 2
     * Denne metode returnerer 2, som er mængden af taglægter med mål 38x73 der skal bruges.
     */
    public static int amountH38x73mmotaglægteT1HHolders(){
        return 2;
    }


    /**
     *
     * @return int 1
     * Denne metode returnerer 1.
     */
    public static int amount4Komma5x60Skruer(){
        return 1;
    }    /**
     *
     * @return double 74.95
     * Denne metode returnerer 74.95
     */
    public static double price4Komma5x60Skruer(){ return 74.95; }
    /**
     *
     * @return int 1
     * Denne metode returnerer 1.
     */
    public static int amount5Komma0x40Skruer(){ return 1; }    /**
     *
     * @return double 259.0
     * Denne metode returnerer 259.0
     */
    public static double price5Komma0x40Skruer(){
        return 259.0;
    }
    /**
     *
     * @return int 2
     * Denne metode returnerer 2
     */
    public static int amount5komma0x40100Skruer(){ return 2; }    /**
     *
     * @return double 398.0
     * Denne metode returnerer 398.0
     */
    public static double price5komma0x40100Skruer(){return 398.0;}

    //redundance done

    //flat tags kalkulationer er færdige

}
