package com.ds.algorithms;


public class RobotSport {
    int count = 0;
    public int movingCount(int k, int m, int n)
    {
        if (m <= 0 || n<=0 || k<0)
            return 0;
        if (k==0)
            return 1;
        if (sum(m-1)+sum(n-1)<=k)
            return m*n;
        int result = 0;
        boolean[][] flag = new boolean[m][n];
        for (int i = 0; i<m; ++i){
            for (int j=0; j<n; ++j)
                flag[i][j] = false;
        }
        move(0, 0, flag, k, m, n);
        return count;

    }

    public void move(int i, int j, boolean[][] flag, int k, int m, int n){
        if (i>=0 && i<m && j>=0 && j<n && sum(i)+sum(j)<k && flag[i][j]==false){
            flag[i][j] = true;
            count++;
            move(i+1, j, flag, k, m, n);
            move(i-1, j, flag, k, m, n);
            move(i, j+1, flag, k, m, n);
            move(i, j-1, flag, k, m, n);
        }
        return;

    }

    public int sum(int a){
        if (a < 9)
            return a;
        int result = 0;
        while (a > 0){
            int tmp = a%10;
            result += tmp;
            a/=10;
        }
        return result;
    }

    public static void main(String[] args) {
        RobotSport r = new RobotSport();
        int res = r.movingCount(15, 20, 20);
        System.out.println(res);
    }
}