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
public class SaveStatus extends SaveTemplate{

    @Override
    public void execute(Object o) throws SQLException {
        Status status = (Status) o;
        System.out.println(status);
        String query = "INSERT INTO status(statustext,nostatuslike,nostatusfacepalm,statususer,statusareaofinterest) VALUES (?,?,?,?,?)";
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        
        preparedStatement.setString(1, status.getStatusText());
        preparedStatement.setInt(2, status.getNoLike());
        preparedStatement.setInt(3, status.getNofacePalm());
        preparedStatement.setString(4,status.getFpuser().getUsername());
        preparedStatement.setString(5,status.getAreaOfInterest().getAreaName());
        
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
