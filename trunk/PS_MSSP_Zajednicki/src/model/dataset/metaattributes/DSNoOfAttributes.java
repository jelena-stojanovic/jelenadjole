/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset.metaattributes;

import java.io.Serializable;
import model.attribute.NumericalAttribute;
import model.dataset.Dataset;

/**
 *
 * @author Jelena
 */
public class DSNoOfAttributes extends NumericalAttribute implements DSMetaAttribute, Serializable{

    int numberOfAttributes=0;
    @Override
    public double calculate(Dataset dataSet) {
        numberOfAttributes=dataSet.getAttributeList().size();
        return numberOfAttributes;
    }

    @Override
    public void register() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double getValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
