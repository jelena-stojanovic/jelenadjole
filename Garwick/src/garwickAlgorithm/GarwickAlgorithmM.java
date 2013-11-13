/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garwickAlgorithm;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jelena
 */
public class GarwickAlgorithmM {

    public static void main(String[] args) {
        int numberOfOverflows = 0;

        //int[] kset= new int[]{1,1,1,3,3,3,3,2,2,3,3,3,3,2,2,2,1,2,2,2,2};
        int[] kset = new int[]{0, 0, 0, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 1, 1, 1, 0, 1, 1, 1, 1};//HAND
        //initialization
        GarwickAlgorithm ga = new GarwickAlgorithm(21, 3, 0.5);//HAND
        // insert data

        for (int i = 0; i < 3; i++) {
            System.out.println("For stack i=" + i + " base is " + ga.base[i] + " and top is " + ga.top[i]);
            System.out.println("New base is " + ga.newBase[i] + " and old top is " + ga.oldTop[i]);
        }
        //while there is spsace
        System.out.println("STAARTIIIING");
        System.out.println("REM is " + ga.REM);
        try {
            for (int m = 0; m < kset.length; m++) {//HAND
                ga.K = kset[m];//HAND
                System.out.println("K is " + ga.K);
                ga.top[ga.K]++;
                System.out.println("New top of " + ga.K + " is now " + ga.top[ga.K]);
                if (ga.top[ga.K] > ga.base[ga.K + 1]) {
                    numberOfOverflows++;
                    System.out.println("OVERFLOOOOOOOOOOOOOOWWWW");
                    System.out.println("K=" + ga.K);
                    try {
                        ga.garwick();
                    } catch (REMlessThanZeroException ex) {
                        //JOptionPane.showMessageDialog(null, ex.getMessage());
                        System.err.println(ex.getMessage());
                        System.out.println("Total umber of overflows is: " + numberOfOverflows);
                        System.out.println("Total number of movement is: " + ga.noMovements);
                        System.out.println("Total number of movement 70 is: " + ga.noMovements70);
                        Logger.getLogger(GarwickAlgorithmM.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (ga.REM <= 0) {
                        break;
                    }
                }
                
                
                System.out.println("----For stack i=" + ga.K + " base is " + ga.base[ga.K] + " and top is " + ga.top[ga.K]);
                System.out.println("******************New state*********************");
                for (int i = 0; i < 3; i++) {
                    System.out.println("For stack i=" + i + " base is " + ga.base[i] + " and top is " + ga.top[i]);
                }

                System.out.println("******************New state END*********************");
            }

           
            System.out.println("**************************Number of overflows is: " + numberOfOverflows);
            System.out.println("*******************NUmber of movement is: " + ga.noMovements);
            System.out.println("*******************NUmber of movement 70 is: " + ga.noMovements70);
            System.out.println("******************FINAL je*********************");
            for (int i = 0; i < 3; i++) {
                System.out.println("For stack i=" + i + " base is " + ga.base[i] + " and top is " + ga.top[i]);
            }

            System.out.println("******************FINAL END*********************");

            
        } catch (Exception e) {
            if (e instanceof REMlessThanZeroException) {
                System.err.println(e.getMessage());
            } else {
                Logger.getLogger(GarwickAlgorithmM.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }
}
