/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import model.AreaOfInterest;
import model.areasOfInterest.EstradeAOI;
import model.areasOfInterest.FONAOI;
import model.areasOfInterest.FilmAOI;
import model.areasOfInterest.MusicAOI;
import model.areasOfInterest.NationalityAOI;
import model.areasOfInterest.PoliticsAOI;

/**
 *
 * @author Jelena
 */
public class GetAreaOfInterest {
   
    public static List<String> getAllAreasOfInterest(){ 
        List<String> listOfAreasOfInterest= new ArrayList<String>();
        listOfAreasOfInterest.add("FON");
        listOfAreasOfInterest.add("Politika");
        listOfAreasOfInterest.add("Film");
        listOfAreasOfInterest.add("Muzika");
        listOfAreasOfInterest.add("Estrada");
        listOfAreasOfInterest.add("Nacionalnost");
        return listOfAreasOfInterest;
    }
    
    private static String getNameOfClass(String areaOfInterestName){
        if(areaOfInterestName.equals("FON")) return FONAOI.class.getName();
        else if(areaOfInterestName.equals("Politika")) return PoliticsAOI.class.getName();
                else if(areaOfInterestName.equals("Film")) return FilmAOI.class.getName();
                        else if(areaOfInterestName.equals("Muzika")) return MusicAOI.class.getName();
                                else if(areaOfInterestName.equals("Estrada")) return EstradeAOI.class.getName();
                                        else if(areaOfInterestName.equals("Nacionalnost")) return NationalityAOI.class.getName();
        return "Ne postoji takva klasa";
    }
    
    
    public static AreaOfInterest getAreaOfInterest(String areaOfInterest) throws Exception {
        Object object=null;
        String areaOfInterestName=getNameOfClass(areaOfInterest);
        try {
            Class cl = Class.forName(areaOfInterestName);
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
        return (AreaOfInterest) object;
    }
}
