/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package base.saveTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Status;
import observe.Observer;

/**
 *
 * @author Jelena
 */
public class UpdateStatus extends SaveTemplate{

    @Override
    public void execute(Object o) throws SQLException {
        
        Status status= (Status) o;
        String query= "UPDATE status SET nostatuslike=?,nostatusfacepalm=?,statususer=?,statusareaofinterest=? WHERE statustext=?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, status.getNoLike());
        preparedStatement.setInt(2, status.getNofacePalm());
        preparedStatement.setString(3,status.getFpuser().getUsername());
        preparedStatement.setString(4,status.getAreaOfInterest().getAreaName());
        preparedStatement.setString(5, status.getStatusText());
        
        preparedStatement.executeUpdate();
            notifyObservers();
    }
    
    static List<Observer> listOfObservers= new ArrayList<Observer>();
    
    public static void attach(Observer obs){
        listOfObservers.add(obs);
        
    }
    public static void detacht(Observer obs){
        listOfObservers.remove(obs);
    }

    private static void notifyObservers() {
        for (Observer obs : listOfObservers) {
            obs.update();
        }
    }
    
}
