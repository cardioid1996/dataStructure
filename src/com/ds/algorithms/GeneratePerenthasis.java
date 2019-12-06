package com.ds.algorithms;
import java.util.*;

class GeneratePerenthasis {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0)
            return res;
        int num = n*2;
        StringBuilder curr = new StringBuilder();
        backtrack(res, curr, num, 0);
        return res;
    }

    public static void backtrack(List<String> res, StringBuilder curr, int len, int score){
        if (score==0 && curr.length() == len){
            res.add(new String(curr.toString()));
            return;
        }
        if (score<0 || curr.length()>len)
            return;

        backtrack(res, curr.append("("), len, score+1);
        curr.deleteCharAt(curr.length()-1);
        backtrack(res, curr.append(")"), len, score-1);
        curr.deleteCharAt(curr.length()-1);
        return;
    }

    public static void main(String[] args) {
        List<String> res = GeneratePerenthasis.generateParenthesis(2);
        for(String s : res)
            System.out.println(s);
    }
}
