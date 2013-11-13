/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modifiedGarwickAlgorithm;

import garwickAlgorithm.REMlessThanZeroException;

/**
 *
 * @author Jelena
 */
public class ModifiedGarwickAlgorithm {

    int[] stackLength;
    int[] table;
    int[] top;
    int[] base;
    int[] increase;
    int[] oldTop;
    int[] delta;
    int[] newBase;
    double[] Alloc;
    int totalSpaceUsed = 0;
    int totalIncrease = 0;
    int REM = 0;
    int tableMax = 0;
    int tableBase = 0;
    double ro;
    int N;
    int K;
    int noMovements = 0;
    int noMovements70 = 0;
    boolean p70 = false;

    public ModifiedGarwickAlgorithm(int nOFMemoryLocations, int nOfStacks, double ro) {
        this.ro = ro;
        tableMax = nOFMemoryLocations;
        table = new int[nOFMemoryLocations];
        N = nOfStacks;
        stackLength = new int[N];
        oldTop = new int[N];
        top = new int[N];
        base = new int[N + 1];
        newBase = new int[N + 1];
        increase = new int[N];
        Alloc = new double[N];
        delta = new int[N];
        int length = nOFMemoryLocations / nOfStacks; //100
        for (int i = 2; i < N; i++) {

            stackLength[i] = length;
            if (i % 2 == 0) {
                top[i] = oldTop[i] = base[i] = i * length;
                top[i - 1] = oldTop[i - 1] = i * length + 1;
                base[i - 1] = i * length;

            }

            top[i] = oldTop[i] = base[i] = (i) * length;
        }

        base[N] = nOFMemoryLocations;
        System.out.println("Base n " + base[N]);
        REM = tableMax - tableBase - totalSpaceUsed;
    }

    public void garwick() throws Exception {
        totalIncrease = 0;
        totalSpaceUsed = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) { //starting from 0
                stackLength[i] = top[i] - base[i];
            } else {
                stackLength[i] = base[i] - top[i] + 1;
            }
            //stackLength[i] = top[i] - base[i];
            if (stackLength[i] < 0) {
                stackLength[i] = 0;
            }
//            System.out.println("Stack length od i " + i + " is " + stackLength[i]);
//            System.out.println("TOP je " + top[i] + " and base je " + base[i]);
            //totalSpaceUsed += top[i] - base[i]; //1. a) Calculate Total Space Used ( ∑i=1, N (Top(i)-Base(i)) )
            totalSpaceUsed += stackLength[i];

            if (i % 2 == 0) {// starting from 0
                increase[i] = top[i] - oldTop[i];//b) For i=1 to N, calculate Increase(i) = Top(i)-Oldtop(i) 
            } else {
//                System.out.println("Old top "+ oldTop[i]);
//                System.out.println("TOp je "+ top[i]);
                increase[i] = oldTop[i] - top[i];
            }
            if (increase[i] < 0) {
                increase[i] = 0;//unless stack i hasn’t increased in size and then it is 0.
            }

            System.out.println("Increase of stack " + i + " is " + increase[i]);
            totalIncrease += increase[i]; //c) Calculate Sum of Increases (∑i=1, N (Increase(i) )
            //a) and c) are done as accumulated totals.
        }
        p70 = totalSpaceUsed >= (0.7 * tableMax);

        System.out.println("Total increase is : " + totalIncrease);
        System.out.println("Table max " + tableMax + " table base " + tableBase + " totalSpaceUSed " + totalSpaceUsed);
        System.out.println("Total space used 70% " + p70);
        REM = tableMax - tableBase - totalSpaceUsed; // 2. Remaining space REM =  (Table Max - Table Base) - Total Space Used.
        System.out.println("So, REM is: " + REM);
        if (REM < 0) {//If REM < 0 then cannot proceed. 
            throw new REMlessThanZeroException("Cannot proceed. There is no more space.");
        } else {// Otherwise, can proceed and REM is the amount of space to be reallocated.

            /*
             3. Set policy i.e. decide on ρ. ρ=0 stack size, ρ=1 recent growth
             4. and 5. Allocate space to ith stack in addition to its current size - this allocated space is 
             denoted by Alloci and is given by:
             */
            for (int i = 0; i < N; i++) {
                /*Alloci = REM x (1/N x .10 + Increase(i)/(Sum of Increases) x ρ x .90 + 
                 (size of ith stack)/(Total Space Used)	x (1-ρ) x .90)*/
                double totIncreaseZero, totSpaseZero;
                if (totalIncrease == 0) {
                    totIncreaseZero = 0;
                } else {
                    totIncreaseZero = (double) increase[i] * ro * 0.9 / totalIncrease;
                }
                if (totalSpaceUsed == 0) {//16
                    totSpaseZero = 0;
                } else {
                    totSpaseZero = stackLength[i] * (1.0 - ro) * 0.9 / (double) totalSpaceUsed; //0.084375
                }

//                System.out.println("Za i=" + i + " total Increae zerp=" + totIncreaseZero + " ,a totaSpaceZero=" + totSpaseZero);
                Alloc[i] = REM * ((0.1 * (1.0 / N)) + totIncreaseZero + totSpaseZero);
            }
            double sum = 0.0; ////Note that ∑i=1, N Alloci = REM
            for (int i = 0; i < N; i++) {
                sum += Alloc[i];
                System.out.println("Aloc " + i + " \t" + Alloc[i]);
            }
//            System.out.println("sum " + Math.round(sum));
//            System.out.println("sum " + sum);
//            System.out.println(REM);
            if (Math.round(sum) != REM) {
                throw new Exception("Nisu isti");
            } else {
                /*Then, the actual integer number of locations allocated to the ith stack (beyond its 
                 current size) is denoted by ∆i and is given by:*/
                double currentAllocSum = 0;
                int deltasum = 0;
                for (int i = 0; i < N - 1; i++) {
                    /*∆i = floor(Alloci) + floor[ fractional part of (Alloc1+…+ Alloci-1) + 
                     fractional part of {Alloci }]*/
                    delta[i] = (int) Math.floor(Alloc[i]);
                    double curFractPartI = Alloc[i] - delta[i];
                    delta[i] += Math.floor(currentAllocSum + curFractPartI);
                    //currentAllocSum+= (Alloc[i]-delta[i]);
                    currentAllocSum += curFractPartI;
                    System.out.println("Delta " + i + " i is \t" + delta[i]);
                    deltasum += delta[i];
                }
                delta[N - 1] = REM - deltasum;
                System.out.println("Delta n is " + delta[N - 1]);
                /*
                 Then,
                 Newbase(1)=Base(1)
                 Newbase(2)=Newbase(1)+(size of stack 1 ) +  ∆1
                 ...
                 Newbase(N)=Newbase(N-1)+(size of stack N-1 ) +  ∆N-1
                 */
                newBase[0] = base[0];
                System.out.println("new base of 0 " + newBase[0]);
                for (int i = 1; i < N; i++) {
                    if (i % 2 != 0) { //starting from 0000000000
                        newBase[i] = newBase[i - 1] + stackLength[i - 1] + delta[i - 1] + stackLength[i] + delta[i];
                        newBase[i + 1] = newBase[i]; //they have the same base 
                        System.out.println("New base of " + i + " is now " + newBase[i]);
                        System.out.println("New base of " + (i + 1) + " is now " + newBase[i + 1]);
                    }
                }
            }
            /*6. Move stackLength to their appropriate new locations by invoking the moving algorithm and
             also updates Base and Top.*/
            movingAlgorithm();
            /*7. Set Oldtop(i) to Top(i) for i=1 to N so the situation now can be saved until the next 
             reallocation is needed.*/
            if (K % 2 == 0) {
                top[K]++;
            } else {
                top[K]--;
            }
            System.out.println("Number of movements " + noMovements);
            for (int i = 0; i < N; i++) {
                oldTop[i] = top[i];
                System.out.println("And " + i + " top is now, like and old top " + top[i]);
            }
        }
    }

    public void movingAlgorithm() {
        /*The moving algorithm:
         1. Set Newbase(N+1) to Base(N+1) and Top(k) to Top(k)-1 so it reflects 
         the actual current top of stack k (the new element was not added yet). */
        newBase[N] = base[N];
        if (K % 2 == 0) {
            top[K]--;
        } else {
            top[K]++;
        }
        System.out.println("Top of K is now " + top[K]);
        //Set i to 2.*/
        for (int i = 1; i < N + 1; i++) {//While i < N 
            System.out.println("START MOVING--->" + i + "--> New base is " + newBase[i] + " and base is " + base[i]);
            if (newBase[i] < base[i]) {
                int moveAmount = base[i] - newBase[i];
                System.out.println("Move to the left stack i=" + i + " for " + moveAmount + " positions");
                if (i % 2 == 0) {// if it is odd stack (neparan) starting from 0
                    System.out.println("neparan");
                    for (int h = base[i] + 1; h <= top[i]; h++) {
                        //table[h - moveAmount] = table[h];
                        noMovements++;
                        if (!p70) {
                            noMovements70++;
                        }
                    }
                }//this one
                else {//it is even (paran)
                    System.out.println("paran");
                    for (int h = top[i]; h <= base[i]; h++) {
                        //table[h - moveAmount] = table[h];
                        noMovements++;
                        if (!p70) {
                            noMovements70++;
                        }
                    }
                }
                base[i] = newBase[i];
                top[i] = top[i] - moveAmount;
                System.out.println("Now the base after movement is " + base[i] + " , and top is " + top[i]);

            } else if (newBase[i] > base[i]) {
                System.out.println("Move to the right");
                int j = N;
                for (int k = i; k <= N; k++) {
                    if (newBase[k] <= base[k]) {
                        j = k;
                        break;
                    }
                }
                System.out.println("For movement of stack i=" + i + ", j=" + j);
                for (int t = j - 1; t >= i; t--) {
                    int moveAmount = newBase[t] - base[t];
                    if (t % 2 == 0) {//odd stack, starting from 0
                        for (int h = top[t]; h >= base[t] + 1; h--) {
                            //table[h + moveAmount] = table[h];
                            noMovements++;
                            if (!p70) {
                                noMovements70++;
                            }
                        }
                    } else {//even stack
                        for (int h = base[t]; h >= top[t]; h--) {
                            //table[h + moveAmount] = table[h];
                            noMovements++;
                            if (!p70) {
                                noMovements70++;
                            }
                        }
                    }
                    base[t] = newBase[t];
                    top[t] = top[t] + moveAmount;
                    //no_movements++;

                    System.out.println("New base is " + base[t] + " and new top is " + top[t] + " za t = " + t);
                    // l=j;
                }
                i = j - 1;
            } else {
                //i++;
            }
            System.out.println("Now the number of movements is: " + noMovements);
            System.out.println("Now the number of movements 70% is: " + noMovements70);

        }

        /*
         2. While i < N  

         if Newbase(i) < Base(i) 
         then stack i must be moved down by an amount δ = 	Base(i) - Newbase(i). 			
         So, for h from Base(i)+1 to Top(i) set Table (h- δ) to Table(h). Then 			
         readjust its base and top by setting Base(i) to Newbase(i) and Top(i) to 			
         Top(i)- δ. Then set i to i+1.
         else if Newbase(i)  > Base(i) 
         then stack i must be shifted up. But first all upward bound stackLength 				
         between stack i and the first stack above i that need not be moved up (if 			
         any) must be moved. So need to find smallest j where i<j<N+1such that 			
         Newbase(j) < Base(j). Note that if no other stack satisfies this then j=N+1 			
         will work. The stackLength are then moved up in order starting the (j-1)th, then 			
         the (j-2)th, . . . , and finally the ith. This is accomplished by:
         For t from j-1 down to i
         Set δ to Newbase(t)-Base(t)
         For h from Top(t) down to Base(t)+1
         Set Table(h+ δ) to Table(h)
         Set Base(t) to Newbase(t) and Top(t) to Top(t)+ δ
         Finally, set i to j.
         else set i to i+1.
         */
    }
    /*
     Allocation Algorithm: 
     Reallocates space for sequential stackLength when overflow occurs 
     (i.e. when an element is to be inserted in some stack k 
     but Top(k)+1>Base(k+1) - so if entered it would overwrite 
     the bottom element of the (k+1)th stack).

     Moving Algorithm:
     Assumes Top(k) has been changed to Top(k)+1 and then overflow was recognized 
     but Top(k) was not changed back. Assume arrays Top, Base, Oldtop, Newbase and Increase.
     Base(i) = Top(i) implies stack i is empty. The algorithm is invoked when some stack overflows.
     */

    public int randomUniform() {
        int randInt = (int) (10 * Math.random());
        System.out.println(randInt);
        return randInt;
    }

    public int skewDistribution() {
        int st = 0;
        double[] skd = new double[N];
        double ranNum = Math.random();
        skd[0] = 0;
        for (int i = 1; i < N; i++) {
            skd[i] = 1 - 1 / Math.pow(2, i);

            if (i != 0) {
                if (ranNum < skd[i] && ranNum > skd[i - 1]) {
                    return i;
                }
            }
        }
        return st;
    }

}
