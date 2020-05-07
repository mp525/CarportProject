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
        if(!(request.getLengthS() == 0)){
            antalRemme++;
        }
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
        double FemTyvHunTreTresPris = StyklisteBeregner.Cal25x125x360Sides(req);
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

    public static void udregnNoget(ArrayList<Material> stykliste, Request request) {
        StyklisteBeregner stykLB = new StyklisteBeregner();

        double amount = stykLB.amountWood(request.getLengthS(), request.getWidthS());

        Material test = new Material("Alt tilbehør til dør", "En test fordi jeg har dumme metoder", "stk", "Beslag & Skruer",
                250, stykLB.doorAccesPrice(), stykLB.doorAccesAmt());

        Material wood = new Material("19x100 mm. trykimp. Brædt.", "til beklædning af skur, sider og stern", "stk", "Træ",
                250, stykLB.priceWood(amount), stykLB.amountWood(request.getLengthS(), request.getWidthS()));

        Material losholterL = new Material("45x95 mm. Reglar ubh.", "løsholter til skur, sider og gavle", "stk", "Træ",
                request.getLengthS(), stykLB.priceLosholter(request.getLengthS()), stykLB.losholter()/2);

        Material losholterW = new Material("45x95 mm. Reglar ubh.", "løsholter til skur, sider og gavle", "stk", "Træ",
                request.getWidthS(), stykLB.priceLosholter(request.getWidthS()), stykLB.losholter()/2);

        stykliste.add(test);
        stykliste.add(wood);
        stykliste.add(losholterL);
        stykliste.add(losholterW);
    }
}

