/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.DataSetCollection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import logic.SO.VratiSve;
import model.OpstiDomenskiObjekat;
import model.dataset.Dataset;
import model.dataset.Dsmetaattribute;
import model.dataset.MetaAttributesAndStatisticsColection;

/**
 *
 * @author Jelena
 */
public class ControllerAL_Main {
    
    private ControllerAL_Main() {
    }
    
    public static ControllerAL_Main getInstance() {
        return ControllerAL_MainHolder.INSTANCE;
    }
    
    private static class ControllerAL_MainHolder {

        private static final ControllerAL_Main INSTANCE = new ControllerAL_Main();
    }
    
    /*public ArrayList<String> getUnalculatedMetaAttribute(){
        ArrayList<String> uncalculated= new ArrayList<String>();
        String[] statclasss = MetaAttributesAndStatisticsColection.getInstance().getAvailableMetaAttributeImplementationClassNames();
        
        
        Dataset dataset1=DataSetCollection.getInstance().getDatasets().get(1);
        if(dataset1!=null){
            HashMap<String, Double> metaAttributes = dataset1.getMetaAttributes();
            System.out.println("All Meta attributes");
            for (int i = 0; i < statclasss.length; i++) {
                String string = statclasss[i];
                System.out.println(i+string);
                if(!metaAttributes.containsKey(string)){
                    uncalculated.add(string);
                }
            } 
        }
        return uncalculated;
    }
    */
    public List<Dataset> getAllDataSets(){
        ArrayList<Dataset> alldsma=new ArrayList<Dataset>();
        ArrayList<OpstiDomenskiObjekat> allODO= new ArrayList<OpstiDomenskiObjekat>();
        Dataset dma= new Dataset();
        allODO.add(dma);
        VratiSve.VratiSve(allODO);
        for (int i = 0; i < allODO.size(); i++) {
            OpstiDomenskiObjekat opstiDomenskiObjekat = allODO.get(i);
            Dataset dsma= (Dataset)opstiDomenskiObjekat;
            alldsma.add(dsma);
        }
        return alldsma;
    }
    
}
