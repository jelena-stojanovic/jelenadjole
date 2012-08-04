/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.attribute;

/**
 *
 * @author Jelena
 */
public class DateAttribute extends Attribute{

    public DateAttribute() {
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
        return false;
    }

    @Override
    public boolean isDate() {
        return true;
    }

    @Override
    public Object getPossibleValues() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
