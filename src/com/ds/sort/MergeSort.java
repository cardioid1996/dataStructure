package com.ds.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class MergeSort{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        if(input.length() <= 2)
            return;
        String[] str_arr = input.substring(1, input.length()-1).split(",");
        int[] arr = new int[str_arr.length];
        for (int i=0; i<arr.length; ++i)
            arr[i] = Integer.parseInt(str_arr[i].trim());

        int[] help = new int[arr.length];
        mergesort(arr, help, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergesort(int[] arr, int[] help, int l, int r){
        if (l >= r)
            return;
        int mid = l + (r-l)/2;
        mergesort(arr, help, l, mid);
        mergesort(arr, help, mid+1, r);
        merge(arr, help, l, mid, mid+1, r);
    }

    public static void merge(int[] arr, int[] help, int l1, int r1, int l2, int r2){
        int t = l1;
        int l = l1;
        int r = r2;
        while (l1 <= r1 && l2 <= r2){
            if(arr[l1] <= arr[l2]){
                help[t++] = arr[l1++];
            }
            else
                help[t++] = arr[l2++];
        }
        while (l1 <= r1)
            help[t++] = arr[l1++];
        while (l2 <= r2)
            help[t++] = arr[l2++];
        for (int i=l; i<=r; i++)
            arr[i] = help[i];
    }
}