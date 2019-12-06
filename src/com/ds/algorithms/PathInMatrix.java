package com.ds.algorithms;


import java.util.ArrayList;
public class PathInMatrix {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if (matrix.length==0 && str.length==0)
            return true;
        if(matrix==null || matrix.length==0 || rows==0 || cols==0 || str.length==0)
            return false;

        for (int i=0; i<matrix.length; ++i){
            if (matrix[i] == str[0]){
                System.out.println(i);
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                boolean flag = backtrack(list, matrix, i, rows, cols, str, 1);
                if (flag)
                    return true;
            }
        }
        return false;

    }

    public boolean backtrack(ArrayList<Integer> list, char[] matrix, int pos, int rows, int cols, char[] str, int index){
        if (list.size() == str.length)
            return true;
        if (index > str.length-1 || pos>matrix.length-1)
            return false;
        char next = str[index];
        // left
        if (pos%cols>0 && pos-1>=0 && matrix[pos-1] == next && !list.contains(pos-1)){
            System.out.println("left");
            list.add(pos-1);
            if(backtrack(list, matrix, pos-1, rows, cols, str, index+1))
                return true;
        }
        // right
        if (pos%cols<=cols-1 && pos+1<matrix.length && matrix[pos+1]==next && !list.contains(pos+1)){
            list.add(pos+1);
            System.out.println("right");
            if(backtrack(list, matrix, pos+1, rows, cols, str, index+1))
                return true;
        }
        // top
        if (pos>=cols && matrix[pos-cols]==next && !list.contains(pos-cols)){
            list.add(pos-cols);
            System.out.println("top");
            if(backtrack(list, matrix, pos-cols, rows, cols, str, index+1))
                return true;
        }
        // bottom
        if (pos<matrix.length-cols && matrix[pos+cols]==next && !list.contains(pos+cols)){
            list.add(pos+cols);
            System.out.println("bottom");
            if(backtrack(list, matrix, pos+cols, rows, cols, str, index+1))
                return true;
        }
        System.out.println("pos" + pos +": 上下左右都没有");
        return false;
    }

    public static void main(String[] args) {
        PathInMatrix p = new PathInMatrix();
        String matrix_str = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS";
        char[] matrix = matrix_str.toCharArray();
        String str_str = "SGGFIECVAASABCEEJIGOEM";
        char[] str = str_str.toCharArray();
        boolean t = p.hasPath(matrix, 5, 8, str);
        System.out.println(t);
    }


}