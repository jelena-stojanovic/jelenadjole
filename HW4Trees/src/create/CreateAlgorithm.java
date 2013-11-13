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
public class CreateAlgorithm {

    //preoprder traversal
    int n;
    int tree_input;
    int[] leftTreeInput;
    int[] rightTreeInput;

    public CreateAlgorithm() {
    }

    public CreateAlgorithm(int n, int tree_input, int[] leftTreeInput, int[] rightTreeInput) {
        this.n = n;
        this.tree_input = tree_input;
        this.leftTreeInput = leftTreeInput;
        this.rightTreeInput = rightTreeInput;
        s = new Node[n];
    }

    Node t;
    Node p;
    Node[] s ;
    int top = -1;
    int i = 0;
    Node q;
    Node rtptr;

    public Node create() {
        t = initialization();
        p = t;
        //int[] s=new int[n];

        while (p != null || top != -1) {
            if (p != null) {
                visit(p);
                
                s[++top] = p; //push(p,s)
                if (p.leftNode != null) {
                    p = p.leftNode;
                } else {
                    p = p.rightNode;
                }

            } else {
                do {
                    q = s[top];
                    top--;
                    if (top != -1) {//is s is not empty
                        Node newTop=s[top];
                        rtptr=newTop.rightNode;
                    }else{
                        rtptr=null;
                    }
                } while (top != -1 && q==rtptr);

                p = rtptr;

            }
        }

        finalization();
        return t;
    }

    private void visit(Node p) {
        
        if (leftTreeInput[i] == 1) {
            p.leftNode = new Node();
        }
        if (rightTreeInput[i] == 1) {
            p.rightNode = new Node();
        }
        i++;
        p.value = i;
        System.out.println(i + "\n  " + leftTreeInput[i - 1] + "  " + rightTreeInput[i - 1]);
    }

    private Node initialization() {
        Node t = null;
        if (tree_input == 1) {//read the first line  
            t = new Node();
        }
        return t;
    }

    private void finalization() {
        // no finalzation to do
    }
}
