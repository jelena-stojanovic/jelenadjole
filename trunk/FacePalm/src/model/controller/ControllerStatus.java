/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controller;

import base.DBBroker;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Status;

/**
 *
 * @author Jelena
 */
public class ControllerStatus {

    private static ControllerStatus instance;
    private List<Status> statusList;

    private ControllerStatus() {
        statusList = new ArrayList<Status>();
    }

    public static ControllerStatus getInstance() {
        if (instance == null) 
            instance = new ControllerStatus();
        return instance = new ControllerStatus();
    }

    public void addStatus(Status status) {
        statusList.add(status);
    }

    public List<Status> getStatusLists() {
        return statusList;
    }
    
    public List<Status> getStatusListsRefreshed() throws SQLException, ClassNotFoundException, Exception {
        statusList=DBBroker.getinstance().getAllStatus();
        return statusList;
    }

    public void setStatusList(ArrayList<Status> statusList) {
        this.statusList = statusList;
    }
    
}
