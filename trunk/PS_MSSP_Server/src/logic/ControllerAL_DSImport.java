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
import logic.SO.MissingValues;
import model.attribute.Attribute;
import model.dataset.DataSet;

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
    
    public ArrayList<String[]>  readCSV(String filePath, char columnSeparator) throws IOException{
        ArrayList<String[]> strings=CSVImportToDataSet.readCSV(filePath, columnSeparator);
        return strings;
    }
    
    public String[][] convert(List<String[]> dsValues, String[][] stringMatrix){
        return ConvertListOfHorizontalStringArrayToMatrixOfString.convert(dsValues, stringMatrix);
    }
    
    public void createDataSet(DataSet ds ){
        List<Attribute> attributes= ds.getAttributes();
        
        for (int i = 0; i < attributes.size(); i++) {
            Attribute attribute = attributes.get(i);
            
        //    attribute.setPossibleValues();
            
        //    attribute.setMissingValues(MissingValues.countMissingValues(column));
            
        }
        
        //ds.setDataTable(null);
        
       // ds.setMetaAttributes(null);
        
      //  ds.setDataSetID(ID);
    }
}
