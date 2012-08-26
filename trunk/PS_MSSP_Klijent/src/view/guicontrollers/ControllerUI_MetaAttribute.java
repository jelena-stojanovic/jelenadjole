/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.guicontrollers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.OpstiDomenskiObjekat;
import model.dataset.Dsmetaattribute;
import view.forms.OpstaEkranskaForma;

/**
 *
 * @author Jelena
 */
public class ControllerUI_MetaAttribute extends OpstiKontrolerKI {

    public ControllerUI_MetaAttribute() throws IOException {
        
    }

    public void setOdo(OpstiDomenskiObjekat odo) {
        this.odo = odo;
    }

    public void setOef(OpstaEkranskaForma oef) {
        this.oef = oef;
    }

   
  
  
    private List<Dsmetaattribute> getAllDataMetaAttributes() {

        Dsmetaattribute ds = new Dsmetaattribute();
        odo=ds;
        List<OpstiDomenskiObjekat> lodo = SOVratiSve();
        List<Dsmetaattribute> dslist = new ArrayList<Dsmetaattribute>();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : lodo) {
            dslist.add((Dsmetaattribute) opstiDomenskiObjekat);
            
        }
        return dslist;
    }
    /*
     * public static ControllerUI_AllDataSets getInstance() { return
     * ControllerUI_AllDataSetsHolder.INSTANCE; }
     */

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
     
        
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {
        List<Dsmetaattribute> allDataMetaAttributes = getAllDataMetaAttributes();
        for (int i = 0; i < allDataMetaAttributes.size(); i++) {
            Dsmetaattribute dsmetaattribute = allDataMetaAttributes.get(i);
            System.out.println(dsmetaattribute);
            
        }
    }
    /*
     * private static class ControllerUI_AllDataSetsHolder {
     *
     * private static final ControllerUI_AllDataSets INSTANCE = new
     * ControllerUI_AllDataSets();
    }
     */
}
