package com.ds.algorithms;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ThreeSum {
    public static int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        int offset = Integer.MAX_VALUE;
        int i = 0;
        int curr = 0;
        int l = 0;
        int r = 0;
        int curr_l = 0;
        int curr_r = 0;
        while (i<nums.length){
            System.out.println("i<len");
            curr = nums[i];
            l = i+1;
            r = nums.length-1;
            while (l < r){
                System.out.println("l<r");
                curr_l = nums[l];
                curr_r = nums[r];
                int sum_tmp = nums[i]+nums[l]+nums[r];
                if (Math.abs(sum_tmp-target) < offset){
                    offset = Math.abs(sum_tmp-target);
                    if (offset == 0)
                        return target;
                    sum = sum_tmp;
                }
                if (sum_tmp < target){
                    while (l<nums.length && nums[l]==curr_l)
                        l++;
                    System.out.println("l: " + l);
                }
                else {
                    while (r>=0 && nums[r]==curr_r)
                        r--;
                    System.out.println("r: " + r);
                }
            }
            while (i<nums.length && nums[i]==curr)
                i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {0,-4,-1,-4,-2,-3,2};
        int res = threeSumClosest(nums, -5);
    }

}
