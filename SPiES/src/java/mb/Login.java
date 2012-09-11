/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import ejb.CallEJB;
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
@ManagedBean(name = "login")
@SessionScoped
public class Login {

    Administrator admin;

    /**
     * Creates a new instance of Login
     */
    public Login() {
        admin = new Administrator();
    }

    public Administrator getAdmin() {
        return admin;
    }

    public void setAdmin(Administrator admin) {
        this.admin = admin;
    }

    public String login() {
        List<Administrator> sviAdministratori = CallEJB.getInstance().getSBadmin().getAllAdmins();

        System.out.println(sviAdministratori.size());
        for (Administrator a : sviAdministratori) {
            if (a.getUsername().equals(admin.getUsername()) && a.getPassword().equals(admin.getPassword())) {
                    admin = a;
                    //return "indexAdmin.xhtml";
                    return "dialog.show()";
            }
        }
        //return "login.xhtml";
        return "dialogError.show()";
    }

    public String logout() {
        admin = new Administrator();
        return "../index.xhtml";

    }
}
