/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset.metaattributes;

import model.attribute.NumericalAttribute;
import model.dataset.DataSet;

/**
 *
 * @author Jelena
 */
public class DSNoOfAttributes extends NumericalAttribute implements DSMetaAttribute{

    int numberOfAttributes=0;
    @Override
    public double calculate(DataSet dataSet) {
        numberOfAttributes=dataSet.getDataTable().getNumColums();
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
