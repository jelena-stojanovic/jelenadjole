/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.fourth;

import assignments.second.ModifiedMss4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jelena
 */
public class MaxSubSeqProduct {

    int maxprod;
    int maxPositiveProd = 1;
    int maxNegativeprod = 1;
    int[] inputarray;
    String filePath;

    public int msp3(int[] a, int p1, int p2) {

        //if p1 is p2
        if (p1 == p2) {
            //if ap1>0 maxsum= ap1 else maxsum=0
            if (a[p1] > 0) {
                maxPositiveProd = a[p1];
                maxprod = maxPositiveProd;
            } else {
                maxprod = 0;
                maxNegativeprod = a[p1];
            }
        } else {
            //m=(p1+ p2)/2
            int m = (p1 + p2) / 2;

            //L=mss3(a, p1, m)  R= mss3(a, m+1, p2)  
            //sumlt=0 sumrt=0 SL=0 SR=0
            int L = msp3(a, p1, m);
            int R = msp3(a, m + 1, p2);
            int prodlt = 1;// product of left side
            int prodrt = 1;// product of right side
            int PL = 1; //positive left
            int PR = 1;//positiveright
            int NL = 1;//negative left
            int NR = 1; //negative right
            //for  i from m down to p1
            for (int i = m; i >= p1; i--) {
                prodlt *= a[i];//sumlt=sumlt+ai
                //if sumlt>SL SL=sumlt      
                if (prodlt > 0) {
                    if (prodlt > PL) {
                        PL = prodlt;
                    }
                } else {
                    if (prodlt < NL) {
                        NL = prodlt;
                    }
                }
            }

            //for  i from m+1 to p2
            for (int i = m + 1; i <= p2; i++) {
                prodrt *= a[i];////sumrt=sumrt+ai
                //if sumrt>SR SR=sumrt 
                if (prodrt > 0) {
                    if (prodrt >= PR) {
                        PR = prodrt;
                        //   lastRight=i;
                    }
                } else {
                    if (prodrt < NR) {
                        NR = prodrt;
                    }

                }
            }
            //int med=PR+PL;
            maxPositiveProd = PL * PR;
            maxNegativeprod = NL * NR;
            int med = Math.max(maxNegativeprod, maxPositiveProd);
            maxprod = Math.max(Math.max(L, R), med);
        }
        return maxprod;
    }

    public void readInputArray(String filePath) throws FileNotFoundException, IOException {
        this.filePath = filePath;
        if (filePath == null) {
            System.err.println("Insert correct path");
        }

        BufferedReader bufRdr = new BufferedReader(new FileReader(new File(filePath)));
        String[] line = bufRdr.readLine().split(" ");
        //System.out.println("Line " + line.length);
        inputarray = new int[line.length - 1];
        //System.out.println(inputarray.length);
        for (int i = 0; i < line.length; i++) {
            String string = line[i];
            if (string.equals("end")) {
                break;
            } else {
                if (!string.equals("")) {
                    inputarray[i] = Integer.parseInt(line[i]);
                }
            }
        }
    }

    public int[] getInputarray() {
        return inputarray;
    }

    public void printinputandoutput(int[] a) {
        try {
            PrintWriter out = null;
            String[] filename = filePath.split("inputs");
            String newFilename = filename[0] + "outputs" + filename[1];
            out = new PrintWriter(new BufferedWriter(new FileWriter(newFilename, true)));
            System.out.println("Input array:");
            for (int i = 0; i < a.length; i++) {
                int j = a[i];
                System.out.print(j);
                System.out.print(" ");
            }
            System.out.println(" ");
            //System.out.println("Maximum subsequence sum");
           /* for (int i = firstPosition; i <= lastPosition; i++) {
             if (firstPosition != -1) {
             int j = a[i];
             out.print(j);
             out.print(" ");
             System.out.print(j);
             System.out.print(" ");
             }else{
             System.out.println("There is no elements in subsequence.");
             out.println("There is no elements in subsequence.");
             }
             }*/
            out.println("Maximum product is " + maxprod);
            System.out.println("Maximum product is " + maxprod);
            out.close();

        } catch (IOException ex) {
            Logger.getLogger(ModifiedMss4.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

}
