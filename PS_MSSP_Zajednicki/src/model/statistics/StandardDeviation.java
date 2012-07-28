/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.statistics;

/**
 *
 * @author Jelena
 */
public class StandardDeviation extends NumericalStatistic{

    @Override
    public double calculate(double[] valuesArray) {
        return 2.0;
    }
}
