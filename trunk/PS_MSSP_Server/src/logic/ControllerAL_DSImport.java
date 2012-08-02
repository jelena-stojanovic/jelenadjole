/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.IOException;
import java.util.ArrayList;
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
    
    public String[][] readCSV(String filePath, String[][] matrix, char columnSeparator) throws IOException {
        
        ArrayList<String[]> strings=CSVImportToDataSet.readCSV(filePath, columnSeparator);
        matrix= new String[strings.size()][strings.get(0).length];
        return ConvertListOfHorizontalStringArrayToMatrixOfString.convert(strings, matrix) ;
    }
}
