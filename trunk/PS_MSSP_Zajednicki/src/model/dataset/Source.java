/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "source")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Source.findAll", query = "SELECT s FROM Source s"),
    @NamedQuery(name = "Source.findBySourceID", query = "SELECT s FROM Source s WHERE s.sourceID = :sourceID"),
    @NamedQuery(name = "Source.findByCreator", query = "SELECT s FROM Source s WHERE s.creator = :creator"),
    @NamedQuery(name = "Source.findByDonor", query = "SELECT s FROM Source s WHERE s.donor = :donor"),
    @NamedQuery(name = "Source.findBySourceDate", query = "SELECT s FROM Source s WHERE s.sourceDate = :sourceDate")})

public class Source implements OpstiDomenskiObjekat, Serializable {
    @Column(name =     "sourceDate")
    @Temporal(TemporalType.DATE)
    private Date sourceDate;

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="seq", sequenceName="seq") 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
    @Basic(optional = false)
    @Column(name = "sourceID")
    private Integer sourceID;
    @Column(name = "creator")
    private String creator;
    @Column(name = "donor")
    private String donor;
    @OneToMany(mappedBy = "source")
    private List<Dataset> datasetList;
    
    public Source() {
    }

    public Source(Integer sourceID) {
        this.sourceID = sourceID;
    }

    public Integer getSourceID() {
        return sourceID;
    }

    public void setSourceID(Integer sourceID) {
        this.sourceID = sourceID;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDonor() {
        return donor;
    }

    public void setDonor(String donor) {
        this.donor = donor;
    }

    @XmlTransient
    public List<Dataset> getDatasetList() {
        return datasetList;
    }

    public void setDatasetList(List<Dataset> datasetList) {
        this.datasetList = datasetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sourceID != null ? sourceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Source)) {
            return false;
        }
        Source other = (Source) object;
        if ((this.sourceID == null && other.sourceID != null) || (this.sourceID != null && !this.sourceID.equals(other.sourceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Source[ sourceID=" + sourceID + " ]";
    }

    
    
//    @Override
//    public String vratiVrednostiAtributa() {
//        java.sql.Date sqlDate = KonverterTipova.Konvertuj(sourceDate);
//        return "" + sourceID + ", '" + creator + "', '" + donor + ", " + sqlDate;
//    }
//
//    @Override
//    public String postaviVrednostiAtributa() {
//        java.sql.Date sqlDate = KonverterTipova.Konvertuj(sourceDate);
//        return "sourceID = " + sourceID + ", creator ='" + creator + "', donor ='" + donor + "', date = "
//                + sqlDate;
//    }

    @Override
    public String vratiImeKlase() {
        return "Source";
    }

//    @Override
//    public String vratiUslovZaNadjiSlog() {
//        return " sourceID = '" + sourceID + "'";
//    }
//
//    @Override
//    public String vratiUslovZaNadjiSlogove() {
//        return "";
//    }
//
//
//    @Override
//    public boolean Napuni(ResultSet RSslog) {
//        try {
//            sourceID = KonverterTipova.Konvertuj(RSslog, sourceID, "sourceID");
//            creator = KonverterTipova.Konvertuj(RSslog, creator, "creator");
//            donor = KonverterTipova.Konvertuj(RSslog, donor, "donor");
//            sourceDate = KonverterTipova.Konvertuj(KonverterTipova.Konvertuj(RSslog, "date"));
//        } catch (Exception e) {
//            System.out.println(e);
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public int povecajBroj(ResultSet rs) {
//        try {
//            sourceID = KonverterTipova.Konvertuj(rs, sourceID, "sourceID");
//            return ++sourceID;
//        } catch (Exception e) {
//            System.out.println("Izuzetak kod generisanja novog broja racuna: " + e);
//            return 0;
//        }
//    }
//
//    @Override
//    public OpstiDomenskiObjekat vratiVezaniObjekat(int brojVezanogObjekta) {
//        return null;
//    }
//
//    @Override
//    public void Napuni(ResultSet RSslog, int brojSloga, int brojVezanogObjekta) {
//    }
//
//    @Override
//    public void kreirajVezaniObjekat(int brojStavkiVezanogObjekta, int brojVezanogObjekta) {
//    }
//
//    @Override
//    public int vratiBrojVezanihObjekata() {
//        return -1;
//    }
//
//    @Override
//    public void postaviPocetniBroj() {
//        sourceID = 1;
//    }
//
//    @Override
//    public OpstiDomenskiObjekat vratiSlogVezanogObjekta(int brojVezanogObjekta, int brojSloga) {
//        return null;
//    }
//
//    @Override
//    public int vratiBrojSlogovaVezanogObjekta(int brojVezanogObjekta) {
//        return -1;
//    }
//
//    @Override
//    public boolean vrednosnaOgranicenja() {
//        Date newDate = new Date();
//        if (sourceDate.before(newDate)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    @Override
//    public void Obradi() {
//    }
//
//    @Override
//    public void Storniraj() {
//    }
//
    @Override
    public String vratiNazivNovogObjekta() {
        return "new source";
    }

    @Override
    public String vratiNazivObjekta() {
        return "source";
    }

    @Override
    public String vratiNazivTabele() {
        return "source";
    }

    @Override
    public void prekopirajVrednostiAtributa(OpstiDomenskiObjekat odo) {
        
        Source source = (Source) odo;
        source.setCreator(creator);
        source.setDonor(donor);
        source.setSourceDate(sourceDate);
        
    }
@Override
    public Object vratiID() {
        return sourceID;
    }

   
    @Override
    public void postaviAtributPretrazivanja(String atribut) {
        
    }
    @Override
    public String vratiAtributPretrazivanja() {
        //return "dataSetID";
        return "SourceID";
    }

    public Date getSourceDate() {
        return sourceDate;
    }

    public void setSourceDate(Date sourceDate) {
        this.sourceDate = sourceDate;
    }
    
}
