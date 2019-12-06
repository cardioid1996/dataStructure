package com.ds.algorithms;


//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
import java.util.ArrayList;
public class TwoOnlyNums {
    public ArrayList<Integer> FindNumsAppearOnce(int [] array) {

        int result = 0;
        // Result是所有数字亦或的结果
        for (int i=0; i<array.length; ++i)
            result^=array[i];
        System.out.println("result after ^: " + result);
        int tmp = 1;
        while(true){
            if ((result&1) == 1)
                break;
            result>>=1;
            tmp<<=1;
        }
        System.out.println("tmp: "+tmp);
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int x : array){
            if ((x&tmp) == tmp)
                list1.add(x);
            else
                list2.add(x);
        }
        System.out.println("list1:");
        show(list1);
        System.out.println("list2:");
        show(list2);
        int n1 = 0;
        int n2 = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i=0; i<list1.size(); ++i)
            n1 ^= list1.get(i);
        for (int i=0; i<list2.size(); ++i)
            n2 ^= list2.get(i);
        res.add(n1);
        res.add(n2);
        return res;

    }

    public static void main(String[] args) {
        int[] array = {2,4,3,6,3,2,5,5};
        TwoOnlyNums t = new TwoOnlyNums();
        ArrayList<Integer> res = t.FindNumsAppearOnce(array);
        show(res);

    }

    public static void show(ArrayList<Integer> a){
        for (int i=0; i<a.size(); ++i)
            System.out.print(a.get(i));
        System.out.println();
    }



}