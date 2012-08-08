/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO.similarity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import logic.SO.Import_Export.CalculateMetaAttributeForDataSet;
import model.dataset.DataSet;

/**
 *
 * @author Jelena
 */
public class CalculateEuclidianSimilarity {

    public static double calculate(DataSet dataset1, DataSet dataset2) {

        if(dataset1.getMetaAttributes().size()!= dataset2.getMetaAttributes().size()){
            new CalculateMetaAttributeForDataSet().calculate(dataset1, dataset1.getMetaAttributes());
            new CalculateMetaAttributeForDataSet().calculate(dataset2, dataset2.getMetaAttributes());
        }
        
        HashMap<String, Double> metaAttributes1= dataset1.getMetaAttributes();
        double[] value1= new double[metaAttributes1.size()];
        HashMap<String, Double> metaAttributes2= dataset2.getMetaAttributes();
        double[] value2= new double[metaAttributes2.size()];
        
        int i=0;
        for (Map.Entry<String, Double> entry : metaAttributes1.entrySet()) {
            String string = entry.getKey();
            
            value1[i]=metaAttributes1.get(string);
            value2[i]=metaAttributes2.get(string);
            
            i++;   
        }
        return calculateSimilarity(value1, value2);
    }

    private static double calculateDistance(double[] value1, double[] value2) {
        double sum = 0.0;
        int counter = 0;
        for (int i = 0; i < value1.length; i++) {
            if ((!Double.isNaN(value1[i])) && (!Double.isNaN(value2[i]))) {
                double diff = value1[i] - value2[i];
                sum += diff * diff;
                counter++;
            }
        }
        if (counter > 0) {
            return Math.sqrt(sum);
        } else {
            return Double.NaN;
        }
    }

    private static double calculateSimilarity(double[] value1, double[] value2) {
        return -calculateDistance(value1, value2);
    }
}
