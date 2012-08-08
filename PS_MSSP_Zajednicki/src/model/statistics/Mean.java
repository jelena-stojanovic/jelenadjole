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
public class Mean extends NumericalStatistic implements Serializable{
    @Override
    public double calculate(double[] valuesArray) {
        return new Sum().calculate(valuesArray)/valuesArray.length;
    }
    
}
