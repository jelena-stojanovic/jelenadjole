/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.statistics;

/**
 *
 * @author Jelena
 */
public class Mean extends NumericalStatistic{
    @Override
    public double calculate(double[] valuesArray) {
        return new Sum().calculate(valuesArray)/valuesArray.length;
    }
    
}
