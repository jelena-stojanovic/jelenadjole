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
import model.OpstiDomenskiObjekat;

/**
 *
 * @author Jelena
 */
public class NominalAttribute extends Attribute implements Serializable {

    private List<String> possibleNominalValue;
    private HashMap<String, Double> classToIndexMap = new HashMap<String, Double>();

    public NominalAttribute( List<String> possibleNominalValue) {
        this.possibleNominalValue = possibleNominalValue;
    }
    
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
    
    //TODO:vidi da li ces bas ovako
    @Override
    public Object getPossibleValues() {
        return getPossibleNominalValue();
    }

    /**
     * @return the possibleNominalValue
     */
    public List<String> getPossibleNominalValue() {
        return possibleNominalValue;
    }

    /**
     * @param possibleNominalValue the possibleNominalValue to set
     */
    public void setPossibleNominalValue(List<String> possibleNominalValue) {
        this.possibleNominalValue = possibleNominalValue;
    }

    /**
     * @return the classToIndexMap
     */
    public HashMap<String, Double> getClassToIndexMap() {
        return classToIndexMap;
    }

    /**
     * @param classToIndexMap the classToIndexMap to set
     */
    public void setClassToIndexMap(HashMap<String, Double> classToIndexMap) {
        this.classToIndexMap = classToIndexMap;
    }

    public NominalAttribute() {
    }

    
    public  double getIndexOfNominalValue(String nominalValue) {
        return classToIndexMap.get(nominalValue);
    }

    public String getNominalValueFromIndex(double index) throws Exception {
        if(Double.isNaN(index))
            
            throw new Exception("Index does not have a valid value.");
        for (Map.Entry<String, Double> entry : classToIndexMap.entrySet()) {
            String string = entry.getKey();
            Double double1 = entry.getValue();
            if (double1 == index) {
                return string;
            }
        }
        return null;
    }

    @Override
    public void setPossibleValues(Object object) {
       possibleNominalValue=(List<String>)object;
    }

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
        return "new nominal attribute";
    }

    @Override
    public String vratiNazivObjekta() {
        return "nominal attribute";
    }

    
}
