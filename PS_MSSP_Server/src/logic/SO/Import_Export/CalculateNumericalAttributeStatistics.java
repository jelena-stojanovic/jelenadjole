/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO.Import_Export;

import java.util.HashMap;
import model.statistics.CalculatedNumericalStatistics;
import model.statistics.NumericalStatistic;

/**
 *
 * @author Jelena
 */
public class CalculateNumericalAttributeStatistics {
    public static void calculate(double[] valuesArray,HashMap<NumericalStatistic, Double> numericalStatistics){
        numericalStatistics=new CalculatedNumericalStatistics().getValues(valuesArray);
    }
}
