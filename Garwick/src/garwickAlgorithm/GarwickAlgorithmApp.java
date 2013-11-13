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
public class GarwickAlgorithmApp {

    public static void main(String[] args) {
        int sumOfOverflows = 0;
        int sumOfMovements = 0;
        int sumOfMovements70 = 0;
        for (int uk = 0; uk < 10; uk++) {//OVA

            int numberOfOverflows = 0;
            int spurtsSize = 1;// can be 1, 20 or 50 for this data

            int[] inputArray = new int[1000];//U
            for (int i = 0; i < inputArray.length; i++) {//U
                inputArray[i] = i + 1;//U
            }//U
            boolean uniform = false;
            //initialization
            GarwickAlgorithm ga = new GarwickAlgorithm(1000, 10, 1);//U //0,0.5,1
            // insert data

            //while there is spsace
            System.out.println("REM is " + ga.REM);
            try {
                while (ga.REM > 0) {//U

                    if (uniform) {//U
                        ga.K = ga.randomUniform();//U
                    } else {//U
                        ga.K = ga.skewDistribution();//U
                    }

                    for (int i = 0; i < spurtsSize; i++) {
//                        System.out.println("i is " + i);
//                        System.out.println("K is " + ga.K);
                        ga.top[ga.K]++;
//                        System.out.println("New top of " + ga.K + " is now " + ga.top[ga.K]);
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
                                Logger.getLogger(GarwickAlgorithmApp.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            if (ga.REM <= 0) {
                                break;
                            }
                        }
                    }
                    if (ga.REM <= 0) {
                        break;
                    }
                }
                System.out.println("Number of overflows is: " + numberOfOverflows);
                System.out.println("NUmber of movement is: " + ga.noMovements);
                System.out.println("NUmber of movement 70 is: " + ga.noMovements70);

            } catch (Exception e) {
                if (e instanceof REMlessThanZeroException) {
                    System.err.println(e.getMessage());
                } else {
                    Logger.getLogger(GarwickAlgorithmApp.class.getName()).log(Level.SEVERE, null, e);
                }
            }

            sumOfMovements += ga.noMovements;
            sumOfMovements70 += ga.noMovements70;
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
