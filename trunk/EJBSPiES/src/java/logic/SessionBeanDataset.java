/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import logic.SO.KreirajNovi;
import logic.SO.Obradi;
import logic.SO.Pretrazi;
import logic.SO.VratiSve;
import logic.SO.Zapamti;
import model.OpstiDomenskiObjekat;
import model.dataset.Dataset;

/**
 *
 * @author Jelena
 */
@Stateless
//@EJB(name="SessionBeanDataset",beanInterface=SessionBeanDatasetLocal.class,beanName="SessionBeanDataset")
public class SessionBeanDataset implements SessionBeanDatasetLocal {


    @Override
    public List<Dataset> getAllDatasets() {
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

    @Override
    public Dataset getDataset(Dataset ds) {
        System.out.println(Pretrazi.Pretrazi(ds));
        return ds;
    }

    @Override
    public void createDataset(Dataset ds) {
        System.out.println(KreirajNovi.kreirajNovi(ds));
    }

    @Override
    public void saveDataset(Dataset ds) {
        System.out.println(Zapamti.Zapamti(ds));
    }

    @Override
    public void updateDataset(Dataset ds) {
        System.out.println(Obradi.Obradi(ds));
    }

    
    
}
