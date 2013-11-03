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
public class Preorder {
    Node t;
    Node p;
    Node[] s ;
    int top = -1;
    int i = 0;
    Node q;
    Node rtptr;

    public Preorder(int n) {
        s= new Node[n];
    }
    
    public void preoprder(Node t) {
        //t = initialization();
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

        //finalization();
        //return t;
    }

    private void visit(Node p) {
        System.out.println(p);
    }
}
