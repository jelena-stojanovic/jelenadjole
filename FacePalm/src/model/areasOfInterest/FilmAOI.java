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
public class FilmAOI extends AreaOfInterest{

    @Override
    public String getAreaName() {
        return "Film";
    }

    @Override
    public int getAreaID() {
        return 2;
    }

    @Override
    public AreaOfInterest getAreaOfInterest() {
        return new FilmAOI();
    }
}
