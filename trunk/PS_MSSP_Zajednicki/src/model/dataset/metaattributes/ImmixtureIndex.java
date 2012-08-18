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
public class ImmixtureIndex implements DSMetaAttribute, Serializable{

    @Override
    public double calculate(Dataset dataSet) {
        return 0.5;
    }

    @Override
    public void register() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double getValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
