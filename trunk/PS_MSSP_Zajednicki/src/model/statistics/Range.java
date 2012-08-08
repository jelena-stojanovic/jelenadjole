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
public class Range extends NumericalStatistic implements Serializable{

    @Override
    public double calculate(double[] valuesArray) {
        double minValue= new Minimum().calculate(valuesArray);
        double maxValue = new Maximum().calculate(valuesArray);
        double range= maxValue-minValue;
        return range;
    }
}
