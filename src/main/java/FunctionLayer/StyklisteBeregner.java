package FunctionLayer;

import java.util.ArrayList;

public class StyklisteBeregner {
    private ArrayList<Material> matList = new ArrayList();


    public static int antalSpær(Request request){
     int spær = 2;
        int længde = request.getLength();
        int bredde = request.getWidth();

        int antal = længde/55;
        for (int i = 0; i <= længde; i++){

        }


        return spær;
    }
}
