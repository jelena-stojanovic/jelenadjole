/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import model.Avatar;
import model.avatars.ChallengeAcceptedAvatar;
import model.avatars.FyeaAvatar;
import model.avatars.KiddingMeAvatar;
import model.avatars.MeGustaAvatar;
import model.avatars.TrollFaceAvatar;
import model.avatars.TrueStoryAvatar;

/**
 *
 * @author Jelena
 */
public class GetAvatar {
   
    private static String getNameOfClass(String avatar){
        if(avatar.equals("Challenge accepted")) return ChallengeAcceptedAvatar.class.getName();
        else if(avatar.equals("F yea")) return FyeaAvatar.class.getName();
                else if(avatar.equals("Are you f kidding me?")) return KiddingMeAvatar.class.getName();
                        else if(avatar.equals("Me gusta")) return MeGustaAvatar.class.getName();
                                else if(avatar.equals("Troll face")) return TrollFaceAvatar.class.getName();
                                        else if(avatar.equals("True story")) return TrueStoryAvatar.class.getName();
        return "Ne postoji takva klasa";
    }
    
    
    public static Avatar getAvatar(String avatarp) throws Exception {
        Object object=null;
        String avatar=getNameOfClass(avatarp);
        try {
            Class cl = Class.forName(avatar);
            Constructor constructor = cl.getConstructor();
            object = constructor.newInstance();
        } catch (InvocationTargetException e) {
            throw new Exception("Niste izabrali odgovarajuću oblast interesovanja:" + e.getMessage()); 
        } catch (NoSuchMethodException e) { // izuzetak metode getConstructor()
            throw new Exception("Niste izabrali odgovarajuću oblast interesovanja:" + e.getMessage()); 
        } catch (ClassNotFoundException e) { //izuzetak metode forName()
            throw new Exception("Klasa nije pronadjena:" + e.getMessage());
        } catch (InstantiationException e) {//izuzetak metode newInstance()
            throw new Exception("Objekat nije moguce instancirati: " + e.getMessage());
        } catch (IllegalAccessException e) {//izuzetak metode newInstance()
            throw new Exception("Klasa ili default konstruktor nije dostupan: " + e.getMessage());
        }
        return (Avatar) object;
    }
}
