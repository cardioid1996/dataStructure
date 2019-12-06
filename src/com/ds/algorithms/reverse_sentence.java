package com.ds.algorithms;

public class reverse_sentence {
    public static String ReverseSentence(String str) {
        char[] result = new char[str.length()];
        for (int i=0; i<str.length(); ++i)
            result[i] = str.charAt(i);
        if (str.length() == 0 || str.trim().equals(""))
            return str;
        int l = 0;
        while (result[l] == ' ' && l<result.length)
            l++;
        System.out.println(l);
        for (int r=l+1; r<result.length; ++r){
            if (result[r] == ' '){
                System.out.println("r"+r);
                reverse(result, l, r-1);
                while (r<result.length && result[r]==' ')
                    r++;

                l = r;
            }
            else if (r == str.length()-1){
                reverse(result, l, r);
            }
        }
        reverse(result, 0, str.length()-1);
        String res = new String(result);
        return res;

    }

    public static void reverse(char[] str, int l, int r){
        if (l>=0 && r<str.length && l<r){
            while (l < r){
                char tmp = str[l];
                str[l] = str[r];
                str[r] = tmp;
                l++;
                r--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse_sentence.ReverseSentence("  world.    hello  "));
    }
}