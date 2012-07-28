/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.statistics;

/**
 *
 * @author Jelena
 */
public class Variance extends NumericalStatistic {

    @Override
    public double calculate(double[] valuesArray) {
       
        double average = new Mean().calculate(valuesArray);
        double Q=0;
        
        for (int i = 0; i < valuesArray.length; i++) 
            Q = Q + (valuesArray[i] - average) * (valuesArray[i] - average);
        
        double variance = Q / (valuesArray.length - 1);
        return variance;
    }
}
