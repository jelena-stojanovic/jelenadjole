/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.statistics;

import java.util.Arrays;

/**
 *
 * @author Jelena
 */
public class Median extends NumericalStatistic {

    @Override
    public double calculate(double[] valuesArray) {
        int length = valuesArray.length;
        double[] sort = new double[length];
        System.arraycopy(valuesArray,0, sort, 0, sort.length);
        Arrays.sort(sort);

        if (length % 2 == 0) {
            return (sort[(sort.length / 2) - 1] + sort[sort.length / 2]) / 2;
        } else {
            return sort[sort.length / 2];
        }
    }

}
