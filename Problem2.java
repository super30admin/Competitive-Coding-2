// Knapsack 
// Time Complexity : O(n*m) n is number of items, m is knapsack capacity
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes, ran in geeksforgeeks
// Any problem you faced while coding this :



import java.io.*;
class Solution {
    public static void main (String[] args) {
        int[] items = {2,3,1,5};
        int[] values = {70,40,30,60};
        int w = 5;
        int result = maxvalue(items, values, w); System.out.println("Max value : " +result);
        }
        
    public static int maxvalue (int[] items, int[] values, int w) { 
        if(items == null || values == null) return -1;
        if(w == 0) return -1;
        int n = items.length;
        int[][] dp = new int[n+1][w+1];
        for(int i = 0; i <= n; i++) { 
            for(int j = 0; j <= w; j++) {
                if(i == 0 || j == 0) { 
                    dp[i][j] = 0;
                }
                else if(items[i-1] > j) { 
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j-items[i-1]]+values[i-1], dp[i-1][j]);
                }
            }
        } return dp[n][w];
    } 
}


