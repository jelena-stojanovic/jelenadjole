/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset.metaattributes;

import java.io.Serializable;
import model.attribute.Attribute;
import model.dataset.Dataset;

/**
 *
 * @author Jelena
 */
public class MissingValues implements DSMetaAttribute, Serializable{

    public MissingValues() {
    }

    
    
    @Override
    public double calculate(Dataset dataSet) {
        int missingvalues=0;
        for (Attribute object : dataSet.getAttributeList()) {
            if(object.getMissingValues()!=null){
                missingvalues+=object.getMissingValues();
            }
        }
        return missingvalues;
    }

    @Override
    public void register() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getName() {
        return "MissingValues";
    }

    @Override
    public double getValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
