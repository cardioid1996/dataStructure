package com.ds.algorithms.recurse;

import java.util.*;

public class AllPermutation {

    public static void process1(ArrayList<String> res, char[] arr, int i){
        /* 字符串中没有重复的 */
        if(i == arr.length)
            res.add(Arrays.toString(arr));
        else{
            for (int j=i; j<arr.length; ++j){
                swap(arr, i, j);
                process1(res, arr, i+1);
            }
        }
    }

    public static void process2(ArrayList<String> res, char[] arr, int i){
        /* 字符串中有重复字符 */
        if (i == arr.length){
            res.add(Arrays.toString(arr));
        }
        else{
            HashSet<Character> set = new HashSet<>();
            for (int j=i; j<arr.length; ++j){
                if (!set.contains(arr[j])){
                    swap(arr, i, j);
                    set.add(arr[j]);
                    process2(res, arr, i+1);
                }
            }
        }

    }


    public static void swap(char[] arr, int a , int b){
        char c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }

    public static void main(String[] args) {
        String str = "aabc";
        char[] arr = str.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        HashSet<Character> set = new HashSet<>();
        process2(res,  arr, 0);
        for (String s : res)
            System.out.println(s);
    }
}
