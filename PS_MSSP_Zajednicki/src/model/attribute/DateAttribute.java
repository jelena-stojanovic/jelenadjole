/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.attribute;

import java.util.Date;
import java.util.HashMap;
import model.statistics.Maximum;
import model.statistics.Minimum;

/**
 *
 * @author Jelena
 */
public class DateAttribute extends Attribute{

    private HashMap<String, Double> statistics;
    private String datePatern="MM/dd/yyyy";
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
        double minValue= getStatistics().get(Minimum.class.getName());
            double maxValue= getStatistics().get(Maximum.class.getName());
            return "["+getDateFromDouble(minValue)+" - " +getDateFromDouble(maxValue)  +"]";
    }



    /**
     * @return the datePatern
     */
    public String getDatePatern() {
        return datePatern;
    }

    /**
     * @param datePatern the datePatern to set
     */
    public void setDatePatern(String datePatern) {
        this.datePatern = datePatern;
    }
    
    /**
     * 
     * @param d double value from matrix
     * @return Date
     */
    public Date getDateFromDouble(double d){
        Long time= Math.round(d);
        Date date= new Date(time);
        return date;
    }

    @Override
    public void setPossibleValues(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
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
    
}
