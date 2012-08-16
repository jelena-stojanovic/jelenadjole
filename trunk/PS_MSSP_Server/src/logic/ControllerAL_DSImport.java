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
import javax.swing.JOptionPane;
import logic.SO.Import_Export.*;
import logic.SO.KreirajNovi;
import logic.SO.MissingValues;
import logic.SO.Zapamti;
import logic.SO.serialization.Serialize;
import model.Attributestatistic;
import model.OpstiDomenskiObjekat;
import model.Reference;
import model.ReferencePK;
import model.attribute.Attribute;
import model.attribute.NumericalAttribute;
import model.dataset.Dataset;
import model.dataset.DataTable;
import model.dataset.Datasetmetaattribute;

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

    public void creatNewODO(OpstiDomenskiObjekat odo) {
        String kreirajNovi = KreirajNovi.kreirajNovi(odo);
        System.out.println(kreirajNovi);
    }

    public void saveODO(OpstiDomenskiObjekat odo) {
        String sacuvaj = Zapamti.Zapamti(odo);
        System.out.println(sacuvaj);
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

    public void createDataSet(Dataset ds, ArrayList<String[]> stringArrayList) throws Exception {
        List<String[]> verticalArrayListString = new ArrayList<String[]>();
        verticalArrayListString = ConvertHorizontalStringArrayListToVertikalStringArrayList.convert(stringArrayList, verticalArrayListString);
        List<Attribute> attributes = ds.getAttributeList();

        /**create dataTable**/
        int row = stringArrayList.size();
        int column = stringArrayList.get(1).length;
        DataTable dataTable = new DataTable(row, column);
        
        
        for (int i = 0; i < attributes.size(); i++) {
            try {
                Attribute attribute = attributes.get(i);

                String[] allValues = verticalArrayListString.get(attribute.getAttributePK().getIndexOfAttribute());

                Object possibleValues = AttributePossibleValues.getAttributePossibleValues(attribute, allValues);
                attribute.setPossibleValues(possibleValues);

                attribute.setMissingValues(MissingValues.countMissingValues(allValues));

                ConvertValuesToMatrixDataTable.convert(dataTable, attribute, allValues);

            } catch (ParseException ex) {
                Logger.getLogger(ControllerAL_DSImport.class.getName()).log(Level.SEVERE, null, ex);
                throw new Exception("The value could not be cpnverted to double matrix. Attribute " + attributes.get(i).getName() + ex.getMessage());

            }
        }
        /**end create dataTable**/
        

        /***save references***/
        for (int i = 0; i < ds.getReferenceList().size(); i++) {
            Reference ref = ds.getReferenceList().get(i);
            ReferencePK refpk= new ReferencePK();
            refpk.setDataSetID(ds.getDataSetID());
            refpk.setReferenceID(i);
            ref.setReferencePK(refpk);
            saveODO(ref);
        }
        
        /***end of save references***/
        
        

        /**ispisivanja datatable*/
        for (int i = 0; i < dataTable.getNumRows(); i++) { //broj redova

            for (int j = 0; j < dataTable.getNumColums(); j++) { //broj kolona
                System.out.print(dataTable.getValue(i, j) + ", ");

            }
            System.out.println("");
        }
        /**end ispisivanja datatable*/
        
        /***sracunavanje statistika**/
        for (int i = 0; i < attributes.size(); i++) {
            Attribute attribute = attributes.get(i);
            if (attribute.isNumerical()) {
                System.out.println(attribute.getName());
                

                double[] columnatt = dataTable.getColumn(attribute.getAttributePK().getIndexOfAttribute());//uzima iz datatable kolonu
                if (columnatt == null) {
                    System.out.println("Niz je prazan");
                }
                

                List<Attributestatistic> statistics = new CalculatedNumericalStatistics().calculate(attribute, columnatt, ControllerAL_MetaAttribute.getInstance().getAllStatistics());
                attribute.setAttributestatisticList(statistics);

                /****stampa statistika***/
                if (statistics.isEmpty()) {
                    System.out.println("Statistike su prazne");
                }
                for (int j = 0; j < statistics.size(); j++) {
                    Attributestatistic attributestatistic = statistics.get(j);
                    System.out.println(attributestatistic.getStatistic().getStatisticName()+"="+attributestatistic.getStatisticValue());
                }
                /****end stampa statistika***/
                /***save statistics***/
                for (Attributestatistic attributestatistic : statistics) {
                    saveODO(attributestatistic);
                }
                /***end save statistics***/
                
                /**save attribute**/
                
                saveODO(attribute);
                /**end save attribute**/
            }
            
            /***end sracunavanje statistika**/
        }

        
        
        /**sracunavanje metaatributa**/
        ControllerAL_MetaAttribute.getInstance().calculateMetaattributes(ds);
        /**end sracunavanje metaatributa**/
        
        /**save metaatributa**/
        List<Datasetmetaattribute> dsm= ds.getDatasetmetaattributeList();
        for (int i = 0; i < dsm.size(); i++) {
            Datasetmetaattribute datasetmetaattribute = dsm.get(i);
            saveODO(datasetmetaattribute);
        }
        /**end save metaatributa**/
        
        /**save source**/
        saveODO(ds.getSource());
        /**end save source**/
        ds.setMetads(ControllerAL_Main.getInstance().getMetads());
        ds.setFilePath(GetFilePath.getFilePath(ds));
       
        Serialize.serialize(ds);
        ds.setDataTable(dataTable);
        saveODO(ds);
     }
    
    
    
}
