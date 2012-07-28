/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.statistics;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jelena
 */
public class CalculatedNumericalStatistics {

    HashMap<String, Double> statisticsMap=new HashMap<String, Double>();

    public HashMap<String, Double> getValues(double[] valuesArray) {

        calculateStatistics(valuesArray);
        return statisticsMap;

    }

    private void calculateStatistics(double[] valuesArray) {
        
        for (String statclass : NumericalStatistic.getAvailableImplementationClassNames()) {
            try {
//                  Method method= Class.forName(statclass).getMethod("getInstance");
//                  Class<?> returnType = method. getReturnType().;
//                  NumericalStatistic numstat = (NumericalStatistic)                .newInstance();
                  
                Constructor constructor = Class.forName(statclass).getConstructor();
                NumericalStatistic object = (NumericalStatistic) constructor.newInstance();
                if(object!=null){
                    statisticsMap.put(statclass, object.calculate(valuesArray));
                }
            } catch (InstantiationException ex) {
                Logger.getLogger(CalculatedNumericalStatistics.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(CalculatedNumericalStatistics.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(CalculatedNumericalStatistics.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(CalculatedNumericalStatistics.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(CalculatedNumericalStatistics.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(CalculatedNumericalStatistics.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CalculatedNumericalStatistics.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }
}
