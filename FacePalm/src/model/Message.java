/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jelena
 */
public class Message{

    private FPUser sendUser;
    private FPUser recieveUser;
    private String mText;

    public Message(FPUser sendUser, FPUser recieveUser, String mText) {
        this.sendUser = sendUser;
        this.recieveUser = recieveUser;
        this.mText = mText;
    }

    /**
     * @return the sendUser
     */
    public FPUser getSendUser() {
        return sendUser;
    }

    /**
     * @param sendUser the sendUser to set
     */
    public void setSendUser(FPUser sendUser) {
        this.sendUser = sendUser;
    }

    /**
     * @return the recieveUser
     */
    public FPUser getRecieveUser() {
        return recieveUser;
    }

    /**
     * @param recieveUser the recieveUser to set
     */
    public void setRecieveUser(FPUser recieveUser) {
        this.recieveUser = recieveUser;
    }

    /**
     * @return the mText
     */
    public String getmText() {
        return mText;
    }

    /**
     * @param mText the mText to set
     */
    public void setmText(String mText) {
        this.mText = mText;
    }

    
}
