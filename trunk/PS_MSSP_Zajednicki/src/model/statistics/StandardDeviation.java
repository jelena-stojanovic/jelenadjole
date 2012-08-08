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
public class StandardDeviation extends NumericalStatistic implements Serializable{

    @Override
    public double calculate(double[] valuesArray) {
        return  Math.sqrt(new Variance().calculate(valuesArray));
    }
}
