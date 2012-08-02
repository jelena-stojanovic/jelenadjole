/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controllers;

/**
 *
 * @author Jelena
 */
public class ControllerUI_Main {
    
    private ControllerUI_Main() {
    }
    
    public static ControllerUI_Main getInstance() {
        return ControllerUI_MainHolder.INSTANCE;
    }
    
    private static class ControllerUI_MainHolder {

        private static final ControllerUI_Main INSTANCE = new ControllerUI_Main();
    }
}
