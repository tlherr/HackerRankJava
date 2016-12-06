package com.tlherr.MiniMaxSum;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        long d = in.nextLong();
        long e = in.nextLong();

        long[] numbers = new long[5];
        numbers[0] = a;
        numbers[1] = b;
        numbers[2] = c;
        numbers[3] = d;
        numbers[4] = e;

        //Calculate the largest and smallest sums each excluding one number
        long largestSum = 0;
        long smallestSum = 0;

        for(int i=0; i<numbers.length; i++) {
            long sum = sumArrayExceptElement(numbers, i);

            if(largestSum==0) {
                largestSum = sum;
            }

            if(sum>largestSum) {
                largestSum = sum;
            }

            if(smallestSum==0) {
                smallestSum = sum;
            }

            if(sum<smallestSum) {
                smallestSum = sum;
            }
        }

        System.out.println(smallestSum+" "+largestSum);

    }

    public static long sumArrayExceptElement(long[] array, long element) {
        long sum = 0;
        for(int i=0;i<array.length;i++) {
            if(i!=element) {
                sum+=array[i];
            }
        }
        return sum;
    }


}
