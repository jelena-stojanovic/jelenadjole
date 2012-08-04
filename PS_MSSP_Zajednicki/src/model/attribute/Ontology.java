/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.attribute;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jelena
 */
public class Ontology {
    public static final String CLASS_ATTRIBUTE="Class";
    public static final String REGULAR_ATTRIBUTE="Attribute";
    public static final String ID_ATTRIBUTE="Id";
    
    public static ArrayList<String> getAttributeRoles(){
        ArrayList<String> list= new ArrayList<String>();
        list.add("Attribute");
        list.add("Class");
        list.add("Id");
        return list;
    }
    
    public static ArrayList<String> getAttributeTypes(){
        ArrayList<String> list= new ArrayList<String>();
        list.add("Nominal");
        list.add("Numerical");
        list.add("Ordinal");
        list.add("Interval");
        list.add("Date");
        return list;
    }
    
    public static final String NUMERICAL_ATTRIBUTE="Numerical";
    public static final String NOMINAL_ATTRIBUTE="Nominal";
    public static final String ORDINAL_ATTRIBUTE="Ordinal";
    public static final String INTERVAL_ATTRIBUTE="Interval";
    public static final String DATE_ATTRIBUTE="Date";
}
