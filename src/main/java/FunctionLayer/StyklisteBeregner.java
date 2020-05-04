package FunctionLayer;

import java.util.ArrayList;

public class StyklisteBeregner {
    private ArrayList<Material> matList = new ArrayList();


    public static int antalSpær(int length){
        double antal = Math.round((length/55.0)) + 1.0;
        int spær = (int) antal;
        return spær;
    }
}
