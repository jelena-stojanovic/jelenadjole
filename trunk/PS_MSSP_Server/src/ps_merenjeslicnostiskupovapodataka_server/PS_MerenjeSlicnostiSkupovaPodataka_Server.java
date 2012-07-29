/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ps_merenjeslicnostiskupovapodataka_server;

import java.io.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.SO.Import_Export.ConvertHorizontalStringArrayListToVertikalStringArrayList;
import logic.SO.Import_Export.ConvertListOfHorizontalStringArrayToMatrixOfString;

/**
 *
 * @author Jelena
 */
public class PS_MerenjeSlicnostiSkupovaPodataka_Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         //   File file= new File("Desktop\\studenti.csv");
        
//            List<String> jsdnka;
//            jsdnka= new ArrayList<String>();
//            jsdnka.add("Jelena");
//         
//            System.out.println(jsdnka);
        String[] string1= {"Jelena", "Djole", "JelenaDjole"};
        String[] string2= {"Jelena1", "Djole1", "JelenaDjole1"};
        String[] string3= {"Jelena2", "Djole2", "JelenaDjole2"};
        String[] string4= {"Jelena3", "Djole3", "JelenaDjole3"};
        
        List<String[]> lista= new ArrayList<String[]>();
        lista.add(string1);
        lista.add(string2);
        lista.add(string3);
        lista.add(string4);
        
        String[][] matrix= new String[lista.size()][string1.length];
        ConvertListOfHorizontalStringArrayToMatrixOfString.convert(lista, matrix);
        for (int i = 0; i < matrix.length; i++) {
            String[] strings = matrix[i];
            for (int j = 0; j < strings.length; j++) {
                String string = strings[j];
                System.out.print(string+" ");
            }
            System.out.println();
        }
        System.out.println(matrix);
        System.out.println(matrix.length);
        
        
        
        List<String[]> attributeStringValueVertical= new ArrayList<String[]>();
        ConvertHorizontalStringArrayListToVertikalStringArrayList.convert(lista, attributeStringValueVertical);
        System.out.println("Lista po kolonama");
        for (int i = 0; i < attributeStringValueVertical.size(); i++) {
            String[] strings = attributeStringValueVertical.get(i);
            for (int j = 0; j < strings.length; j++) {
                String string = strings[j];
                System.out.print(string+", ");
                
            }
            
            
            System.out.println();
            
        }
        
        
    }
    
    
    
}
