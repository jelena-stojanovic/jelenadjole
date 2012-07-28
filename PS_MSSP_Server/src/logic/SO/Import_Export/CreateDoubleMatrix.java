/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO.Import_Export;

import java.util.ArrayList;

/**
 *
 * @author Djordje
 */
public class CreateDoubleMatrix {
    
    public static double[][] create (ArrayList<Double[]> datasetValues) {
        double[][] doubleMatrix = new double[datasetValues.size()][datasetValues.get(0).length];
        for (int i = 0; i < datasetValues.size(); i++) {
            for (int j = 0; j < datasetValues.get(i).length; j++) {
                doubleMatrix[i][j] = datasetValues.get(i)[j];
            }
        }
        System.out.println("have fun");
        return doubleMatrix;
        
    }
}
