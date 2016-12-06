package com.tlherr.TwoDimensionalArrayDS;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Calculate the hourglass sum for every hourglass in , then print the maximum hourglass sum.
 *
 * Input Format:
 * There are  lines of input, where each line contains  space-separated integers describing 2D Array ;
 * every value in  will be in the inclusive range of -9 to 9.
 *
 *
 */
public class Solution {

    private final static int hourGlassWidth = 3;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++) {
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }


        class Hourglass {

            private int[] toprow;
            private int mid;
            private int[] bottomrow;

            public Hourglass(int[] toprow, int mid, int[] bottomrow) {
                this.toprow = toprow;
                this.mid = mid;
                this.bottomrow = bottomrow;
            }

            public int getSum() {
                int sum = 0;

                for (int aToprow : this.toprow) {
                    sum+=aToprow;
                }

                sum+=this.mid;

                for (int aBottomrow : this.bottomrow) {
                    sum+=aBottomrow;
                }

                return sum;
            }

            @Override
            public String toString() {
                String returnString = "";

                for (int aToprow : this.toprow) {
                    returnString += aToprow + " ";
                }
                returnString+="\n"+this.mid+"\n";
                for (int aBottomrow : this.bottomrow) {
                    returnString += aBottomrow + " ";
                }

                return returnString;
            }
        }

        ArrayList<Hourglass> hourGlasses = new ArrayList<Hourglass>();

        for(int y_counter = 0; y_counter<arr.length; y_counter++) {
            for(int x_counter = 0; x_counter<arr[y_counter].length; x_counter++) {

//                System.out.printf("X Counter: %d Y Counter: %d X Value: %d \n", x_counter, y_counter,
//                        arr[y_counter][x_counter]);

                if(hourGlassExists(arr, x_counter, y_counter)) {
                    hourGlasses.add(new Hourglass(Arrays.copyOfRange(arr[y_counter], x_counter, x_counter+hourGlassWidth),
                            arr[y_counter+1][x_counter+1],
                            Arrays.copyOfRange(arr[y_counter+hourGlassWidth-1], x_counter, x_counter+hourGlassWidth)
                    ));
                }
            }
        }

        int largestSum = 0;
        for(Hourglass glass: hourGlasses) {

            if(glass.getSum()>largestSum) {
                largestSum = glass.getSum();
            }

        }

        System.out.println(largestSum);
    }

    /**
     * Method to check if an hourglass can be found in the matrix at a given position
     * Hourglasses are I shapes with a top row of 3 elements, middle row of 1 and bottom row of 3
     *
     * @param arr Matrix containing hourlgass values
     * @param x X coordinate to check from
     * @param y Y coordinate to check from
     * @return Boolean yes/no if an hourglass can exist
     */
    public static boolean hourGlassExists(int arr[][], int x, int y) {
        return (arr.length-hourGlassWidth+1) > y && (arr[y].length-hourGlassWidth+1) > x;
    }

}