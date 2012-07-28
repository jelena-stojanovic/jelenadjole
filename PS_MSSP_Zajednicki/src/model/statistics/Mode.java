/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.statistics;

/**
 *
 * @author Jelena
 */
public class Mode extends NumericalStatistic {

    @Override
    public double calculate(double[] valuesArray) {

        double max = 0, maxCount = 0;
        int length = valuesArray.length;
        for (int i = 0; i < length; ++i) {
            int count = 0;
            for (int j = 0; j < length; ++j) {
                if (valuesArray[j] == valuesArray[i]) {
                    ++count;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                max = valuesArray[i];
            }
        }
        return max;

    }
}
