/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset.metaattributes;

import java.io.Serializable;
import java.util.List;
import model.attribute.Attribute;
import model.attribute.NumericalAttribute;
import model.dataset.DataSet;

/**
 *
 * @author Jelena
 */
public class PercentOfNumericalAttribute extends NumericalAttribute implements DSMetaAttribute, Serializable{

    int percentOfNumericalAttributes=0;
    @Override
    public double calculate(DataSet dataSet) {
        List<Attribute> attributes= dataSet.getAttributes();
        for (Attribute attribute : attributes) {
            if(attribute.isNumerical()){
                percentOfNumericalAttributes++;
            }
        }
        return percentOfNumericalAttributes*100/attributes.size();
    }

    @Override
    public void register() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double getValue() {
        return percentOfNumericalAttributes;
    }
    
}
