// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Knapsack {
    
    public int kanpsack(int[] values, int[] weights, int target) {
        
        if(values.length != weights.length || values.length ==0 || weights.length == 0) {
            return -1;
        }
        
        int[][] dp = new int[weights.length+1][target+1];
        
        for(int i = 0; i <= weights.length; i++) {
            for(int j = 0; j <= target; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else if(weights[i-1] <= j) {
                    dp[i][j] = Math.max(values[i-1] + dp[i-1][j-weights[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[weights.length][target];
    }
    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        System.out.println(knapsack.kanpsack(new int[]{60, 100, 120}, new int[]{10, 20, 30},50));
    }
    
}