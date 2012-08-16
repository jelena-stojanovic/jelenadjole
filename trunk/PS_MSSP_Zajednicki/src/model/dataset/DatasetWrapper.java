/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset;

/**
 *
 * @author Jelena
 */
public class DatasetWrapper {
    Dataset dataset;
    DataTable dataTable;

    public DatasetWrapper() {
    }

    public DatasetWrapper(Dataset dataset, DataTable dataTable) {
        this.dataset = dataset;
        this.dataTable = dataTable;
    }

    public DataTable getDataTable() {
        return dataTable;
    }

    public Dataset getDataset() {
        return dataset;
    }

    public void setDataTable(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
    }
    
    
}
