///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package model.attribute;
//
//import java.io.Serializable;
//import java.lang.reflect.InvocationTargetException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.persistence.Entity;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//import javax.xml.bind.annotation.XmlRootElement;
//import model.Attributestatistic;
//import model.OpstiDomenskiObjekat;
//import model.statistics.Maximum;
//import model.statistics.Minimum;
//import model.statistics.NumericalStatistic;
//
//
///**
// *
// * @author Jelena
// */
//public class NumericalAttributeOLD extends Attribute implements Serializable {
//
//    public NumericalAttributeOLD() {
//        
//        
//    }
//
//    public NumericalAttributeOLD(int indexOfAttribute, int dataSetID) {
//        super(indexOfAttribute, dataSetID);
//    }
//
//  //  private HashMap<String, Double> statistics;
//
//    public NumericalAttributeOLD(AttributePK attributePK) {
//        super(attributePK);
//    }
//
//    
//    @Override
//    public boolean isNominal() {
//         return false;
//    }
//
//    @Override
//    public boolean isNumerical() {
//         return true;
//    }
//
//    @Override
//    public boolean isOrdinal() {
//         return false;
//    }
//
//    public Object getPossibleValues() {
//        double minValue=0;
//        double maxValue=0;
//            
//        for (int i = 0; i < getAttributestatisticList().size(); i++) {
//            Attributestatistic as = getAttributestatisticList().get(i);
//            if(as.getStatistic().getStatisticName().equals("Minimum"))
//                minValue=as.getStatisticValue();
//            if(as.getStatistic().getStatisticName().equals("Maximum"))
//                maxValue=as.getStatisticValue();
//        }
//            
//            return "["+minValue+" - " +maxValue +"]";
//        
//    }
//
//    @Override
//    public boolean isInterval() {
//        return false;
//    }
//
//    @Override
//    public boolean isDate() {
//        return false;
//    }
//
//  
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
//
////    @Override
////    public void setPossibleValues(Object object) {
////        
////    }
//@Override
//    public String vratiImeKlase() {
//        return "NumericalAttribute";
//    }
//
//    @Override
//    public String vratiNazivTabele() {
//        return "attribute";
//    }
//
//    @Override
//    public void prekopirajVrednostiAtributa(OpstiDomenskiObjekat odo) {
//        NumericalAttributeOLD na= (NumericalAttributeOLD) odo;
//        na.setAttributePK(attributePK);
//        na.setAttributeRole(this.getAttributeRole());
//        
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
//        return "new numerical attribute";
//    }
//
//    @Override
//    public String vratiNazivObjekta() {
//        return "numerical attribute";
//    }
//
//  
//    
//}
