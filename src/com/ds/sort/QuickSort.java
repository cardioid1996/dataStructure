package com.ds.sort;

import java.util.Scanner;

public class QuickSort{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int[] arr = new int[len];
        for (int i=0; i<len; ++i){
            arr[i] = s.nextInt();
        }
        quicksort(arr, 0, arr.length-1);
        for (int n : arr)
            System.out.print(n + " ");
    }

    public static void quicksort(int[] arr, int l, int r){
        if (l >= r || l<0 || r>arr.length-1)
            return;

        // l<r
        int[] pos = partition(arr, l, r);
        quicksort(arr, l, pos[0]);
        quicksort(arr, pos[1], r);
    }

    public static int[] partition(int[] arr, int l, int r){
        // random change the last number
        int random_pos = (int)((r-l+1)*Math.random())+l;
        // 0-99
        // (int)(100*Math.random())
        swap(arr, random_pos, r);
        int less = l-1;
        int more = r;
        int i = l;
        while (i < more){
            if(arr[i] < arr[r]){
                swap(arr, ++less, i++);
            }
            else if (arr[i] == arr[r]){
                i++;
            }
            else{
                // curr > pivot
                swap(arr, i, --more);
            }
        }
        swap(arr, more++, r);
        return new int[]{less, more};
    }

    public static void swap(int[] arr, int l, int r){
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

}