/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.HashMap;
import java.util.Map;
import model.statistics.CalculatedNumericalStatistics;
import model.statistics.NumericalStatistic;

/**
 *
 * @author Jelena
 */
public class Testic {
    public static void main(String[] args) {
        double[] niz= {1,2,3,4,5,6,7,8,9};
        for (int i = 0; i < niz.length; i++) {
            double d = niz[i];
            System.out.println(d);
            
        }
        HashMap<NumericalStatistic, Double> statistic= new CalculatedNumericalStatistics().getValues(niz);
        for (Map.Entry<NumericalStatistic, Double> entry : statistic.entrySet()) {
            NumericalStatistic numericalStatistic = entry.getKey();
            Double double1 = entry.getValue();
            System.out.println(numericalStatistic.getClass().getSimpleName()+"="+double1);
        }

    }
    
}
