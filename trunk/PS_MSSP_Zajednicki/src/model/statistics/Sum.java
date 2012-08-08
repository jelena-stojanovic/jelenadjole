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
public class Sum extends NumericalStatistic implements Serializable{

    @Override
    public double calculate(double[] valuesArray) {
        double sum= 0;
        for (int i = 0; i < valuesArray.length; i++) {
            double d = valuesArray[i];
            sum+=d;
        }
        
        return sum;
    }
}
