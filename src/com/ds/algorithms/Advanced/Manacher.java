package com.ds.algorithms.Advanced;

public class Manacher {


    public static String preprocess(String str){

        StringBuilder sb = new StringBuilder("#");
        for (int i=0; i<str.length(); ++i){
            sb.append(str.charAt(i));
            sb.append("#");
        }
        return sb.toString();
    }


    public static int getLongestPalindrome(String str) {
        if (str == null || str.length() == 0)
            return 0;

        int max_len = Integer.MIN_VALUE;  // result to return
        String s = preprocess(str);
        int[] radius = new int[s.length()];
        int r = -1;
        int c = 0;

        for (int i = 0; i < s.length(); ++i) {
            radius[i] = i<r?Math.min(r-i, radius[2*c-i]):0;
            while (i-radius[i]-1 >=0 && i+radius[i]+1 < s.length() && (s.charAt(i+radius[i]+1)==s.charAt(i-radius[i]-1))){
                radius[i]++;
            }
            if(i+radius[i] > r){
                r = i+radius[i];
                c = i;
            }
            max_len = Math.max(max_len, radius[i]);

        }
        return max_len;
    }

    public static void main(String[] args) {
        String str = "abcba";
        System.out.println(getLongestPalindrome(str));
    }
}
