/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset;

import java.util.List;
import model.Instance;
import model.Reference;
import model.attribute.Attribute;
import model.dataset.metaattributes.DSMetaAttribute;


/**
 *
 * @author Jelena
 */
public class DataSet {
    int dataSetID;
    String title;
    String dsDescription;
    Source source;
    List<Reference> references;

    
    List<Attribute> attributes;
    List<Instance> instances;
        
    List<DSMetaAttribute> metaAttributes;
    
    DataTable dataTable;

}
