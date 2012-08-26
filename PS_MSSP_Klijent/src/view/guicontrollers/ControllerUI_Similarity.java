/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.guicontrollers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.OpstiDomenskiObjekat;
import model.attribute.Ontology;
import model.dataset.Dataset;
import model.dataset.Dsmetaattribute;
import to.DataSetTO;
import view.forms.OpstaEkranskaForma;
import view.panels.PanelSimilarity;
import view.panels.tablemodels.TableModelDataSets;

/**
 *
 * @author Jelena
 */
public class ControllerUI_Similarity extends OpstiKontrolerKI {

    private PanelSimilarity panelSimilarity;
    Dataset dataset1;
    Dataset dataset2;
    String similarity ;

    public ControllerUI_Similarity() throws IOException {
        
    }

    private void setSelectedDataSets() {
        if (getPanelSimilarity().getTblAllDatasets() != null) {
            int[] indexes = getPanelSimilarity().getTblAllDatasets().getSelectedRows();

            if (indexes.length != 2) {
                JOptionPane.showMessageDialog(getPanelSimilarity(), "You must select two data sets");
            } else {
                dataset1 = ((TableModelDataSets) (getPanelSimilarity().getTblAllDatasets().getModel())).getDataSet(indexes[0]);
                dataset2 = ((TableModelDataSets) (getPanelSimilarity().getTblAllDatasets().getModel())).getDataSet(indexes[1]);
            }
        }
    }


    /**
     * @return the panelSimilarity
     */
    public PanelSimilarity getPanelSimilarity() {
        return panelSimilarity;
    }

    /**
     * @param panelSimilarity the panelSimilarity to set
     */
    public void setPanelSimilarity(PanelSimilarity panelSimilarity) {
        this.panelSimilarity = panelSimilarity;
    }

    public Dataset getDataset1() {
        return dataset1;
    }

    public Dataset getDataset2() {
        return dataset2;
    }

    public void setSimilarity() {
        this.similarity = String.valueOf(panelSimilarity.getCbSimilarity().getSelectedItem());
    }

    public void setOef(OpstaEkranskaForma oef) {
        this.oef = oef;
    }

    public void setOdo(OpstiDomenskiObjekat odo) {
        this.odo = odo;
    }
    

    double SOCalculateSimilarity() {
    KonvertujGrafickiObjekatUDomenskiObjekat();
        if (dataset1 != null && dataset2 != null) {


            try {
                out.writeObject("CalculateSimilarity");
                out.writeObject(dataset1);
                out.writeObject(dataset2);
                out.writeObject(similarity);
            } catch (IOException ex) {
                Logger.getLogger(OpstiKontrolerKI.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Neuspesno slanje objekata ka serveru.");
            }
            try {
                double d= (Double)in.readObject();
                signal = (String) in.readObject();
                return d;
            } catch (IOException ex) {
                System.err.println("Neuspesno citanje objekata sa servera.");
                Logger.getLogger(OpstiKontrolerKI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                System.err.println("Neuspesno citanje objekata sa servera.");
                Logger.getLogger(OpstiKontrolerKI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Double.NaN;
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        setSelectedDataSets();
        setSimilarity();
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {
        TableModelDataSets tmds = new TableModelDataSets(getAllDataSets(),getAllDataMetaAttributes());
        fillCB();
        panelSimilarity.getTblAllDatasets().setModel(tmds);
    }
    
    
    private void fillCB(){
        panelSimilarity.getCbSimilarity().addItem("CalculateCosineSimilarity");
        panelSimilarity.getCbSimilarity().addItem("CalculateEuclidianSimilarity");
    }
    private List<Dataset> getAllDataSets(){
        Dataset ds= new Dataset();
        panelSimilarity.setOdo(ds);
        List<OpstiDomenskiObjekat> lodo = SOVratiSve();
        ArrayList<Dataset> dslist = new ArrayList<Dataset>();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : lodo) {
            dslist.add(new Dataset((DataSetTO)opstiDomenskiObjekat));
        }
        return dslist;
    }
    private List<Dsmetaattribute> getAllDataMetaAttributes(){
        
        Dsmetaattribute ds= new Dsmetaattribute();
        panelSimilarity.setOdo(ds);
        List<OpstiDomenskiObjekat> lodo = SOVratiSve();
        ArrayList<Dsmetaattribute> dslist = new ArrayList<Dsmetaattribute>();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : lodo) {
            dslist.add((Dsmetaattribute)opstiDomenskiObjekat);
        }
        return dslist;
    }

    public void calculateSimilarity() {
        panelSimilarity.getLblSimilarityResult().setText(String.valueOf(SOCalculateSimilarity()));
    }
}
