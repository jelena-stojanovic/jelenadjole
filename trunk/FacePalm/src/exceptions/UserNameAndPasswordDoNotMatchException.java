/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Jelena
 */
public class UserNameAndPasswordDoNotMatchException extends Exception {
    String message= "Korisničko ime i šifra se ne poklapaju.";

    public UserNameAndPasswordDoNotMatchException() {
    }
    @Override
    public String getMessage() {
        return message;
    }
}
