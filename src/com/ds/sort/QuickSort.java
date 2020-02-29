package com.ds.sort;

import java.util.Scanner;

public class QuickSort{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int[] nums = new int[len];
        for (int i=0; i<len; ++i)
            nums[i] = s.nextInt();
        quickSort(nums, 0, len-1);
    }


    public static void quickSort(int[] nums, int l, int r){
        if (nums==null || l>=r)
            return;
        int pos = partition(nums, l, r);
        quickSort(nums, l, pos-1);
        quickSort(nums, pos+1, r);
    }


    private static int partition(int[] nums, int l, int r){
        // random change the last num  l,r-1
        int end = r;
        int randomPos = l + (int)(Math.random()*(r-l));
        swap(nums, randomPos, r);
        int val = nums[r];
        while (l < r){
            while (l<r && nums[l]<=val)
                l++;
            while (l<r && nums[r]>=val)
                r--;
            if (l<r){
                swap(nums, l++, r--);
            }
        }
        swap(nums, l, end);
        return l;
    }


    private static void swap(int[] arr, int l, int r){
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

}