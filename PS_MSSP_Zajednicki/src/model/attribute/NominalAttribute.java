/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.attribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Jelena
 */
public class NominalAttribute extends Attribute{

    List<String> possibleNominalValue;
    private final HashMap<String, Double> classToIndexMap = new HashMap<String, Double>();

    public NominalAttribute( List<String> possibleNominalValue) {
        this.possibleNominalValue = possibleNominalValue;
    }
    
    @Override
    public boolean isNominal() {
        return true;
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
        return false;
    }
    
    //TODO:vidi da li ces bas ovako
    @Override
    public Object getPossibleValues() {
        return possibleNominalValue;
    }

    
}
