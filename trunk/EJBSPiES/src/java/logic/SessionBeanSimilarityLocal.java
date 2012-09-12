/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import javax.ejb.Local;
import model.dataset.Dataset;

/**
 *
 * @author Jelena
 */
@Local
public interface SessionBeanSimilarityLocal {
    double calculateSimilarity(Dataset ds1, Dataset ds2, String similarityMeasure);
}
