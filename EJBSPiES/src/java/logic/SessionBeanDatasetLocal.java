/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import javax.ejb.Local;
import model.dataset.Dataset;

/**
 *
 * @author Jelena
 */
@Local
public interface SessionBeanDatasetLocal {
 
    List<Dataset> getAllDatasets();

    Dataset getDataset(Dataset ds);
    
    void createDataset(Dataset ds);
    void saveDataset(Dataset ds);
    void updateDataset(Dataset ds);
}
