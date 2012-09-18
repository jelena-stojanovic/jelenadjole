/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controller;

import gui.forms.coordinator.FormCoordinator;
import gui.panels.PanelHome;
import model.FPUser;


/**
 *
 * @author Jelena
 */
public class ControllerFPUser {
    
    private static ControllerFPUser instance;
    private FPUser activeUser ;
    
    private ControllerFPUser () {
        activeUser = null;
        
    }
    public static ControllerFPUser getInstance() {
        if(instance==null)
            instance = new ControllerFPUser();
        
            return instance;
    }
    public FPUser getActiveUser () {
        return activeUser;
    }
    public void setActiveUser (FPUser activeUser) {
        this.activeUser=activeUser;
    }
    
    
    public boolean activeUserExist(){
        return (getActiveUser()!=null);
    }
    
    
    
    public void forbidAccess() throws Exception{
       if(!ControllerFPUser.getInstance().activeUserExist()){
        FormCoordinator.getInstance().setNewPanel(new PanelHome());
        throw new Exception("Ne mozete pristupiti ovom panelu, morate se ulogovati");        
       }
    }
    
    
}
