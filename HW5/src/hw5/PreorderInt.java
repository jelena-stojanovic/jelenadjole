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
public class PreorderInt {

    int t;
    int p;
    int[] s;

    //int i = 0;
    int q;
    int top = -1;
    int oa = -1;
    int rtptr = -1;
    int[] outputArray;
    int noOfTrees = 0;
    int n;
    int[] leftNode;
    int[] rightNode;

    public PreorderInt(int n, int[] lefttree, int[] righttree, int numberOftrees) {
        this.n = n;
        this.leftNode = lefttree;
        this.rightNode = righttree;
        this.noOfTrees = numberOftrees;
        s = new int[n];
        outputArray = new int[2 * n];
        for (int j = 0; j < outputArray.length; j++) {
            outputArray[j] = -22;

        }
    }

    public void preoprder(int t) {
        s = new int[n];
        outputArray = new int[2 * n];
        for (int j = 0; j < outputArray.length; j++) {
            outputArray[j] = -22;

        }
        top = -1;
        oa = -1;
        rtptr = -1;
        //t = initialization();
        p = t;
        //int[] s=new int[n];
        if (n <= 5) {
            System.out.println("***************" + (++noOfTrees) + "******************");
            System.out.println("Output of tree No: " + noOfTrees);
            System.out.print("Left: [");
            for (int j = 1; j < n; j++) {
                System.out.print(leftNode[j] + ", ");
            }
            System.out.println(leftNode[n] + "]");

            System.out.print("Right: [");
            for (int j = 1; j < n; j++) {
                System.out.print(rightNode[j] + ", ");
            }
            System.out.println(rightNode[n] + "]");

            while (p != 0 || top != -1) {
                //System.out.println("*********SADA JE P = "+p+"***********");
                if (p != 0) {
                    visit(p);
//                    System.out.println("Stack with top " + top + ".");
                    s[++top] = p; //push(p,s)
//                    System.out.println("Stack elements:");
//                    for (int j = 0; j < s.length; j++) {
//                        System.out.print(s[j] + " ");
//                    }
//                    System.out.println("");
                    if (leftNode[p] != 0) {
                        p = leftNode[p];
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
                        p = rightNode[p];
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
                            rtptr = rightNode[newTop];
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
                    System.out.print("( " );
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
            System.out.println("***************" + noOfTrees + "******************");

        } else {
            noOfTrees++;
        }

        /////////PROMENI STAMPU DA STAMPA OD KECA
        ///////////////////Proveri sta ce ti biti top
        //finalization();
        //return t;
    }

    private void visit(int p) {
        outputArray[++oa] = 1;
//        System.out.print("Output array VISIT p " + p + ": ");
//        for (int j = 0; j < outputArray.length - 1; j++) {
//            System.out.print(outputArray[j] + " ");
//        }System.out.println(outputArray[outputArray.length - 1]+"");
//        System.out.println("_______________________");
    }
}
