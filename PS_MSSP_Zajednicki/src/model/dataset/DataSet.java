/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset;

import java.sql.ResultSet;
import java.util.List;
import model.Instance;
import model.OpstiDomenskiObjekat;
import model.Reference;
import model.attribute.Attribute;
import model.dataset.metaattributes.DSMetaAttribute;


/**
 *
 * @author Jelena
 */
public class DataSet implements OpstiDomenskiObjekat {
    
    private int dataSetID;
    private String title;
    private String dsDescription;
    private Source source;
    private List<Reference> references;

    
    private List<Attribute> attributes;
    private List<Instance> instances;
        
    private List<DSMetaAttribute> metaAttributes;
    
    private DataTable dataTable;

    /**
     * @return the dataSetID
     */
    public int getDataSetID() {
        return dataSetID;
    }

    /**
     * @param dataSetID the dataSetID to set
     */
    public void setDataSetID(int dataSetID) {
        this.dataSetID = dataSetID;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the dsDescription
     */
    public String getDsDescription() {
        return dsDescription;
    }

    /**
     * @param dsDescription the dsDescription to set
     */
    public void setDsDescription(String dsDescription) {
        this.dsDescription = dsDescription;
    }

    /**
     * @return the source
     */
    public Source getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(Source source) {
        this.source = source;
    }

    /**
     * @return the references
     */
    public List<Reference> getReferences() {
        return references;
    }

    /**
     * @param references the references to set
     */
    public void setReferences(List<Reference> references) {
        this.references = references;
    }

    /**
     * @return the attributes
     */
    public List<Attribute> getAttributes() {
        return attributes;
    }

    /**
     * @param attributes the attributes to set
     */
    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    /**
     * @return the instances
     */
    public List<Instance> getInstances() {
        return instances;
    }

    /**
     * @param instances the instances to set
     */
    public void setInstances(List<Instance> instances) {
        this.instances = instances;
    }

    /**
     * @return the metaAttributes
     */
    public List<DSMetaAttribute> getMetaAttributes() {
        return metaAttributes;
    }

    /**
     * @param metaAttributes the metaAttributes to set
     */
    public void setMetaAttributes(List<DSMetaAttribute> metaAttributes) {
        this.metaAttributes = metaAttributes;
    }

    /**
     * @return the dataTable
     */
    public DataTable getDataTable() {
        return dataTable;
    }

    /**
     * @param dataTable the dataTable to set
     */
    public void setDataTable(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    @Override
    public String vratiVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String postaviVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String vratiImeKlase() {
        return "DataSet";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String vratiAtributPretrazivanja() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean Napuni(ResultSet RSslog) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int povecajBroj(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OpstiDomenskiObjekat vratiVezaniObjekat(int brojVezanogObjekta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void Napuni(ResultSet RSslog, int brojSloga, int brojVezanogObjekta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void kreirajVezaniObjekat(int brojStavkiVezanogObjekta, int brojVezanogObjekta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int vratiBrojVezanihObjekata() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void postaviPocetniBroj() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OpstiDomenskiObjekat vratiSlogVezanogObjekta(int brojVezanogObjekta, int brojSloga) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int vratiBrojSlogovaVezanogObjekta(int brojVezanogObjekta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean vrednosnaOgranicenja() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void Obradi() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void Storniraj() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String vratiNazivNovogObjekta() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String vratiNazivObjekta() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
