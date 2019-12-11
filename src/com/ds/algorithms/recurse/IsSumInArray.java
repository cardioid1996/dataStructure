package algorithms.recurse;

/** 给定一个arr和target， 判断是否能挑选arr中的整数，相加得到target  **/

public class IsSumInArray {

    public static boolean judge(int[] arr, int pos, int target){
        if (pos >= arr.length || arr[pos]>target)
            return false;
        if (arr[pos] == target)
            return true;
        return judge(arr, pos+1, target) || judge(arr, pos+1, target-arr[pos]);
    }


    public static boolean judge2(int[] arr, int pos, int curr_sum, int target){
        if (curr_sum == target)
            return true;
        if (pos > arr.length-1 || curr_sum>target)
            return false;
        return judge2(arr, pos+1, curr_sum+arr[pos], target) || judge2(arr, pos+1, curr_sum, target);

    }


    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(judge2(arr, 0, 0, 5));
    }
}
