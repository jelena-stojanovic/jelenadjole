/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import javax.ejb.Stateless;
import logic.SO.similarity.CalculateCosineSimilarity;
import logic.SO.similarity.CalculateEuclidianSimilarity;
import model.dataset.Dataset;

/**
 *
 * @author Jelena
 */
@Stateless
public class SessionBeanSimilarity implements SessionBeanSimilarityLocal {

    @Override
    public double calculateSimilarity(Dataset ds1, Dataset ds2, String similarityMeasure) {
                    double d = Double.NaN;

                    if (similarityMeasure.equals("CalculateCosineSimilarity")) {
                        d = CalculateCosineSimilarity.calculate(ds1, ds2);
                    } else if (similarityMeasure.equals("CalculateEuclidianSimilarity")) {
                        d = CalculateEuclidianSimilarity.calculate(ds1, ds2);
                    }

                    return d;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    
}
