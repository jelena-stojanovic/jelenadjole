/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO.Import_Export;

import java.util.List;
import model.attribute.Attribute;

/**
 *
 * @author Jelena
 */
public class ConvertStringMatrixToDoubleMatrix {
    
    public void convert(String[][] stringMatrix, double [][] doubleMatrix, List<Attribute> attributes){
        
        
        for (int i = 0; i < stringMatrix.length; i++) {
            //redovi
            String[] strings = stringMatrix[i];
            
            
            for (int j = 0; j < strings.length; j++) {
                //kolone u jednom redu
                String string = strings[j];
                
                
                
            }
            
            
        }

        
    }
}
