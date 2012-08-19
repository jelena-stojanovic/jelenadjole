/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.guicontrollers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.dataset.Dataset;
import model.dataset.metaattributes.DSMetaAttribute;
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
    }

    public void setPanelAllDS(PanelAllDataSets panelAllDS) {
        this.panelAllDS = panelAllDS;
    }

    public PanelAllDataSets getPanelAllDS() {
        return panelAllDS;
    }
    public ArrayList<Dataset> getAllDataSets(){
        return new ArrayList<Dataset>();
    }
    
  /*  public static ControllerUI_AllDataSets getInstance() {
        return ControllerUI_AllDataSetsHolder.INSTANCE;
    }
*/
    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        
        throw new UnsupportedOperationException("Not supported yet.");
        
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {
       TableModelDataSets tmds=new TableModelDataSets(getAllDataSets());
        panelAllDS.getTblDatasets().setModel(tmds);
    }
    /*
    private static class ControllerUI_AllDataSetsHolder {

        private static final ControllerUI_AllDataSets INSTANCE = new ControllerUI_AllDataSets();
    }*/
}
