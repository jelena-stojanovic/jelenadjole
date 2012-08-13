/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO.login;

import java.util.List;
import model.Administrator;

/**
 *
 * @author Djordje
 */
public class LoginCheck {

    public static boolean check(List<Administrator> administrators, String username, String password) {
        for (Administrator administrator : administrators) {
            if (administrator.getUsername().equals(username) && administrator.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
