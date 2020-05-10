package FunctionLayer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MaterialHelper {

    public static Set<String> flatSet(ArrayList<String> flatList){
        Set<String> flatSet = new HashSet<>();
        for (String flat: flatList) {
            flatSet.add(flat);
        }
        return flatSet;
    }
    public static Set<String> slopeSet(ArrayList<String> slopeList){
        Set<String> slopeSet = new HashSet<>();
        for (String slope: slopeList) {
            slopeSet.add(slope);
        }
        return slopeSet;
    }

    public static void udregnSpær(ArrayList<Material> stykliste, Request request){
        StyklisteBeregner styklisteBeregner= new StyklisteBeregner();
        int antalSpær = StyklisteBeregner.antalSpær(request.getLength());
        int spærLængde = StyklisteBeregner.længdeSpær(request.getWidth());
        double spærPris = StyklisteBeregner.spærPris(spærLængde, antalSpær); //Her er det den samlede pris på spær
        int antalRemme = 2;
        /*if(!(request.getLengthS() == 0)){ Dette er kun hvis skuret er for langt og remme ikke må være så lange,
            antalRemme++;                   så remmene bliver skåret over hvor skur starter.
        }*/
        double remPris = StyklisteBeregner.remPris(request.getLength(), antalRemme);
        double beslagPris = StyklisteBeregner.round(antalSpær * 45.95, 2);
        int beslagSkrueAntal = StyklisteBeregner.beslagSkrueAntal(request.getLength());
        double beslagSkruePris = StyklisteBeregner.round(beslagSkrueAntal * 259,2);
        //int remLængde = reviewReq.getLengthS(); RemlængdeS er jeg lidt i tvivl om
        Material spær = new Material("45x195 mm. spærtræ ubh.", "Spær, monteres på rem",
                "stk", "Træ", spærLængde, spærPris, antalSpær);
        Material remme = new Material("45x195 mm. spærtræ ubh.", "Remme i sider, sadles ned i stolper",
                "stk", "Træ", request.getLength(), remPris, antalRemme);
        Material beslagHøjre = new Material("universal beslag 190mm højre", "Til montering af spær på rem",
                "stk", "Beslag og skruer", 0, beslagPris, antalSpær);
        Material beslagVenstre = new Material("universal beslag 190mm venstre", "Til montering af spær på rem",
                "stk", "Beslag og skruer", 0, beslagPris, antalSpær);
        Material beslagSkruer = new Material("4,0x50mm. beslagskruer 250 stk.", "Til montering af universalbeslag " +
                "+ hulbånd", "pakke", "Beslag og skruer", 0, beslagSkruePris, beslagSkrueAntal);

        stykliste.add(spær);
        stykliste.add(remme);
        stykliste.add(beslagHøjre);
        stykliste.add(beslagVenstre);
        stykliste.add(beslagSkruer);

    }

    public static void udregnTagDele(ArrayList<Material> stykliste, Request req){
        StyklisteBeregner styklisteBeregner= new StyklisteBeregner();
        int antalPlader = StyklisteBeregner.numRofPlatesSingls(req);
        double pladerPris = StyklisteBeregner.roofMatPrice(req);
        int antalPlastSkruer = StyklisteBeregner.numOfRofScrews(req);
        double skruerPris = StyklisteBeregner.RofScrewPrice(req);
        // der er kun 1 af dem her
        int D4o5skruerD = 1;
        double D4o5skruerDpris = 74.95 ;
        int frontBackScrews25 = StyklisteBeregner.Cal25x200x300FnB(req);
        double frontBackScrews25pris = StyklisteBeregner.Cal25x200x300FnBPrice(req);
        int antalFemTyvHunTreTres = StyklisteBeregner.Cal25x125x360Sides(req);
        double FemTyvHunTreTresPris = StyklisteBeregner.Cal25x125x360SidesPrice(req);
        int antalFemOgTyvPlanksStern = StyklisteBeregner.Cal25x125x300Front(req);
        double FemOgTyvPlanksSternPris = StyklisteBeregner.Cal25x125x300FrontPrice(req);

        int antalFirFirsNulTilStern = StyklisteBeregner.CaL19x100x480(req);
        double FirFirsNulTilSternPrice = StyklisteBeregner.CaL19x100x480Price(req);
        int antal420 = StyklisteBeregner.CaL19x100x420Forend(req);
        double h420Pris = StyklisteBeregner.CaL19x100x420ForendPrice(req);

        Material TagPlader = new Material(req.getRoofmat(), "tagplader monteres på spær, saves til efter behov",
                "stk", "TagFlat", StyklisteBeregner.roofPlateLengths(req), pladerPris, antalPlader);
        Material PlastmoSkruer = new Material("plastmo bundskruer 200 stk.", "Skruer til tagplader",
                "pakke", "Beslag og Skruer", 0, skruerPris, antalPlastSkruer);
        Material Skruer2 = new Material("4,5 x 60 mm. skruer 200 stk.", "Til montering af stern, vindskeder, vindkryds & vandbrædt",
                "pakke", "Beslag & Skruer", 0, D4o5skruerDpris, D4o5skruerD);
        Material Stern300e = new Material("25x200 mm. trykimp. Brædt.", "understernbrædder til ender",
                "stk", "Træ", 300, frontBackScrews25pris, frontBackScrews25);
        Material Stern300s = new Material("25x200 mm. trykimp. Brædt.", "understernbrædder til siderne",
                "stk", "Træ", 300, frontBackScrews25pris, frontBackScrews25 + 2);
        Material Sterni300S = new Material("25x125 mm. trykimp. Brædt.", "oversternbrædder til sider",
                "stk", "Træ", 360, FemTyvHunTreTresPris, antalFemTyvHunTreTres);
        Material Sterni360F = new Material("25x125 mm. trykimp. Brædt.", "oversternbrædder til front",
                "stk", "Træ", 300, FemOgTyvPlanksSternPris, antalFemOgTyvPlanksStern);
        Material D19D420DVand = new Material("45x195 mm. spærtræ ubh.", "vandbrædt på stern i forende",
                "stk", "Træ", 480, FirFirsNulTilSternPrice, antalFirFirsNulTilStern);
        Material D19D480DVand = new Material("45x195 mm. spærtræ ubh.", "vandbrædt på stern i sider",
                "stk", "Træ", 420, h420Pris, antal420);


        stykliste.add(TagPlader);
        stykliste.add(PlastmoSkruer);
        stykliste.add(Skruer2);
        stykliste.add(Stern300e);
        stykliste.add(Stern300s);
        stykliste.add(Sterni300S);
        stykliste.add(Sterni360F);
        stykliste.add(D19D420DVand);
        stykliste.add(D19D480DVand);

    }


    public static void udregnStolpe(ArrayList<Material> stykliste, Request request) {
        StyklisteBeregner styklisteBeregner= new StyklisteBeregner();

        Material stolper = new Material("97x97 mm. trykimp. Stolpe", "Stolper nedgraves 90 cm. i jord + skråstiver","stk","træ",360, styklisteBeregner.prisStolpe(request) ,styklisteBeregner.stolpeAntal(request));
        stykliste.add(stolper);

    }

    // @Vibeke
    public static void udregnSkur(ArrayList<Material> stykliste, Request request) {
        // Antagelser og værdier:
        // Materialer:
        int angleBracket = 4;
        int hinge = 2;
        // Vi skal altid bruge en pakke beslagskruer, der bliver aldrig brugt mere end en pakke!
        // int abScrews = angleBracket * 4;
        int abScrews = 1;
        int doorHandle = 1;

        StyklisteBeregner stykLB = new StyklisteBeregner();

        int amount = stykLB.amountWood(request.getLengthS(), request.getWidthS());
        int screwAmtIn = stykLB.amountScrewsInner(amount);
        int screwAmtOut = stykLB.amountScrewsOuter(amount);

        int boxAmtIn = stykLB.amtBoxScrewIn(screwAmtIn);
        int boxAmtOut = stykLB.amtBoxScrewOut(screwAmtOut);

        if(request.getLengthS() != 0) {
            Material wood = new Material("19x100 mm. trykimp. Brædt.", "til beklædning af skur, sider og stern", "stk", "Træ",
                    250, stykLB.priceWood(amount), stykLB.amountWood(request.getLengthS(), request.getWidthS()));

            Material losholterL = new Material("45x95 mm. Reglar ubh.", "løsholter til skur, sider og gavle", "stk", "Træ",
                    request.getLengthS(), stykLB.priceLosholter(request.getLengthS()), stykLB.losholter()/2);

            Material losholterW = new Material("45x95 mm. Reglar ubh.", "løsholter til skur, sider og gavle", "stk", "Træ",
                    request.getWidthS(), stykLB.priceLosholter(request.getWidthS()), stykLB.losholter()/2);

            Material skruerIndre = new Material("4,5 x 50 mm. Skruer 300 stk.", "til montering af inderste beklædning", "pakke", "Beslag & Skruer",
                    5, stykLB.priceScrewIn(boxAmtIn), boxAmtIn);

            Material skruerYdre = new Material("4,5 x 70 mm. Skruer 200 stk.", "til montering af yderste bræt ved beklædning", "pakke", "Beslag & Skruer",
                    7, stykLB.priceScrewOut(boxAmtOut), boxAmtOut);

            Material dBracket = new Material("vinkelbeslag 35", "Til montering af løsholter i skur", "stk", "Beslag & Skruer",
                    0, stykLB.doorABPrice(angleBracket), angleBracket);

            Material dHinge = new Material("t hængsel 390 mm", "Til skurdør", "stk", "Beslag & Skruer",
                    0, stykLB.doorHPrice(hinge), hinge);

            Material dABScrews = new Material("5,0 x 40 mm. beslagskruer 250 stk.", "Til montering af universalbeslag + toplægte", "pakke", "Beslag & Skruer",
                    4, stykLB.doorABScrewPrice(abScrews), abScrews);

            Material dHandle = new Material("stalddørsgreb 50x75", "Til lås på dør i skur", "stk", "Beslag & Skruer",
                    0, stykLB.doorHandlePrice(doorHandle), doorHandle);

            stykliste.add(wood);
            stykliste.add(losholterL);
            stykliste.add(losholterW);
            stykliste.add(skruerIndre);
            stykliste.add(skruerYdre);
            stykliste.add(dBracket);
            stykliste.add(dHinge);
            stykliste.add(dABScrews);
            stykliste.add(dHandle);
        }


    }
    public static void slopeSpær(Request request, ArrayList<Material> stykliste){
        StyklisteBeregner styklisteBeregner= new StyklisteBeregner();
        int antalSpær = StyklisteBeregner.antalSpær(request.getLength());
        int carportLængde = StyklisteBeregner.længdeSpær(request.getWidth());
        int carportBredde = request.getWidth();
        int carportVinkel = request.getSlopeangle();
        double spærPris = StyklisteBeregner.spærPakkePris(antalSpær,carportBredde,carportVinkel, carportLængde);
        int antalRemme = 2;
        double remPris = StyklisteBeregner.remPris(request.getLength(), antalRemme);
        double beslagPris = StyklisteBeregner.round(antalSpær * 45.95, 2);
        int beslagSkrueAntal = StyklisteBeregner.beslagSkrueAntal(request.getLength());
        double beslagSkruePris = StyklisteBeregner.round(beslagSkrueAntal * 259,2);

        Material spærPakke = new Material("Færdigskåret (byg-selv spær)", "byg-selv spær (skal samles) " +
                antalSpær + " stk.", "stk", "Træ", 0, spærPris, antalSpær);
        Material remme = new Material("45x195 mm. spærtræ ubh.", "Remme i sider, sadles ned i stolper",
                "stk", "Træ", request.getLength(), remPris, antalRemme);
        Material beslagHøjre = new Material("universal beslag 190mm højre", "Til montering af spær på rem",
                "stk", "Beslag og skruer", 0, beslagPris, antalSpær);
        Material beslagVenstre = new Material("universal beslag 190mm venstre", "Til montering af spær på rem",
                "stk", "Beslag og skruer", 0, beslagPris, antalSpær);
        Material beslagSkruer = new Material("4,0x50mm. beslagskruer 250 stk.", "Til montering af universalbeslag " +
                "+ hulbånd", "pakke", "Beslag og skruer", 0, beslagSkruePris, beslagSkrueAntal);

        stykliste.add(spærPakke);
        stykliste.add(remme);
        stykliste.add(beslagHøjre);
        stykliste.add(beslagVenstre);
        stykliste.add(beslagSkruer);


    }
    public static void slopeStolper(){

    }
    public static void slopeSkur(){

    }
    public static void slopeTag(){

    }
}

