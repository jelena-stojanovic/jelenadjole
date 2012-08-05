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

    public NumericalAttribute() {
    }

    
    /**
     * map of class names of statistics and their values of concrete attribute
     */
    private HashMap<String, Double> statistics;

    
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
            double minValue= getStatistics().get(Minimum.class.getName());
            double maxValue= getStatistics().get(Maximum.class.getName());
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

    /**
     * @return the statistics
     */
    public HashMap<String, Double> getStatistics() {
        return statistics;
    }

    /**
     * @param statistics the statistics to set
     */
    public void setStatistics(HashMap<String, Double> statistics) {
        this.statistics = statistics;
    }

    @Override
    public void setPossibleValues() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
