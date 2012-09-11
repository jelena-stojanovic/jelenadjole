/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import javax.ejb.Stateless;
import model.dataset.Dataset;

/**
 *
 * @author Jelena
 */
@Stateless
public class SessionBeanDataset implements SessionBeanDatasetLocal {

   
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Dataset> getAllDatasets() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Dataset getDataset(Dataset ds) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
