package com.ds.algorithms;

public class Myatoi {
    public static int myAtoi(String str) {
        int res = 0;
        int changed = 0;
        boolean sign = true;
        int i=0;
        while (str.charAt(i)==' ')
            i++;
        for (; i<str.length(); ++i){
            char ch = str.charAt(i);

            if (ch>='0' && ch<='9'){
                System.out.println("ok");
                int tmp = ch-'0';
                if(sign == true && res>(Integer.MAX_VALUE-tmp)/10){
                    System.out.println(res);
                    return Integer.MAX_VALUE;
                }
                if(sign == false && -res<(Integer.MIN_VALUE+tmp)/10)
                    return Integer.MIN_VALUE;
                res = res*10 + tmp;
                changed = 1;
                continue;
            }

            if(changed == 0) {
                if ((ch < '0' || ch > '9') && ch != '-' && ch != '+')
                    return 0;
                if (ch == '-') {
                    sign = false;
                    changed = 1;
                    continue;
                }
                if (ch == '+') {
                    changed = 1;
                    continue;
                }
            }


            if((ch<'0' || ch>'9') && changed==1){
                break;
            }

        }
        res = sign==true?res:-res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("0012a42"));
    }
}
