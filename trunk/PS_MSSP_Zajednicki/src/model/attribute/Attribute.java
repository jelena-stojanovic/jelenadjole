/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.attribute;

import java.io.Serializable;

/**
 *
 * @author Jelena
 */
public abstract class Attribute implements Serializable {
    private int indexOfAttribute;
    private String name;
    private String description;
    private int missingValues;
    private String attributeRole;
    
    public abstract boolean isNominal();
    public abstract boolean isNumerical();
    public abstract boolean isOrdinal();
    public abstract boolean isInterval();
    public abstract boolean isDate();
    
    public abstract void setPossibleValues(Object object);
   
    public abstract Object getPossibleValues();

    /**
     * @return the indexOfAttribute
     */
    public int getIndexOfAttribute() {
        return indexOfAttribute;
    }

    /**
     * @param indexOfAttribute the indexOfAttribute to set
     */
    public void setIndexOfAttribute(int indexOfAttribute) {
        this.indexOfAttribute = indexOfAttribute;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the missingValues
     */
    public int getMissingValues() {
        return missingValues;
    }

    /**
     * @param missingValues the missingValues to set
     */
    public void setMissingValues(int missingValues) {
        this.missingValues = missingValues;
    }

    /**
     * @return the attributeRole
     */
    public String getAttributeRole() {
        return attributeRole;
    }

    /**
     * @param attributeRole the attributeRole to set
     */
    public void setAttributeRole(String attributeRole) {
        this.attributeRole = attributeRole;
    }
    
    
   
    
}
