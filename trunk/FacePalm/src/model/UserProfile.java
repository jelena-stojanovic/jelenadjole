/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import model.userProfiles.AbstractFactoryUserProfile;

/**
 *
 * @author Jelena
 */
public class UserProfile {

    private  String userProfileName;
    private  List<AreaOfInterest> areasOfInterest;
    private  Avatar avatar;
    AbstractFactoryUserProfile abstractFactoryUserProfile;

    public UserProfile() {
    }

    public UserProfile(AbstractFactoryUserProfile abstractFactoryUserProfile) {
        this.abstractFactoryUserProfile = abstractFactoryUserProfile;
    }

    
    
    /**
     * @return the areasOfInterest
     */
    public List<AreaOfInterest> getAreasOfInterest() {
        return areasOfInterest;
    }

    /**
     * @return the avatar
     */
    public Avatar getAvatar() {
        return avatar;
    }

    /**
     * @return the userProfileName
     */
    public String getUserProfileName() {
        return userProfileName;
    }

    /**
     * @param userProfileName the userProfileName to set
     */
    public void setUserProfileName(String userProfileName) {
        this.userProfileName = userProfileName;
    }


    /**
     * @param areasOfInterest the areasOfInterest to set
     */
    public void setAreasOfInterest(List<AreaOfInterest> areasOfInterest) {
        this.areasOfInterest = areasOfInterest;
    }

    /**
     * @param avatar the avatar to set
     */
    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "UserProfile{" + "userProfileName=" + userProfileName + ", areasOfInterest=" + areasOfInterest + ", avatar=" + avatar + '}';
    }
    
    public UserProfile create(){
        List<AreaOfInterest> aoi= abstractFactoryUserProfile.createAreasOfInterest();
        Avatar avat= abstractFactoryUserProfile.createAvatar();
        String userprofName= abstractFactoryUserProfile.createUserProfileName();
        UserProfile usp= new UserProfile();
        usp.setAreasOfInterest(aoi);
        usp.setAvatar(avat);
        usp.setUserProfileName(userprofName);
        return usp;
    }
    
}
