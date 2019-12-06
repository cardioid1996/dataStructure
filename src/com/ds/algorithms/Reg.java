package com.ds.algorithms;


import java.util.Arrays;
public class Reg {
    public boolean isMatch(String s, String p) {
        if(p.length() == 0)
            return s.length()==0;
        else if (p.length()>=2 && p.charAt(1)=='*'){
            if (s.length()==0)
                return isMatch(s, p.substring(2));
            else
                return isMatch(s, p.substring(2)) || isMatch(s.substring(1), p.substring(2)) || isMatch(s.substring(1), p);
        }
        else
            return s.length()!=0 && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.') && isMatch(s.substring(1), p.substring(1));

    }

    public static void main(String[] args) {
        Reg reg = new Reg();
        String str = "aaaaaaaaaaaaab";
        String pattern = "a*a*a*a*a*a*a*a*a*a*c";
        boolean result = reg.isMatch(str,pattern);
        System.out.println(result);
    }
}
