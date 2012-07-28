/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.statistics;

/**
 *
 * @author Jelena
 */
public class Mode extends NumericalStatistic{

    @Override
    public double calculate(double[] valuesArray) {
        return 34;
    }
    private static Mode instance;

    private Mode() {
    }

    public static Mode getInstance() {
        if (instance == null) {
            instance = new Mode();
        }
        return instance;
    }
}
