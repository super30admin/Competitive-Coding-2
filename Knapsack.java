//Time Complexity : O(N*M) -> N is the number of elements in the profit array and M is the capacity
//Space Complexity : O(N*M) -> N is the number of elements in the profit array and M is the capacity

public class Knapsack {
    public static int knapsack(int[] profit, int[] weight, int capacity) {
        int m = profit.length;
        int n = capacity; 

        int[][] dp = new int[m+1][n+1];

        for(int i = 0 ; i < m+1; i++) {
            dp[i][0] = 0;
        }

        for(int j = 0; j < n+1; j++) {
            dp[0][j] = 0;
        }

        for(int i = 1; i < m+1; i++) {
            for(int j = 1; j< n+1 ; j ++) {
                if(j < weight[i-1]) {
                    dp[i][j] = dp [i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], profit[i-1] +dp[i-1][j-weight[i-1]]);
                }
            }
        }
        return dp[m][n]; 
    }
}