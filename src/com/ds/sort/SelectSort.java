package com.ds.sort;

public class SelectSort {
    public static int[] sort(int[] a){
        for (int i=0; i<a.length-1; ++i){
            int min = a[i];
            int min_index = i;
            for(int j=i+1; j<a.length; ++j){
                if (a[j] < min){
                    min = a[j];
                    min_index = j;
                }
            }
            if (min_index != i) {
                a[min_index] = a[i];
                a[i] = min;
            }
        }
        return a;
    }

    public static void display(int[] a){
        for (int i=0; i<a.length; ++i)
            System.out.print(a[i] + ",");
        System.out.println();
    }

    public static void main(String[] args){
        int[] a = {4,2,8,9,5,7,6,1,3};
        a = sort(a);
        display(a);
    }

}
