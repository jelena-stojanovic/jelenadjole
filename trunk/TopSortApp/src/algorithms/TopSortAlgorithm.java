/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import datastructures.SuccArray;
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
 * @author jelena
 */
public class TopSortAlgorithm {

    int n = 0; //number of objects to be sorted
    int[] predArray; // array of predecessors count
    SuccArray[] succArray; //successors array, elements are SuccArrayElement and represent list of successors for eaxh of n objects
    int[] bag; //array of objects that currently have no predecessors and should be removed to outputRanking array
    int[] outputRanking; // one possible version of topsort, output from method topsort
    int endPossition = -1; // position in the bag, represents pointer to last element in the bag; when element is added to the bag, pointer is moved to that position
    int startPOsition = -1; //position of the element that should be next moved from the bag
    int numRanked = -1; // pointer to the last element in the outputRanking array
    String filePath; //path to the input file (file with the m pairs)

    public TopSortAlgorithm() {
    }

    /**
     *
     * @return number of objects to be sorted
     */
    public int getN() {
        return n;
    }

    /**
     * method read the input file: read number of objects(n), initialize
     * predecessors array, initialize successors array and read m pairs. For
     * each of m input pairs method update predecessors array and successors
     * array. Method works with different structures of input data (ex. files:
     * src/data/Assign1input1 and src/data/Assign1input3 )
     *
     * @param filePath path to the input file
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void readInputArray(String filePath) throws FileNotFoundException, IOException {
        this.filePath = filePath;
        if (filePath == null) {
            System.err.println("Insert correct path");
        }
        String line;
        BufferedReader bufRdr = new BufferedReader(new FileReader(new File(filePath)));
        boolean first = true;

        n = Integer.parseInt(bufRdr.readLine());//read n
        predArray = new int[n];//initialize pred array, 
        //there is no need for initialization of pred count to 0, since default value for integers are 0 

        succArray = new SuccArray[n];//initialize succ array
        for (int i = 0; i < succArray.length; i++) {
            succArray[i] = new SuccArray();
        }

        bag = new int[n]; //initialization of bag, bag represents array of n elements
        outputRanking = new int[n]; //initialization of output rank array, outputRanking represents array of n elements

        System.out.println("Size of array: " + n);
        int firstInPair = -1; //temp variable, represents the value of first element in input pair
        int seconInPair = -1; //temp variable, represents the value of second element in input pair

        while ((line = bufRdr.readLine()) != null) {
            if (!line.equals("")) { //in case that there is some empty line
                String[] split = line.split(" "); //split line by space
                int size = split.length; //number of leements in one line of input data

                if (size == 1) { //if data is in format that has only one number per line
                    int element = Integer.parseInt(split[0]); //element if first and only element in that line
                    if (first) { //check if the element is first element in the pair of input data
                        firstInPair = element;
                        first = false;
                        if (firstInPair == 0) { //check if element has value 0, if has- stop reading the data
                            break;
                        }
                    } else {
                        seconInPair = element; //if element if not first element in the pair, put it in the secondInPair variable
                        first = true; //set value of first variable on true, since next element will be first in the pair
                        predArray[--seconInPair]++; //increase pred count for second element in that pair; since array starts from 0, decrease number of second element in pair by one; 
                        succArray[--firstInPair].addFirst(seconInPair); // add second element of that pair in the successors list of the first element; since array starts from 0, decrease number of first element in pair by one;
                    }
                } else if (size == 2) { //if data is in format that has two numbers per line
                    firstInPair = Integer.parseInt(split[0]);
                    seconInPair = Integer.parseInt(split[1]);

                    if (firstInPair == 0) {
                        break;
                    } else {
                        predArray[--seconInPair]++; //increase pred count for second element in that pair; since array starts from 0, decrease number of second element in pair by one; 
                        succArray[--firstInPair].addFirst(seconInPair); // add second element of that pair in the successors list of the first element; since array starts from 0, decrease number of first element in pair by one;
                    }
                }
            }
        }

        //print the number of predecessors of the object
        for (int i = 0; i < predArray.length; i++) {
            int j = predArray[i];
            System.out.println("Number of predd " + (i + 1) + " is: " + j);
        }
        //print successors list
        System.out.println("*Successors*");
        for (int i = 0; i < succArray.length; i++) {
            SuccArray j = succArray[i];
            System.out.println("Successors of " + (i + 1) + " :");
            if (j.getFirst() == null) {
                System.out.println("No one");
            } else {
                SuccArray.SuccArrayElement currentelement = j.getFirst();
                while (currentelement != null) {
                    System.out.print((currentelement.getValue() + 1) + " ");
                    currentelement = currentelement.getNext();
                }
                System.out.println("");
            }
        }
    }

    /**
     * method initialize the bag array. Place all objects with zero predecessors
     * into the bag.
     */
    public void bagInitialization() {
        for (int i = 0; i < predArray.length; i++) {
            if (predArray[i] == 0) { // if pred count of i-th is 0. I-th element is number+1
                bag[++endPossition] = i; // place that element in the bag on endPosition, but first move position by one to the right
            }
        }
        startPOsition = 0; //move start position to 0. Element that should be taken from the bag first is on the first position
//        System.out.println("end position " + endPossition);
//        System.out.println("start position " + startPOsition);
//        System.out.println("Items in bag:");
//        for (int i = startPOsition; i < endPossition + 1; i++) {
//            System.out.println(bag[i] + 1);
//        }
    }

    /**
     * method check if bag is empty
     *
     * @return boolean value: if true that means that there is no element in the
     * bag that should be taken from the bag. The case when bag is empty is when
     * startPosition is higher then endPosition or when both of them has
     * initialization values (-1).
     */
    public boolean bagIsEmpty() {
        return ((startPOsition > endPossition) || (startPOsition == -1 && endPossition == -1));
    }

    /**
     * method generates all topological sorts of n elements that satisfy
     * relations given by m input pairs
     */
    public void topsorts() {
        //   if (bag is not empty){
        if (!bagIsEmpty()) {
            //while (there is an object not taken out yet){
            for (int currentStartPosition = startPOsition; currentStartPosition <= endPossition; currentStartPosition++) {
                
                int currentEndPosition; //local variable that shows current end position.
                // It is used in reverse part of method to set endPosition in the bag to this current bag position
                
                //Take it out of the Bag,
                int element = bag[currentStartPosition]; //take element from the current star position of the bag
                bag[currentStartPosition] = bag[startPOsition]; // on that position put the element from the start position in order to make permutation (if on different position in the bag)
                startPOsition++; //move start position by one place to the right
                currentEndPosition = endPossition; // remember current endPosition in local variable
                outputRanking[++numRanked] = element + 1;//put element in the output array on next position; +1 because arrays starts from 0 and want to have real value in output array

                //traverse its succ list, 
                SuccArray succelem = succArray[element];
                SuccArray.SuccArrayElement currentelement = succelem.getFirst();
                while (currentelement != null) {
                    int ithsucc = currentelement.getValue();
                    predArray[ithsucc]--; //reduce the pred count for each successor, 
                    if (predArray[ithsucc] == 0) {//and if it goes to zero,
                        bag[++endPossition] = ithsucc;//put it in the Bag
                    }
                    currentelement = currentelement.getNext();
                }

                //****recursive call
                topsorts();

                //***********Reverse the above
                numRanked--;//  Take it from the output array,
                // put it back in the Bag,
                bag[currentStartPosition] = element; //on currentStartPosition in order to make permutations in next for loop iteration
                startPOsition--; 
                endPossition = currentEndPosition; //set end position to the value of current end posion before recursive call
                                                   //in order to move out of the bag elements in constant time
                //traverse its succ list, 
                SuccArray listSucc = succArray[element];
                SuccArray.SuccArrayElement currentlistsucc = listSucc.getFirst();
                while (currentlistsucc != null) {
                    predArray[currentlistsucc.getValue()]++; //increase the pred count for each successor 
                    currentlistsucc = currentlistsucc.getNext();
                }
            }
        } else {
            //Output the output array
            if (numRanked == (n - 1)) { //to be sure if it is not partial order
                counter++; //increase the number of outpus
                if (counter <= 50) { //if it is less the 50
                    outputOutput(outputRanking); //print it in the file with the name of intupt file + output 
                }
            } else {
                System.err.println("It is not partial order.");
                notPartialOrder(); //else print that relation is not in partial order
            }
        }
    }
    
    
    int counter = 0;// number of outputs printed so far

   /**
    * method prints the current output rank array into file that has name in form: (filePath + "output")
    * @param output rank array to be printed
    */
    public void outputOutput(int[] output) {
        try {
            PrintWriter out = null;
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

    /**
     * method prints the number of possible sorts into file that has name in form: (filePath + "output")
     */
    public void printNumberOfPossibleTopsorts() {
        try {
            PrintWriter out = null;

            out = new PrintWriter(new BufferedWriter(new FileWriter((filePath + "output"), true)));
            out.print("Number of possible sorts is: " + counter + ".");
            out.println();
            out.close();

        } catch (IOException ex) {
            Logger.getLogger(TopSortAlgorithm.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    boolean partialOrder = true;
    /**
     * methods print message into the file if relation is not in partial order
     */
    public void notPartialOrder() {
        try {
            if (partialOrder) {
                PrintWriter out = null;

                out = new PrintWriter(new BufferedWriter(new FileWriter((filePath + "output"), true)));
                out.print("It is not partial order.");
                out.println();
                out.close();
                partialOrder = false;
            }

        } catch (IOException ex) {
            Logger.getLogger(TopSortAlgorithm.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
