package com.tlherr.CamelCase;

import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        int leftBoundry = 0;
        int wordCount = 0;
        for(int i=0; i<s.length();i++) {
            char c = s.charAt(i);
            if(Character.isUpperCase(c)) {
                wordCount++;
            }
        }

        wordCount++;
        System.out.println(wordCount);
    }
}

