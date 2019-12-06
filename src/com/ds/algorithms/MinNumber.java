package com.ds.algorithms;


import com.ds.structure.MinStack;

import java.util.ArrayList;

public class MinNumber {
    public String PrintMinNumber(int [] numbers) {
        if(numbers.length==0)
            return "";
        if (numbers.length==1)
            return Integer.toString(numbers[0]);
        ArrayList<Integer> nums= new ArrayList<>();
        for (int i : numbers)
            nums.add(i);
        long res = min(nums);
        return Long.toString(res);
    }

    public long min(ArrayList<Integer> numbers){
        long min_value = Long.MAX_VALUE;
        if (numbers.size()==1)
            return (int)numbers.get(0);

        for (int i=0; i<numbers.size(); ++i){
            int val = numbers.get(i);
            ArrayList<Integer> list = new ArrayList(numbers);
            list.remove(i);
            long tmp = min(list)*getPosNum(val)*10+val;
            min_value = tmp<min_value?tmp:min_value;
        }
        return min_value;
    }

    public int getPosNum(long num){
        System.out.println("num:"+num);
        int res = 0;
        while (num>0){
            num/=10;
            res++;
        }
        System.out.println("pos:"+res);
        return res;
    }

    public void show(ArrayList<Integer> a){
        for (int i=0; i<a.size(); ++i)
            System.out.print(a.get(i)+",");
        System.out.println();
    }

    public static void main(String[] args) {
        MinNumber m = new MinNumber();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(m.PrintMinNumber(nums));
    }

}


