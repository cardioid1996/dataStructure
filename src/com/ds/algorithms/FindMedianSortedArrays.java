package com.ds.algorithms;

public class FindMedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total_len = nums1.length + nums2.length;
        double res = 0.0;
        if (nums1.length == 0){
            res = (double)(nums2[(nums2.length-1)/2]+nums2[nums2.length/2])/2;
            return res;

        }
        if(nums2.length == 0){
            res = (double)(nums1[(nums1.length-1)/2]+nums1[nums2.length/2])/2;
            return res;
        }

        // both not empty
        int p = 0;
        int q = 0;
        int t = 0;
        int[] help = new int[total_len];
        while (p<nums1.length && q<nums2.length){
            if (nums1[p] <= nums2[q]){
                help[t] = nums1[p];
                p++;
            }
            else{
                help[t] = nums2[q];
                q++;
            }
            if(t == total_len/2){
                res = (double)(help[t]+help[(total_len-1)/2])/2;
                return res;
            }
            System.out.println("help No." + t + ":" + help[t]);
            t++;
        }
        while (p<nums1.length){
            help[t] = nums1[p];
            System.out.println("help No." + t + ":" + help[t]);
            p++;
            if(t == total_len/2){
                System.out.println("first:" + help[t]);
                System.out.println("second: " + help[(total_len-1)/2]);
                res = (double)(help[t]+help[(total_len-1)/2])/2;
                return res;
            }
            t++;
        }

        while (q<nums2.length){
            help[t] = nums2[q];
            System.out.println("help No." + t + ":" + help[t]);
            q++;
            if(t == total_len/2){
                System.out.println("first:" + help[t]);
                System.out.println("second: " + help[(total_len-1)/2]);
                res = (double)(help[t]+help[(total_len-1)/2])/2;
                return res;
            }
            t++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println("result: "+findMedianSortedArrays(nums1, nums2));
    }
}
