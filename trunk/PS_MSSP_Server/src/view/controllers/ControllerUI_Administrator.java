/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controllers;

import tools.KonverterTipova;
import java.io.IOException;
import java.util.List;
import logic.ControllerAL_Main;
import model.Administrator;
import model.OpstiDomenskiObjekat;
import view.forms.FrmAdministrator;
import view.forms.OpstaEkranskaForma;
import view.panels.importDSpanel.PanelAllAdmins;
import view.panels.importDSpanel.model.TableModelAdministrator;

/**
 * 0
 *
 * @author Jelena
 */
public class ControllerUI_Administrator extends OpstiKontrolerKI {

    PanelAllAdmins panelAllAdmins;
    public ControllerUI_Administrator() {
    }

    public ControllerUI_Administrator(FrmAdministrator frmAdmin){
        oef = frmAdmin;
    }

    
    public void setOef(OpstaEkranskaForma oef) {
        this.oef = oef;
        KonvertujDomenskiObjekatUGrafickiObjekat();
    }

    public void setOdo(OpstiDomenskiObjekat odo) {
        this.odo = odo;
    }

    public void setPanelAllAdmins(PanelAllAdmins panelAllAdmins) {
        this.panelAllAdmins = panelAllAdmins;
        setTableModel();
    }

    public PanelAllAdmins getPanelAllAdmins() {
        return panelAllAdmins;
    }

    public void setTableModel(){
        List<Administrator> admins= ControllerAL_Main.getInstance().getAllAdmins();
//        Administrator[] adminArray= new Administrator[admins.size()];
//        for (int i = 0; i < admins.size(); i++) {
//            Administrator administrator = admins.get(i);
//            adminArray[i]=administrator;
//        }
        panelAllAdmins.getTblAllAdmins().setModel(new TableModelAdministrator(admins));
        //KonverterTipova.KonvertujNizObjekataUTabelu(adminArray, panelAllAdmins.getTblAllAdmins());
    }
    
    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        if(odo==null){
            odo=oef.kreirajObjekat();
        }
        Administrator admin = (Administrator) odo;
        FrmAdministrator frmAdmin = (FrmAdministrator) oef;
        admin.setUsername(KonverterTipova.Konvertuj(frmAdmin.getUsername(), admin.getUsername()));
        admin.setPassword(KonverterTipova.Konvertuj(frmAdmin.getPassword(), admin.getPassword()));
        admin.setFirstName(KonverterTipova.Konvertuj(frmAdmin.getFirstName(), admin.getFirstName()));
        admin.setLastName(KonverterTipova.Konvertuj(frmAdmin.getLastName(), admin.getLastName()));
        admin.setEmail(KonverterTipova.Konvertuj(frmAdmin.getEmail(), admin.getEmail()));
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {
        Administrator admin = (Administrator) odo;
        FrmAdministrator frmadmin = (FrmAdministrator) oef;
        KonverterTipova.Konvertuj(admin.getUsername(), frmadmin.getUsername());
        KonverterTipova.Konvertuj(admin.getPassword(), frmadmin.getPassword());
        KonverterTipova.Konvertuj(admin.getFirstName(), frmadmin.getFirstName());
        KonverterTipova.Konvertuj(admin.getLastName(), frmadmin.getLastName());
        KonverterTipova.Konvertuj(admin.getEmail(), frmadmin.getEmail());
    }
    
    
}
