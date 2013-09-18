/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.fourth;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jelena
 */
public class MaxSubSeqProductApp {

    public static void main(String[] args) {
        try {
            MaxSubSeqProduct mssp = new MaxSubSeqProduct();
            mssp.readInputArray("src\\assignments\\fourth\\inputs\\example6");
            int[] a = mssp.getInputarray();
            mssp.msp3(a, 0, (a.length-1 ));
            mssp.printinputandoutput(a);
        } catch (IOException ex) {
            Logger.getLogger(MaxSubSeqProductApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
