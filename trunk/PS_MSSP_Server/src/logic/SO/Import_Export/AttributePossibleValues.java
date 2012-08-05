/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO.Import_Export;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.attribute.Attribute;
import model.attribute.DateAttribute;
import model.attribute.NominalAttribute;
import model.attribute.NumericalAttribute;

/**
 *
 * @author Jelena
 */
public class AttributePossibleValues {
    
    public static Object getAttributePossibleValues(Attribute a, String[] allValues){
        Object possibleValues= new Object();
        if(a.isNominal()){
            NominalAttribute na= (NominalAttribute) a;
            List<String> possibleNominalValues= new ArrayList<String>();
            possibleNominalValues=MappingValues.extractPossibleNominaValuse(allValues, possibleNominalValues);
            possibleValues= possibleNominalValues;
            HashMap<String, Double> classToIndexMap = na.getClassToIndexMap();
            classToIndexMap=MappingValues.mapNominalToNumerical(possibleNominalValues, classToIndexMap);
            na.setClassToIndexMap(classToIndexMap);
            
        }else if (a.isNumerical()){
                       
            
        }else if (a.isOrdinal()){
            
        }else if (a.isDate()){
            /*DateAttribute da= (DateAttribute) a;
            List<String> possibleDateValues= new ArrayList<String>();
            possibleDateValues=MappingValues.extractPossibleDateValuse(allValues, possibleDateValues);
            possibleValues= possibleDateValues;
            HashMap<String, Double> classToIndexMap = da.getClassToIndexMap();
            classToIndexMap=MappingValues.mapNominalToNumerical(possibleDateValues, classToIndexMap);
            da.setClassToIndexMap(classToIndexMap);
            */
            
        }else if (a.isInterval()){
            
        }
        
        
        return possibleValues;
    }
    
}
