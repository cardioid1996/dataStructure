package com.ds.algorithms;

// 1
import java.util.*;
// dfs

public class tencent{
    static int res = 0;

    public static int recurse(ArrayList<Integer> a){
        if (isPalindrome(a) || a.size()==1)
            return 1;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<a.size(); ++i){
            ArrayList<Integer> list = new ArrayList<>(a);
            list.remove(i);
            int tmp = 1+recurse(list);
            min = tmp<min?tmp:min;
        }
        return min;
    }
    public static boolean isPalindrome(ArrayList<Integer> a){
        int i=0;
        int j = a.size()-1;
        while (i<j){
            if (a.get(i)!=a.get(j))
                return false;
            i++;
            j--;
        }
        return true;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ArrayList<Integer> list = new ArrayList<>();
        for (int x : nums)
            list.add(x);
        int res = recurse(list);
        System.out.println(res);
    }

}


// 2
