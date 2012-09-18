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
public class PoliticsAOI extends AreaOfInterest{

    @Override
    public String getAreaName() {
        return "Politika";
    }

    @Override
    public int getAreaID() {
        return 4;
    }

    @Override
    public AreaOfInterest getAreaOfInterest() {
        return new PoliticsAOI();
    }
}
