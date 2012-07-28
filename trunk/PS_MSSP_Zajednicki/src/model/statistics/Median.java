/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.statistics;

/**
 *
 * @author Jelena
 */
public class Median extends NumericalStatistic{
    @Override
    public double calculate(double[] valuesArray) {
        return 34;
    }
    private static Median instance;

    private Median() {
    }

    public static Median getInstance() {
        if (instance == null) {
            instance = new Median();
        }
        return instance;
    }
}
