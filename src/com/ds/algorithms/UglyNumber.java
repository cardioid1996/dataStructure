package com.ds.algorithms;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class UglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if (index < 7)
            return index;
        List<Integer> set = new ArrayList<>();

        set.add(Integer.valueOf(1));
        int count = 0;

        while (true){
            Collections.sort(set);
            int min = set.get(0);
            count ++;
            if (count == index)
                return min;
            set.remove(0);
            if (! set.contains(min * 2))
                set.add(min*2);
            if (! set.contains(min*3))
                set.add(min*3);
            if (! set.contains(min*5))
                set.add(min*5);
        }

    }

    public static void main(String[] args) {
        UglyNumber u = new UglyNumber();
        System.out.println(u.GetUglyNumber_Solution(7));
    }
}