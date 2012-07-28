/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.attribute;

/**
 *
 * @author Jelena
 */
public abstract class Attribute {
    
    String name;
    String description;
    int missingValues;
    Ontology attributeRole;
    
    public abstract boolean isNominal();
    public abstract boolean isNumerical();
    public abstract boolean isOrdinal();
    public abstract boolean isInterval();
    public abstract boolean isDate();
    
   
    public abstract Object getPossibleValues();
    
    
   
    
}
