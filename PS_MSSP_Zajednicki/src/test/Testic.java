/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dataset.MetaAttributesAndStatisticsColection;

/**
 *
 * @author Jelena
 */
public class Testic {
    public static void main(String[] args) {
        
        
        String[] availableMetaAttributeImplementationClassNames = MetaAttributesAndStatisticsColection.getInstance().getAvailableStatisticsImplementationClassNames();
       for (String statclass : availableMetaAttributeImplementationClassNames) {
            System.out.println(statclass);
        }
          
//        
//        PrintWriter out = null;
//        try {
//            /*   double[] niz= {1,2,3,4,5,6,7,8,9,3,2,3,2,3,3,3,3,3};
//            for (int i = 0; i < niz.length; i++) {
//            double d = niz[i];
//            System.out.println(d);
//            }
//            HashMap<String, Double> statistic= new CalculatedNumericalStatistics().getValues(niz);
//            for (Map.Entry<String, Double> entry : statistic.entrySet()) {
//            String numericalStatistic = entry.getKey();
//            Double double1 = entry.getValue();
//            System.out.println(numericalStatistic+"="+double1);
//            }
//             */
//            double[][] dmds= new double[2][3];
//            dmds[0][0]=1.0;
//            dmds[0][1]=2.0;
//            dmds[0][2]=3.0;
//            dmds[1][0]=4.0;
//            dmds[1][1]=5.0;
//            dmds[1][2]=6.0;
//            out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\Jelena\\Desktop\\jelena.csv")));
//            //int noOfColums= dataset.getDataTable().getNumColums();
//            //int noOfRows= dataset.getDataTable().getNumRows();
//            double[][] doubleMatrix=dmds;
//            //                               trebalo bi da je broj redova
//            for (int i = 0; i < doubleMatrix.length; i++) {
//                double[] ds = doubleMatrix[i];
//                out.print(String.valueOf(ds[0]));
//                //                      broj kolona
//                for (int j = 1; j < ds.length; j++) {
//                    double d = ds[j];
//                    out.print(','+String.valueOf(d));
//                }
//                out.println();
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Testic.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            out.close();
//        }
        
    }
    
}
