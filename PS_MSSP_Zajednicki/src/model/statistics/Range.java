/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.statistics;

/**
 *
 * @author Jelena
 */
public class Range extends NumericalStatistic{

    @Override
    public double calculate(double[] valuesArray) {
        return 4.0;
    }
    private static Range instance;

    private Range() {
    }

    public static Range getInstance() {
        if (instance == null) {
            instance = new Range();
        }
        return instance;
    }
}
