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
public class Minimum extends NumericalStatistic implements Serializable{

    @Override
    public double calculate(double[] valuesArray) {
        double minValue= Double.MAX_VALUE;
        
        for (int i = 0; i < valuesArray.length; i++) {
            double d = valuesArray[i];
            minValue = Math.min(minValue, d);
        }
        return minValue;
    }
   
}
