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
import logic.SO.KreirajNovi;
import logic.SO.MissingValues;
import logic.SO.Obradi;
import logic.SO.Zapamti;
import logic.SO.serialization.Serialize;
import model.Attributestatistic;
import model.OpstiDomenskiObjekat;
import model.Reference;
import model.ReferencePK;
import model.attribute.Attribute;
import model.attribute.Possibleattributevalue;
import model.dataset.*;

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

        /**
         * create dataTable*
         */
        int row = stringArrayList.size();
        int column = stringArrayList.get(1).length;
        DataTable dataTable = new DataTable(row, column);

        /**
         * mapping values*
         */
        for (int i = 0; i < attributes.size(); i++) {
            try {
                Attribute attribute = attributes.get(i);
                String[] allValues = verticalArrayListString.get(attribute.getAttributePK().getIndexOfAttribute());
            
                attribute.setMissingValues(Integer.valueOf(MissingValues.countMissingValues(allValues)));

                creatNewODO(attribute);
                
                if (attribute.isNominal()) {
                    List<Possibleattributevalue> attributePossibleValues = AttributePossibleValues.getAttributePossibleValues(attribute, allValues);
                    for (int j = 0; j < attributePossibleValues.size(); j++) {
                        
                        Possibleattributevalue possibleattributevalue = attributePossibleValues.get(j);
                        creatNewODO(possibleattributevalue);
                    }
                }
                
                ConvertValuesToMatrixDataTable.convert(dataTable, attribute, allValues);
                /**
                 * *calculate statistics**
                 */
                double[] columnatt = dataTable.getColumn(attribute.getAttributePK().getIndexOfAttribute());//uzima iz datatable kolonu
                List<Attributestatistic> statistics = new CalculatedNumericalStatistics().calculate(attribute, columnatt, ControllerAL_MetaAttribute.getInstance().getAllStatistics());
                attribute.setAttributestatisticList(statistics);
                /**
                 * *end calculate statistics**
                 */
                
                /**
                 * *save statistics**
                 */
                for (Attributestatistic attributestatistic : statistics) {
                    creatNewODO(attributestatistic);
                }
                /**
                 * *end save statistics**
                 */
                
//                Obradi.Obradi(attribute);
            } catch (ParseException ex) {
                Logger.getLogger(ControllerAL_DSImport.class.getName()).log(Level.SEVERE, null, ex);
                throw new Exception("The value could not be cpnverted to double matrix. Attribute " + attributes.get(i).getName() + ex.getMessage());
                
            }
        }
        /**
         * end mapping values*
         */
        /**
         * end create dataTable*
         */
        /**
         * *save references**
         */
        for (int i = 0; i < ds.getReferenceList().size(); i++) {
            Reference ref = ds.getReferenceList().get(i);
            ReferencePK refpk = new ReferencePK();
            refpk.setDataSetID(ds.getDataSetID());
            refpk.setReferenceID(i);
            ref.setReferencePK(refpk);
            creatNewODO(ref);
            //Obradi.Obradi(ref);
        }

        /**
         * *end of save references**
         */
        ds.setDataTable(dataTable);
        /**
         * sracunavanje metaatributa*
         */
        ControllerAL_MetaAttribute.getInstance().calculateMetaattributes(ds);
        /**
         * end sracunavanje metaatributa*
         */
        /**
         * save metaatributa*
         */
        List<Datasetmetaattribute> dsm = ds.getDatasetmetaattributeList();
        for (int i = 0; i < dsm.size(); i++) {
            Datasetmetaattribute datasetmetaattribute = dsm.get(i);
            creatNewODO(datasetmetaattribute);
        }
        /**
         * end save metaatributa*
         */

        Metads mds= ControllerAL_Main.getInstance().getMetads();

        mds.addDataset(ds);
        ds.setMetads(mds);
        ds.setMetadsID(mds);
        
        ds.setFilePath(GetFilePath.getFilePath(ds));
        
        Serialize.serialize(ds);
        ds.setDataTable(dataTable);
        Obradi.Obradi(ds);
        Obradi.Obradi(mds);
    }
}
