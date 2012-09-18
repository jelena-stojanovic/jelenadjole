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
public class NationalityAOI extends AreaOfInterest{

    @Override
    public String getAreaName() {
        return "Nacionalnost";
    }

    @Override
    public int getAreaID() {
        return 5;
    }

    @Override
    public AreaOfInterest getAreaOfInterest() {
        return new NationalityAOI();
    }
}
