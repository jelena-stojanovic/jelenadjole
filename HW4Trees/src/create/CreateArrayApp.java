/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package create;

import structures.Node;

/**
 *
 * @author Jelena
 */
public class CreateArrayApp {

    public static void main(String[] args) {
        int n = 4;
        int tree_input = 1;
        //int[] leftTreeInput = new int[n];
        //int[] rightTreeInput = new int[n];
        int[] leftTreeInput={1,1,0,0,0};
        int[] rightTreeInput={1,0,0,1,0};
        System.out.println("left"+ leftTreeInput.length);
        System.out.println("right"+ rightTreeInput.length);
        CreateAlgorithm ca = new CreateAlgorithm(n, tree_input, leftTreeInput, rightTreeInput);
        Node create = ca.create();
        System.out.println("Preorder");
        Preorder pr= new Preorder(n);
        pr.preoprder(create);
        System.out.println("Inorder");
        Inorder in= new Inorder(n);
        in.inorder(create);
        System.out.println("Postorder");
        Postorder post= new Postorder(n);
        post.postorder(create);
    }
}
