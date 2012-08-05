/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jelena
 */
public class Reference {
    private String author;
    private String title;
    private Date date;
    private String location;
    private String otherInformation;

    public Reference() {
    }

    public Reference(String author, String title, Date date, String location, String otherInformation) {
        this.author = author;
        this.title = title;
        this.date = date;
        this.location = location;
        this.otherInformation = otherInformation;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the otherInformation
     */
    public String getOtherInformation() {
        return otherInformation;
    }

    /**
     * @param otherInformation the otherInformation to set
     */
    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }
    @Override
    public String toString() {
        return  author + "; " + title + "; " + date + ", " + location + ". " + otherInformation;
    }
    
    
    
}
