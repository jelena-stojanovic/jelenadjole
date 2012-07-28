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
        return 34;
    }
    
    private static Mean instance;

    private Mean() {
    }

    public static Mean getInstance() {
        if (instance == null) {
            instance = new Mean();
        }
        return instance;
    }

    
}
