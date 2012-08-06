/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.List;
import model.dataset.DataSet;

/**
 *
 * @author Jelena
 */
public class DataSetCollection {
    List<DataSet> datasets;
    private DataSetCollection() {
        datasets= new ArrayList<DataSet>();
    }
    
    public static DataSetCollection getInstance() {
        return DataSetCollectionHolder.INSTANCE;
    }
    
    private static class DataSetCollectionHolder {

        private static final DataSetCollection INSTANCE = new DataSetCollection();
    }
    
    public void addDataSet(DataSet ds){
        datasets.add(ds);
    }

    public List<DataSet> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<DataSet> datasets) {
        this.datasets = datasets;
    }
    
}
