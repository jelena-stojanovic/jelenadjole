/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.second;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jelena
 */
public class ModifiedMss4App {
    public static void main(String[] args) {
        try {
            ModifiedMss4 mss4M= new ModifiedMss4();
            mss4M.readInputArray("src\\assignments\\second\\inputs\\example2");
            int[] a= mss4M.getInputarray();
            mss4M.mss4Modified(a, 0, (a.length-1) );
            mss4M.printinputandoutput(a);
        } catch (IOException ex) {
            Logger.getLogger(ModifiedMss4App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
