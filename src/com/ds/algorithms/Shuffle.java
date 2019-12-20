package com.ds.algorithms;

public class Shuffle {
    /** Fisher Yates 洗牌算法 **/
    public static void shuffle(int[] arr){
        int end = arr.length-1;
        while (end > 0){
            int rdm_pos = (int)Math.random()*(end+1);   // generate a num between [0, end]
            swap(arr, rdm_pos, end--);
        }
    }

    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
