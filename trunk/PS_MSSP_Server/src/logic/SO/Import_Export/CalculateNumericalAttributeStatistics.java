/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO.Import_Export;

import java.util.HashMap;
import model.statistics.CalculatedNumericalStatistics;

/**
 *
 * @author Jelena
 */
public class CalculateNumericalAttributeStatistics {
    public static HashMap<String, Double> calculate(double[] valuesArray,HashMap<String, Double> numericalStatistics){
        numericalStatistics=new CalculatedNumericalStatistics().getValues(valuesArray);
        return numericalStatistics;
    }
}
