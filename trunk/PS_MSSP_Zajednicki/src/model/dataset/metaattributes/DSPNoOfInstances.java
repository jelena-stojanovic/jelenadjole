/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset.metaattributes;

import model.attribute.Attribute;
import model.attribute.NumericalAttribute;
import model.dataset.DataSet;

/**
 *
 * @author Jelena
 */
public class DSPNoOfInstances extends NumericalAttribute implements DSMetaAttribute{
    
    private int numberOfInstances;

    /**
     * @return the numberOfInstances
     */
    public int getNumberOfInstances() {
        return numberOfInstances;
    }

    /**
     * @param numberOfInstances the numberOfInstances to set
     */
    public void setNumberOfInstances(int numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    @Override
    public double calculate(DataSet dataSet) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void register() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double getValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

  
  
}
