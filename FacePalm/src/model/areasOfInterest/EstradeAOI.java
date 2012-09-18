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
public class EstradeAOI extends AreaOfInterest{

    @Override
    public String getAreaName() {
        return "Estrada";
    }

    @Override
    public int getAreaID() {
        return 3;
    }

    @Override
    public AreaOfInterest getAreaOfInterest() {
        return new EstradeAOI();
    }
    
}
