/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.statistics;

import java.io.Serializable;

/**
 *
 * @author Jelena
 */
public class Maximum extends NumericalStatistic implements Serializable{
    @Override
    public double calculate(double[] valuesArray) {
        double maxValue= Double.MIN_VALUE;
        
        for (int i = 0; i < valuesArray.length; i++) {
            double d = valuesArray[i];
            maxValue = Math.max(maxValue, d);
        }
        return maxValue;
    }
    
}
