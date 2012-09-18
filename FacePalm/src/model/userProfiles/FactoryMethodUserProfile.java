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
import logic.GetAreaOfInterest;
import logic.GetAvatar;

/**
 *
 * @author Jelena
 */
public class FactoryMethodUserProfile {

        UserProfile userProfile;

    
    private static Avatar getAvatar(String avatar) throws Exception {
        return GetAvatar.getAvatar(avatar);
    }

    private static List<AreaOfInterest> getAreasOfInterest(String aoi1, String aoi2, String aoi3) throws Exception {
        AreaOfInterest aoi1o= GetAreaOfInterest.getAreaOfInterest(aoi1);
        AreaOfInterest aoi2o= GetAreaOfInterest.getAreaOfInterest(aoi2);
        AreaOfInterest aoi3o= GetAreaOfInterest.getAreaOfInterest(aoi3);
        
        List<AreaOfInterest> listaoi= new ArrayList<AreaOfInterest>();
        listaoi.add(aoi1o);
        listaoi.add(aoi2o);
        listaoi.add(aoi3o);
        return listaoi;
    }

    
    public  UserProfile getUserProfile(String avatar, String aoi1, String aoi2, String aoi3) throws Exception {
        Avatar avatar1= getAvatar(avatar);
        List<AreaOfInterest> listaoi= getAreasOfInterest(aoi1,aoi2,aoi3);
        
        userProfile= new UserProfile();
        userProfile.setAreasOfInterest(listaoi);
        userProfile.setAvatar(avatar1);
        userProfile.setUserProfileName("korisnički definisan");
        return userProfile;
    }
 
    
}
