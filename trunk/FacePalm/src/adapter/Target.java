/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

import model.FPUser;

/**
 *
 * @author Jelena
 */
public interface Target {
    public void storeUser(FPUser fPUser) throws Exception;
}
