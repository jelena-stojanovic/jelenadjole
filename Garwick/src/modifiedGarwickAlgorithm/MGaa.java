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
public class MGaa {

    public static void main(String[] args) {
        int sumOfOverflows = 0;
        int sumOfMovements = 0;
        int sumOfMovements70 = 0;
        int spurtsSize = 50;// can be 1, 20 or 50 for this data
        for (int uk = 0; uk < 10; uk++) {//OVA
            int numberOfOverflows = 0;
//            int[] inputArray = new int[1000];//U
            boolean uniform = false;
            //initialization
            ModifiedGarwickAlgorithm mga = new ModifiedGarwickAlgorithm(1000, 10, 0);//U
            // insert data
            //while there is spsace
//            System.out.println("REM is " + mga.REM);
            try {
                while (mga.REM > 0) {//U

                    if (uniform) {//U
                        mga.K = mga.randomUniform();//U
                    } else {//U
                        mga.K = mga.skewDistribution();//U
                    }

                    for (int i = 0; i < spurtsSize; i++) {
//                        System.out.println("i is " + i);
//                        System.out.println("K is " + mga.K);
                        if (mga.K % 2 == 0) {
                            mga.top[mga.K]++;
                            boolean overflow = false;
                            if (mga.K == mga.N - 1) { //last case
                                if (mga.top[mga.K] > mga.base[mga.K + 1]) {
                                    overflow = true;
                                }
                            } else {// it is not the last case
                                if (mga.top[mga.K] >= mga.top[mga.K + 1]) {
                                    overflow = true;
                                }
                            }
                            if (overflow) {
                                numberOfOverflows++;
                                System.out.println("OVERFLOOOOOOOOOOOOOOWWWW");
                                System.out.println("K=" + mga.K);
                                try {
                                    mga.garwick();
                                } catch (REMlessThanZeroException ex) {
                                    //JOptionPane.showMessageDialog(null, ex.getMessage());
                                    System.err.println(ex.getMessage());
//                                    System.out.println("Total umber of overflows is: " + numberOfOverflows);
//                                    System.out.println("Total number of movement is: " + mga.noMovements);
//                                    System.out.println("Total number of movement 70 is: " + mga.noMovements70);
                                }
                                if (mga.REM <= 0) {
                                    break;
                                }
                            }
                        } else {
                            mga.top[mga.K]--;
                            if (mga.top[mga.K] <= mga.top[mga.K - 1]) {
                                numberOfOverflows++;
                                System.out.println("OVERFLOOOOOOOOOOOOOOWWWW");
                                System.out.println("K=" + mga.K);
                                try {
                                    mga.garwick();
                                } catch (REMlessThanZeroException ex) {
                                    //JOptionPane.showMessageDialog(null, ex.getMessage());
                                    System.err.println(ex.getMessage());
//                                    System.out.println("Total umber of overflows is: " + numberOfOverflows);
//                                    System.out.println("Total number of movement is: " + mga.noMovements);
//                                    System.out.println("Total number of movement 70 is: " + mga.noMovements70);
                                }

                                if (mga.REM <= 0) {
                                    break;
                                }
                            }
                        }
//                        System.out.println("----For stack i=" + mga.K + " base is " + mga.base[mga.K] + " and top is " + mga.top[mga.K]);
//                        System.out.println("******************Novo stanje je*********************");
//                        for (int b = 0; b < 3; b++) {
//                            System.out.println("For stack i=" + b + " base is " + mga.base[b] + " and top is " + mga.top[b]);
//                        }
//                        System.out.println("******************Novo stanje END*********************");
                    }
                    if (mga.REM <= 0) {
                        break;
                    }
                }
//                System.out.println("**************************Number of overflows is: " + numberOfOverflows);
//                System.out.println("*******************NUmber of movement is: " + mga.noMovements);
//                System.out.println("*******************NUmber of movement 70 is: " + mga.noMovements70);
//                System.out.println("******************Konacno stanje je*********************");
//                for (int i = 0; i < mga.N; i++) {
//                    System.out.println("For stack i=" + i + " base is " + mga.base[i] + " and top is " + mga.top[i]);
//                }
//
//                System.out.println("******************Konacno stanje stanje END*********************");

            } catch (Exception e) {
                if (e instanceof REMlessThanZeroException) {
                    System.err.println(e.getMessage());
                } else {
                    Logger.getLogger(MGaa.class.getName()).log(Level.SEVERE, null, e);
                }
            }

            sumOfMovements += mga.noMovements;
            sumOfMovements70 += mga.noMovements70;
            sumOfOverflows += numberOfOverflows;

        }//OVA

        double averageMove = sumOfMovements / 10.0;
        double averageMove70 = sumOfMovements70 / 10.0;
        double averageOver = sumOfOverflows / 10.0;
        System.out.println("Average movements: \t" + averageMove);
        System.out.println("Average movements 70: \t" + averageMove70);
        System.out.println("Average overflows: \t" + averageOver);

    }
}
