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
import model.areasOfInterest.EstradeAOI;
import model.areasOfInterest.FilmAOI;
import model.areasOfInterest.MusicAOI;
import model.avatars.KiddingMeAvatar;

/**
 *
 * @author Jelena
 */
public class TrendyUserProfile  implements AbstractFactoryUserProfile{
/*
     * 
     * //extends UserProfile
    @Override
    public Avatar getAvatar() {
        return new KiddingMeAvatar();
    }

    @Override
    public List<AreaOfInterest> getAreasOfInterest() {
        List<AreaOfInterest> areasOfInterests= new ArrayList<AreaOfInterest>();
        areasOfInterests.add(new MusicAOI());
        areasOfInterests.add(new FilmAOI());
        areasOfInterests.add(new EstradeAOI());

        return areasOfInterests;
    }

    @Override
    public String getUserProfileName() {
        return "Trendy";
    }
*/
    @Override
    public List<AreaOfInterest> createAreasOfInterest() {
        List<AreaOfInterest> areasOfInterests= new ArrayList<AreaOfInterest>();
        areasOfInterests.add(new MusicAOI());
        areasOfInterests.add(new FilmAOI());
        areasOfInterests.add(new EstradeAOI());

        return areasOfInterests;
    }

    @Override
    public Avatar createAvatar() {
        return new KiddingMeAvatar();
    }

    @Override
    public String createUserProfileName() {
        return "Trendy";
    }
    
    
    
}
