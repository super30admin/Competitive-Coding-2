//{ Driver Code Starts
import java.lang.*;

class Knapsack
{
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int[][] dp = new int[n+1][W+1];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=W; j++) {
                //case1 - no choose
                if(wt[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    //case2 - choose current item
                    //find max between 0th case above and value of this item + value at previous row - current weight
                    dp[i][j] = Math.max(dp[i-1][j] , val[i-1] + dp[i-1][j-wt[i-1]]);
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] wt = {3,2,4,1};
        int[] val = {2,3,5,1};
        int W = 7;
        int n = 4;
        System.out.println("Max value in knapsack is " + knapSack(W, wt, val, n));
    }
}