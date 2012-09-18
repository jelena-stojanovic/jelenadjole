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
public class MBAdministrator implements Serializable {

    Administrator logadmin;
    Administrator updateadmin;
    Administrator newAdmin;
    List<Administrator> allAdmins = new ArrayList<Administrator>();
    Administrator loged;
    /**
     * Creates a new instance of MBAdministrator
     */
    public MBAdministrator() {
        logadmin = new Administrator();
        newAdmin = new Administrator();
        updateadmin=new Administrator();
    }

    public Administrator getLogadmin() {
        return logadmin;
    }

    public void setAllAdmins(List<Administrator> allAdmins) {
        this.allAdmins = allAdmins;
    }

    public List<Administrator> getAllAdmins() {
        allAdmins=getAdmins();
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
        if (loged!=null&&loged.getFirstName() != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, loged.getFirstName() + ", you are already logged in!", "Already loged in!!!"));
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(loged.getFirstName() + ", vec ste ulogovani!"));
            return "./indexAdmin.xhtml";
        }else{
            loged = CallEJB.getInstance().getSBadmin().login(logadmin);
            if(loged==null){
             // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Neuspesno logovanje! Proverite korisnicko ime i lozinku!"));
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unsuccessfull login!!!", "Check your username and password!"));    
                return "./login.xhtml";
            }else{
               // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Uspesno logovanje! Dobrodošli " + loged.getFirstName() + " " + loged.getLastName() + " ! :)"));
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage( "Welcome, " + loged.getFirstName() + " " + loged.getLastName() + " ! :)"));
                return "./indexAdmin.xhtml";
            }
        }
    }
    
    public String saveAdmin(){
        if(newAdmin!=null&&newAdmin.getUsername()!=null){
                 String saveAdmin = CallEJB.getInstance().getSBadmin().saveAdmin(newAdmin);
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Administrator " + newAdmin.getFirstName() +  " "+ newAdmin.getLastName() + " has been successfully registered! :)",saveAdmin));
                 newAdmin= new Administrator();
        }
        
        return "./indexAdmin.xhtml";
    }

        public String updateAdmin(){
        if(updateadmin!=null&&updateadmin.getUsername()!=null){
                 String saveAdmin = CallEJB.getInstance().getSBadmin().updateAdmin(updateadmin);
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Administrator " + updateadmin.getFirstName() +  " "+ updateadmin.getLastName() + " has been successfully updated! :)",saveAdmin));
                 updateadmin= new Administrator();
        }
        
        return "./indexAdmin.xhtml";
    }

    
    public String logout() {
        logadmin = new Administrator();
        loged=new Administrator();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error!" ,"System cannot create new administrator."));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error!" ,"System cannot save administrator."));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error!" ,"System cannot edit administrator."));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error!" ,"System cannot find administrator."));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error!" ,"System cannot create new dataset."));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error!" ,"System cannot save dataset."));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error!" ,"System cannot edit dataset."));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error!" ,"System cannot find dataset."));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error!" ,"System cannot calculate dataset similarity."));
        
        return "./index.xhtml";

    }

    public List<Administrator> getAdmins() {
        List<Administrator> sviAdministratori = CallEJB.getInstance().getSBadmin().getAllAdmins();
        return sviAdministratori;
    }


    public String  update(){
        if(updateadmin==null||(updateadmin!=null&&updateadmin.getUsername()==null)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("You have to select one administrator." ));            
        }
        
            return "./updateAdmin.xhtml";  
    }
    
}
