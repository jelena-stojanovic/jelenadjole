/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO.Import_Export;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import model.attribute.Attribute;
import model.attribute.Possibleattributevalue;
import model.attribute.PossibleattributevaluePK;

/**
 *
 * @author Jelena
 */
public class MappingValues {

    
//    public static HashMap<String, Double> mapNominalToNumerical(List<String> nominalValues, HashMap<String, Double> indexMap) {
//        for (int i = 0; i < nominalValues.size(); i++) {
//            String string = nominalValues.get(i);
//            indexMap.put(string, Double.valueOf(i));
//        }
//        return indexMap;
//    }
//    
    public static List<Possibleattributevalue> mapNominalToNumerical(Attribute a, List<String> nominalValues, List<Possibleattributevalue> pvalues) {
        for (int i = 0; i < nominalValues.size(); i++) {
            Possibleattributevalue pv= new Possibleattributevalue();
            
            PossibleattributevaluePK pk=new PossibleattributevaluePK(a.getAttributePK().getIndexOfAttribute(), a.getAttributePK().getDataSetID(), Double.valueOf(i));
            String string = nominalValues.get(i);
            
            pv.setPossibleattributevaluePK(pk);
            pv.setAttribute(a);
            pv.setPossibleValue(string);
            
            pvalues.add(pv);
        }
        return pvalues;
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
    
    public static List<String> extractPossibleNominaValuse(String[] allNominalValues, List<String> possibleNominalValues) {
        if (possibleNominalValues == null) {
            possibleNominalValues = new ArrayList<String>();
        }

        for (String string : allNominalValues) {
            if (!possibleNominalValues.contains(string)) {
                possibleNominalValues.add(string);
            }
        }
        
        return possibleNominalValues;
    }
    
    
    public static HashMap<String, Double> mapDateToNumerical(List<String> nominalValues, String patern, HashMap<String, Double> indexMap) throws ParseException {
        
        for (int i = 0; i < nominalValues.size(); i++) {
            String string = nominalValues.get(i);
            Date date = new SimpleDateFormat(patern).parse(string);
            
            indexMap.put(string, Double.valueOf(date.getTime()));
        }
        return indexMap;
    }

        public static List<String> extractPossibleDateValuse(String[] allDateValues, List<String> possibleDateValues) {
        if (possibleDateValues == null) {
            possibleDateValues = new ArrayList<String>();
        }

        for (String string : allDateValues) {
            if (!possibleDateValues.contains(string)) {
                possibleDateValues.add(string);
            }
        }
        
        return possibleDateValues;
    }
    

        
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

}
