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
}
