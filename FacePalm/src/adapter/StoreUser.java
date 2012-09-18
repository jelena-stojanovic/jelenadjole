/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

import base.saveTemplate.SaveUser;
import model.FPUser;

/**
 *
 * @author Jelena
 */
public class StoreUser implements Target{ //Adapter
    SaveUser saveUser;

    public StoreUser(SaveUser saveUser) {
        this.saveUser = saveUser;
    }

    @Override
    public void storeUser(FPUser fPUser) throws Exception {
        saveUser.save(fPUser);
    }
    

    
}
