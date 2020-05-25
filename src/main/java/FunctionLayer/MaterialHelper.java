package FunctionLayer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/**

 @author Matti
 @author Nikolaj
 @author Vibeke
 @author Mathias

 Denne klasse kalder alle styklisteberegner metoder, og fylder materialer i styklisten ud fra en request.


 TO DO: Hver af os skal skrive lidt javaDoc ved hver af vores given afsnit
 */
public class MaterialHelper {


    /**
     *
     * @param flatList - arrayliste med strings
     * @return et Set
     *
     * Denne metode tager en arrayliste med materialenavne til fladt tag fra databasen
     * og returnerer et set lavet ud fra den liste.
     */
    public static Set<String> flatSet(ArrayList<String> flatList){
        Set<String> flatSet = new HashSet<>();
        for (String flat: flatList) {
            flatSet.add(flat);
        }
        return flatSet;
    }

    /**
     *
     * @param slopeList - arraylist med Strings
     * @return et set
     *
     * Denne metode tager en arrayliste med materialenavne til tag med rejsning fra databasen
     * og returnerer et set lavet ud fra den liste.
     */
    public static Set<String> slopeSet(ArrayList<String> slopeList){
        Set<String> slopeSet = new HashSet<>();
        for (String slope: slopeList) {
            slopeSet.add(slope);
        }
        return slopeSet;
    }

    /**
     *
     * @param stykliste - arrayliste der skal indeholde materialer
     * @param request - den request en kunde har lavet
     *
     * Denne metode modtager en arraylist og en request. Metoder fra StyklisteBeregner bliver kaldt
     * og passende værdier bliver udregnet ud fra request. Herefter bliver Material objekter instantieret
     * og tilføjet til styklisten. Denne metode er kun aktuel for carport med fladt tag.
     */
    public static void udregnSpær(ArrayList<Material> stykliste, Request request){
        StyklisteBeregner styklisteBeregner= new StyklisteBeregner();
        int antalSpær = styklisteBeregner.antalSpær(request.getLength());
        int spærLængde = styklisteBeregner.længdeSpær(request.getWidth());
        double spærPris = styklisteBeregner.spærPris(spærLængde, antalSpær); //Her er det den samlede pris på spær
        int antalRemme = 2;
        /*if(!(request.getLengthS() == 0)){ Dette er kun hvis skuret er for langt og remme ikke må være så lange,
            antalRemme++;                   så remmene bliver skåret over hvor skur starter.
        }*/
        double remPris = styklisteBeregner.remPris(request.getLength(), antalRemme);
        double beslagPris = styklisteBeregner.round(antalSpær * 45.95, 2);
        int beslagSkrueAntal = styklisteBeregner.beslagSkrueAntal(request.getLength());
        double beslagSkruePris = styklisteBeregner.round(beslagSkrueAntal * 259,2);
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


    /**
     *
     * @param stykliste
     * @param req
     *  Denne metode udregner adskellige parameter som priser og antal for hver materiale som skal bruges til et flattag.
     *  Derefter sender den materialerne til review.
     */
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
        double frontBackScrews25pris = styklisteBeregner.Cal25x200x300FnBPrice(req);
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
                "stk", "Træ", 300, frontBackScrews25pris, frontBackScrews25);

        Material Sterni300S = new Material("25x125 mm. trykimp. Brædt.", "oversternbrædder til sider",
                "stk", "Træ", 360, FemTyvHunTreTresPris, antalFemTyvHunTreTres);
        Material Sterni360F = new Material("25x125 mm. trykimp. Brædt.", "oversternbrædder til front",
                "stk", "Træ", 300, FemOgTyvPlanksSternPris, antalFemOgTyvPlanksStern);
        Material D19D420DVand = new Material("19x100 mm. trykimp. Brædt.", "vandbrædt på stern i forende",
                "stk", "Træ", 480, FirFirsNulTilSternPrice, antalFirFirsNulTilStern);
        Material D19D480DVand = new Material("19x100 mm. trykimp. Brædt.", "vandbrædt på stern i sider",
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


    /**
     *
     * @param stykliste
     * @param req
     *  Denne metode udregner adskellige parameter som priser og antal for hver materiale som skal bruges til et slopedtag.
     *  Derefter sender den materialerne til review.
     */
    public static void udregnTagDeleSLOP(ArrayList<Material> stykliste, Request req){
        StyklisteBeregner styklisteBeregner = new StyklisteBeregner();
        //tal

        int antalBC = StyklisteBeregner.antalBnCDob(req);
        double prispåBC = StyklisteBeregner.prisBnCDob(req);

        int antalRygsten = StyklisteBeregner.antalRygsten(req);
        double prisRygsten = StyklisteBeregner.prisRygsten(req);

        int antalTopLaegH = StyklisteBeregner.antalTopLaegHolds(req);
        double prisTopLaegH = StyklisteBeregner.prisTopLaegHolds(req);

        int antalRygstensBeslag = StyklisteBeregner.antalRygstensBeslag(req);
        double prisRygBeslag = StyklisteBeregner.prisRygstensBeslag(req);

        int bindsNNakrog = StyklisteBeregner.bindsNNakrog();
        double prisNNakrog = StyklisteBeregner.prisNNakrog();


        int strlseSternSidder25n150nx = StyklisteBeregner.strlseSternSidder25n150nx(req);
        int SternSidderAntal = 2;
        double SternBrædderPris = StyklisteBeregner.SternBrædderPris(req);

        int tagFodLægteStørrelse = StyklisteBeregner.tagFodLægteStørrelse(req);
        int tagFodLægteAntal = StyklisteBeregner.tagFodLægteAntal();
        double tagFodLægtePris = styklisteBeregner.tagFodLægtePris();

        int størrelseDoor = StyklisteBeregner.doorSize(req);
        int antalDoor = StyklisteBeregner.doorAmount();
        double prisDoor = StyklisteBeregner.doorPrice();

        int antalH38x73mmotaglægteT1HRows = StyklisteBeregner.antalH38x73mmotaglægteT1HRows(req);
        int sizeH38x73mmotaglægteT1HRows = StyklisteBeregner.sizeH38x73mmotaglægteT1HRows(req);
        double prisH38x73mmotaglægteT1HRows = StyklisteBeregner.prisH38x73mmotaglægteT1HRows(req);


        int antalH38x73mmotaglægteT1HHolders = 2;
        int sizeH38x73mmotaglægteT1HHolders = StyklisteBeregner.sizeH38x73mmotaglægteT1HHolders(req);
        double priceH38x73mmotaglægteT1HHolders = 22.95 * 2;

        int amount4Komma5x60Skruer = 1;
        double price4Komma5x60Skruer = 74.95;

        int amount5Komma0x40Skruer = 1;
        double price5Komma0x40Skruer = 259.0;

        int amount5komma0x40100Skruer = 2;
        double price5komma0x40100Skruer = 398.0;
        //oprettelse

        Material BNCDobb = new Material("B & C Dobbelt -s sort", "monteres på taglægter 6 rækker af 24 sten på hver side af taget",
                "stk", "Tagpakken", 0, prispåBC, antalBC);

        Material Rygsten = new Material("B & C Rygsten sort", "monteres på toplægte med medfølgende beslag se tagstens vejledning",
                "stk", "Tagpakken", 0, prisRygsten, antalRygsten);

        Material TopLaeug = new Material("B & C Toplægte holder", "monteres på toppen af spæret (til toplægte)",
                "stk", "Tagpakken", 0, prisTopLaegH, antalTopLaegH);

        Material RygstensBeslag = new Material("B & C rygstensbeslag", "Til montering af rygsten",
                "stk", "Tagpakken", 0, prisRygBeslag, antalRygstensBeslag);

        Material bindKrog = new Material("B & C tagstens bindere & nakkekroge", "til montering af tagsten, alle ydersten hver anden fastgøres",
                "pk", "Tagpakken", 0, prisNNakrog, bindsNNakrog);

        Material H25x150mmDotTrykImpDotBrædtH = new Material("25x150mm. trikimp. Bræt", "Sternbrædder til sider",
                "stk", "Træ", strlseSternSidder25n150nx, SternBrædderPris, SternSidderAntal);

        Material tagFodLægte = new Material("38x73 mm. taglægte T1", "toplægte, montering, z på bagside af dør",
                "stk", "Træ", tagFodLægteStørrelse, tagFodLægtePris, tagFodLægteAntal);

        Material door = new Material("38x73 mm. Lægte ubh.", "til z på bagside af dør",
                "stk", "Træ", størrelseDoor, prisDoor, antalDoor);

        Material H38x73mmotaglægteT1HRows = new Material("38x73 mm. taglægte T1", "til montering på spær, 7 rækker lægter på hver skiftevis 1 hel & 1 halv lægte",
                "stk", "Træ", sizeH38x73mmotaglægteT1HRows, prisH38x73mmotaglægteT1HRows, antalH38x73mmotaglægteT1HRows);

        Material H38x73mmotaglægteT1HHolders = new Material("38x73 mm. taglægte T1", "til montering på spær, 7 rækker lægter på hver skiftevis 1 hel & 1 halv lægte",
                "stk", "Træ", sizeH38x73mmotaglægteT1HHolders, priceH38x73mmotaglægteT1HHolders, antalH38x73mmotaglægteT1HHolders);

        Material firSkruer = new Material("4,5 x 60 mm. Skruer 200 stk", "Til montering af Stern, vindskeder, vindkryds & vand bræt",
                "pakke", "Beslag & Skruer", 0, price4Komma5x60Skruer, amount4Komma5x60Skruer);


        Material femFyre = new Material("5,0 x 40 mm. beslagskruer 250 stk.", "til taglægter",
                "pakke", "Beslag & Skruer", 0, price5Komma0x40Skruer, amount5Komma0x40Skruer);

        Material femHundred = new Material("5,0 x 100 mm. skruer 100 stk.", "",
                "stk", "Beslag & Skruer", 0, price5komma0x40100Skruer, amount5komma0x40100Skruer);

        //adder
        stykliste.add(BNCDobb);
        stykliste.add(Rygsten);
        stykliste.add(TopLaeug);
        stykliste.add(RygstensBeslag);
        stykliste.add(H25x150mmDotTrykImpDotBrædtH);
        stykliste.add(tagFodLægte);
        stykliste.add(door);
        stykliste.add(H38x73mmotaglægteT1HRows);
        stykliste.add(H38x73mmotaglægteT1HHolders);
        stykliste.add(firSkruer);
        stykliste.add(femFyre);
        stykliste.add(femHundred);
    }

    /**
     *
     * @param stykliste - arrayliste der skal indeholde materialer
     * @param request - den request en kunde har lavet
     *
     * Denne metode modtager en arraylist og en request. Metoder fra StyklisteBeregner bliver kaldt
     * og passende værdier bliver udregnet ud fra request. Herefter bliver Material objekter instantieret
     * og tilføjet til styklisten. Denne metode er kun aktuel for carport med hældning på taget.
     */
    public static void udregnStolpe(ArrayList<Material> stykliste, Request request) {
        StyklisteBeregner styklisteBeregner= new StyklisteBeregner();

        Material stolper = new Material("97x97 mm. trykimp. Stolpe", "Stolper nedgraves 90 cm. i jord + skråstiver","stk","træ",360, styklisteBeregner.prisStolpe(request) ,styklisteBeregner.stolpeAntal(request));
        stykliste.add(stolper);

    }

    /**
     * Denne metode sender alle materialer der skal bruges til at bygge skuret, skulle kunden ønske det i sin carport.
     * Tallene bliver beregnet i styklisteBeregner.java og indsat i ArrayListen stykliste.
     * @param stykliste - ArrayList
     * @param request - Request
     */
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

    /**
     *
     * @param stykliste - arrayliste der skal indeholde materialer
     * @param request - den request en kunde har lavet
     *
     * Denne metode modtager en arraylist og en request. Metoder fra StyklisteBeregner bliver kaldt
     * og passende værdier bliver udregnet ud fra request. Herefter bliver Material objekter instantieret
     * og tilføjet til styklisten. Denne metode er kun aktuel for carport med hældning på taget.
     */
    public static void slopeSpær(Request request, ArrayList<Material> stykliste){
        StyklisteBeregner styklisteBeregner= new StyklisteBeregner();
        int antalSpær = styklisteBeregner.antalSpær(request.getLength());
        int carportLængde = styklisteBeregner.længdeSpær(request.getWidth());
        int carportBredde = request.getWidth();
        int carportVinkel = request.getSlopeangle();
        double spærPris = styklisteBeregner.spærPakkePris(antalSpær,carportBredde,carportVinkel, carportLængde);
        int antalRemme = 2;
        double remPris = styklisteBeregner.remPris(request.getLength(), antalRemme);
        double beslagPris = styklisteBeregner.round(antalSpær * 45.95, 2);
        int beslagSkrueAntal = styklisteBeregner.beslagSkrueAntal(request.getLength());
        double beslagSkruePris = styklisteBeregner.round(beslagSkrueAntal * 259,2);

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

    /**
     *
     * @param stykliste - arrayliste der skal indeholde materialer
     * @param request - den request en kunde har lavet
     *
     * Denne metode modtager en arraylist og en request. Metoder fra StyklisteBeregner bliver kaldt
     * og passende værdier bliver udregnet ud fra request. Herefter bliver Material objekter instantieret
     * og tilføjet til styklisten. Denne metode er kun aktuel for carport med hældning på taget.
     */
    public static void slopeStolper(ArrayList<Material>stykliste,Request r){
        udregnStolpe(stykliste, r);
    }
}

