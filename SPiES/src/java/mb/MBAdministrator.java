/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import ejb.CallEJB;
import java.io.Serializable;
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
@ManagedBean(name = "admin")
@SessionScoped
public class MBAdministrator implements Serializable{

    Administrator logadmin;
    Administrator newAdmin;

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

    public void setLogadmin(Administrator logadmin) {
        this.logadmin = logadmin;
    }

    public Administrator getNewAdmin() {
        return newAdmin;
    }

    public void setNewAdmin(Administrator newAdmin) {
        this.newAdmin = newAdmin;
    }

    
   
    public String login() {
//        List<Administrator> sviAdministratori = CallEJB.getInstance().getSBadmin().getAllAdmins();
//
//        System.out.println(sviAdministratori.size());
//        for (Administrator a : sviAdministratori) {
//            if (a.getUsername().equals(logadmin.getUsername()) && a.getPassword().equals(logadmin.getPassword())) {
//                    logadmin = a;
//                    //return "indexAdmin.xhtml";
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
}
