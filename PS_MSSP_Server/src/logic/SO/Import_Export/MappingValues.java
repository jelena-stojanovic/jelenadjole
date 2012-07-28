/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO.Import_Export;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jelena
 */
public class MappingValues {

    public static double getIndexOfNominalValue(HashMap<String, Double> indexMap, String nominalValue) {
        return indexMap.get(nominalValue);
    }

    public static String getNominalValueFromIndex(HashMap<String, Double> indexMap, double index) throws Exception {
        if(Double.isNaN(index))
            throw new Exception("Index does not have a valid value.");
        for (Map.Entry<String, Double> entry : indexMap.entrySet()) {
            String string = entry.getKey();
            Double double1 = entry.getValue();
            if (double1 == index) {
                return string;
            }
        }
        return null;
    }

    public static void mapNominalToNumerical(List<String> nominalValues, HashMap<String, Double> indexMap) {
        for (int i = 0; i < nominalValues.size(); i++) {
            String string = nominalValues.get(i);
            indexMap.put(string, Double.valueOf(i));
        }
    }

    public static void extractPossibleNominaValuse(List<String> allNominalValues, List<String> possibleNominalValues) {
        if (possibleNominalValues == null) {
            possibleNominalValues = new ArrayList<String>();
        }

        for (String string : allNominalValues) {
            if (!possibleNominalValues.contains(string)) {
                possibleNominalValues.add(string);
            }
        }
    }
}
