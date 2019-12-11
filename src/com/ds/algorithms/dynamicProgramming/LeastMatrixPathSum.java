package algorithms.dynamicProgramming;

/** 给定一个二维数组，所有数都是整数。
 * 从左上角走到右下角，每一步只能向右或向下，
 * 沿途经过的数字累加起来，返回最小的路径和。**/

public class LeastMatrixPathSum {

    /**  递归版本 *************************************/

    public static int res = Integer.MAX_VALUE;

    public static void recurse(int[][] matrix, int curr_sum, int row, int col){

        if (row == matrix.length-1 && col == matrix[0].length-1){
            res = Math.min(res, curr_sum);
            return;
        }
        if (col+1 <= matrix[0].length-1)
            recurse(matrix, curr_sum+matrix[row][col+1], row, col+1);
        if (row+1 <= matrix.length-1)
            recurse(matrix, curr_sum+matrix[row+1][col], row+1, col);
    }

    /**  递归版本 *************************************/

    public static int getLeastPath(int[][] matrix){
        if (matrix.length == 0 || matrix[0].length==0)
            return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        return process(matrix,rows-1, cols-1);
    }

    public static int process(int[][] matrix, int row, int col){
        if (row == 0 && col == 0)
            return matrix[0][0];
        if (row == 0 )
            return matrix[row][col] + process(matrix, row, col-1);
        if(col == 0)
            return matrix[row][col] + process(matrix, row-1, col);
        return Math.min(process(matrix,row-1, col), process(matrix, row, col-1))+matrix[row][col];

    }


    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        //System.out.println(LeastMatrixPathSum.getLeastPath(matrix));
        recurse(matrix, matrix[0][0], 0, 0);
        System.out.println(LeastMatrixPathSum.res);
    }
}
