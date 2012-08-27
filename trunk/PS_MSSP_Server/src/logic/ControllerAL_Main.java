/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import logic.SO.PretraziPoUslovu;
import logic.SO.VratiSve;
import model.Administrator;
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

    public List<Dataset> getAllDataSets() {

        List<Dataset> alldsma = new ArrayList<Dataset>();
        List<OpstiDomenskiObjekat> allODO = new ArrayList<OpstiDomenskiObjekat>();
        Dataset dma = new Dataset();
        allODO.add(dma);
        String signal = "";
        allODO = VratiSve.VratiSve(allODO, signal);
        if (allODO != null) {
            for (int i = 0; i < allODO.size(); i++) {

                OpstiDomenskiObjekat opstiDomenskiObjekat = allODO.get(i);
                Dataset dsma = (Dataset) opstiDomenskiObjekat;
                dsma.instantiateLAZYrelationship();

                alldsma.add(dsma);
            }
        }
        return alldsma;
    }

    public Metads getMetads() {
        List<OpstiDomenskiObjekat> allODO = new ArrayList<OpstiDomenskiObjekat>();
        Metads dma = new Metads();
        allODO.add(dma);
        String signal = "";
        allODO = VratiSve.VratiSve(allODO, signal);
        dma = (Metads) allODO.get(0);
        return dma;
    }
    
    public List<Administrator> getAllAdmins(){
        
        List<Administrator> alldsma = new ArrayList<Administrator>();
        List<OpstiDomenskiObjekat> allODO = new ArrayList<OpstiDomenskiObjekat>();
        Administrator dma = new Administrator();
        allODO.add(dma);
        String signal = "";
        allODO = VratiSve.VratiSve(allODO, signal);
        if (allODO != null) {
            for (int i = 0; i < allODO.size(); i++) {
                OpstiDomenskiObjekat opstiDomenskiObjekat = allODO.get(i);
                Administrator admin = (Administrator) opstiDomenskiObjekat;
                alldsma.add(admin);
            }
        }
        return alldsma;
    }
    
    public Administrator login(OpstiDomenskiObjekat odo){
        Administrator admin= (Administrator) odo;
        HashMap<String, Object> map= new HashMap<String, Object>();
        map.put("username", admin.getUsername());
        map.put("password",admin.getPassword());
        String signal="";
        List<OpstiDomenskiObjekat> Pretrazi = PretraziPoUslovu.Pretrazi(odo, signal, map);
        if(Pretrazi!=null&&!Pretrazi.isEmpty()){
            
            for (OpstiDomenskiObjekat opstiDomenskiObjekat : Pretrazi) {
                Administrator administ= (Administrator)opstiDomenskiObjekat;

                 return administ;
            }
        }
        
        return null;
    }
}
