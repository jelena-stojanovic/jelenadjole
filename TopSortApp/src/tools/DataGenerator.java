/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import algorithms.TopSortAlgorithm;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jelena
 */
public class DataGenerator {
    public static void main(String[] args) {
                try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("src/data/Assign1Input11", true)));
            out.print("100");
            for (int i = 1; i < 100; i++) {
                out.println((i)+" "+(i+1));
            }
            out.close();

        } catch (IOException ex) {
            Logger.getLogger(TopSortAlgorithm.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
