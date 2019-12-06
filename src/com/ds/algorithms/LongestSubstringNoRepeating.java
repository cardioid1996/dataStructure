package com.ds.algorithms;

public class LongestSubstringNoRepeating {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)
            return s.length();

        int max = 1;
        int l = 0;
        int r = 1;
        while (l < r && l >= 0 && r <= s.length() - 1) {
            char c = s.charAt(r);
            if (s.substring(l, r).indexOf(c) != -1) {
                // repeat
                System.out.println(c + " repeat");
                max = Math.max(max, r - l);
                System.out.println(max);
                l = l + s.indexOf(c, l) + 1;
                r++;
            } else {
                // no repeat
                System.out.println(c + " no repeat");
                r++;
                System.out.println(max);
            }
        }
        max = Math.max(max, r - l);
        return max;
    }



    public static void main(String[] args) {
        int res = lengthOfLongestSubstring("abcabcbb");
        System.out.println(res);
    }
}
