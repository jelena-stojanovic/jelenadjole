/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import ejb.CallEJB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Administrator;


/**
 *
 * @author Jelena
 */
@ManagedBean(name = "mbadmin")
@SessionScoped
public class MBAdministrator implements Serializable{

    Administrator logadmin;
    Administrator updateadmin;
    Administrator newAdmin;
    List<Administrator> allAdmins= new ArrayList<Administrator>();
   

    /**
     * Creates a new instance of MBAdministrator
     */
    public MBAdministrator() {
        logadmin = new Administrator();
        newAdmin= new Administrator();
    }

    public Administrator getLogadmin() {
        return logadmin;
    }

    public void setAllAdmins(List<Administrator> allAdmins) {
        this.allAdmins = allAdmins;
    }

    public List<Administrator> getAllAdmins() {
        allAdmins.add(new Administrator(1, "admin1", "admin1", "admin1", "admin1", "admin1"));
        allAdmins.add(new Administrator(1, "admin2", "admin2", "admin2", "admin2", "admin2"));
        allAdmins.add(new Administrator(1, "admin3", "admin3", "admin3", "admin3", "admin3"));
        return allAdmins;
    }

    public void setLogadmin(Administrator logadmin) {
        this.logadmin = logadmin;
    }

    public Administrator getNewAdmin() {
        return newAdmin;
    }

    public void setNewAdmin(Administrator newAdmin) {
        this.newAdmin = newAdmin;
    }

    public Administrator getUpdateadmin() {
        return updateadmin;
    }

    public void setUpdateadmin(Administrator updateadmin) {
        this.updateadmin = updateadmin;
    }
    

    
   
    public String login() {
//        List<Administrator> sviAdministratori = CallEJB.getInstance().getSBadmin().getAllAdmins();
//
//        System.out.println(sviAdministratori.size());
//        for (Administrator a : sviAdministratori) {
//            if (a.getUsername().equals(logadmin.getUsername()) && a.getPassword().equals(logadmin.getPassword())) {
//                    logadmin = a;
                    //return "indexAdmin.xhtml";
                    return "dialog.show()";
//            }
//        }
//        //return "login.xhtml";
//        return "dialogError.show()";
    }

    public String logout() {
        logadmin = new Administrator();
        return "../index.xhtml";

    }
    
    public List<Administrator> getAdmins() {
        List<Administrator> sviAdministratori = CallEJB.getInstance().getSBadmin().getAllAdmins();
        return sviAdministratori;
    }
    
    public void saveNewAdmin(){
        CallEJB.getInstance().getSBadmin().saveAdmin(newAdmin);
    }
    
}
