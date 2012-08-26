/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controllers;

import tools.KonverterTipova;
import javax.swing.JOptionPane;
import logic.ControllerAL_Main;
import model.Administrator;
import model.OpstiDomenskiObjekat;
import view.forms.FrmStart;
import view.forms.OpstaEkranskaForma;

/**
 *
 * @author Jelena
 */
public class ControllerUI_Login extends OpstiKontrolerKI{

    public void setOdo(OpstiDomenskiObjekat odo) {
        this.odo = odo;
    }

    public void setOef(OpstaEkranskaForma oef) {
        this.oef = oef;
    }

    
    
    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        Administrator admin= new Administrator();
        FrmStart fst=(FrmStart) oef;
        admin.setUsername(KonverterTipova.Konvertuj(fst.getTfUserName(), signal));
        admin.setPassword(String.valueOf(fst.getPfPassword().getPassword()));
        
        odo=admin;
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void login(){
        KonvertujGrafickiObjekatUDomenskiObjekat();
        odo = ControllerAL_Main.getInstance().login(odo);
        if(odo!=null){
            JOptionPane.showMessageDialog((FrmStart)oef,"Welcome, "+((Administrator)odo).getFirstName()+" "+((Administrator)odo).getLastName() +"! :)");
            ControllerUI_Main.getInstance().startApplication();
            ((FrmStart)oef).dispose();
       
        }
        else{
            JOptionPane.showMessageDialog((FrmStart)oef,"Wrong username or password!", "Error", JOptionPane.ERROR_MESSAGE);
           //((FrmStart)oef).getTfUserName().setText("");
           ((FrmStart)oef).getPfPassword().setText("");
        }
    }
}
