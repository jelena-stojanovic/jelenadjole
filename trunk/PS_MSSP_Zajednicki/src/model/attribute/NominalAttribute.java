/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.attribute;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class NominalAttribute extends Attribute implements Serializable {

//    private List<String> possibleNominalValue;
//    private HashMap<String, Double> classToIndexMap = new HashMap<String, Double>();

//    public NominalAttribute( List<String> possibleNominalValue) {
//        this.possibleNominalValue = possibleNominalValue;
//    }
//    
    @Override
    public boolean isNominal() {
        return true;
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
        return false;
    }
    
//    //TODO:vidi da li ces bas ovako
//    @Override
//    public Object getPossibleValues() {
//        return getPossibleNominalValue();
//    }
//
//    /**
//     * @return the possibleNominalValue
//     */
//    public List<String> getPossibleNominalValue() {
//        return possibleNominalValue;
//    }

    /**
     * @param possibleNominalValue the possibleNominalValue to set
     */
//    public void setPossibleNominalValue(List<String> possibleNominalValue) {
//        this.possibleNominalValue = possibleNominalValue;
//    }
//
//    /**
//     * @return the classToIndexMap
//     */
//    public HashMap<String, Double> getClassToIndexMap() {
//        return classToIndexMap;
//    }

    /**
     * @param classToIndexMap the classToIndexMap to set
     */
//    public void setClassToIndexMap(HashMap<String, Double> classToIndexMap) {
//        this.classToIndexMap = classToIndexMap;
//    }

    public NominalAttribute() {
    }

    
    public  double getIndexOfNominalValue(String nominalValue) {
        List<Possibleattributevalue> possibleattributevalueList = getPossibleattributevalueList();
        for (int i = 0; i < possibleattributevalueList.size(); i++) {
            Possibleattributevalue possibleattributevalue = possibleattributevalueList.get(i);
            if(possibleattributevalue.getPossibleattributevaluePK().getIndexOfAttribute()==this.getAttributePK().getIndexOfAttribute()&&possibleattributevalue.getPossibleattributevaluePK().getDatasetID()==this.getAttributePK().getDataSetID()&&possibleattributevalue.getPossibleValue().equals(nominalValue)){
                return possibleattributevalue.getPossibleattributevaluePK().getIndexOfValue();
            }
        }
        return Double.NaN;
    }

    public String getNominalValueFromIndex(double index) throws Exception {
        if(Double.isNaN(index))
            throw new Exception("Index does not have a valid value.");
        
        List<Possibleattributevalue> possibleattributevalueList = getPossibleattributevalueList();
        for (int i = 0; i < possibleattributevalueList.size(); i++) {
            Possibleattributevalue possibleattributevalue = possibleattributevalueList.get(i);
            if(possibleattributevalue.getPossibleattributevaluePK().getIndexOfAttribute()==this.getAttributePK().getIndexOfAttribute()&&possibleattributevalue.getPossibleattributevaluePK().getDatasetID()==this.getAttributePK().getDataSetID()&&possibleattributevalue.getPossibleattributevaluePK().getIndexOfValue()==index){
                return possibleattributevalue.getPossibleValue();
            }
        }
        return null;
    }

//    @Override
//    public void setPossibleValues(Object object) {
//       possibleNominalValue=(List<String>)object;
//    }

    @Override
    public String vratiImeKlase() {
        return "NominalAttribute";
    }

    @Override
    public String vratiNazivTabele() {
        return "attribute";
    }

    @Override
    public void prekopirajVrednostiAtributa(OpstiDomenskiObjekat odo) {
        NominalAttribute noma= (NominalAttribute) odo;
        noma.setAttributePK(attributePK);
        noma.setAttributeRole(this.getAttributeRole());
        
    }

    @Override
    public Object vratiID() {
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
        return "new nominal attribute";
    }

    @Override
    public String vratiNazivObjekta() {
        return "nominal attribute";
    }

    
}
