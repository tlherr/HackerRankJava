package com.tlherr.ArrayDS;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an array, A,N of  integers, print each element in reverse order as a single line of space-separated integers.
 */
public class Solution {


    public static void main(String[] args) {
        //Get the users input
        Scanner sysin = new Scanner(System.in);
        int n = sysin.nextInt();
        int array[] = new int[n];

        //Iterate for the size of the array and gather numbers
        for(int a = 0; a < array.length; a++) {
            array[a] = sysin.nextInt();
        }

        reverseIntArray(array);

        for(int a = 0; a < array.length; a++) {
            System.out.print(array[a]+" ");
        }

    }


    public static int[] reverseIntArray(int[] inputArray) {
        int midpoint = (int) Math.ceil(inputArray.length/2);
        for(int b = 0; b < midpoint; b++) {
            int tmp = inputArray[b];
            inputArray[b] = inputArray[(inputArray.length-1)-b];
            inputArray[(inputArray.length-1)-b] = tmp;
        }
        return inputArray;
    }
}
