package com.ds.algorithms.JZOffer;

public class Q3_DuplicateNumInArray {

    /** 在一个长度为n的数组里所有数字都在 0 ~ n-1 范围内，找出任意一个重复的数字。 **/

    public static int findDuplicateNum(int[] nums){
        if(nums == null || nums.length <= 1)
            return -1;

        // 判断输入的合法性，保证所有元素都在 0 ~n-1 范围内
        for (int i=0; i<nums.length; ++i){
            if(nums[i] < 0 || nums[i]>nums.length-1)
                return -1;
        }

        for (int pos=0; pos<nums.length; ++pos){
            while (nums[pos] != pos){
                if(nums[nums[pos]] == nums[pos]){
                    return nums[pos];
                }
                swap(nums, pos, nums[pos]);
            }
        }
        return -1;
    }

    /** 不能修改原数组， n+1个元素，范围为1~n  */

    // 空间复杂度O(n)
    public static int findDuplicateNumNoModification1(int[] nums){
        int[] help = new int[nums.length-1];
        for (int i=0; i<nums.length; ++i){
            if (help[nums[i]] != 0)
                return nums[i];
            help[nums[i]-1] = nums[i];

        }
        return -1;
    }



    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }




    public static void main(String[] args) {
        int[][] nums = {{2,3,1,0,2,5,3}, {2,3,1,0}, {}, {1,3,8}, {-1, 2, 1}};
        for(int[] arr : nums)
            System.out.println(findDuplicateNum(arr));
    }

}
