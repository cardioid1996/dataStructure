package com.ds.algorithms.JZOffer;

public class Q5_ReplaceBlanks {

    /** 将字符串里的空格转化为%20 **/

    public static String replace(String str){
        if(str == null || str.length() == 0)
            return str;
        char[] arr_old = str.toCharArray();
        int blank_num = 0;
        for (int i=0; i<arr_old.length; ++i){
            if(arr_old[i] == ' ')
                blank_num++;
        }
        if (blank_num == 0)
            return str;
        char[] arr = new char[arr_old.length+2*blank_num];
        for (int i=0; i<arr_old.length; ++i)
            arr[i] = arr_old[i];
        int pre = arr_old.length-1;
        int post = arr.length-1;

        while (pre >= 0){
            while (pre>=0 && arr[pre]!=' ')
                arr[post--] = arr[pre--];
            if (pre < 0)
                return String.valueOf(arr);
            while (arr[pre] == ' '){
                arr[post--] = '0';
                arr[post--] = '2';
                arr[post--] = '%';
                pre--;
            }
        }
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        String str = "hello world hi.";
        System.out.println(replace(str));
    }
}
