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
public class MusicAOI extends AreaOfInterest{

    @Override
    public String getAreaName() {
        return "Muzika";
    }

    @Override
    public int getAreaID() {
        return 1;
    }

    @Override
    public AreaOfInterest getAreaOfInterest() {
        return new MusicAOI();
    }
}
