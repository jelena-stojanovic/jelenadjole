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
public class Create {

    int n;
    int[] tree_input;
    int topavail = -1;

    public Create() {
    }

    public Create(int n, int[] tree_input) {
        this.n = n;
        this.tree_input = tree_input;
        s = new Node[n];

    }

    public Node create(Node t) {
        Node p = t;
        Node predp = t;
        i = 0;
        //visitCreate
        while ((p != null || top != -1) && (i < 2 * n - 1)) {
            if (p != null) {
                visitCreate(p);

                s[++top] = p; //push(p,s)
                if (p.leftNode != null) {
                    p = p.leftNode;
                } else {
                    p = p.rightNode;
                }
            } else {
                do {
                    predp = s[top];

                    if (predp.rightNode == null && predp.leftNode != null) {
                        if ((i < tree_input.length - 1)) {
                            if (tree_input[i] == 1) {
                                p = new Node();
                                rtptr = p;
                                s[top].rightNode = rtptr;
                                break;
                            } else {
                                top--;
                                i++;
                                if (top != -1) {//is s is not empty
                                    Node newTop = s[top];
                                    rtptr = newTop.rightNode;
                                } else {
                                    rtptr = null;
                                }
                            }
                        }
                    } else {
                        top--;
                        if (top != -1) {//is s is not empty
                            Node newTop = s[top];
                            rtptr = newTop.rightNode;
                        } else {
                            rtptr = null;
                        }
                    }
                } while (top != -1 && predp == rtptr);
                p = rtptr;
            }

        }
        return t;
    }

    int info = 1;

    private void visitCreate(Node p) {
        System.out.println("*******************NODE " + info + "**********");
        i++;
        System.out.println("I je sad" + i);
        p.value = info;

        System.out.println("Tree input od " + i + " je " + tree_input[i]);
        if (tree_input[i] == 1) {
            System.out.println("Ima levi");
            p.leftNode = new Node();

        } else if ((i < tree_input.length - 1) && tree_input[i + 1] == 1) {
            System.out.println("Nema levi ali ima desni");
            p.rightNode = new Node();
            i++;
        } else {
            System.out.println("Nema ni levi ni desni");
            i = i + 2;
        }
        System.out.println("I je posle pomeranja: " + i);

        System.out.println(p);
        info++;
    }

    Node t;
    Node p;
    Node[] s;
    int top = -1;
    int i = 0;
    Node predp;
    Node rtptr;
    int[] leftNode;
    int[] rightNode;
    int noOfTrees;

}
