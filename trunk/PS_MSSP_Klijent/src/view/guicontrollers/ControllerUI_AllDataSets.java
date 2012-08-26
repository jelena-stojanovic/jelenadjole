/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.guicontrollers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.OpstiDomenskiObjekat;
import model.dataset.Dataset;
import model.dataset.Dsmetaattribute;
import to.DataSetTO;
import view.panels.PanelAllDataSets;
import view.panels.tablemodels.TableModelDataSets;

/**
 *
 * @author Jelena
 */
public class ControllerUI_AllDataSets extends OpstiKontrolerKI{
    
    PanelAllDataSets panelAllDS;
    public ControllerUI_AllDataSets(PanelAllDataSets panelAllDataSets) throws IOException {
        super();
        this.panelAllDS=panelAllDataSets;
        oef=panelAllDataSets;
        KonvertujDomenskiObjekatUGrafickiObjekat();
    }

    public void setPanelAllDS(PanelAllDataSets panelAllDS) {
        this.panelAllDS = panelAllDS;
    }

    public PanelAllDataSets getPanelAllDS() {
        return panelAllDS;
    }
    private List<Dataset> getAllDataSets(){
        Dataset ds= new Dataset();
        panelAllDS.setOdo(ds);
        List<OpstiDomenskiObjekat> lodo = SOVratiSve();
        ArrayList<Dataset> dslist = new ArrayList<Dataset>();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : lodo) {
            dslist.add(new Dataset((DataSetTO)opstiDomenskiObjekat));
        }
        return dslist;
    }
    private List<Dsmetaattribute> getAllDataMetaAttributes(){
        
        Dsmetaattribute ds= new Dsmetaattribute();
        panelAllDS.setOdo(ds);
        List<OpstiDomenskiObjekat> lodo = SOVratiSve();
        ArrayList<Dsmetaattribute> dslist = new ArrayList<Dsmetaattribute>();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : lodo) {
            dslist.add((Dsmetaattribute)opstiDomenskiObjekat);
        }
        return dslist;
    }
  /*  public static ControllerUI_AllDataSets getInstance() {
        return ControllerUI_AllDataSetsHolder.INSTANCE;
    }
*/
    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        int rowIndex= panelAllDS.getTblDatasets().getSelectedRow();
        Dataset ds= ((TableModelDataSets)panelAllDS.getTblDatasets().getModel()).getDataSet(rowIndex);
        odo=ds;
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {
       TableModelDataSets tmds=new TableModelDataSets(getAllDataSets(), getAllDataMetaAttributes());
        panelAllDS.getTblDatasets().setModel(tmds);
    }
    /*
    private static class ControllerUI_AllDataSetsHolder {

        private static final ControllerUI_AllDataSets INSTANCE = new ControllerUI_AllDataSets();
    }*/
}
