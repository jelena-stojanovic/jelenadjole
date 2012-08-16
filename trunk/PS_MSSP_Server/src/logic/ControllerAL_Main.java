/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.List;
import logic.SO.VratiSve;
import model.OpstiDomenskiObjekat;
import model.dataset.Dataset;
import model.dataset.Metads;

/**
 *
 * @author Jelena
 */
public class ControllerAL_Main {
    
    private ControllerAL_Main() {
    }
    
    public static ControllerAL_Main getInstance() {
        return ControllerAL_MainHolder.INSTANCE;
    }
    
    private static class ControllerAL_MainHolder {

        private static final ControllerAL_Main INSTANCE = new ControllerAL_Main();
    }
    
    public List<Dataset> getAllDataSets(){
        ArrayList<Dataset> alldsma=new ArrayList<Dataset>();
        ArrayList<OpstiDomenskiObjekat> allODO= new ArrayList<OpstiDomenskiObjekat>();
        Dataset dma= new Dataset();
        allODO.add(dma);
        VratiSve.VratiSve(allODO);
        for (int i = 0; i < allODO.size(); i++) {
            OpstiDomenskiObjekat opstiDomenskiObjekat = allODO.get(i);
            Dataset dsma= (Dataset)opstiDomenskiObjekat;
            alldsma.add(dsma);
        }
        return alldsma;
    }
    
    public Metads getMetads(){
        ArrayList<OpstiDomenskiObjekat> allODO= new ArrayList<OpstiDomenskiObjekat>();
        Metads dma= new Metads();
        allODO.add(dma);
        String vratiSve = VratiSve.VratiSve(allODO);
        System.out.println(vratiSve);
        dma=(Metads)allODO.get(0);
        return dma;
    }
    
}
