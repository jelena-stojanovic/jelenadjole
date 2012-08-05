/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.SO.Import_Export.*;
import logic.SO.MissingValues;
import model.attribute.Attribute;
import model.dataset.DataSet;
import model.dataset.DataTable;

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

        ArrayList<String[]> strings = CSVImportToDataSet.readCSV(filePath, columnSeparator);
        matrix = new String[strings.size()][strings.get(0).length];
        return ConvertListOfHorizontalStringArrayToMatrixOfString.convert(strings, matrix);
    }

    public ArrayList<String[]> readCSV(String filePath, char columnSeparator) throws IOException {
        ArrayList<String[]> strings = CSVImportToDataSet.readCSV(filePath, columnSeparator);
        return strings;
    }

    public String[][] convert(List<String[]> dsValues, String[][] stringMatrix) {
        return ConvertListOfHorizontalStringArrayToMatrixOfString.convert(dsValues, stringMatrix);
    }

    public void createDataSet(DataSet ds, ArrayList<String[]> stringArrayList) throws Exception {
        List<String[]> verticalArrayListString = new ArrayList<String[]>();

        verticalArrayListString = ConvertHorizontalStringArrayListToVertikalStringArrayList.convert(stringArrayList, verticalArrayListString);
        List<Attribute> attributes = ds.getAttributes();
        DataTable dataTable = new DataTable();
        dataTable.setNumRows(stringArrayList.size());
        dataTable.setNumColums(stringArrayList.get(1).length);
        for (int i = 0; i < attributes.size(); i++) {
            try {
                Attribute attribute = attributes.get(i);

                String[] allValues = verticalArrayListString.get(attribute.getIndexOfAttribute());

                Object possibleValues = AttributePossibleValues.getAttributePossibleValues(attribute, allValues);
                attribute.setPossibleValues(possibleValues);

                attribute.setMissingValues(MissingValues.countMissingValues(allValues));

                ConvertValuesToMatrixDataTable.convert(dataTable, attribute, allValues);


                // ds.setMetaAttributes(null);
                //  ds.setDataSetID(ID);
            } catch (ParseException ex) {
                Logger.getLogger(ControllerAL_DSImport.class.getName()).log(Level.SEVERE, null, ex);
                throw new Exception("The value could not be cpnverted to double matrix. Attribute " + attributes.get(i).getName() + ex.getMessage());

            }
        }



        ds.setDataTable(dataTable);
        for (int i = 0; i < dataTable.getNumRows(); i++){ //broj redova
            
            for (int j = 0; j < dataTable.getNumColums(); j++) { //broj kolona
                System.out.print(dataTable.getIndex(i, j));
                
            }
            System.out.println("");
        }
            

        //------------URADI OVO ds.setMetaAttributes(null);

        //------------URADI OVO  ds.setDataSetID(ID);
    }
}
