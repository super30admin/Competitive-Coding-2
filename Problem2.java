//0/1 knapsack problem

// Time Complexity : O(n*W).
// Space Complexity : O(n*W)
// Did this code successfully run on Leetcode : Yes
// Approach : I was asked to solve this problem in the mock interview. I did a exhaustive approach with binary trees and was getting 2^n time complexity.
// Then I did a 2d matrix approach and was able to define a formula for picking and not picking the value. If we pick the value, we need to consider the
// maximum of previous row value vs the value that satisfies the remaining weight criteria. And the last value of the matrix will be the solution. It can also
// be implemented in 1D array as only previous array values are considered in formula calculation.


public class Main
{
    public static int Knapsack(int[] val, int[] wt, int W){
        int[][] dp = new int[wt.length+1][W+1];
        for(int i=1;i<=wt.length;i++){ //loop over given weight array
            for(int j=0;j<=W;j++){ //loop over weights to reach maximum

                if(wt[i-1] <= j) { //condition for elements less than weight
                    dp[i][j] = Math.max(dp[i-1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]); //picking the value
                }else{
                    dp[i][j] = dp[i-1][j];//not picking
                }
            }
        }
        return dp[wt.length][W];
    }

    public static void main(String args[]){
        int[] val = {60,100,120};
        int[] wt = {10,20,30};
        int W = 50;
        System.out.println(Knapsack(val, wt, W));
    }
}
