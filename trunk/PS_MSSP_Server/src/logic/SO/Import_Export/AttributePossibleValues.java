/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO.Import_Export;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.attribute.Attribute;
import model.attribute.Nominalattribute;
import model.attribute.Possibleattributevalue;

/**
 *
 * @author Jelena
 */
public class AttributePossibleValues {
    
    public static  List<Possibleattributevalue> getAttributePossibleValues(Attribute a, String[] allValues){
         List<Possibleattributevalue> possibleValuesList= new ArrayList<Possibleattributevalue>();
        if(a.getNominalattribute()!=null){
            Nominalattribute na=  a.getNominalattribute();
            List<String> possibleNominalValues= new ArrayList<String>();
            possibleNominalValues=MappingValues.extractPossibleNominaValuse(allValues, possibleNominalValues);
            //HashMap<String, Double> classToIndexMap = na.getClassToIndexMap();
            possibleValuesList= new ArrayList<Possibleattributevalue>();
            possibleValuesList=MappingValues.mapNominalToNumerical(na,possibleNominalValues, possibleValuesList);
            na.setPossibleattributevalueList(possibleValuesList);
        }else if (a.getNumericalattribute()!=null){
                       
            
//        }else if (a.isOrdinal()){
//            
//        }else if (a.isDate()){
//            /*DateAttribute da= (DateAttribute) a;
//            List<String> possibleDateValues= new ArrayList<String>();
//            possibleDateValues=MappingValues.extractPossibleDateValuse(allValues, possibleDateValues);
//            possibleValues= possibleDateValues;
//            HashMap<String, Double> classToIndexMap = da.getClassToIndexMap();
//            classToIndexMap=MappingValues.mapNominalToNumerical(possibleDateValues, classToIndexMap);
//            da.setClassToIndexMap(classToIndexMap);
//            */
//            
//        }else if (a.isInterval()){
//            
        }
        
        
        return possibleValuesList;
    }
    
}
