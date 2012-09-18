/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controller;

import java.util.ArrayList;
import java.util.List;
import model.Message;

/**
 *
 * @author Jelena
 */
public class ControllerMessage {
    
    private static ControllerMessage instance;
    private List<Message> messageList;
    
    private ControllerMessage() {
        messageList = new ArrayList<Message>();
    }
    
    public static  ControllerMessage getInstance() {
        if(instance==null)
            instance = new ControllerMessage();
        
            return instance;
    }           
    
    public void addMessage (Message message) {
        messageList.add(message);
    }
    
    public List<Message> getMessageList () {
        return messageList;
    }
    
    public void addMessagesList (ArrayList<Message> messageList) {
        this.messageList = messageList;
    }
}
