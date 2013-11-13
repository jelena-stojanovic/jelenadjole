/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modifiedGarwickAlgorithm;

import garwickAlgorithm.REMlessThanZeroException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jelena
 */
public class ModifiedGarwickApp {

    public static void main(String[] args) {

        int numberOfOverflows = 0;

        //int[] kset= new int[]{1,1,1,3,3,3,3,2,2,3,3,3,3,2,2,2,1,2,2,2,2};
        int[] kset = new int[]{0, 0, 0, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 1, 1, 1, 0, 1, 1, 1, 1};//HAND
        //initialization
        ModifiedGarwickAlgorithm mga = new ModifiedGarwickAlgorithm(21, 3, 0.5);//HAND
        // insert data

        for (int i = 0; i < 3; i++) {
            System.out.println("For stack i=" + i + " base is " + mga.base[i] + " and top is " + mga.top[i]);
            System.out.println("New base is " + mga.newBase[i] + " and old top is " + mga.oldTop[i]);
        }

        //while there is spsace
        System.out.println("STAARTIIIING");
        System.out.println("REM is " + mga.REM);
        try { //HAND
            for (int m = 0; m < kset.length; m++) {//HAND
                mga.K = kset[m];//HAND
                System.out.println("K stack is " + mga.K);
                if (mga.K % 2 == 0) {
                    mga.top[mga.K]++;
                    boolean overflow = false;
                    if (mga.K == mga.N - 1) { //krajnji slucaj
                        if (mga.top[mga.K] > mga.base[mga.K + 1]) {
                            overflow = true;
                        }
                    } else {// nije krajnji slucaj
                        if (mga.top[mga.K] >= mga.top[mga.K + 1]) {
                            overflow = true;
                        }
                    }
                    if (overflow) {
                        numberOfOverflows++;
                        System.out.println("OVERFLOOOOOOOOOOOOOOWWWW");
                        System.out.println("K=" + mga.K);
                        mga.garwick();
                        if (mga.REM == 0) {
                            break;
                        }
                    }
                } else {
                    mga.top[mga.K]--;
                    if (mga.top[mga.K] <= mga.top[mga.K - 1]) {
                        numberOfOverflows++;
                        System.out.println("OVERFLOOOOOOOOOOOOOOWWWW");
                        System.out.println("K=" + mga.K);
                        mga.garwick();
                        if (mga.REM == 0) {
                            break;
                        }
                    }
                }
                System.out.println("----For stack i=" + mga.K + " base is " + mga.base[mga.K] + " and top is " + mga.top[mga.K]);
                System.out.println("******************New state is*********************");
                for (int i = 0; i < 3; i++) {
                    System.out.println("For stack i=" + i + " base is " + mga.base[i] + " and top is " + mga.top[i]);
                }

                System.out.println("******************New state END*********************");

//                }//U
            }

            System.out.println("**************************Number of overflows is: " + numberOfOverflows);
            System.out.println("*******************NUmber of movement is: " + mga.noMovements);
            System.out.println("*******************NUmber of movement 70 is: " + mga.noMovements70);
            System.out.println("******************FINAL*********************");
            for (int i = 0; i < 3; i++) {
                System.out.println("For stack i=" + i + " base is " + mga.base[i] + " and top is " + mga.top[i]);
            }

            System.out.println("******************FINAL END*********************");

        } catch (REMlessThanZeroException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Total umber of overflows is: " + numberOfOverflows);
            System.out.println("Total number of movement is: " + mga.noMovements);
            System.out.println("Total number of movement 70 is: " + mga.noMovements70);
        } catch (Exception e) {
            Logger.getLogger(ModifiedGarwickApp.class.getName()).log(Level.SEVERE, null, e);
        }

    }

}
