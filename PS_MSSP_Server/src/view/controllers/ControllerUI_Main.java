/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controllers;

import javax.swing.JPanel;
import view.forms.FrmMain;

/**
 *
 * @author Jelena
 */
public class ControllerUI_Main {
    
    FrmMain mainForm;
    private ControllerUI_Main() {
        mainForm= new FrmMain();
        
    }
    
    public static ControllerUI_Main getInstance() {
        return ControllerUI_MainHolder.INSTANCE;
    }
    
    private static class ControllerUI_MainHolder {

        private static final ControllerUI_Main INSTANCE = new ControllerUI_Main();
    }
    
    public void setActivePanel(JPanel newPanel){
        mainForm.setActivePanel(newPanel);
    }

    public void startApplication(){
        mainForm.setVisible(true);
    }
}
