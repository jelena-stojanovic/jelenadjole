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
    
    String createAdmin(Administrator admin);
    String saveAdmin(Administrator admin);
    String updateAdmin(Administrator admin);
    
    Administrator login(Administrator admin);
}
