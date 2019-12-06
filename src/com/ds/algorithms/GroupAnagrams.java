package com.ds.algorithms;
import java.util.*;

class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0)
            return res;

        for (int i=0; i<strs.length; ++i){
            boolean found = false;
            for (List<String> list : res){
                if (isSame(list.get(0), strs[i])){
                    list.add(strs[i]);
                    found = true;
                    break;
                }
            }
            if (!found){
                ArrayList<String> tmp = new ArrayList<>();
                tmp.add(strs[i]);
                res.add(tmp);
            }
        }
        return res;
    }

    public static boolean isSame(String a, String b){
        System.out.println(a + " and " + b);
        if (a.length() != b.length())
            return false;
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        Arrays.sort(ca);
        Arrays.sort(cb);


        for (int i=0; i<ca.length; ++i){
            if (i>cb.length-1 || cb[i]!=ca[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] list = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams(list);
        for (List<String> l : res){
            System.out.println(l);
        }
    }
}
