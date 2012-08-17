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
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import model.Attributestatistic;
import model.OpstiDomenskiObjekat;
import model.statistics.Maximum;
import model.statistics.Minimum;
import model.statistics.NumericalStatistic;


/**
 *
 * @author Jelena
 */
@Entity
@Table(name = "attribute")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attribute.findAll", query = "SELECT a FROM Attribute a"),
    @NamedQuery(name = "Attribute.findByIndexOfAttribute", query = "SELECT a FROM Attribute a WHERE a.attributePK.indexOfAttribute = :indexOfAttribute"),
    @NamedQuery(name = "Attribute.findByDataSetID", query = "SELECT a FROM Attribute a WHERE a.attributePK.dataSetID = :dataSetID"),
    @NamedQuery(name = "Attribute.findByName", query = "SELECT a FROM Attribute a WHERE a.name = :name"),
    @NamedQuery(name = "Attribute.findByDescription", query = "SELECT a FROM Attribute a WHERE a.description = :description"),
    @NamedQuery(name = "Attribute.findByMissingValues", query = "SELECT a FROM Attribute a WHERE a.missingValues = :missingValues"),
    @NamedQuery(name = "Attribute.findByAttributeRole", query = "SELECT a FROM Attribute a WHERE a.attributeRole = :attributeRole")})
public class NumericalAttribute extends Attribute implements Serializable {

    public NumericalAttribute() {
        
        
    }

    
    /**
     * map of class names of statistics and their values of concrete attribute
     */
  //  private HashMap<String, Double> statistics;

    
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
    
    public Object getPossibleValues() {
        double minValue=0;
        double maxValue=0;
            
        for (int i = 0; i < getAttributestatisticList().size(); i++) {
            Attributestatistic as = getAttributestatisticList().get(i);
            if(as.getStatistic().getStatisticName().equals("Minimum"))
                minValue=as.getStatisticValue();
            if(as.getStatistic().getStatisticName().equals("Maximum"))
                maxValue=as.getStatisticValue();
        }
            
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
//    public HashMap<String, Double> getStatistics() {
//        return statistics;
//    }
//
//    /**
//     * @param statistics the statistics to set
//     */
//    public void setStatistics(HashMap<String, Double> statistics) {
//        this.statistics = statistics;
//    }

//    @Override
//    public void setPossibleValues(Object object) {
//        
//    }
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
    public Object vratiID() {
        return attributePK;
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
