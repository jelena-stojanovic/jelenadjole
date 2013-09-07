/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topsortapp;

import algorithms.TopSortAlgorithm;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jelena
 */
public class TopSortApp {

    /**
     * @param args the command line arguments
     */
       
    public static void main(String[] args) {
       TopSortAlgorithm tsa= new TopSortAlgorithm();
        try {
            
            tsa.readInputArray("src/data/Assign1input5");
            tsa.bagInitialization();
            tsa.topsorts();
            //tsa.printNumberOfPossibleTopsorts();
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TopSortApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TopSortApp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            tsa.printNumberOfPossibleTopsorts();
        }
    }
    
    
    
}
