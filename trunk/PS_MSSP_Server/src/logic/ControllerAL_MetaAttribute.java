/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.DataSetCollection;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import logic.SO.Import_Export.CalculateMetaAttributeForDataSet;
import logic.SO.serialization.Serialize;
import model.dataset.DataSet;

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
    
    public void calculateMetaattributes(DataSet ds){
        HashMap<String, Double> metaAttributes = new HashMap<String, Double>();
        metaAttributes = (new CalculateMetaAttributeForDataSet()).calculate(ds, metaAttributes);
        ds.setMetaAttributes(metaAttributes);

        for (Map.Entry<String, Double> entry : metaAttributes.entrySet()) {
            String string = entry.getKey();
            Double double1 = entry.getValue();
            System.out.println(string + "=" + double1);

        }
    }
    
    public void recalculateMetaAttributes() throws IOException{
        for (DataSet dataSet : DataSetCollection.getInstance().getDatasets()) {
            calculateMetaattributes(dataSet);
            Serialize.serialize(dataSet);
        }
    }
}
