/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.attribute;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.statistics.Maximum;
import model.statistics.Minimum;
import model.statistics.NumericalStatistic;


/**
 *
 * @author Jelena
 */
public class NumericalAttribute extends Attribute{

    
    /**
     * map of class names of statistics and their values of concrete attribute
     */
    HashMap<String, Double> statistics;

    
    @Override
    public boolean isNominal() {
         return false;
    }

    @Override
    public boolean isNumerical() {
         return true;
    }

    @Override
    public boolean isOrdinal() {
         return false;
    }
/**
 * 
 * @return range of values
 */
    @Override
    public Object getPossibleValues() {
            double minValue= statistics.get(Minimum.class.getName());
            double maxValue= statistics.get(Maximum.class.getName());
            return "["+minValue+" - " +maxValue +"]";
        
    }

    @Override
    public boolean isInterval() {
        return false;
    }

    @Override
    public boolean isDate() {
        return false;
    }
    
}
