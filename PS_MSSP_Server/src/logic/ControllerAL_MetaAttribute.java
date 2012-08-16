/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import logic.SO.Import_Export.CalculateMetaAttributeForDataSet;
import logic.SO.VratiSve;
import logic.SO.serialization.Serialize;
import model.OpstiDomenskiObjekat;
import model.Statistic;
import model.dataset.Dataset;
import model.dataset.Datasetmetaattribute;
import model.dataset.Dsmetaattribute;

/**
 *
 * @author Jelena
 */
public class ControllerAL_MetaAttribute {
    
    private ControllerAL_MetaAttribute() {
    }
    
    public static ControllerAL_MetaAttribute getInstance() {
        return ControllerAL_MetaAttributeHolder.INSTANCE;
    }
    
    private static class ControllerAL_MetaAttributeHolder {

        private static final ControllerAL_MetaAttribute INSTANCE = new ControllerAL_MetaAttribute();
    }
    
    public void calculateMetaattributes(Dataset ds){
        ArrayList<Dsmetaattribute> allDsmetaattributes = getAllDsmetaattributes();
        List<Datasetmetaattribute> calculate = new CalculateMetaAttributeForDataSet().calculate(ds, allDsmetaattributes);
        ds.setDatasetmetaattributeList(calculate);
        /*HashMap<String, Double> metaAttributes = new HashMap<String, Double>();
        metaAttributes = (new CalculateMetaAttributeForDataSet()).calculate(ds, metaAttributes);
        ds.setMetaAttributes(metaAttributes);
        for (Map.Entry<String, Double> entry : metaAttributes.entrySet()) {
        String string = entry.getKey();
        Double double1 = entry.getValue();
        System.out.println(string + "=" + double1);
        }*/
    }
    
    public void recalculateMetaAttributes() throws IOException{
        
        for (Dataset dataSet : ControllerAL_Main.getInstance().getAllDataSets()) {
            ArrayList<Dsmetaattribute> al= getUnalculatedMetaAttribute(dataSet);
            List<Datasetmetaattribute> calculate = new CalculateMetaAttributeForDataSet().calculate(dataSet, al);
            
            for (Datasetmetaattribute datasetmetaattribute : calculate) {
                dataSet.addDatasetmetaattribute(datasetmetaattribute);
            }
            
            Serialize.serialize(dataSet);
        }
    }
    
    public ArrayList<Dsmetaattribute> getUnalculatedMetaAttribute(Dataset dss){
        ArrayList<Dsmetaattribute> uncalculated=new ArrayList<Dsmetaattribute>();
        ArrayList<Dsmetaattribute> alldsma=getAllDsmetaattributes();
        List<Datasetmetaattribute> datasetmetaattributeList = dss.getDatasetmetaattributeList();
            
        for (int i = 0; i < alldsma.size(); i++) {
            
            Dsmetaattribute d = alldsma.get(i);
            boolean exist=false;
            for (int j = 0; j < datasetmetaattributeList.size(); j++) {
                Datasetmetaattribute datasetmetaattribute = datasetmetaattributeList.get(j);
                if(datasetmetaattribute.getDsmetaattribute().getDsmetaattributeID().equals(d.getDsmetaattributeID())){
                    exist=true;
                    break;
                }        
            }
            
            if(exist==true){
                uncalculated.add(d);
            }
        }
        
        return uncalculated;
    }
    
    public ArrayList<Dsmetaattribute> getAllDsmetaattributes(){
        ArrayList<Dsmetaattribute> alldsma=new ArrayList<Dsmetaattribute>();
        ArrayList<OpstiDomenskiObjekat> allODO= new ArrayList<OpstiDomenskiObjekat>();
        Dsmetaattribute dma= new Dsmetaattribute();
        allODO.add(dma);
        VratiSve.VratiSve(allODO);
        for (int i = 0; i < allODO.size(); i++) {
            OpstiDomenskiObjekat opstiDomenskiObjekat = allODO.get(i);
            Dsmetaattribute dsma= (Dsmetaattribute)opstiDomenskiObjekat;
            alldsma.add(dsma);
        }
        return alldsma;
    }
    
    public ArrayList<Statistic> getAllStatistics(){
        ArrayList<Statistic> alldsma=new ArrayList<Statistic>();
        ArrayList<OpstiDomenskiObjekat> allODO= new ArrayList<OpstiDomenskiObjekat>();
        Statistic st= new Statistic();
        allODO.add(st);
        VratiSve.VratiSve(allODO);
        for (int i = 0; i < allODO.size(); i++) {
            OpstiDomenskiObjekat opstiDomenskiObjekat = allODO.get(i);
            Statistic dsma= (Statistic)opstiDomenskiObjekat;
            alldsma.add(dsma);
        }
        return alldsma;
    }
    
}
