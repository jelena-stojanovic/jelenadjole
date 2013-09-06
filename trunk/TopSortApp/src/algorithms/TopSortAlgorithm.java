/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jelena
 */
public class TopSortAlgorithm {

    int n = 0;
    int[] predArray;
    ArrayList[] succArray;
    int[] bag;
    int endPossition = -1;
    int startPOsition = -1;
    int[] outputRanking;
    int numRanked = -1;
    String filePath;

    public TopSortAlgorithm() {
    }

    public int getN() {
        return n;
    }

    public void readInputArray(String filePath) throws FileNotFoundException, IOException {
        this.filePath = filePath;
        if (filePath == null) {
            System.err.println("Insert correct path");
        }
        String line;
        BufferedReader bufRdr = new BufferedReader(new FileReader(new File(filePath)));
        boolean first = true;
        //read n
        n = Integer.parseInt(bufRdr.readLine());
        //initialize pred array
        predArray = new int[n];
        //initialize succ array
        succArray = new ArrayList[n];
        for (int i = 0; i < succArray.length; i++) {
            succArray[i] = new ArrayList();
        }
        bag = new int[n];
        outputRanking = new int[n];

        System.out.println("Size of array: " + n);
        int firstInPair = -1;
        int seconInPair = -1;

        while ((line = bufRdr.readLine()) != null) {
            if (!line.equals("")) {
                String[] split = line.split(" ");
                int size = split.length;
                //System.out.println("ima ih u redu " + size);
                if (size == 1) {
                    int element = Integer.parseInt(split[0]);

                    if (first) {
                        firstInPair = element;
                        first = false;
                        if (firstInPair == 0) {
                            break;
                        }
                    } else {
                        seconInPair = element;
                        first = true;
                        predArray[--seconInPair]++; //since array starts from 0, it is drugi--; increase number of pred for second element in that pair
                        succArray[--firstInPair].add(--seconInPair);// add second element of that pair in the successors list of the first element
                    }
                } else if (size == 2) {
                    firstInPair = Integer.parseInt(split[0]);
                    seconInPair = Integer.parseInt(split[1]);

                    if (firstInPair == 0) {
                        break;
                    } else {
                        predArray[--seconInPair]++; //since array starts from 0, it is drugi--; increase number of pred for second element in that pair
                        succArray[--firstInPair].add(seconInPair);// add second element of that pair in the successors list of the first element
                    }
                }
            }
        }

        System.out.println("pred " + predArray);
        System.out.println("succ " + succArray);

        for (int i = 0; i < predArray.length; i++) {
            int j = predArray[i];
            System.out.println("Number of predd " + (i + 1) + " is: " + j);

        }
        System.out.println("*Successors*");
        for (int i = 0; i < succArray.length; i++) {
            ArrayList j = succArray[i];
            System.out.println("Successors of " + (i + 1) + " :");
            if (j.isEmpty()) {
                System.out.println("Nema nikog");
            } else {
                for (int k = 0; k < j.size(); k++) {
                    int object = (int) j.get(k);
                    System.out.print(object + 1 + " ");
                }
                System.out.println("");
            }
        }
        //read n--- first row
        //initialize pred array
        //initialize succ array
        //read m pairs, do 00
        // put it in a list
    }

    public void bagInitialization() {
        for (int i = 0; i < predArray.length; i++) {
            int j = predArray[i];
            if (j == 0) {
                bag[++endPossition] = i;
            }
        }
        startPOsition = 0;
        System.out.println("end position " + endPossition);
        System.out.println("start position " + startPOsition);
        System.out.println("Items in bag:");
        for (int i = startPOsition; i < endPossition + 1; i++) {
            int j = bag[i] + 1;
            System.out.println(j);
        }
    }

    public boolean bagIsEmpty() {

        return ((startPOsition > endPossition) || (startPOsition == -1 && endPossition == -1));

//        if ((startPOsition == -1 && endPossition == -1)) {
//            return true;
//        }
//        if (currentStartPosition <= startPOsition && endPossition < currentStartPosition) {
//            return false;
//        } else {
//            return startPOsition > endPossition;
//        }
    }

    private boolean thereIsAnObjectNotTakenOutYet() {
        if (currentStartPosition <= startPOsition && endPossition < currentStartPosition) {
            return false;
        } else {
            return startPOsition <= endPossition;
        }

        //check
//        if (currentStartPosition <= startPOsition) {
//            if (currentStartPosition <= endPossition) {
//                return startPOsition <= endPossition;
//            } else {
//                return false;
//            }
//        } else {//current>start
//            return startPOsition <= endPossition;
//        }
    }
    int currentStartPosition = 0;
    int currentEndPosition = 0;

    boolean negative = false;

    public void topsorts() {

        System.out.println("START NEW TOPSORT");
        //   if (bag is not empty){
        if (!bagIsEmpty()) {

//      while (there is an object not taken out yet){
            //while (startPOsition <= endPossition) {
            for (int iter = startPOsition; iter < endPossition + 1; iter++) {
                //while (thereIsAnObjectNotTakenOutYet()) {
                System.out.println("STARTNA POZICIJA JE " + startPOsition);
                System.out.println("TRENUTNA STARTNA POZICIJA JE:" + iter + currentStartPosition);
                //Take it out of the Bag,
                //******************zamena starog
                //int element = bag[startPOsition++];   //******************zamena starog
                int element = bag[iter];
                bag[iter] = bag[startPOsition];
                startPOsition++;
                currentEndPosition = endPossition;
                outputRanking[++numRanked] = element + 1;

//                if ((startPOsition == n - 1) && currentStartPosition != 0) {            //******************zamena starog
//                    startPOsition = 0;                    //******************zamena starog
//                } else {                                //******************zamena starog
//                    startPOsition++;                  //******************zamena starog
//                }
//                //put it in the output array,               
//                outputRanking[++numRanked] = element + 1;//+1 because arrays starts from 0
                System.out.println("num ranked " + numRanked);
                //traverse its succ list, 
                System.out.println("element is:" + (element + 1));
                ArrayList succelem = succArray[element];
                for (int i = 0; i < succelem.size(); i++) {
                    int ithsucc = Integer.parseInt(String.valueOf(succelem.get(i)));
                    System.out.println((ithsucc + 1) + " je " + (i + 1) + ". " + " succ of " + (element + 1));
                    //reduce the pred count for each successor, 
                    //   System.out.println("pre " + predArray[ithsucc]);
                    predArray[ithsucc]--;
                    System.out.println("Sad je njegov broj prethodnika " + predArray[ithsucc]);
                    //   System.out.println("posle " + predArray[ithsucc]);
                    //and if it goes to zero, put it in the Bag
                    if (predArray[ithsucc] == 0) {
                        System.out.println("dodajem ga u bag");

////                        if (endPossition == (n - 1) && currentStartPosition != 0) { //******************zamena starog
////                            endPossition = 0;         //******************zamena starog
////                        } else {                    //******************zamena starog
////                            endPossition++;       //******************zamena starog
////                        }                           //******************zamena starog
////                        bag[endPossition] = ithsucc;//******************zamena starog
                        bag[++endPossition] = ithsucc;//******************zamena starog
                    } else if (predArray[ithsucc] < 0) {
                        System.out.println("NEGATIVAN JE");
                        negative = true;
                    }
                }

                System.out.println("pocetna pozicija:" + startPOsition);
                System.out.println("krajnja pozicija" + endPossition);
                System.out.println("Items in bag:");
                for (int i = startPOsition; i <= endPossition; i++) {
                    int j = bag[i] + 1;
                    System.out.println(j);
                }
                if (!negative) {
                    topsorts();
                }
//         Reverse the above
//         and if it goes to zero, put it in the Bag
                System.out.println("Element after call of ts" + element);
//         "remove" it from the output array,
                numRanked--;
                //         Take it back in the Bag,
                System.out.println("posle reversa startna pozicija je " + startPOsition);
                //******************zamena starog
//                if (startPOsition == 0 && currentStartPosition != 0) {            //******************zamena starog
//                    startPOsition = n - 1;                    //******************zamena starog
//                } else {                                //******************zamena starog
//                    startPOsition--;                  //******************zamena starog
//                }
//
//                bag[startPOsition] = element;             //******************zamena starog

                startPOsition--;
                numRanked--;
                endPossition = currentEndPosition;
                bag[iter] = element;         //******************zamena starog
                System.out.println("Element je u vrecici na " + startPOsition + " poziciji");
                System.out.println("A krajnja pozicija je " + endPossition);

                ArrayList listSucc = succArray[element];
                if (listSucc != null && !listSucc.isEmpty()) {
                    //traverse its succ list, 
                    for (int i = 0; i < listSucc.size(); i++) {
                        //increase the pred count for each successor, 
                        int ithsuccessor = (int) listSucc.get(i);
                        predArray[ithsuccessor]++;
                    }
                }

//                if (currentStartPosition < n) {
//                    currentStartPosition++;
//                }
            }
        } else {
            if (counter <= 50) {
                outputOutput(outputRanking);
            }
//      Output the output array
//            System.out.println("*********************OUTPUT***********");
//            for (int i = 0; i < outputRanking.length; i++) {
//                int j = outputRanking[i];
//                System.out.println((i + 1) + "th rank:" + j);
//            }
        }
        printNumberOfPossibleTopsorts();
    }

    int counter = 0;

    public void outputOutput(int[] output) {
        try {
            PrintWriter out = null;
            System.out.println("ŠTAMPA" + counter++);

            out = new PrintWriter(new BufferedWriter(new FileWriter((filePath + "output"), true)));
            out.print("Topsort " + counter + " : ");
            for (int i = 0; i < output.length; i++) {
                int j = output[i];
                out.print(j);
                out.print(" ");
            }
            out.println();
            out.close();

        } catch (IOException ex) {
            Logger.getLogger(TopSortAlgorithm.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void printNumberOfPossibleTopsorts() {
        try {
            PrintWriter out = null;

            out = new PrintWriter(new BufferedWriter(new FileWriter((filePath + "output"), true)));
            out.print("Broj mogucih sortova je " + counter + " .");
            out.println();
            out.close();

        } catch (IOException ex) {
            Logger.getLogger(TopSortAlgorithm.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
