/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import logic.ControllerAL_Main;
import logic.ControllerAL_MetaAttribute;
import model.dataset.Dsmetaattribute;

/**
 *
 * @author Jelena
 */
public class ControllerUI_MetaAttributes {
    
    private ControllerUI_MetaAttributes() {
    }
    
    public static ControllerUI_MetaAttributes getInstance() {
        return ControllerUI_MetaAttributesHolder.INSTANCE;
    }

    
    private static class ControllerUI_MetaAttributesHolder {

        private static final ControllerUI_MetaAttributes INSTANCE = new ControllerUI_MetaAttributes();
    }
    
    public List<Dsmetaattribute> getUnCalculatedMetaAttribute(){
        List<Dsmetaattribute> uncalculated= ControllerAL_MetaAttribute.getInstance().getUnalculatedMetaAttribute(ControllerAL_Main.getInstance().getAllDataSets().get(0));
        
        for (int i = 0; i < uncalculated.size(); i++) {
            Dsmetaattribute Dsmetaattribute = uncalculated.get(i);
            System.out.println(Dsmetaattribute.getDsmetaattributeName());
        }
        return uncalculated;
    }
    
    
    public void recalculateMetaAttributes() throws IOException {
        ControllerAL_MetaAttribute.getInstance().recalculateMetaAttributes();
    }
}
