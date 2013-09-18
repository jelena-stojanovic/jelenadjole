/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.second;

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
public class ModifiedMss4 {

    int firstPosition = -1;
    int lastPosition = -1;
    String filePath;
    int inputarray[];
    int maxsum;

    public int mss4Modified(int[] a, int p1, int p2) {
        maxsum = 0;
        int sum = 0;
        int i = p1;
        int currentFirst = p1;
        int currentLast = i;

        while (i <= p2) {
            sum += a[i];
            currentLast = i;
            if (sum > maxsum) {
                maxsum = sum;
                firstPosition = currentFirst;
                lastPosition = currentLast;
            } else {
                if (sum < 0) {
                    sum = 0;
                    currentFirst = i + 1;
                }
            }
            i++;
        }
        return maxsum;
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
            System.out.println("Maximum subsequence sum");
            for (int i = firstPosition; i <= lastPosition; i++) {
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
            }
            out.println();
            System.out.println(" ");
            System.out.println("Maximum sum is "+ maxsum);
            out.println("Maximum sum is "+ maxsum);
            out.close();

        } catch (IOException ex) {
            Logger.getLogger(ModifiedMss4.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

}
