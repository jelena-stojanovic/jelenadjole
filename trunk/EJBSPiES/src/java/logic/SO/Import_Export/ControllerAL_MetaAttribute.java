/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO.Import_Export;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import logic.SO.Obradi;
import logic.SO.VratiSve;
import logic.SO.serialization.Serialize;
import model.OpstiDomenskiObjekat;
import model.Statistic;
import model.dataset.Dataset;
import model.dataset.Datasetmetaattribute;
import model.dataset.Dsmetaattribute;
import model.dataset.Metads;

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
        List<Dsmetaattribute> allDsmetaattributes = getAllDsmetaattributes();
        List<Datasetmetaattribute> calculate = new CalculateMetaAttributeForDataSet().calculate(ds, allDsmetaattributes);
        ds.setDatasetmetaattributeList(calculate);
     
    }
    
    
    
    public List<Dsmetaattribute> getUnalculatedMetaAttribute(Dataset dss){
        List<Dsmetaattribute> uncalculated=new ArrayList<Dsmetaattribute>();
        List<Dsmetaattribute> alldsma=getAllDsmetaattributes();
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
    
    public List<Dsmetaattribute> getAllDsmetaattributes(){
        List<Dsmetaattribute> alldsma=new ArrayList<Dsmetaattribute>();
        List<OpstiDomenskiObjekat> allODO= new ArrayList<OpstiDomenskiObjekat>();
        Dsmetaattribute dma= new Dsmetaattribute();
        allODO.add(dma);
        String signal="";
        allODO=VratiSve.VratiSve(allODO,signal);
        for (int i = 0; i < allODO.size(); i++) {
            OpstiDomenskiObjekat opstiDomenskiObjekat = allODO.get(i);
            Dsmetaattribute dsma= (Dsmetaattribute)opstiDomenskiObjekat;
            alldsma.add(dsma);
        }
        return alldsma;
    }
    
    public List<Statistic> getAllStatistics(){
        List<Statistic> alldsma=new ArrayList<Statistic>();
        List<OpstiDomenskiObjekat> allODO= new ArrayList<OpstiDomenskiObjekat>();
        Statistic st= new Statistic();
        allODO.add(st);
        String signal= "";
        allODO=VratiSve.VratiSve(allODO,signal);

        for (int i = 0; i < allODO.size(); i++) {
            OpstiDomenskiObjekat opstiDomenskiObjekat = allODO.get(i);

            Statistic dsma= (Statistic)opstiDomenskiObjekat;

            alldsma.add(dsma);
        }
        return alldsma;
    }

    
        public Metads getMetads() {
        List<OpstiDomenskiObjekat> allODO = new ArrayList<OpstiDomenskiObjekat>();
        Metads dma = new Metads();
        allODO.add(dma);
        String signal = "";
        allODO = VratiSve.VratiSve(allODO, signal);
        dma = (Metads) allODO.get(0);
        return dma;
    }

}
