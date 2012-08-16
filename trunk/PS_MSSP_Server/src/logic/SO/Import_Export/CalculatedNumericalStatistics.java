/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO.Import_Export;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.ControllerAL_MetaAttribute;
import model.Attributestatistic;
import model.AttributestatisticPK;
import model.Statistic;
import model.attribute.Attribute;
import model.statistics.NumericalStatistic;

/**
 *
 * @author Jelena
 */
public class CalculatedNumericalStatistics {


//    public List<Attributestatistic> getValues(double[] valuesArray, Attribute attribute) {
//
//        List<Statistic> availableStatistics= ControllerAL_MetaAttribute.getInstance().getAllStatistics();
//        List<Attributestatistic> calc=calculate(attribute, valuesArray, availableStatistics);
//        return calc;
//    }
//
//    
//    
    /****/
    public List<Attributestatistic> calculate(Attribute a,double[] valuesArray,List<Statistic> availableStatistics){
        String[] availableMetaAttributeImplementationClassNames= new String[availableStatistics.size()];
        List<Attributestatistic> list= new ArrayList<Attributestatistic>();
        for (int i = 0; i < availableStatistics.size(); i++) {
            Statistic statistic = availableStatistics.get(i);
            availableMetaAttributeImplementationClassNames[i]=statistic.getStatisticClass();
            
            Attributestatistic d= new Attributestatistic();
            d.setAttribute(a);
            d.setStatistic(statistic);
            
            AttributestatisticPK apk= new AttributestatisticPK();
            apk.setDataSetID(a.getAttributePK().getDataSetID());
            apk.setIndexOfAttribute(a.getAttributePK().getIndexOfAttribute());
            apk.setStatisticID(statistic.getStatisticID());
            d.setAttributestatisticPK(apk);
            
            double doub= calculateValues(valuesArray, statistic.getStatisticClass());
            d.setStatisticValue(doub);
            list.add(d);
        }
        
        return list;
    }
    
    private double calculateValues(double[] values, String statclass) {
            try {
                Constructor constructor = Class.forName(statclass).getConstructor();
                NumericalStatistic object= (NumericalStatistic)constructor.newInstance();
                if (object != null) {
                    return object.calculate(values);
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
    
    /*****/
    
}
