/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import view.controllers.KonverterTipova;

/**
 *
 * @author Djordje
 */
public class Administrator implements OpstiDomenskiObjekat {

    private int adminID;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    public Administrator(String username, String password, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Administrator(int adminID, String username, String password, String firstName, String lastName, String email) {
        this.adminID = adminID;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Administrator() {
    }

    @Override
    public String vratiVrednostiAtributa() {
        return "" + adminID + ", '" + username + "', '" + password + "', '" + firstName + "', '" + lastName + "', '" + email + "', '";
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "adminID = " + adminID + ", username ='" + username + "', password = '"
                + password + "', firstName = '" + firstName + "', lastName = '" + lastName + "', email= " + email + "";
    }

    @Override
    public String vratiImeKlase() {
        return "Administrator";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return " adminID = " + adminID + "";
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return "";
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return "adminID";
    }

    @Override
    public boolean Napuni(ResultSet RSslog) {
        try {
            adminID = KonverterTipova.Konvertuj(RSslog, adminID, "adminID");
            username = KonverterTipova.Konvertuj(RSslog, username, "username");
            password = KonverterTipova.Konvertuj(RSslog, password, "password");
            firstName = KonverterTipova.Konvertuj(RSslog, firstName, "firstName");
            lastName = KonverterTipova.Konvertuj(RSslog, lastName, "lastName");
            email = KonverterTipova.Konvertuj(RSslog, email, "email");
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public int povecajBroj(ResultSet rs) {
        try {
            adminID = tools.KonverterTipova.Konvertuj(rs, adminID, "adminID");
            return ++adminID;
        } catch (Exception e) {
            System.out.println("Izuzetak kod generisanja novog broja racuna: " + e);
            return 0;
        }
    }

    @Override
    public OpstiDomenskiObjekat vratiVezaniObjekat(int brojVezanogObjekta) {
        return null;
    }

    @Override
    public void Napuni(ResultSet RSslog, int brojSloga, int brojVezanogObjekta) {
    }

    @Override
    public void kreirajVezaniObjekat(int brojStavkiVezanogObjekta, int brojVezanogObjekta) {
    }

    @Override
    public int vratiBrojVezanihObjekata() {
        return -1;
    }

    @Override
    public void postaviPocetniBroj() {
        adminID = 1;
    }

    @Override
    public OpstiDomenskiObjekat vratiSlogVezanogObjekta(int brojVezanogObjekta, int brojSloga) {
        return null;
    }

    @Override
    public int vratiBrojSlogovaVezanogObjekta(int brojVezanogObjekta) {
        return -1;
    }

    @Override
    public boolean vrednosnaOgranicenja() {
        if (adminID >= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void Obradi() {
    }

    @Override
    public void Storniraj() {
    }

    @Override
    public String vratiNazivNovogObjekta() {
        return "new administrator";
    }

    @Override
    public String vratiNazivObjekta() {
        return "administrator";
    }

    /**
     * @return the adminID
     */
    public int getAdminID() {
        return adminID;
    }

    /**
     * @param adminID the adminID to set
     */
    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
