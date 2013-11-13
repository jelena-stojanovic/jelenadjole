/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extracredit;

import hw5.*;
import structures.Node;

/**
 *
 * @author Jelena
 */
public class Preorder {

    Node t;
    Node p;
    Node[] s;
    int top = -1;
    int i = 0;
    Node q;
    Node rtptr;
    int n;

    int noOfTrees;

    public Preorder(int n) {
        s = new Node[n];
        this.n = n;
        
    }

    public void preoprder(Node t) {
        // t = initialization();
////        Write and test a non-recursive program "create", 
//        that reads only the sequence of n 0's and n 1's
//        (i.e. the n right and n left parentheses) representing an n node 
//                binary tree as we discussed in class and creates the standard  
//                linked representation of the tree in memory with a node assigned
//                an info value i if it is the ith node visited in a preorder 
//                traversal. This program should echo the input. After the tree 
//                is created, output its parentheses representation with each left
//                parenthesis succeeded by its info value.  For example, if the 
//                input is (()())() then the output parenthesis representation 
//                should appear as (1(2)(3))(4)

        p = t;

        while (p != null || top != -1) {
            if (p != null) {
                visit(p);

                s[++top] = p; //push(p,s)
                if (p.leftNode != null) {
                    p = p.leftNode;
                } else {

                    System.out.print(")");i++;
                    p = p.rightNode;
                }

            } else {
                do {
                    q = s[top];
                    top--;
                    if (top != -1) {//is s is not empty
                        Node newTop = s[top];
                        rtptr = newTop.rightNode;
                    } else {
                        rtptr = null;
                    }
                } while (top != -1 && q == rtptr);

                p = rtptr;
                
                if(i<n){
                    i++;
                System.out.print(")");
                }
            }
        }

        //finalization();
    }

    private void visit(Node p) {
        System.out.print("(" + p.value);
    }
}
