/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import javax.ejb.Local;
import model.Administrator;

/**
 *
 * @author Jelena
 */
@Local
public interface SeassionBeanAdministratorLocal {
    List<Administrator> getAllAdmins();
    Administrator getAdmin(Administrator admin);
    
    void createAdmin(Administrator admin);
    void saveAdmin(Administrator admin);
    void updateAdmin(Administrator admin);
    
    Administrator login(Administrator admin);
}
