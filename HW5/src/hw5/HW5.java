/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw5;

import structures.Node;

/**
 *
 * @author Jelena
 */
public class HW5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int tree_input = 1;// za 6 132, za 7 429
//        int n=3;int[] leftTreeInput = new int[n+1];
//        int[] rightTreeInput = new int[n+1]; 
//        for (int i = 1; i <= n - 1; i++) {
//            leftTreeInput[i] = 0;
//            rightTreeInput[i] = i + 1;
//        }        leftTreeInput[n] = 0;rightTreeInput[n] = 0;

//        int[] leftTreeInput={1,1,0,0,0};
//        int[] rightTreeInput={1,0,0,1,0};
//        int[] rightTreeInput={0,2,3,4,5,0};int n = 5;
//        int[] leftTreeInput={0,0,0,0,0,0};
        int[] leftTreeInput = {0,2, 0, 0, 0};        int n = 4;
        int[] rightTreeInput = {0,4, 3, 0, 0};
        System.out.println("left" + leftTreeInput.length);
        System.out.println("right" + rightTreeInput.length);
        PreorderInt poi = new PreorderInt(n, leftTreeInput, rightTreeInput,0);
        poi.preoprder(1);
        Create ca = new Create(n, tree_input, leftTreeInput, rightTreeInput);
        int insert = -1;
        while (insert != 0) {
            insert = ca.create();

        }

    }

}
