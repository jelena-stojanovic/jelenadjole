/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.attribute;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import model.OpstiDomenskiObjekat;

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
public class DateAttribute extends Attribute  implements Serializable {

//    private HashMap<String, Double> statistics;
//    private String datePatern="MM/dd/yyyy";
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

    
//    public Object getPossibleValues() {
//        double minValue= getStatistics().get(Minimum.class.getName());
//            double maxValue= getStatistics().get(Maximum.class.getName());
//            return "["+getDateFromDouble(minValue)+" - " +getDateFromDouble(maxValue)  +"]";
//    }



//    /**
//     * @return the datePatern
//     */
//    public String getDatePatern() {
//        return datePatern;
//    }
//
//    /**
//     * @param datePatern the datePatern to set
//     */
//    public void setDatePatern(String datePatern) {
//        this.datePatern = datePatern;
//    }
//    
    
    public Date getDateFromDouble(double d){
        Long time= Math.round(d);
        Date date= new Date(time);
        return date;
    }

//    @Override
//    public void setPossibleValues(Object object) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }

//    /**
//     * @return the statistics
//     */
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
//    
    
    @Override
    public String vratiImeKlase() {
        return "DateAttribute";
    }

    @Override
    public String vratiNazivTabele() {
        return "attribute";
    }

    @Override
    public void prekopirajVrednostiAtributa(OpstiDomenskiObjekat odo) {
        DateAttribute da= (DateAttribute) odo;
        da.setAttributePK(attributePK);
        da.setAttributeRole(this.getAttributeRole());
        da.setAttributestatisticList(getAttributestatisticList());
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
        return "new date attribute";
    }

    @Override
    public String vratiNazivObjekta() {
        return "date attribute";
    }


}
