/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.attribute;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import model.OpstiDomenskiObjekat;

/**
 *
 * @author Jelena
 */
@Entity
@Table(name = "attributetype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attributetype.findAll", query = "SELECT a FROM Attributetype a"),
    @NamedQuery(name = "Attributetype.findByAttribtteTypeID", query = "SELECT a FROM Attributetype a WHERE a.attribtteTypeID = :attribtteTypeID"),
    @NamedQuery(name = "Attributetype.findByAttributeTypeName", query = "SELECT a FROM Attributetype a WHERE a.attributeTypeName = :attributeTypeName")})
public class Attributetype implements Serializable,OpstiDomenskiObjekat {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "attribtteTypeID")
    private Integer attribtteTypeID;
    @Basic(optional = false)
    @Column(name = "attributeTypeName")
    private String attributeTypeName;
    @OneToMany(mappedBy = "dateAttributeType")
    private List<Attribute> attributeList;

    public Attributetype() {
    }

    public Attributetype(Integer attribtteTypeID) {
        this.attribtteTypeID = attribtteTypeID;
    }

    public Attributetype(Integer attribtteTypeID, String attributeTypeName) {
        this.attribtteTypeID = attribtteTypeID;
        this.attributeTypeName = attributeTypeName;
    }

    public Integer getAttribtteTypeID() {
        return attribtteTypeID;
    }

    public void setAttribtteTypeID(Integer attribtteTypeID) {
        this.attribtteTypeID = attribtteTypeID;
    }

    public String getAttributeTypeName() {
        return attributeTypeName;
    }

    public void setAttributeTypeName(String attributeTypeName) {
        this.attributeTypeName = attributeTypeName;
    }

    @XmlTransient
    public List<Attribute> getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(List<Attribute> attributeList) {
        this.attributeList = attributeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attribtteTypeID != null ? attribtteTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attributetype)) {
            return false;
        }
        Attributetype other = (Attributetype) object;
        if ((this.attribtteTypeID == null && other.attribtteTypeID != null) || (this.attribtteTypeID != null && !this.attribtteTypeID.equals(other.attribtteTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return attributeTypeName;
    }

    @Override
    public String vratiImeKlase() {
        return Attributetype.class.getSimpleName();
    }

    @Override
    public String vratiNazivTabele() {
        return "attributetype";
    }

    @Override
    public void prekopirajVrednostiAtributa(OpstiDomenskiObjekat odo) {
        Attributetype at= (Attributetype)odo;
        at.setAttribtteTypeID(attribtteTypeID);
        at.setAttributeTypeName(attributeTypeName);
        at.setAttributeList(attributeList);
    }

    @Override
    public Object vratiID() {
        return attribtteTypeID;
    }

    @Override
    public void postaviAtributPretrazivanja(String atribut) {
        
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return "AttribtteTypeID";
    }

    @Override
    public String vratiNazivNovogObjekta() {
        return "new attributetype";
    }

    @Override
    public String vratiNazivObjekta() {
        return "attributetype";
    }
    
}
