/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.SO.Import_Export.*;
import logic.SO.MissingValues;
import model.attribute.Attribute;
import model.attribute.NumericalAttribute;
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
        int row = stringArrayList.size();
        int column = stringArrayList.get(1).length;
        DataTable dataTable = new DataTable(row, column);
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

        
        
        

            for (int i = 0; i < dataTable.getNumRows(); i++) { //broj redova

                for (int j = 0; j < dataTable.getNumColums(); j++) { //broj kolona
                    System.out.print(dataTable.getValue(i, j) + ", ");

                }
                System.out.println("");
            }

            for (int i = 0; i < attributes.size(); i++) {
            Attribute attribute = attributes.get(i);
            if (attribute.isNumerical()) {
                System.out.println(attribute.getName());
                HashMap<String, Double> statistics = new HashMap<String, Double>();
                
                double[] columnatt = dataTable.getColumn(attribute.getIndexOfAttribute());
                if(columnatt==null) System.out.println("Niz je prazan");
                System.out.println("Prvi element niza je "+ columnatt[0]);
                
                statistics=CalculateNumericalAttributeStatistics.calculate(columnatt, statistics);
                
                ((NumericalAttribute) attribute).setStatistics(statistics);
                if(statistics.isEmpty()) System.out.println("Statistike su prazne");
                
                for (Map.Entry<String, Double> entry : statistics.entrySet()) {
                    String string = entry.getKey();
                    
                    Double double1 = entry.getValue();
                    
                    System.out.println(string + "=" + double1);
                }
            }
        }
            
            

            //------------URADI OVO ds.setMetaAttributes(null);

            //------------URADI OVO  ds.setDataSetID(ID);
        }
    }
