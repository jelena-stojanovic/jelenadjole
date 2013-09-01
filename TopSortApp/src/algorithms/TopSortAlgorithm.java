/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author jelena
 */
public class TopSortAlgorithm {

    int n = 0;
    int[] predArray;
    ArrayList[] succArray;
    int[] bag;
    int endPossition=-1;
    int startPOsition=-1;

    public TopSortAlgorithm() {
        
    }

    public int getN() {
        return n;
    }

    public void readInputArray(String filePath) throws FileNotFoundException, IOException {
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
        bag= new int[n];
        
        System.out.println("Veličina niza je " + n);
        int firstInPair = -1;
        int seconInPair = -1;
        while ((line = bufRdr.readLine()) != null) {
            if (!line.equals("")) {
                String[] split = line.split(" ");
                int size = split.length;
                System.out.println("ima ih u redu " + size);
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

        System.out.println("pred "+predArray);
        System.out.println("succ "+succArray);
        for (int i = 0; i < predArray.length; i++) {
            int j = predArray[i];
            System.out.println("Number of predd "+i+1 +" is: "+ j);
            
        }
        System.out.println("Successors");
        for (int i = 0; i < succArray.length; i++) {
            ArrayList j = succArray[i];
            System.out.println("Successors of " +i+ " :");
            for (int k = 0; k < j.size(); k++) {
                Object object = j.get(k);
                System.out.print((int)object+1+" ");
            }
            System.out.println("");
        }
        //read n--- first row
        //initialize pred array
        //initialize succ array
        //read m pairs, do 00
        // put it in a list
        
        bagInitialization();
    }

    void bagInitialization(){
        for (int i = 0; i < predArray.length; i++) {
            int j = predArray[i];
            if(j==0){
                bag[++endPossition]=i;
                startPOsition=0;
            }
        }
        
        
        System.out.println("end position "+ endPossition);
        System.out.println("start position "+ startPOsition);
        for (int i = startPOsition; i < endPossition+1; i++) {
            int j = bag[i]+1;
            System.out.println(j);
            
        }
    }
    
    
    public void topsorts() {
//   if (bag is not empty){
//
//      while (there is an object not taken out yet){
//
//         Take it out of the Bag, put it in the output array,
//         traverse its succ list, reduce the pred count for 
//         each successor, and if it goes to zero, put it in 
//         the Bag
//         topsorts();
//         Reverse the above
//
//      }
//   } 
//   else{
//      Output the output array
//   }
    }
}
