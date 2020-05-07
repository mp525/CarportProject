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

    public static void udregnStolpe(ArrayList<Material> stykliste, Request request) {
        StyklisteBeregner styklisteBeregner= new StyklisteBeregner();

        Material stolper = new Material("97x97 mm. trykimp. Stolpe", "Stolper nedgraves 90 cm. i jord + skråstiver","stk","træ",360, styklisteBeregner.prisStolpe(request) ,styklisteBeregner.stolpeAntal(request));
        stykliste.add(stolper);

    }

    public static void udregnSkur(ArrayList<Material> stykliste, Request request) {
        StyklisteBeregner stykLB = new StyklisteBeregner();

        int amount = stykLB.amountWood(request.getLengthS(), request.getWidthS());
        int screwAmtIn = stykLB.amountScrewsInner(amount);
        int screwAmtOut = stykLB.amountScrewsOuter(amount);

        Material test = new Material("Alt tilbehør til dør", "En test fordi jeg har dumme metoder", "stk", "Beslag & Skruer",
                250, stykLB.doorAccesPrice(), stykLB.doorAccesAmt());

        Material wood = new Material("19x100 mm. trykimp. Brædt.", "til beklædning af skur, sider og stern", "stk", "Træ",
                250, stykLB.priceWood(amount), stykLB.amountWood(request.getLengthS(), request.getWidthS()));

        Material losholterL = new Material("45x95 mm. Reglar ubh.", "løsholter til skur, sider og gavle", "stk", "Træ",
                request.getLengthS(), stykLB.priceLosholter(request.getLengthS()), stykLB.losholter()/2);

        Material losholterW = new Material("45x95 mm. Reglar ubh.", "løsholter til skur, sider og gavle", "stk", "Træ",
                request.getWidthS(), stykLB.priceLosholter(request.getWidthS()), stykLB.losholter()/2);

        Material skruerIndre = new Material("SkruerIndre", "Skruer bes", "pakke", "Skruer",
                5, stykLB.priceScrews(screwAmtIn), screwAmtIn);

        Material skruerYdre = new Material("SkruerYdre", "Skruer bes", "pakke", "Skruer",
                5, stykLB.priceScrews(screwAmtOut), screwAmtOut);

        stykliste.add(test);
        stykliste.add(wood);
        stykliste.add(losholterL);
        stykliste.add(losholterW);
        stykliste.add(skruerIndre);
        stykliste.add(skruerYdre);
    }
}

