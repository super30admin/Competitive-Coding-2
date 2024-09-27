//Time complexity: O(m*n) | m is the length of the array and n is the capacity(max Weight)
//Space Complexity: O(m*n) | Here I have assumed the maximum length of the array and the maximum weight to be 100 but in normal case, the space complexity should be m*n
/*
    Algorithm: 1. Recursively select each of the possible paths to determine the maximum value
               2. Memoize the recursive calls to optimize the solution
*/
import java.util.Arrays;

public class knapSack01 {
    public static void main(String[] args) {
        int[] wt = {1,3,4,5};
        int[] val = {1,4,5,7};
        setArray();
        System.out.println(knapSack(wt,val,wt.length,7));
    }
    static int[][] dp = new int[100][100];
    private static void setArray(){
        for(int[] temp: dp){
            Arrays.fill(temp,-1);   
        }
    }
    public static int knapSack(int[] wt, int[] val, int n, int W){
        //base case
        if(n == 0 || W == 0) return 0;
        if(dp[n][W] != -1 ) return dp[n][W];
        //Choices
        if(wt[n-1] <= W){
            dp[n][W] = Math.max(val[n - 1] + knapSack(wt, val, n - 1, W - wt[n - 1]), knapSack(wt, val, n - 1, W));
            return dp[n][W];
        }else{
            dp[n][W] = knapSack(wt, val, n - 1, W);
            return  dp[n][W];
        }
    }
}
