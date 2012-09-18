/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Jelena
 */
public class UserDoesNotExistException extends Exception{

    String message= "Korisnik sa ovi korisničkim imenom ne postoji u bazi";
    public UserDoesNotExistException() {
    }

    @Override
    public String getMessage() {
        return message;
    }
    
}
