///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package model.attribute;
//
//import java.io.Serializable;
//import java.util.List;
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
//
//public class NominalAttributeOLD extends Attribute implements Serializable {
//
//    public NominalAttributeOLD(int indexOfAttribute, int dataSetID) {
//        super(indexOfAttribute, dataSetID);
//    }
//
//    public NominalAttributeOLD(AttributePK attributePK) {
//        super(attributePK);
//    }
//
////    private List<String> possibleNominalValue;
////    private HashMap<String, Double> classToIndexMap = new HashMap<String, Double>();
//
////    public NominalAttributeOLD( List<String> possibleNominalValue) {
////        this.possibleNominalValue = possibleNominalValue;
////    }
////    
//    @Override
//    public boolean isNominal() {
//        return true;
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
//     @Override
//    public boolean isInterval() {
//        return false;
//    }
//
//    @Override
//    public boolean isDate() {
//        return false;
//    }
//    
////    //TODO:vidi da li ces bas ovako
////    @Override
////    public Object getPossibleValues() {
////        return getPossibleNominalValue();
////    }
////
////    /**
////     * @return the possibleNominalValue
////     */
////    public List<String> getPossibleNominalValue() {
////        return possibleNominalValue;
////    }
//
////    public void setPossibleNominalValue(List<String> possibleNominalValue) {
////        this.possibleNominalValue = possibleNominalValue;
////    }
////
////    /**
////     * @return the classToIndexMap
////     */
////    public HashMap<String, Double> getClassToIndexMap() {
////        return classToIndexMap;
////    }
//
//    
////    public void setClassToIndexMap(HashMap<String, Double> classToIndexMap) {
////        this.classToIndexMap = classToIndexMap;
////    }
//
//    public NominalAttributeOLD() {
//    }
//
//    
//    public  double getIndexOfNominalValue(String nominalValue) {
//        List<Possibleattributevalue> possibleattributevalueList = getPossibleattributevalueList();
//        for (int i = 0; i < possibleattributevalueList.size(); i++) {
//            Possibleattributevalue possibleattributevalue = possibleattributevalueList.get(i);
//            if(possibleattributevalue.getPossibleattributevaluePK().getIndexOfAttribute()==this.getAttributePK().getIndexOfAttribute()&&possibleattributevalue.getPossibleattributevaluePK().getDatasetID()==this.getAttributePK().getDataSetID()&&possibleattributevalue.getPossibleValue().equals(nominalValue)){
//                return possibleattributevalue.getPossibleattributevaluePK().getIndexOfValue();
//            }
//        }
//        return Double.NaN;
//    }
//
//    public String getNominalValueFromIndex(double index) throws Exception {
//        if(Double.isNaN(index))
//            throw new Exception("Index does not have a valid value.");
//        
//        List<Possibleattributevalue> possibleattributevalueList = getPossibleattributevalueList();
//        for (int i = 0; i < possibleattributevalueList.size(); i++) {
//            Possibleattributevalue possibleattributevalue = possibleattributevalueList.get(i);
//            if(possibleattributevalue.getPossibleattributevaluePK().getIndexOfAttribute()==this.getAttributePK().getIndexOfAttribute()&&possibleattributevalue.getPossibleattributevaluePK().getDatasetID()==this.getAttributePK().getDataSetID()&&possibleattributevalue.getPossibleattributevaluePK().getIndexOfValue()==index){
//                return possibleattributevalue.getPossibleValue();
//            }
//        }
//        return null;
//    }
//
////    @Override
////    public void setPossibleValues(Object object) {
////       possibleNominalValue=(List<String>)object;
////    }
//
//    @Override
//    public String vratiImeKlase() {
//        return "NominalAttribute";
//    }
//
//    @Override
//    public String vratiNazivTabele() {
//        return "attribute";
//    }
//
//    @Override
//    public void prekopirajVrednostiAtributa(OpstiDomenskiObjekat odo) {
//        NominalAttributeOLD noma= (NominalAttributeOLD) odo;
//        noma.setAttributePK(attributePK);
//        noma.setAttributeRole(this.getAttributeRole());
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
//        return "new nominal attribute";
//    }
//
//    @Override
//    public String vratiNazivObjekta() {
//        return "nominal attribute";
//    }
//
//    
//}
