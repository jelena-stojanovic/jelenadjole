/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.forms.coordinator;

import exceptions.UserDoesNotExistException;
import exceptions.UserNameAndPasswordDoNotMatchException;
import gui.forms.FPForm;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import logic.Logic;
import model.AreaOfInterest;
import model.FPUser;
import model.Message;
import model.Status;
import model.UserProfile;
import logic.GetAreaOfInterest;
import model.controller.ControllerFPUser;
import model.userProfiles.AbstractFactoryUserProfile;
import model.userProfiles.FactoryMethodUserProfile;
import model.userProfiles.TrendyUserProfile;
import model.userProfiles.WhySoSeriousUserProfile;

/**
 *
 * @author Jelena
 */
public class FormCoordinator {

    private FPForm fPForm;
    private static FormCoordinator instance;
    private Logic logic;

    private FormCoordinator() throws SQLException, ClassNotFoundException {
        fPForm = new FPForm();
        logic= Logic.getInstance();
    }

    public static FormCoordinator getInstance() {
        if (instance == null) {
            try {
                instance = new FormCoordinator();
            } catch (SQLException ex) {
                Logger.getLogger(FormCoordinator.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FormCoordinator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return instance;
    }

    public void startApplication() {
        fPForm.setVisible(true);
    }

    public void setNewPanel(JPanel newPanel) {
        fPForm.setActivePanel(newPanel);
    }

    public void saveNewStatus(String statusText, String areaOfInterest) throws SQLException, Exception {
            AreaOfInterest aof = GetAreaOfInterest.getAreaOfInterest(areaOfInterest);
            Status newStatus = new Status(ControllerFPUser.getInstance().getActiveUser(), statusText, aof, 0, 0);
            logic.saveStatus(newStatus);
       
    }
    
    public List<Status> getAllStatuses() throws SQLException, ClassNotFoundException, Exception {
     return logic.getStatuses();
    }
    
    public List<Status> getStatusList() throws SQLException, ClassNotFoundException, Exception {
     return logic.getStatusesForUser(ControllerFPUser.getInstance().getActiveUser());
    }
    
    public List<String> getAreasOfInterest(){
        return logic.getAreasOfInterest();
    }

    public FPUser getUser(String username, String password) throws SQLException, UserNameAndPasswordDoNotMatchException, Exception{
        return logic.getUser(username,password);
    }
    
    public FPUser getUser(String username) throws SQLException, UserDoesNotExistException, Exception{
        return logic.getUser(username);
    }
    
    public void checkAvailability(String username) throws Exception {
        logic.checkAvailability(username);
    }

    public void saveNewFPUser(String username, String password, String firstName, String lastName, char sex, String email, String avatar, String aoi1, String aoi2, String aoi3) throws Exception {
        
        UserProfile userprofile = new FactoryMethodUserProfile().getUserProfile(avatar,aoi1,aoi2,aoi3);
        FPUser fPUser = new FPUser(username, password, firstName, lastName, sex, email, userprofile);
        logic.saveFPUser(fPUser);
    }

    public void saveNewFPUser(String username, String password, String firstName, String lastName, char sex, String email, String defaultProfileName) throws SQLException, ClassNotFoundException, Exception {
        AbstractFactoryUserProfile afup;
        if(defaultProfileName.equals(TrendyUserProfile.class.getSimpleName()))
            afup= new TrendyUserProfile();
        else 
           afup= new WhySoSeriousUserProfile();
        UserProfile userProfile= (new UserProfile(afup)).create();
        
        FPUser fPUser = new FPUser(username, password, firstName, lastName, sex, email, userProfile);
        logic.saveFPUser(fPUser);
    }

    public void updateStatus(Status status) throws SQLException, ClassNotFoundException {
        logic.updateStatus(status);
    }

    
}
