/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.userProfiles;

import java.util.ArrayList;
import java.util.List;
import model.AreaOfInterest;
import model.Avatar;
import model.UserProfile;
import model.areasOfInterest.FONAOI;
import model.areasOfInterest.NationalityAOI;
import model.areasOfInterest.PoliticsAOI;
import model.avatars.TrollFaceAvatar;

/**
 *
 * @author Jelena
 */
public class WhySoSeriousUserProfile  implements AbstractFactoryUserProfile{
/*
     * 
     * //extends UserProfile
    @Override
    public List<AreaOfInterest> getAreasOfInterest() {
        List<AreaOfInterest> areaOfInterests= new ArrayList<AreaOfInterest>();
        areaOfInterests.add(new PoliticsAOI());
        areaOfInterests.add(new NationalityAOI());
        areaOfInterests.add(new FONAOI());

        return areaOfInterests;
    }

    @Override
    public Avatar getAvatar() {
        return new TrollFaceAvatar();
    }

    @Override
    public String getUserProfileName() {
        return "Why so serious?";
    }
*/
    @Override
    public List<AreaOfInterest> createAreasOfInterest() {
        List<AreaOfInterest> areaOfInterests= new ArrayList<AreaOfInterest>();
        areaOfInterests.add(new PoliticsAOI());
        areaOfInterests.add(new NationalityAOI());
        areaOfInterests.add(new FONAOI());

        return areaOfInterests;
    }

    @Override
    public Avatar createAvatar() {
         return new TrollFaceAvatar();
    }

    @Override
    public String createUserProfileName() {
        return "Why so serious?";
    }
    
    
}
