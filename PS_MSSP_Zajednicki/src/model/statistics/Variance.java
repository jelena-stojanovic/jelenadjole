/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.statistics;

/**
 *
 * @author Jelena
 */
public class Variance extends NumericalStatistic{

    @Override
    public double calculate(double[] valuesArray) {
        return 1.0;
    }
    private static Variance instance;

    private Variance() {
    }

    public static Variance getInstance() {
        if (instance == null) {
            instance = new Variance();
        }
        return instance;
    }
}
