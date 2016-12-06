package com.tlherr.TwoDimensionalArrayDS;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private final static int hourGlassWidth = 3;

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        System.out.printf("%1$22s", "Creating Matrix\n");
        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                //arr[arr_i][arr_j] = in.nextInt();
                arr[arr_i][arr_j] = new Random().nextInt(18)-9;
                System.out.printf("%1$4s", arr[arr_i][arr_j]);
            }
            System.out.println("\n");
        }

        class Hourglass {

            private int position;
            private int[] toprow;
            private int mid;
            private int[] bottomrow;

            public Hourglass(int position, int[] toprow, int mid, int[] bottomrow) {
                this.position = position;
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

            public int getPosition() {
                return position;
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

        int counter = 0;
        for(int y_counter = 0; y_counter<arr.length; y_counter++) {
            for(int x_counter = 0; x_counter<arr[y_counter].length; x_counter++) {

//                System.out.printf("X Counter: %d Y Counter: %d X Value: %d \n", x_counter, y_counter,
//                        arr[y_counter][x_counter]);

                if(hourGlassExists(arr, x_counter, y_counter)) {
                    hourGlasses.add(new Hourglass(counter, Arrays.copyOfRange(arr[y_counter], x_counter, x_counter+hourGlassWidth),
                            arr[y_counter+1][x_counter+1],
                            Arrays.copyOfRange(arr[y_counter+hourGlassWidth-1], x_counter, x_counter+hourGlassWidth)
                    ));
                    counter++;
                }
            }
        }

        int largestSum = 0;
        int largestPosition = 0;
        for(Hourglass glass: hourGlasses) {
            System.out.println("HourGlass ("+glass.getPosition()+")");
            System.out.println(glass.toString());
            System.out.println("Sum: "+glass.getSum());

            if(glass.getSum()>largestSum) {
                largestSum = glass.getSum();
                largestPosition = glass.getPosition();
            }

        }

        System.out.println("The largest summed hourglass is:\n "+hourGlasses.get(largestPosition).toString()
                + "\n at position "+largestPosition +" with sum: " +largestSum);

        //Need to find all possible hourglasses and sum them
        //Then need to print out the hourglass with the maximum sum
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