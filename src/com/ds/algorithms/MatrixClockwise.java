package com.ds.algorithms;


import java.util.ArrayList;
public class MatrixClockwise {
        public ArrayList<Integer> printMatrix(int [][] matrix) {
            if (matrix==null || matrix[0].length==0)
                return null;
            ArrayList<Integer> result = new ArrayList<>();
            int top = 0;
            int bottom = matrix.length-1;
            int right = matrix[0].length-1;
            int left = 0;

            while (left<=right && top<=bottom && top<matrix.length && bottom>=0 && left<matrix[0].length && right>=0){
                if (top == bottom){
                    for (int j=left; j<=right; ++j){
                        result.add(matrix[top][j]);
                    }
                    break;
                }

                if (left == right){
                    for (int i=top; i<=bottom; ++i){
                        result.add(matrix[i][left]);
                    }
                    break;
                }
                for (int i=top,j=left; j<right; ++j){
                    result.add(matrix[i][j]);
                }
                for (int i=top,j=right; i<bottom; ++i){
                    result.add(matrix[i][j]);
                }
                for (int i=bottom,j=right; j>left; --j){
                    result.add(matrix[i][j]);
                }
                for (int i=bottom,j=left; i>top; --i){
                    result.add(matrix[i][j]);
                }
                top++;
                bottom--;
                left++;
                right--;
            }
            return result;
        }

    public static void main(String[] args) {
        MatrixClockwise m = new MatrixClockwise();
        int[][] matrix = {{1,2},{3,4},{5,6},{7,8}};
        ArrayList<Integer> result = m.printMatrix(matrix);
        System.out.println(result);
    }
}