package com.ds.algorithms;

public class MultiplyStrings {
}
class Solution {
    public String multiply(String num1, String num2) {
        if (num1=="0" || num2=="0" || num1.length()==0 || num2.length()==0)
            return "0";
        String res_str = "";
        long res_num = 0;
        int sqr = 1;
        for (int i=num2.length()-1; i>=0; --i){
            res_num = res_num + process(num1, num2.charAt(i))*sqr;
            sqr *= 10;
        }
        return Long.toString(res_num);
    }

    public long process(String longstr, char shortstr) {
        if(shortstr == '0')
            return 0;
        long res = 0;
        int carry = 0;
        int sqr = 0;
        for (int i=longstr.length()-1; i>=0; --i){
            int tmp_product = (shortstr-'0')*(longstr.charAt(i)-'0')+carry;
            int tmp = tmp_product%10;
            carry = tmp_product/10;
            res = res + tmp*sqr;
            sqr*=10;
        }
        if (carry > 0)
            res = res + carry*sqr;
        return res;
    }
}