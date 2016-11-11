package com.tlherr.TwoDimensionalArrayDS;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                //arr[arr_i][arr_j] = in.nextInt();
                //Saving time generating random input
                arr[arr_i][arr_j] = new Random().nextInt(18)-9;
                System.out.print(arr[arr_i][arr_j]+" ");
            }
            System.out.println("\n");
        }


        /**
         * 1 1 1 0 0 0
         * 0 1 0 0 0 0
         * 1 1 1 0 0 0
         * 0 0 0 0 0 0
         * 0 0 0 0 0 0
         * 0 0 0 0 0 0
         */
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

        for(int y_counter = 0; y_counter<arr.length-1; y_counter++) {
            for(int x_counter = 0; x_counter<arr[y_counter].length-1; x_counter++) {

                System.out.printf("X Counter: %d Y Counter: %d X Value: %d \n", x_counter, y_counter,
                        arr[y_counter][x_counter]);

                System.out.println(hourGlassExists(arr, x_counter, y_counter));

                if(hourGlassExists(arr, x_counter, y_counter)) {
                    //Create our hourglass from current positions

                    hourGlasses.add(new Hourglass(Arrays.copyOfRange(arr[y_counter], x_counter, x_counter+2),
                            arr[y_counter+1][x_counter+1],
                            Arrays.copyOfRange(arr[y_counter+2], x_counter, x_counter+2)
                    ));
                }
            }
        }

        for(Hourglass glass: hourGlasses) {
            System.out.print(glass.toString());
        }

        //Need to find all possible hourglasses and sum them
        //Then need to print out the hourglass with the maximum sum
    }

    public static boolean hourGlassExists(int arr[][], int x, int y) {
        return (arr.length - 4) < y && (arr[y].length - 4) < x;
    }

}