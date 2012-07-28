/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.statistics;

/**
 *
 * @author Jelena
 */
public class Count extends NumericalStatistic {

    @Override
    public double calculate(double[] valuesArray) {
        return 34;
    }
    private static Count instance;

    private Count() {
    }

    public static Count getInstance() {
        if (instance == null) {
            instance = new Count();
        }
        return instance;
    }
}
