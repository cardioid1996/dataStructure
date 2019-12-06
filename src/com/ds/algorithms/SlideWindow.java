package com.ds.algorithms;

import java.util.Arrays;
import java.util.ArrayList;
public class SlideWindow {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        // window_num = num.length - size
        // new[size-1] <= old[0], 不变
        // else: new[size-1] > old.max ? new[size-1] : old.max
        if (num==null || num.length == 0 || size<=0)
            return null;

        ArrayList<Integer> result = new ArrayList<>();
        if (size == 1){
            for (int x : num)
                result.add(x);
            return result;
        }
        if (size >= num.length){
            Arrays.sort(num);
            result.add(num[num.length-1]);
            return result;
        }
        int max = Integer.MIN_VALUE;
        for (int i=0; i<size; ++i){
            if (num[i] > max){
                max = num[i];
            }
        }
        result.add(max);
        System.out.println("first"+max);
        for (int i=1; i<=num.length-size; ++i){
            int new_ele = num[i+size-1];
            int old_ele = num[i-1];
            if (new_ele > max){
                // 新元素比原本的max大，直接覆盖
                result.add(new_ele);
                max = new_ele;
                System.out.println(max);
            }
            else{
                // 新元素比原本的max小
                if (max != old_ele){
                    // 最大的在新旧之间
                    result.add(max);
                    System.out.println(max);
                }else{
                    // 不知道新元素是不是最大的
                    max = Integer.MIN_VALUE;
                    for (int j=i; j<i+size;++j){
                        if (num[j] > max){
                            max = num[j];
                        }
                    }
                    result.add(max);
                    System.out.println(max);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,2,6,2,5,1};
        int size = 3;
        SlideWindow s = new SlideWindow();
        ArrayList<Integer> res = s.maxInWindows(nums, size);
        System.out.println("result:");
        for (int i=0; i<res.size(); ++i)
            System.out.println(res.get(i));
    }
}