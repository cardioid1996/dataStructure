package algorithms.recurse;

/** 母牛每年生一只母牛，新出生的母牛成长三年后也能每年生一只母牛，假设不会死。求n年后，母牛的数量。
 *  1, 2, 3, 4, 5, 6, 9
 *  f(n) = f(n-1) + f(n-3)
 * **/

public class Cows {
    // 假设母牛不会死
    public static int getCowNumber(int n){
        if (n <= 6)
            return n;
        else{
            return getCowNumber(n-1) + getCowNumber(n-3);
        }
    }

}
