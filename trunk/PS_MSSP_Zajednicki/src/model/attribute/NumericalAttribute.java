/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.attribute;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.OpstiDomenskiObjekat;
import model.statistics.Maximum;
import model.statistics.Minimum;
import model.statistics.NumericalStatistic;


/**
 *
 * @author Jelena
 */
public class NumericalAttribute extends Attribute implements Serializable {

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
    public void setPossibleValues(Object object) {
        
    }
@Override
    public String vratiImeKlase() {
        return "NumericalAttribute";
    }

    @Override
    public String vratiNazivTabele() {
        return "attribute";
    }

    @Override
    public void prekopirajVrednostiAtributa(OpstiDomenskiObjekat odo) {
        NumericalAttribute na= (NumericalAttribute) odo;
        na.setAttributePK(attributePK);
        na.setAttributeRole(this.getAttributeRole());
        
    }

    @Override
    public int vratiID() {
        return attributePK.getIndexOfAttribute();
    }

    @Override
    public void postaviAtributPretrazivanja(String atribut) {
        
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return "IndexOfAttribute";
    }

    @Override
    public String vratiNazivNovogObjekta() {
        return "new numerical attribute";
    }

    @Override
    public String vratiNazivObjekta() {
        return "numerical attribute";
    }

  
    
}
