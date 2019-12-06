package com.ds.algorithms;


import java.util.*;
public class Permutation {
    public ArrayList<String> Permutation(String str) {

        ArrayList<String> result = new ArrayList<>();
        if(str.length()==0)
            return result;
        char[] c = new char[str.length()];
        for (int i=0; i<str.length(); ++i)
            c[i] = str.charAt(i);
        Arrays.sort(c);

        String curr = "";
        ArrayList<Integer> pos = new ArrayList<>();
        backtrack(result, curr, str, pos);
        return result;

    }

    public void backtrack(ArrayList<String> result, String curr, String str, ArrayList<Integer> pos){
        if(pos.size() == str.length()){
            String tmp = curr.toString();
            result.add(tmp);
            return;
        }
        for (int i=0; i<str.length(); ++i){
            if (pos.contains(i))
                continue;
            pos.add(i);
            System.out.println(curr.toString());
            for(int x : pos)
                System.out.print(x+",");
            System.out.println();
            backtrack(result, curr+str.charAt(i), str, pos);

            pos.remove(pos.size()-1);
        }
    }

    public static void main(String[] args) {
        Permutation p = new Permutation();
        String s = "abc";
        ArrayList<String> res = p.Permutation(s);
        for (String str : res)
            System.out.println(str);
    }
}