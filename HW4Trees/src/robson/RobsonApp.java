/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robson;

import create.CreateAlgorithm;
import create.Preorder;
import structures.Node;

/**
 *
 * @author Jelena
 */
public class RobsonApp {
    public static void main(String[] args) {
        int n = 12;
        int tree_input = 1;
        //int[] leftTreeInput = new int[n];
        //int[] rightTreeInput = new int[n];
//        int[] leftTreeInput={1,1,0,0,0};
//        int[] rightTreeInput={1,0,0,1,0};

//        int[] leftTreeInput={1,1,1,0,0,0,0,1,0,0,1,0};
//        int[] rightTreeInput={1,1,1,0,0,1,0,1,1,0,0,0};

        int[] leftTreeInput={1,1,1,1, 0,0,0,1,1,1,1,0,0,0,1,0,0,1,0,0,1,0,0,1,1,0,1,0,0,1,0,1,0};
        int[] rightTreeInput={1,1,1,1,0,0,0,1,1,1,1,0,0,1,1,0,0,1,0,0,1,0,0,1,1,0,1,0,0,1,0,0,0};
        
        System.out.println("left"+ leftTreeInput.length);
        System.out.println("right"+ rightTreeInput.length);
        CreateAlgorithm ca = new CreateAlgorithm(n, tree_input, leftTreeInput, rightTreeInput);
        Node create = ca.create();
        Preorder pr= new Preorder(n);
        pr.preoprder(create);
        RobsonTraversal rt= new RobsonTraversal(create);
        rt.robson();
        
        Preorder prAFT= new Preorder(n);
        prAFT.preoprder(create);
    }
}
