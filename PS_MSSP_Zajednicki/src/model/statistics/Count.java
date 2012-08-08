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
public class Count extends NumericalStatistic implements Serializable{

    @Override
    public double calculate(double[] valuesArray) {
        return valuesArray.length;
    }
}
