/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO.Import_Export;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jelena
 */
public class ConvertHorizontalStringArrayListToVertikalStringArrayList {
     public static void convert(List<String[]> dsValues, List<String[]> attributeStringValueVertical){
        if(attributeStringValueVertical==null)
         attributeStringValueVertical= new ArrayList<String[]>();
        
        for (int i = 0; i < dsValues.get(0).length; i++) {
            attributeStringValueVertical.add(new String[dsValues.size()]);
        }
        
        for (int i = 0; i < dsValues.size(); i++) {
            String[] stringrow = dsValues.get(i); //red u prvoj matrici
            
            for (int j = 0; j < stringrow.length; j++) {
                String stringValue = stringrow[j];// red i u prvoj listi, j kolona
                attributeStringValueVertical.get(j)[i]=stringValue;
            }
            
        }
        
    }
    
   
   
}
