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
public class Inorder {

    Node t;
    Node p;
    Node[] s;
    int top = -1;
    int i = 0;
    Node q;
    Node rtptr;
    int n=0;

    public Inorder(int n) {
        s = new Node[n];
        this.n=n;
    }

    public void inorder(Node t) {
        //t = initialization();
        p = t;
        //int[] s=new int[n];
        while (p != null || top != -1) {
            
            if (p != null) {

                s[++top] = p; //push(p,s)
                if (p.leftNode != null) {
                    p = p.leftNode;
                } else {
                    visit(p);
                    p = p.rightNode;
                }
            } else {
                do {
                    q = s[top];
                    top--;
                    if (top != -1) {//is s is not empty
                        p = s[top];
                        rtptr = p.rightNode;
                    } else {
                        rtptr = null;
                    }
                } while (top != -1 && q == rtptr);
                if (top != -1) {
                    visit(p);
                    p = rtptr;
                }
           
            }
            
        }
        //finalization();
        //return t;
    }

    private void visit(Node p) {
        System.out.println(p);
    }
}
