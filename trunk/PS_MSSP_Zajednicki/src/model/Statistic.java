/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jelena
 */
@Entity
@Table(name = "statistic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Statistic.findAll", query = "SELECT s FROM Statistic s"),
    @NamedQuery(name = "Statistic.findByStatisticID", query = "SELECT s FROM Statistic s WHERE s.statisticID = :statisticID"),
    @NamedQuery(name = "Statistic.findByStatisticName", query = "SELECT s FROM Statistic s WHERE s.statisticName = :statisticName"),
    @NamedQuery(name = "Statistic.findByStatisticDescription", query = "SELECT s FROM Statistic s WHERE s.statisticDescription = :statisticDescription"),
    @NamedQuery(name = "Statistic.findByStatisticClass", query = "SELECT s FROM Statistic s WHERE s.statisticClass = :statisticClass")})
public class Statistic implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "statisticID")
    private Integer statisticID;
    @Column(name = "statisticName")
    private String statisticName;
    @Column(name = "statisticDescription")
    private String statisticDescription;
    @Basic(optional = false)
    @Column(name = "statisticClass")
    private String statisticClass;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statistic")
    private List<Attributestatistic> attributestatisticList;

    public Statistic() {
    }

    public Statistic(Integer statisticID) {
        this.statisticID = statisticID;
    }

    public Statistic(Integer statisticID, String statisticClass) {
        this.statisticID = statisticID;
        this.statisticClass = statisticClass;
    }

    public Integer getStatisticID() {
        return statisticID;
    }

    public void setStatisticID(Integer statisticID) {
        this.statisticID = statisticID;
    }

    public String getStatisticName() {
        return statisticName;
    }

    public void setStatisticName(String statisticName) {
        this.statisticName = statisticName;
    }

    public String getStatisticDescription() {
        return statisticDescription;
    }

    public void setStatisticDescription(String statisticDescription) {
        this.statisticDescription = statisticDescription;
    }

    public String getStatisticClass() {
        return statisticClass;
    }

    public void setStatisticClass(String statisticClass) {
        this.statisticClass = statisticClass;
    }

    @XmlTransient
    public List<Attributestatistic> getAttributestatisticList() {
        return attributestatisticList;
    }

    public void setAttributestatisticList(List<Attributestatistic> attributestatisticList) {
        this.attributestatisticList = attributestatisticList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statisticID != null ? statisticID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statistic)) {
            return false;
        }
        Statistic other = (Statistic) object;
        if ((this.statisticID == null && other.statisticID != null) || (this.statisticID != null && !this.statisticID.equals(other.statisticID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Statistic[ statisticID=" + statisticID + " ]";
    }
    
}
