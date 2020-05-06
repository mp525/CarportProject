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
        int antalSpær = StyklisteBeregner.antalSpær(request.getLength());
        int spærLængde = StyklisteBeregner.længdeSpær(request.getWidth());
        double spærPris = StyklisteBeregner.spærPris(spærLængde, antalSpær); //Her er det den samlede pris
        int antalRemme = 2;
        if(!(request.getLengthS() == 0)){
            antalRemme++;
        }
        double remPris = StyklisteBeregner.remPris(request.getLength(), antalRemme);
        double beslagPris = antalSpær * 45.95;
        int beslagSkrueAntal = StyklisteBeregner.beslagSkrueAntal(request.getLength());
        double beslagSkruePris = beslagSkrueAntal * 259;
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
}
