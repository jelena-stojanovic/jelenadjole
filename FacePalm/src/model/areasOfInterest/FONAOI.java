/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.areasOfInterest;

import model.AreaOfInterest;

/**
 *
 * @author Jelena
 */
public class FONAOI extends AreaOfInterest{

    @Override
    public String getAreaName() {
        return "FON";
    }

    @Override
    public int getAreaID() {
        return 11;
    }

    @Override
    public AreaOfInterest getAreaOfInterest() {
        return new FONAOI();
    }
}
