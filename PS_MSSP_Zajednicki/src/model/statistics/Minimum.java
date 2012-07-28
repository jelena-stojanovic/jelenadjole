/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.statistics;

/**
 *
 * @author Jelena
 */
public class Minimum extends NumericalStatistic{

    @Override
    public double calculate(double[] valuesArray) {
        return 34;
    }
    private static Minimum instance;

    private Minimum() {
    }

    public static Minimum getInstance() {
        if (instance == null) {
            instance = new Minimum();
        }
        return instance;
    }
}
