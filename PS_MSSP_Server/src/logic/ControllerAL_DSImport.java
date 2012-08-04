/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import logic.SO.Import_Export.CSVImportToDataSet;
import logic.SO.Import_Export.ConvertListOfHorizontalStringArrayToMatrixOfString;

/**
 *
 * @author Jelena
 */
public class ControllerAL_DSImport {
    
    private ControllerAL_DSImport() {
    }
    
    public static ControllerAL_DSImport getInstance() {
        return ControllerAL_DSImportHolder.INSTANCE;
    }
    
    private static class ControllerAL_DSImportHolder {
        private static final ControllerAL_DSImport INSTANCE = new ControllerAL_DSImport();
    }
    
    public String[][] readCSV(String filePath, String[][] matrix, char columnSeparator, boolean trimLines) throws IOException {
        
        ArrayList<String[]> strings=CSVImportToDataSet.readCSV(filePath, columnSeparator, trimLines);
        matrix= new String[strings.size()][strings.get(0).length];
        return ConvertListOfHorizontalStringArrayToMatrixOfString.convert(strings, matrix) ;
    }
    
    public ArrayList<String[]>  readCSV(String filePath, char columnSeparator, boolean trimLines) throws IOException{
        ArrayList<String[]> strings=CSVImportToDataSet.readCSV(filePath, columnSeparator, trimLines);
        return strings;
    }
    
    public String[][] convert(List<String[]> dsValues, String[][] stringMatrix){
        return ConvertListOfHorizontalStringArrayToMatrixOfString.convert(dsValues, stringMatrix);
    }
}
