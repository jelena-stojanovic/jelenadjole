/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extracredit;

import structures.Node;

/**
 *
 * @author Jelena
 */
public class ExtraCredit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //int[] inputarray={1, 1,1,1,1, 0,  0, 0, 0, 0};int n=5;
        //int[] inputarray={1, 1, 0, 1, 0, 0, 1, 0}; int n=4;
        //int[] inputarray={1,0,1,0,1,0,1,0,1,0};int n=5;
        int[] inputarray={1, 1,1,0,1,0,0,1,1,0,0,1,0,0,1,1,1,0,0,0,1,0,1,1,0,0};int n=13;
        
        Node t= new Node();
        Create ca = new Create(n, inputarray);
        ca.create(t);
        
        System.out.println("***********PRINT**********");
        System.out.println("Input is:");
        for (int i = 0; i < inputarray.length; i++) {
            int j = inputarray[i];
            if(j==1){
            System.out.print("( ");
            }else{
                System.out.print(")");
            }
        }
        System.out.println("\nTree looks like:");
        PreorderNormal pn= new PreorderNormal(n);
        pn.preoprder(t);
        System.out.println("Input is:");
        for (int i = 0; i < inputarray.length; i++) {
            int j = inputarray[i];
            if(j==1){
            System.out.print("( ");
            }else{
                System.out.print(")");
            }
        }
        System.out.println("\nParenthesis representation is:");
        Preorder poi = new Preorder(n);
        poi.preoprder(t);        
    }

}
