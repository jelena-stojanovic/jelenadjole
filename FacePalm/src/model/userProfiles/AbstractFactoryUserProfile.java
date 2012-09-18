/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.userProfiles;

import java.util.List;
import model.AreaOfInterest;
import model.Avatar;

/**
 *
 * @author Jelena
 */
public interface AbstractFactoryUserProfile {

    public abstract List<AreaOfInterest> createAreasOfInterest();
    public abstract Avatar createAvatar();
    public abstract String createUserProfileName();
    
    
}
