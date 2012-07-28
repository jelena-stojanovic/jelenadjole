/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.attribute;

/**
 *
 * @author Jelena
 */
public class OrdinalAttribute extends Attribute{

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
        return true;
    }

     @Override
    public boolean isInterval() {
        return false;
    }

    @Override
    public boolean isDate() {
        return false;
    }
    
    @Override
    public Object getPossibleValues() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
