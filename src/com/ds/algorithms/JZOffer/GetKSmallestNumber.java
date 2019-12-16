package com.ds.algorithms.JZOffer;

public class GetKSmallestNumber {

    /** 给定一个无序数组，得到第k小的数字  **/
    /** 思路：快速排序partition  **/

    public static int solution(int[] arr, int l, int r, int k){
        if(arr==null || arr.length==0 || k<=0 || k>arr.length)
            return -1;
        int[] mid_pos = partition(arr, l, r);
        if (mid_pos[0]<= k-1 && k-1 <= mid_pos[1])
            return arr[mid_pos[0]];
        else if (k < mid_pos[0])
            return solution(arr, l, mid_pos[0], k);
        else
            return solution(arr, mid_pos[1], arr.length-1, k);
    }


    public static int[] partition(int[] arr, int l, int r){
        int random_pos = (int)((r-l+1)*Math.random())+l;
        swap(arr, random_pos, r);
        int less = l-1;
        int more = r;
        int i = l;
        while (i < more){
            if(arr[i] < arr[r])
                swap(arr, i++, ++less);
            else if (arr[i] > arr[r])
                swap(arr, i, --more);
            else
                i++;
        }
        swap(arr, more++, r);
        return new int[]{less+1, more-1};
    }


    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,7,1,2};
        System.out.println(solution(arr, 0, arr.length-1, 2));
    }
}
