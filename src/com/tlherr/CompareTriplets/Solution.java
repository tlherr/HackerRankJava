package com.tlherr.CompareTriplets;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();

        int[] scores = new int[3];
        scores[0] = 0;
        scores[1] = 0;
        scores[2] = 0;

        scores[getLarger(a0,b0)]++;
        scores[getLarger(a1,b1)]++;
        scores[getLarger(a2,b2)]++;

        System.out.println(scores[0]+" "+scores[1]);
    }

    public static int getLarger(int first, int second) {
        if(first==second) {
            return 2;
        } else if(first>second) {
            return 0;
        } else {
            return 1;
        }
    }
}

