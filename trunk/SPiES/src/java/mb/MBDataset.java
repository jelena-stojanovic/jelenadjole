/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import ejb.CallEJB;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import model.dataset.Dataset;

/**
 *
 * @author Djordje
 */
@Named(value = "mbdataset")
@Dependent
public class MBDataset {

    Dataset dataset;
    List<Dataset> allDatasets;
    
    /**
     * Creates a new instance of MBDataset
     */
    public MBDataset() {
        dataset= new Dataset();
    }

    public Dataset getDataset() {
        return dataset;
    }

    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
    }
    
    public List<Dataset> getAllDatasets() {
        //allDatasets = CallEJB.getInstance().getSBdataset().getAllDatasets();
        //return allDatasets;
        ArrayList<Dataset> a = new ArrayList<Dataset>();
        a.add(new Dataset(1));
        a.add(new Dataset(2));
        a.add(new Dataset(3));
        return a;
    }
    
}
