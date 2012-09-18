/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import adapter.StoreUser;
import adapter.Target;
import base.DBBroker;
import base.saveTemplate.SaveStatus;
import base.saveTemplate.SaveTemplate;
import base.saveTemplate.SaveUser;
import base.saveTemplate.UpdateStatus;
import exceptions.UserDoesNotExistException;
import exceptions.UserNameAndPasswordDoNotMatchException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.AreaOfInterest;
import model.FPUser;
import model.Status;
import model.controller.ControllerFPUser;

/**
 *
 * @author Jelena
 */
public class Logic {
    private SaveTemplate saveObject;
    private static Logic instance;
    private DBBroker dbBroker;
    Target store;
    private Logic() throws SQLException, ClassNotFoundException {
        dbBroker=DBBroker.getinstance();
    }

    public static Logic getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new Logic();
        }
        return instance = new Logic();
    }

    public void setFPUser(FPUser fpuser) {
        ControllerFPUser.getInstance().setActiveUser(fpuser);
    }

    public void saveFPUser(FPUser fpuser) throws SQLException, ClassNotFoundException, Exception {
       // dbBroker.saveFPUser(fpuser);
       saveObject=new SaveUser();
       // saveObject.save(fpuser);
        store= new StoreUser((SaveUser)saveObject);
        store.storeUser(fpuser);
    }

    public void saveStatus(Status status) throws SQLException, ClassNotFoundException {
        //dbBroker.saveStatuus(status);
        saveObject= new SaveStatus();
        saveObject.save(status);
    }

    public void updateStatus(Status status) throws SQLException, ClassNotFoundException {
        //        dbBroker.updateStatus(status);
        saveObject=new UpdateStatus();
        saveObject.save(status);
    }
    public List<Status> getStatuses() throws SQLException, ClassNotFoundException, Exception {
        return dbBroker.getAllStatus();
    }

    public List<Status> getStatusesForUser(FPUser fPUser) throws SQLException, ClassNotFoundException, Exception {
        List<Status> allStatuses = getStatuses();
        List<Status> newList = new ArrayList<Status>();
        for (Status status : allStatuses) {
            for (AreaOfInterest aoi : fPUser.getUserProfile().getAreasOfInterest()) {
                if(aoi.getAreaName().equals(status.getAreaOfInterest().getAreaName()))
                   newList.add(status);
            }
        }
        return newList;
    }

  /*  public List<Message> getMessagesForUser(FPUser activeUser) throws SQLException, ClassNotFoundException {
        List<Message> allMessages = getAllMessages();
        List<Message> newList = new ArrayList<Message>();
        for (Message message : allMessages) {
            if (message.getRecieveUser().equals(activeUser) || message.getSendUser().equals(activeUser)) {
                newList.add(message);
            }
        }
        return newList;
    }

    public List<Message> getAllMessages() throws SQLException, ClassNotFoundException {
        return DBBroker.getinstance().getAllMesages();
    }
*/
    public List<String> getAreasOfInterest() {
        return GetAreaOfInterest.getAllAreasOfInterest();
    }

    public void checkAvailability(String username) throws Exception {
        dbBroker.checkAvailability(username);
    }

    public FPUser getUser(String username) throws SQLException, UserDoesNotExistException, Exception {
       return  dbBroker.getUser(username);
    }

    public FPUser getUser(String username, String password) throws SQLException, UserNameAndPasswordDoNotMatchException, Exception {
        return dbBroker.getUser(username, password);
    }

    
    
}
