/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO.similarity;

import java.util.ArrayList;
import java.util.List;
import logic.SO.Import_Export.CalculateMetaAttributeForDataSet;
import logic.SO.VratiSve;
import model.OpstiDomenskiObjekat;
import model.dataset.Dataset;
import model.dataset.Datasetmetaattribute;
import model.dataset.Dsmetaattribute;

/**
 *
 * @author Jelena
 */
public class CalculateCosineSimilarity {

    public static double calculate(Dataset dataset1, Dataset dataset2) {

        if (dataset1.getDatasetmetaattributeList().size() != dataset2.getDatasetmetaattributeList().size()) {
            List<OpstiDomenskiObjekat> list = new ArrayList<OpstiDomenskiObjekat>();
            list.add(new Dsmetaattribute());
            String poruka = "";
            list = VratiSve.VratiSve(list, poruka);
            System.out.println(poruka);
            List<Dsmetaattribute> lista = new ArrayList<Dsmetaattribute>();
            for (int i = 0; i < list.size(); i++) {
                OpstiDomenskiObjekat opstiDomenskiObjekat = list.get(i);
                Dsmetaattribute d = (Dsmetaattribute) opstiDomenskiObjekat;
                lista.add(d);
            }

            new CalculateMetaAttributeForDataSet().calculate(dataset1, lista);
            new CalculateMetaAttributeForDataSet().calculate(dataset2, lista);
        }

        List<Datasetmetaattribute> l1 = dataset1.getDatasetmetaattributeList();
        List<Datasetmetaattribute> l2 = dataset2.getDatasetmetaattributeList();
        //HashMap<String, Double> metaAttributes1= dataset1.getMetaAttributes();
        double[] value1 = new double[l1.size()];
        //HashMap<String, Double> metaAttributes2= dataset2.getMetaAttributes();
        double[] value2 = new double[l2.size()];

        for (int i = 0; i < l2.size(); i++) {
            value2[i] = l2.get(i).getValue();
            value1[i] = l1.get(i).getValue();
        }

        /*
         * int i=0;
         *
         * for (Map.Entry<String, Double> entry : metaAttributes1.entrySet()) {
         * String string = entry.getKey();
         *
         * value1[i]=metaAttributes1.get(string);
         * value2[i]=metaAttributes2.get(string);
         *
         * i++;   
        }
         */
        return calculateSimilarity(value1, value2);
    }

    public static double calculateSimilarity(double[] value1, double[] value2) {
        double sum = 0.0;
        double sum1 = 0.0;
        double sum2 = 0.0;
        for (int i = 0; i < value1.length; i++) {
            double v1 = value1[i];
            double v2 = value2[i];
            if ((!Double.isNaN(v1)) && (!Double.isNaN(v2))) {
                sum += v2 * v1;
                sum1 += v1 * v1;
                sum2 += v2 * v2;
            }
        }
        if ((sum1 > 0) && (sum2 > 0)) {
            double result = sum / (Math.sqrt(sum1) * Math.sqrt(sum2));
            // result can be > 1 (or -1) due to rounding errors for equal vectors, but must be between -1 and 1
            return Math.min(Math.max(result, -1d), 1d);
            //return result;
        } else if (sum1 == 0 && sum2 == 0) {
            return 1d;
        } else {
            return 0d;
        }
    }

    public static double calculateDistance(double[] value1, double[] value2) {
        return Math.acos(calculateSimilarity(value1, value2));
    }
}
