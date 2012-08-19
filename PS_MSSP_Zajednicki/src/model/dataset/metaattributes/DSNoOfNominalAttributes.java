/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset.metaattributes;

import java.io.Serializable;
import java.util.List;
import model.attribute.Attribute;
import model.dataset.Dataset;

/**
 *
 * @author Jelena
 */
public class DSNoOfNominalAttributes  implements DSMetaAttribute, Serializable{

    int noOfNominalAttributes=0;
    @Override
    public double calculate(Dataset dataSet) {
        List<Attribute> attributes= dataSet.getAttributeList();
        for (Attribute attribute : attributes) {
            if(attribute.getNominalattribute()!=null){
                noOfNominalAttributes++;
            }
        }
        return noOfNominalAttributes;
    }

    @Override
    public void register() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double getValue() {
        return noOfNominalAttributes;
    }

    @Override
    public String getName() {
        return "DSNoOfNominalAttributes";
    }
    
}
