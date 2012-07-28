/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.statistics;

/**
 *
 * @author Jelena
 */
public class Maximum extends NumericalStatistic{
    @Override
    public double calculate(double[] valuesArray) {
        return 34;
    }
    private static Maximum instance;

    private Maximum() {
    }

    public static Maximum getInstance() {
        if (instance == null) {
            instance = new Maximum();
        }
        return instance;
    }

}
