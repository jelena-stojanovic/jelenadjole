/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.guicontrollers;

import java.util.ArrayList;
import model.dataset.DataSet;
import view.panels.PanelAllDataSets;

/**
 *
 * @author Jelena
 */
public class ControllerUI_AllDataSets {
    
    PanelAllDataSets panelAllDS;
    private ControllerUI_AllDataSets() {
    }

    public void setPanelAllDS(PanelAllDataSets panelAllDS) {
        this.panelAllDS = panelAllDS;
    }

    public PanelAllDataSets getPanelAllDS() {
        return panelAllDS;
    }
    public ArrayList<DataSet> getAllDataSets(){
       SendRequest
        return new ArrayList<DataSet>();
    }
    
    public static ControllerUI_AllDataSets getInstance() {
        return ControllerUI_AllDataSetsHolder.INSTANCE;
    }
    
    private static class ControllerUI_AllDataSetsHolder {

        private static final ControllerUI_AllDataSets INSTANCE = new ControllerUI_AllDataSets();
    }
}
