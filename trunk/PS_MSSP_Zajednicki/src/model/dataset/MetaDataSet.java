/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.dataset.metaattributes.DSMetaAttribute;

/**
 *
 * @author Jelena
 */
public class MetaDataSet extends DataSet implements Serializable{
    List<File> datasets= new ArrayList<File>();
    List<DSMetaAttribute> metaAttributes= new ArrayList<DSMetaAttribute>();

    public MetaDataSet() {
    }

    public List<File> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<File> datasets) {
        this.datasets = datasets;
    }


    public void setMetaAttributes(List<DSMetaAttribute> metaAttributes) {
        this.metaAttributes = metaAttributes;
    }
    
    
}
