/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jelena
 */
abstract public class AreaOfInterest {
    String areaName;
    int areaID;
    
    abstract public String getAreaName();

    abstract public int getAreaID() ;
    
    abstract public AreaOfInterest getAreaOfInterest();

    @Override
    public String toString() {
        return "Oblast interesovanja{" + getAreaName() + ", " + getAreaID() + '}';
    }

    
}
