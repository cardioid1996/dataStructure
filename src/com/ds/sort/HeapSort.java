package com.ds.sort;

import java.security.InvalidParameterException;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {10,293, 108, 161, 783 ,376, 265, 330 ,598 ,646, 812};
        heapSort(arr);
    }

    public static void heapSort(int[] arr){
        for(int i=0; i<arr.length; ++i)
            heap_insert(arr, i);
        int size = arr.length;
        while (size > 0){
            System.out.println(arr[0]);
            swap(arr, 0, --size);
            heapify(arr, size);
        }
    }

    public static void heap_insert(int[] table, int curr){
        int parent = (curr-1)/2;
        while(parent>=0 && table[parent] > table[curr]){
            swap(table, curr, parent);
            curr = parent;
            parent = (curr-1)/2;
        }
    }

    public static void heapify(int[] table, int size){
        int curr = 0;
        int l = 2*curr+1;
        while(l <= size-1){
            int least = l+1<size && table[l+1]<table[l] ? l+1:l;
            least = table[least]<table[curr]?least:curr;
            if(least == curr)
                break;
            else{
                swap(table, curr, least);
                curr = least;
                l = 2*curr + 1;
            }
        }
    }


    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}


