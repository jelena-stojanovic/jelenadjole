/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controllers;

import java.io.IOException;
import java.util.ArrayList;
import logic.ControllerAL_Main;
import logic.ControllerAL_MetaAttribute;

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
    
    public ArrayList<String> getCalculatedMetaAttribute(){
        ArrayList<String> uncalculated= ControllerAL_Main.getInstance().getUnalculatedMetaAttribute();
        
        for (int i = 0; i < uncalculated.size(); i++) {
            String string = uncalculated.get(i);
            System.out.println(string);
        }
        return uncalculated;
    }
    
    
    public void recalculateMetaAttributes() throws IOException {
        ControllerAL_MetaAttribute.getInstance().recalculateMetaAttributes();
    }
}
