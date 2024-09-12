// Time Complexity : O(n*w) where n is the length of value array and w is the weight capacity
// Space Complexity : O(n*w) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// 0-1 Knapsack Problem

public class Main {
    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] value = {60, 100, 120};
        int result = knapSack(weights,value,50);
        System.out.println(result);
    }
    public static int knapSack(int[] weights,int[] value,int W){
        int n = value.length;
        int[][] dp = new int[n+1][W+1];
        for(int i=0;i<=n;i++){ 
            for(int j=0;j<=W;j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(weights[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max((value[i-1]+dp[i-1][j-weights[i-1]]), dp[i-1][j]);
            }
        }
        return dp[n][W];
    }
}
