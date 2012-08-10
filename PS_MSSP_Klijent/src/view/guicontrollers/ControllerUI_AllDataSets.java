/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.guicontrollers;

import java.io.IOException;
import java.util.ArrayList;
import model.dataset.DataSet;
import view.panels.PanelAllDataSets;
import view.panels.TableModelDataSets;

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
    public ArrayList<DataSet> getAllDataSets(){
        return new ArrayList<DataSet>();
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
