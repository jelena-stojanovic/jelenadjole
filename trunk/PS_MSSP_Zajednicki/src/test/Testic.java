/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.HashMap;
import java.util.Map;
import model.statistics.CalculatedNumericalStatistics;

/**
 *
 * @author Jelena
 */
public class Testic {
    public static void main(String[] args) {
        double[] niz= {1,2,3,4,5,6,7,8,9,3,2,3,2,3,3,3,3,3};
        for (int i = 0; i < niz.length; i++) {
            double d = niz[i];
            System.out.println(d);
            
        }
        HashMap<String, Double> statistic= new CalculatedNumericalStatistics().getValues(niz);
        for (Map.Entry<String, Double> entry : statistic.entrySet()) {
            String numericalStatistic = entry.getKey();
            Double double1 = entry.getValue();
            System.out.println(numericalStatistic+"="+double1);
        }

    }
    
}
