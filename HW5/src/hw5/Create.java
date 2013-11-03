/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw5;

/**
 *
 * @author Jelena
 */
public class Create {

    int n;
    int tree_input;
    int[] leftTreeInput;
    int[] rightTreeInput;
    int[] availablePositions;
    int topavail = -1;

    public Create() {
    }

    public Create(int n, int tree_input, int[] leftTreeInput, int[] rightTreeInput) {
        this.n = n;
        this.tree_input = tree_input;
        this.leftTreeInput = leftTreeInput;
        this.rightTreeInput = rightTreeInput;
        availablePositions = new int[n];
        s = new int[n];

    }

    public int create() {
        int p = 1;
        int iter;
        int numOfElements= 0;
        int right= 0;
        int predp= 0;
        int insert = 0;
        while (rightTreeInput[p] != 0 || leftTreeInput[p] != 0) {
            while (rightTreeInput[p] != 0) {
                numOfElements = 0;
                predp = p;
                right = rightTreeInput[p];
                p = right;
            }
            if (leftTreeInput[p] != 0) {
                numOfElements++;
                p = leftTreeInput[p];
            }
        }
        if (predp == 0) {
            insert = 0;
        } else if (leftTreeInput[predp] == 0) {
            insert = predp;
        } else {
            p = leftTreeInput[predp];
            while (rightTreeInput[p] != 0) {
                p = rightTreeInput[p];
            }
            insert = p;
        }
        if (rightTreeInput[insert] == 0) {
            rightTreeInput[insert] = right;
        } else {
            leftTreeInput[insert] = right;
        }
        rightTreeInput[right] = 0;
        leftTreeInput[right] = 0;
        rightTreeInput[predp] = 0;
        right++;
        iter = 1;
        while (rightTreeInput[iter] != 0) {
            iter = rightTreeInput[iter];
        }
        for (int i = 1; i <= numOfElements; i++) {
            rightTreeInput[iter] = right;
            leftTreeInput[right] = 0;
            rightTreeInput[right] = 0;
            iter = right;
            right++;
        }
        if (insert != 0) {
            visit(1);
        }

        return insert;
    }

    private void visit(int t) {

        s = new int[n];
        outputArray = new int[2 * n];
        for (int j = 0; j < outputArray.length; j++) {
            outputArray[j] = -22;

        }
        top = -1;
        oa = -1;
        rtptr = -1;
        //t = initialization();
        int p = t;
        //int[] s=new int[n];
        if (n <= 5) {
            System.out.println("***************" + (++noOfTrees) + "******************");
            System.out.println("Output of tree No: " + noOfTrees);
            System.out.print("Left: [");
            for (int j = 1; j < n; j++) {
                System.out.print(leftTreeInput[j] + ", ");
            }
            System.out.println(leftTreeInput[n] + "]");

            System.out.print("Right: [");
            for (int j = 1; j < n; j++) {
                System.out.print(rightTreeInput[j] + ", ");
            }
            System.out.println(rightTreeInput[n] + "]");

            while (p != 0 || top != -1) {
                //System.out.println("*********SADA JE P = "+p+"***********");
                if (p != 0) {
                    outputArray[++oa] = 1;
//                    System.out.println("Stack with top " + top + ".");
                    s[++top] = p; //push(p,s)
//                    System.out.println("Stack elements:");
//                    for (int j = 0; j < s.length; j++) {
//                        System.out.print(s[j] + " ");
//                    }
//                    System.out.println("");
                    if (leftTreeInput[p] != 0) {
                        p = leftTreeInput[p];
                    } else {
                        if (oa == (outputArray.length - 1)) {
                            break;
                        }
                        outputArray[++oa] = 0;
//                        System.out.println("_______________________");
//                        System.out.print("Output array left node od " + p + " je null: ");
//                        for (int j = 0; j < outputArray.length - 1; j++) {
//                            System.out.print(outputArray[j] + " ");
//                        }System.out.println(outputArray[outputArray.length - 1]+"");
//                        System.out.println("_______________________");
                        p = rightTreeInput[p];
                    }

                } else {
//                    System.out.println("_______________________");
//                    System.out.print("Output array: P " + p + " je null: ");
//                    for (int j = 0; j < outputArray.length - 1; j++) {
//                        System.out.print(outputArray[j] + " ");
//                    }System.out.println(outputArray[outputArray.length - 1]+"");
//                    System.out.println("_______________________");
                    if (oa == (outputArray.length - 1)) {
                        break;
                    }
                    outputArray[++oa] = 0;
//                    System.out.println("RTPTR:"+ rtptr);
                    do {
                        q = s[top];
                        top--;
//                        System.out.println("Stack elements with top " + top + ":");
//                        for (int j = 0; j < s.length ; j++) {
//                            System.out.print(s[j] + " ");
//                        }
//                        System.out.println("");
                        if (top != -1) {//is s is not empty
                            int newTop = s[top];
                            rtptr = rightTreeInput[newTop];
//                            System.out.println("Sade je rtprt:"+ rtptr);
                        } else {
                            rtptr = -1;
                        }
                    } while (top != -1 && q == rtptr);
                    p = rtptr;

                }
            }
            System.out.println("_______________________");
            System.out.print("Output array: ");
            for (int j = 0; j < outputArray.length - 1; j++) {
                System.out.print(outputArray[j] + " ");

            }
            System.out.println(outputArray[outputArray.length - 1] + "");

            for (int j = 0; j < outputArray.length - 1; j++) {
                if (outputArray[j] == 1) {
                    System.out.print("( ");
                } else if (outputArray[j] == 0) {
                    System.out.print(") ");
                }

            }
            if (outputArray[outputArray.length - 1] == 1) {
                System.out.println("( ");
            } else if (outputArray[outputArray.length - 1] == 0) {
                System.out.println(") ");
            }
            //System.out.println(outputArray[outputArray.length - 1] + "");

            System.out.println("_______________________");
            System.out.println("***************" + (noOfTrees) + "******************");
        } else {
            noOfTrees++;
            System.out.println(noOfTrees);
        }

        /////////PROMENI STAMPU DA STAMPA OD KECA
        ///////////////////Proveri sta ce ti biti top
        //finalization();
        //return t;
    }
    int[] s;
    int q;
    int top = -1;
    int oa = -1;
    int rtptr = -1;
    int[] outputArray;
    int noOfTrees = 1;

}
