package com.ds.algorithms.Advanced;

public class ManacherProblem1 {

    /** 问题：在一个字符串后面追加最少的字符，使得整个字符串成为回文串

    /** 思路：求得以最后一个字符为结尾的最长回文子串a，在后面追加a前字符的逆序
     */

    public static String preprocess(String str){
        StringBuilder sb = new StringBuilder("#");
        for (int i=0; i<str.length(); ++i){
            sb.append(str.charAt(i));
            sb.append("#");
        }
        return sb.toString();
    }


    public static String solution(String str){
        StringBuilder res = new StringBuilder();
        str = preprocess(str);
        int[] radius = new int[str.length()];
        int r = -1;
        int c = -1;
        for (int i=0; i<str.length(); ++i){
            radius[i] = r>i ? Math.min(r-i, radius[2*c-i]) : 0;
            while (i-radius[i]-1 >= 0 && i+radius[i]+1 < str.length() && str.charAt(i-radius[i]-1)==str.charAt(i+radius[i]+1))
                radius[i]++;
            if (i+radius[i] > r){
                r = i+radius[i];
                c = i;
                if (r == str.length()-1)
                    break;
            }
        }

        for (int i=c-radius[c]-1; i>=0; --i){
            if(str.charAt(i) != '#')
                res.append(str.charAt(i));
        }
        return res.toString();
    }


    public static void main(String[] args) {
        String s = "abcdc";
        System.out.println(solution(s));
    }


}
