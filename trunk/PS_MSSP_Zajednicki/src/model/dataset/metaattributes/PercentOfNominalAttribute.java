/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset.metaattributes;

import java.io.Serializable;
import java.util.List;
import model.attribute.Attribute;
import model.attribute.NumericalAttribute;
import model.dataset.Dataset;

/**
 *
 * @author Jelena
 */
public class PercentOfNominalAttribute extends NumericalAttribute implements DSMetaAttribute, Serializable{

    int percentOfNominalAttributes=0;
    @Override
    public double calculate(Dataset dataSet) {
        List<Attribute> attributes= dataSet.getAttributeList();
        for (Attribute attribute : attributes) {
            if(attribute.isNominal()){
                percentOfNominalAttributes++;
            }
        }
        return percentOfNominalAttributes*100/attributes.size();
    }

    @Override
    public void register() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double getValue() {
        return percentOfNominalAttributes;
    }
    
}
