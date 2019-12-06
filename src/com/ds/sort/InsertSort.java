package com.ds.sort;

public class InsertSort {
    public static int[] sort(int[] a){
        for (int i=1; i<a.length; ++i){
            int val = a[i];
            for (int j=i-1; j>=0; --j){
                if (a[j]>=val){
                    a[j+1] = a[j];
                    if(j == 0){
                        a[j] = val;
                        break;
                    }
                    continue;
                }
                a[j+1] = val;
                break;
            }
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
        int[] a = {4,2,8,9,5,7,6,1,3};
        a = sort(a);
        display(a);
    }
}
