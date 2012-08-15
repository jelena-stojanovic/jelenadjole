/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO.Import_Export;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dataset.Dataset;
import model.dataset.Datasetmetaattribute;
import model.dataset.Dsmetaattribute;
import model.dataset.metaattributes.DSMetaAttribute;

/**
 *
 * @author Jelena
 */
public class CalculateMetaAttributeForDataSet {

 /*   private HashMap<String, Double> metaAttributeMap = new HashMap<String, Double>();
    
    public HashMap<String, Double> calculate(Dataset ds,HashMap<String, Double> metaAttributes){
        metaAttributeMap=metaAttributes;
        metaAttributeMap=getValues(ds);
        return metaAttributeMap;
    }
*/
    public List<Datasetmetaattribute> calculate(Dataset ds,List<Dsmetaattribute> availableMetaAttribute){
        String[] availableMetaAttributeImplementationClassNames= new String[availableMetaAttribute.size()];
        List<Datasetmetaattribute> list= new ArrayList<Datasetmetaattribute>();
        for (int i = 0; i < availableMetaAttribute.size(); i++) {
            Dsmetaattribute dsmetaattribute = availableMetaAttribute.get(i);
            availableMetaAttributeImplementationClassNames[i]=dsmetaattribute.getDsmetaattributeClass();
            
            Datasetmetaattribute d= new Datasetmetaattribute();
            d.setDataset(ds);
            d.setDsmetaattribute(dsmetaattribute);
            
            double doub= calculateValues(ds, dsmetaattribute.getDsmetaattributeClass());
            d.setValue(doub);
            list.add(d);
        }
        
        return list;
    }
    
    /*
    public HashMap<String, Double> getValues(Dataset ds) {

        calculateValues(ds);
        return metaAttributeMap;

    }
*/
    private double calculateValues(Dataset ds, String statclass) {
      //  String[] availableMetaAttributeImplementationClassNames = MetaAttributesAndStatisticsColection.getInstance().getAvailableMetaAttributeImplementationClassNames();
       
        
      //  for (String statclass : availableMetaAttributeImplementationClassNames) {
            try {

                Constructor constructor = Class.forName(statclass).getConstructor();
                DSMetaAttribute object= (DSMetaAttribute)constructor.newInstance();
                if (object != null) {
                    return object.calculate(ds);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CalculateMetaAttributeForDataSet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(CalculateMetaAttributeForDataSet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(CalculateMetaAttributeForDataSet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(CalculateMetaAttributeForDataSet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(CalculateMetaAttributeForDataSet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(CalculateMetaAttributeForDataSet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(CalculateMetaAttributeForDataSet.class.getName()).log(Level.SEVERE, null, ex);
            }
        //}
            
            return Double.NaN;
    }
}
