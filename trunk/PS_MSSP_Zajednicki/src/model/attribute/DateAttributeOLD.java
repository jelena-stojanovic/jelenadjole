///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package model.attribute;
//
//import java.io.Serializable;
//import java.util.Date;
//import javax.persistence.Entity;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//import javax.xml.bind.annotation.XmlRootElement;
//import model.OpstiDomenskiObjekat;
//
///**
// *
// * @author Jelena
// */
//public class DateAttributeOLD extends Attribute  implements Serializable {
//
////    private HashMap<String, Double> statistics;
//    private String datePatern="MM/dd/yyyy";
//    public DateAttributeOLD() {
//    }
//    
//
//    @Override
//    public boolean isNominal() {
//       return false;
//    }
//
//    @Override
//    public boolean isNumerical() {
//        return false;
//    }
//
//    @Override
//    public boolean isOrdinal() {
//        return false;
//    }
//
//    @Override
//    public boolean isInterval() {
//        return false;
//    }
//
//    @Override
//    public boolean isDate() {
//        return true;
//    }
//
//    
////    public Object getPossibleValues() {
////        double minValue= getStatistics().get(Minimum.class.getName());
////            double maxValue= getStatistics().get(Maximum.class.getName());
////            return "["+getDateFromDouble(minValue)+" - " +getDateFromDouble(maxValue)  +"]";
////    }
//
//    
//    public Date getDateFromDouble(double d){
//        Long time= Math.round(d);
//        Date date= new Date(time);
//        return date;
//    }
//
////    @Override
////    public void setPossibleValues(Object object) {
////        throw new UnsupportedOperationException("Not supported yet.");
////    }
//
////    /**
////     * @return the statistics
////     */
////    public HashMap<String, Double> getStatistics() {
////        return statistics;
////    }
////
////    /**
////     * @param statistics the statistics to set
////     */
////    public void setStatistics(HashMap<String, Double> statistics) {
////        this.statistics = statistics;
////    }
////    
//    
//    @Override
//    public String vratiImeKlase() {
//        return "DateAttribute";
//    }
//
//    @Override
//    public String vratiNazivTabele() {
//        return "attribute";
//    }
//
//    @Override
//    public void prekopirajVrednostiAtributa(OpstiDomenskiObjekat odo) {
//        DateAttributeOLD da= (DateAttributeOLD) odo;
//        da.setAttributePK(attributePK);
//        da.setAttributeRole(this.getAttributeRole());
//        da.setAttributestatisticList(getAttributestatisticList());
//    }
//
//    @Override
//    public Object vratiID() {
//        return attributePK;
//    }
//
//    @Override
//    public void postaviAtributPretrazivanja(String atribut) {
//        
//    }
//
//    @Override
//    public String vratiAtributPretrazivanja() {
//        return "IndexOfAttribute";
//    }
//
//    @Override
//    public String vratiNazivNovogObjekta() {
//        return "new date attribute";
//    }
//
//    @Override
//    public String vratiNazivObjekta() {
//        return "date attribute";
//    }
//
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
//
//}
