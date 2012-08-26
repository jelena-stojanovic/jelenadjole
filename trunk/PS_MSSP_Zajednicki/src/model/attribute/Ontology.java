/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.attribute;

import java.util.ArrayList;

/**
 *
 * @author Jelena
 */
public class Ontology {

    public static final String CLASS_ATTRIBUTE = "Class";
    public static final String REGULAR_ATTRIBUTE = "Attribute";
    public static final String ID_ATTRIBUTE = "Id";

    public static ArrayList<String> getAttributeRoles() {
        ArrayList<String> list = new ArrayList<String>();
        list.add(REGULAR_ATTRIBUTE);
        list.add(CLASS_ATTRIBUTE);
        list.add(ID_ATTRIBUTE);
        return list;
    }
    public static ArrayList<String> getAttributeTypesS(){
        ArrayList<String> list= new ArrayList<String>();
        list.add(NOMINAL_ATTRIBUTE);
        list.add(NUMERICAL_ATTRIBUTE);
        list.add(ORDINAL_ATTRIBUTE);
        list.add(INTERVAL_ATTRIBUTE);
        list.add(DATE_ATTRIBUTE);
        return list;
    }
    
    public static ArrayList<Attributetype> getAttributeTypes(){
        ArrayList<Attributetype> list= new ArrayList<Attributetype>();
        list.add(NOMINAL_ATTRIBUTE_TYPE);
        list.add(NUMERICAL_ATTRIBUTE_TYPE);
        list.add(ORDINAL_ATTRIBUTE_TYPE);
        list.add(INTERVAL_ATTRIBUTE_TYPE);
        list.add(DATE_ATTRIBUTE_TYPE);
        return list;
    }
    
    
    public static final String NUMERICAL_ATTRIBUTE = "numerical";
    public static final String NOMINAL_ATTRIBUTE = "nominal";
    public static final String ORDINAL_ATTRIBUTE = "ordinal";
    public static final String INTERVAL_ATTRIBUTE = "interval";
    public static final String DATE_ATTRIBUTE = "date";
    public static final Attributetype NUMERICAL_ATTRIBUTE_TYPE = new Attributetype(2, NUMERICAL_ATTRIBUTE);
    public static final Attributetype NOMINAL_ATTRIBUTE_TYPE = new Attributetype(1, NOMINAL_ATTRIBUTE);
    public static final Attributetype ORDINAL_ATTRIBUTE_TYPE = new Attributetype(5, ORDINAL_ATTRIBUTE);
    public static final Attributetype INTERVAL_ATTRIBUTE_TYPE = new Attributetype(5, INTERVAL_ATTRIBUTE);
    public static final Attributetype DATE_ATTRIBUTE_TYPE = new Attributetype(3, DATE_ATTRIBUTE);

    public static Attributetype getAttributeTypeObject(String attributeTypeString) {
        if (attributeTypeString.equals(NOMINAL_ATTRIBUTE)) {
            return NOMINAL_ATTRIBUTE_TYPE;
        }
        if (attributeTypeString.equals(NUMERICAL_ATTRIBUTE)) {
            return NUMERICAL_ATTRIBUTE_TYPE;
        }
        if (attributeTypeString.equals(DATE_ATTRIBUTE)) {
            return DATE_ATTRIBUTE_TYPE;
        }
        if (attributeTypeString.equals(ORDINAL_ATTRIBUTE)) {
            return ORDINAL_ATTRIBUTE_TYPE;
        } else if (attributeTypeString.equals(INTERVAL_ATTRIBUTE)) {
            return INTERVAL_ATTRIBUTE_TYPE;
        }
        
        return NOMINAL_ATTRIBUTE_TYPE;

    }
    
    public static final String COSINE_SIMILARITY="CalculateCosineSimilarity";
    public static final String EUCLIDIAN_SIMILARITY="CalculateEuclidianSimilarity";
}
