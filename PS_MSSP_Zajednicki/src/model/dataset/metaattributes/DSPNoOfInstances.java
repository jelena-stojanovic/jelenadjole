/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset.metaattributes;

import java.io.Serializable;
import model.dataset.Dataset;

/**
 *
 * @author Jelena
 */
public class DSPNoOfInstances implements DSMetaAttribute, Serializable{
    
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
    public double calculate(Dataset dataSet) {
        numberOfInstances= dataSet.getDataTable().getNumRows();
        return numberOfInstances;
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
