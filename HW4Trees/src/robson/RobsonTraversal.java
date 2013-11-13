/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robson;

import structures.Node;

/**
 *
 * @author Jelena
 */
public class RobsonTraversal {

    Node t;
    Node p;
    Node stack;
    Node predp;
    Node top;
    Node next;
    Node avail;
    int i = 0;

    public RobsonTraversal() {
    }

    public RobsonTraversal(Node t) {
        this.t = t;
        this.p = this.t;
        this.stack = null;
        this.predp = this.t;
        this.top = null;
    }

    public void robson() {
        if (t != null) {
            boolean kraj = false;
            while (true) {
                while ((p.leftNode != null || p.rightNode != null)) {
                    if(kraj){if(t.equals(p)){return;}}
                    visit(p, stack, top);
                    if (p.leftNode != null) {// ima levo drvo
                        System.out.println("To the left");
                        next = p.leftNode; 
                        p.leftNode = predp;
                        predp = p;
                        p = next;
                        System.out.println("Next is \n"+ next);
                        kraj=true;
                    } else if (p.rightNode != null) {//ima desno drvo
                        System.out.println("To the right");
                        next = p.rightNode;
                        System.out.println("p.right is predp:\n"+ predp);
                        p.rightNode = predp;
                        predp = p;
                        p = next;
                        System.out.println("Next is \n"+ next);
                        kraj=true;
                    }
                }System.out.println("Leaf case");
                visit(p, stack, top);
                avail = p; 
                if (p.equals(t)){
                    break;
                } else {
                    while (!p.equals(t)) {
                        if (predp.rightNode == null) {
                            System.out.println("Right is null");
                            next = predp.leftNode; 
                            System.out.println("Predp. lef is \n"+ predp.leftNode);
                            System.out.println("Predp.lef is now p /n"+p);
                            predp.leftNode = p; 
                            System.out.println("p is now predp:\n"+predp);
                            p = predp;
                            predp = next; 
                            System.out.println("P : \n"+ p);
                            System.out.println("Predp : \n"+ predp);
                            continue;
                        }
                        if (predp.leftNode == null) {
                            System.out.println("Left is null");
                            next = predp.rightNode;
                            System.out.println("Predp.right is \n"+ predp.rightNode);
                            System.out.println("Predp.right is now p /n"+p);
                            predp.rightNode = p;
                            p = predp;
                            predp = next;
                            System.out.println("P : \n"+ p);
                            System.out.println("Predp : \n"+ predp);
                            continue;
                        }
                        if (predp.equals(top)) {
                            System.out.println("Prev is \n" + predp.value + " \nTop is \n " + top.value);
                            next = stack;
                            System.out.println("Stack is:\n"+stack);
                            top = stack.rightNode;
                            System.out.println("Top is stack.right\n"+top);
                            stack = stack.leftNode;
                            System.out.println("Stack is stack.left\n"+stack);
                            next.leftNode = null; System.out.println("Next.left and right are null.");
                            next.rightNode = null;

                            next = predp.rightNode; System.out.println("Next is now predp.rightNode\n"+next);
                            predp.rightNode = p;System.out.println("And predp.rightNode is  p\n"+p);
                            p = predp;System.out.println("P is predp\n"+predp);
                            predp = next; System.out.println("Predp is next\n"+next);
                            continue;
                        } else {
                            System.out.println("AVAIL");
                            System.out.println("avail.left is stack\n"+ stack);
                            avail.leftNode = stack; 
                            avail.rightNode = top; 
                            System.out.println("Avail.right is top\n"+top);

                            stack = avail; 
                            top = predp; 

                            System.out.println("Stack is now avail\n"+ stack);
                            System.out.println("Top is now predp\n"+ top);
                            next = predp.rightNode; System.out.println("Next will be right node of predp\n"+ next);
                            Node temp = predp.leftNode;
                            predp.leftNode = p; System.out.println("Predp.left is now p\n"+p);
                            predp.rightNode = temp;System.out.println("Predp.right is now predp.left\n"+temp);
                            p = next;
                            break;
                        }
                    }
                }
            }
        } else {
            System.out.println("Null tree");
        }
    }

    private void visit(Node p, Node stack, Node top) {
        System.out.println("**********START*************");
        System.out.println("Visited node:");
        System.out.println(p);
        System.out.println("TOP");
        System.out.println(top);
        System.out.println("Predp");
        System.out.println(predp);
        System.out.println("STACK pointers");
        if (stack != null) {
            Node iter = stack;
            while (iter != null) {
                System.out.println(iter);
                iter = iter.leftNode;
            }
            iter = stack;
            System.out.println("Elemnts on stack");
            while (iter != null) {
                if (iter.rightNode != null) {
                    System.out.println(iter.rightNode);
                }
                iter = iter.leftNode;
            }
        } else {
            System.out.println("There are no elements in the stack");
        }
        System.out.println("**********END*************");

    }

}
