package com.ds.structure;

import java.util.Random;

import java.util.ArrayList;
import java.util.Collections;


import java.util.ArrayList;
public class MyStack {
    public int findFirstNoRepeat(String str) {
        int result = -1;
        char curr = str.charAt(0);
        int count = 1;
        for (int i=1; i<str.length(); ++i){
            if (str.charAt(i) == curr)
                count ++;
            else{
                if (count == 1){
                    result = i-1;
                    break;
                }
                else{
                    // the previous not only one
                    count = 1;
                    curr = str.charAt(i);
                }
            }
        }
        if (count == 1)
            result = str.length()-1;
        return result;
    }



    public static void main(String[] args) {
        MyStack m = new MyStack();
        String s = "aabbc";
        int n = m.findFirstNoRepeat(s);
        System.out.println("result:" + n);
    }

}











