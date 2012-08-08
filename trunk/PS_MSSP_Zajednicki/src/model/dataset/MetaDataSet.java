/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jelena
 */
public class MetaDataSet extends DataSet implements Serializable{
    List<File> datasets= new ArrayList<File>();

    public MetaDataSet() {
    }

    public List<File> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<File> datasets) {
        this.datasets = datasets;
    }
    
    
}
