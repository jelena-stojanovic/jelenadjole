/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO.Import_Export;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dataset.DataSet;
import model.dataset.metaattributes.DSMetaAttribute;
import model.dataset.MetaAttributesAndStatisticsColection;
import model.statistics.CalculatedNumericalStatistics;
import model.statistics.NumericalStatistic;

/**
 *
 * @author Jelena
 */
public class CalculateMetaAttributeForDataSet {

    private HashMap<String, Double> metaAttributeMap = new HashMap<String, Double>();
    
    public HashMap<String, Double> calculate(DataSet ds,HashMap<String, Double> metaAttributes){
        metaAttributeMap=metaAttributes;
        metaAttributeMap=getValues(ds);
        return metaAttributeMap;
    }

    public HashMap<String, Double> getValues(DataSet ds) {

        calculateValues(ds);
        return metaAttributeMap;

    }

    private void calculateValues(DataSet ds) {

        for (String statclass : MetaAttributesAndStatisticsColection.getInstance().getAvailableMetaAttributeImplementationClassNames()) {
            try {

                Constructor constructor = Class.forName(statclass).getConstructor();
                DSMetaAttribute object= (DSMetaAttribute)constructor.newInstance();
                if (object != null) {
                    metaAttributeMap.put(statclass, object.calculate(ds));
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
        }
    }
}
