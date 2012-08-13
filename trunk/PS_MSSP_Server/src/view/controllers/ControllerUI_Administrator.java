/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controllers;

import java.io.IOException;
import model.Administrator;
import view.forms.FrmAdministrator;

/**
 * 0
 *
 * @author Djordje
 */
public class ControllerUI_Administrator extends OpstiKontrolerKI {

    public ControllerUI_Administrator(FrmAdministrator frmAdmin) throws IOException {
        oef = frmAdmin;
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
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
