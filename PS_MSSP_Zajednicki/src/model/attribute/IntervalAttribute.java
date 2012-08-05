/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.attribute;

/**
 *
 * @author Jelena
 */
public class IntervalAttribute extends Attribute{

    public IntervalAttribute() {
    }

    
    @Override
    public boolean isNominal() {
        return false;
    }

    @Override
    public boolean isNumerical() {
        return false;
    }

    @Override
    public boolean isOrdinal() {
        return false;
    }

    @Override
    public boolean isInterval() {
       return true;
    }

    @Override
    public boolean isDate() {
        return false;
    }
    
    @Override
    public Object getPossibleValues() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setPossibleValues() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
