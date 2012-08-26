///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package model.attribute;
//
//import java.io.Serializable;
//import java.util.List;
//import javax.persistence.*;
//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlTransient;
//import model.OpstiDomenskiObjekat;
//
///**
// *
// * @author Jelena
// */
//@Entity
//@Table(name = "nominalattribute")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Nominalattribute.findAll", query = "SELECT n FROM Nominalattribute n"),
//    @NamedQuery(name = "Nominalattribute.findByIndexOfAttribute", query = "SELECT n FROM Nominalattribute n WHERE n.nominalattributePK.indexOfAttribute = :indexOfAttribute"),
//    @NamedQuery(name = "Nominalattribute.findByDataSetID", query = "SELECT n FROM Nominalattribute n WHERE n.nominalattributePK.dataSetID = :dataSetID")})
//public class Nominalattribute implements Serializable, OpstiDomenskiObjekat {
//    private static final long serialVersionUID = 1L;
//    @EmbeddedId
//    protected NominalattributePK nominalattributePK;
//    
//    @JoinColumns({
//    @JoinColumn(name = "dataSetID", referencedColumnName = "dataSetID", insertable = false, updatable = false),    
//    @JoinColumn(name = "indexOfAttribute", referencedColumnName = "indexOfAttribute", insertable = false, updatable = false)    
//    })
//    @OneToOne(optional = false)
//    private Attribute attribute;
//    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nominalattribute")
//    private List<Possibleattributevalue> possibleattributevalueList;
//    public Nominalattribute() {
//    }
//
//    public Nominalattribute(NominalattributePK nominalattributePK) {
//        this.nominalattributePK = nominalattributePK;
//    }
//
//    public Nominalattribute(int indexOfAttribute, int dataSetID) {
//        this.nominalattributePK = new NominalattributePK(indexOfAttribute, dataSetID);
//    }
//
//    public NominalattributePK getNominalattributePK() {
//        return nominalattributePK;
//    }
//
//    public void setNominalattributePK(NominalattributePK nominalattributePK) {
//        this.nominalattributePK = nominalattributePK;
//    }
//
//    public Attribute getAttribute() {
//        return attribute;
//    }
//
//    public void setAttribute(Attribute attribute) {
//        this.attribute = attribute;
//    }
//
//    
//    @XmlTransient
//    public List<Possibleattributevalue> getPossibleattributevalueList() {
//        return possibleattributevalueList;
//    }
//
//    public void setPossibleattributevalueList(List<Possibleattributevalue> possibleattributevalueList) {
//        this.possibleattributevalueList = possibleattributevalueList;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (nominalattributePK != null ? nominalattributePK.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Nominalattribute)) {
//            return false;
//        }
//        Nominalattribute other = (Nominalattribute) object;
//        if ((this.nominalattributePK == null && other.nominalattributePK != null) || (this.nominalattributePK != null && !this.nominalattributePK.equals(other.nominalattributePK))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "model.attribute.Nominalattribute[ nominalattributePK=" + nominalattributePK + " ]";
//    }
//
//    
//    
//     
//    public boolean isNominal() {
//        return true;
//    }
//
//    public boolean isNumerical() {
//        return false;
//    }
//
//    public boolean isOrdinal() {
//        return false;
//    }
//
//    public boolean isInterval() {
//        return false;
//    }
//
//    public boolean isDate() {
//        return false;
//    }
//    public String getNominalValueFromIndex(double index) throws Exception {
//        if(Double.isNaN(index))
//            throw new Exception("Index does not have a valid value.");
//        
//        
//        for (int i = 0; i < possibleattributevalueList.size(); i++) {
//            Possibleattributevalue possibleattributevalue = possibleattributevalueList.get(i);
//            if(possibleattributevalue.getPossibleattributevaluePK().getIndexOfAttribute()==nominalattributePK.getIndexOfAttribute()&&possibleattributevalue.getPossibleattributevaluePK().getDatasetID()==nominalattributePK.getDataSetID()&&possibleattributevalue.getPossibleattributevaluePK().getIndexOfValue()==index){
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
//        Nominalattribute noma= (Nominalattribute) odo;
//        noma.setNominalattributePK(nominalattributePK);
//        noma.setPossibleattributevalueList(possibleattributevalueList);
//        
//    }
//
//    @Override
//    public Object vratiID() {
//        return nominalattributePK;
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
//    
//}
