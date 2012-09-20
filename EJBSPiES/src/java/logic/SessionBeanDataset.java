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
import javax.ejb.Stateless;
import logic.SO.Import_Export.AttributeFactory;
import logic.SO.Import_Export.AttributePossibleValues;
import logic.SO.Import_Export.CSVExportDSToFile;
import logic.SO.Import_Export.CSVImportToDataSet;
import logic.SO.Import_Export.CalculatedNumericalStatistics;
import logic.SO.Import_Export.ControllerAL_MetaAttribute;
import logic.SO.Import_Export.ConvertHorizontalStringArrayListToVertikalStringArrayList;
import logic.SO.Import_Export.ConvertListOfHorizontalStringArrayToMatrixOfString;
import logic.SO.Import_Export.ConvertValuesToMatrixDataTable;
import logic.SO.Import_Export.GetFilePath;
import logic.SO.KreirajNovi;
import logic.SO.MissingValues;
import logic.SO.Obradi;
import logic.SO.Pretrazi;
import logic.SO.VratiSve;
import logic.SO.Zapamti;
import logic.SO.serialization.Serialize;
import model.Attributestatistic;
import model.OpstiDomenskiObjekat;
import model.Reference;
import model.ReferencePK;
import model.attribute.Attribute;
import model.attribute.Possibleattributevalue;
import model.dataFormat.CSVFormat;
import model.dataset.DataTable;
import model.dataset.Dataset;
import model.dataset.Datasetmetaattribute;
import model.dataset.Metads;
import to.DataSetTO;

/**
 *
 * @author Jelena
 */
@Stateless
public class SessionBeanDataset implements SessionBeanDatasetLocal {

    @Override
    public List<DataSetTO> getAllDatasetsTO() {

        Dataset rac = new Dataset();
        String signal = "";
        List<OpstiDomenskiObjekat> odoList = new ArrayList<OpstiDomenskiObjekat>();
        odoList.add(rac);
        odoList = VratiSve.VratiSve(odoList, signal);
        List<DataSetTO> odoListDS = new ArrayList<DataSetTO>();
        for (int i = 0; i < odoList.size(); i++) {
            OpstiDomenskiObjekat opstiDomenskiObjekat = odoList.get(i);
            DataSetTO dto = new DataSetTO((Dataset) opstiDomenskiObjekat);
            odoListDS.add(dto);

        }
        return odoListDS;
    }

    @Override
    public Dataset getDataset(Dataset ds) {
        System.out.println(Pretrazi.Pretrazi(ds));
        return ds;
    }

    @Override
    public int createDataset(Dataset ds) {
       System.out.println(KreirajNovi.kreirajNovi(ds));
      //  System.out.println(Zapamti.Zapamti(ds));
        return ds.getDataSetID();
    }

    @Override
    public void saveDataset(Dataset ds,ArrayList<String[]>metaAttributes, ArrayList<String[]> stringArrayList){
            Dataset novi= new Dataset();
            novi.setTitle(ds.getTitle());
            novi.setDsDescription(ds.getDsDescription());
            
            createDataset(novi);
            
            ds.setDataSetID(novi.getDataSetID());
            
            List<Attribute> attributes1 = AttributeFactory.createAttributes(ds,metaAttributes);
            ds.setAttributeList(attributes1);
            
            
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
            try {                
                ConvertValuesToMatrixDataTable.convert(dataTable, attribute, allValues);
            } catch (ParseException ex) {
                Logger.getLogger(SessionBeanDataset.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        Metads mds= ControllerAL_MetaAttribute.getInstance().getMetads();

        mds.addDataset(ds);
        ds.setMetads(mds);
        ds.setMetadsID(mds);
        creatNewODO(ds.getSource());
        ds.setFilePath(GetFilePath.getFilePath(ds));
        try {
            Serialize.serialize(ds);
        } catch (IOException ex) {
            Logger.getLogger(SessionBeanDataset.class.getName()).log(Level.SEVERE, null, ex);
        }
        ds.setDataTable(dataTable);
        Obradi.Obradi(ds);
        Obradi.Obradi(mds);
    
    }
    
    @Override
    public void saveDataset(Dataset ds) {
                System.out.println(Zapamti.Zapamti(ds));
    }

    @Override
    public void updateDataset(Dataset ds) {
        System.out.println(Obradi.Obradi(ds));
    }

    @Override
    public List<Dataset> getAllDatasets() {
        List<Dataset> alldsma = new ArrayList<Dataset>();
        List<OpstiDomenskiObjekat> allODO = new ArrayList<OpstiDomenskiObjekat>();
        Dataset dma = new Dataset();
        allODO.add(dma);
        String signal = "";
        allODO = VratiSve.VratiSve(allODO, signal);
        if (allODO != null) {
            for (int i = 0; i < allODO.size(); i++) {

                OpstiDomenskiObjekat opstiDomenskiObjekat = allODO.get(i);
                Dataset dsma = (Dataset) opstiDomenskiObjekat;
                dsma.instantiateLAZYrelationship();

                alldsma.add(dsma);
            }
        }
        return alldsma;

    }

    @Override
    public String exportDS(Dataset ds, CSVFormat csv) {
        try {
            new CSVExportDSToFile().export(ds, csv);
            return "csvFileCreated";
        } catch (Exception ex) {
            Logger.getLogger(SessionBeanDataset.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
            
        }
    }
    @Override
    public ArrayList<String[]> readCSV(String filePath, char columnSeparator){
        ArrayList<String[]> strings=null;
        try {
            strings = CSVImportToDataSet.readCSV(filePath, columnSeparator);
        } catch (IOException ex) {
            Logger.getLogger(SessionBeanDataset.class.getName()).log(Level.SEVERE, null, ex);
        }
        return strings;
    }
    @Override
    public String[][] convert(List<String[]> dsValues, String[][] stringMatrix) {
        return ConvertListOfHorizontalStringArrayToMatrixOfString.convert(dsValues, stringMatrix);
    }


public void creatNewODO(OpstiDomenskiObjekat odo) {
        String kreirajNovi = KreirajNovi.kreirajNovi(odo);
        System.out.println(kreirajNovi);
    }
    
    public void saveODO(OpstiDomenskiObjekat odo) {
        String sacuvaj = Zapamti.Zapamti(odo);
        System.out.println(sacuvaj);
    }


}
