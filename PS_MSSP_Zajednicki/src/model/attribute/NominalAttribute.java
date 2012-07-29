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

    private List<String> possibleNominalValue;
    private HashMap<String, Double> classToIndexMap = new HashMap<String, Double>();

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
        return getPossibleNominalValue();
    }

    /**
     * @return the possibleNominalValue
     */
    public List<String> getPossibleNominalValue() {
        return possibleNominalValue;
    }

    /**
     * @param possibleNominalValue the possibleNominalValue to set
     */
    public void setPossibleNominalValue(List<String> possibleNominalValue) {
        this.possibleNominalValue = possibleNominalValue;
    }

    /**
     * @return the classToIndexMap
     */
    public HashMap<String, Double> getClassToIndexMap() {
        return classToIndexMap;
    }

    /**
     * @param classToIndexMap the classToIndexMap to set
     */
    public void setClassToIndexMap(HashMap<String, Double> classToIndexMap) {
        this.classToIndexMap = classToIndexMap;
    }

    
}
