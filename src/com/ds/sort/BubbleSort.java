package com.ds.sort;

public class BubbleSort {
    public static int[] sort(int[] a){
        for (int i=0; i<a.length-1; ++i){
            boolean change = false;
            for (int j=0; j<a.length-1-i; ++j){
                if (a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    change = true;
                }
            }
            System.out.print(i+1+":");
            display(a);
            if (!change)
                break;
        }
        return a;
    }

    public static void display(int[] a){
        for (int i=0; i<a.length; ++i){
            System.out.print(a[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] a = {2,4,8,9,5,7,6,1,3};
        a = sort(a);
    }
}
