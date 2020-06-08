// Time Complexity : O(n * m) --> where n is size of input weight and m is maxixum capacity
// Space Complexity : O(n * m)
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this : 

public class Knapsack {
    int dp[][];
    public int findMax(int weights[], int values[], int maxWeight) {
		if(weights == null || weights.length == 0 || values == null || values.length == 0) return 0; 
        dp = new int[weights.length + 1][maxWeight + 1];

        for (int i = 0; i < weights.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < weights[i - 1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], (dp[i-1][j-weights[i-1]] + values[i-1]));
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        Knapsack kn = new Knapsack();
        int weights[] = new int[]{1, 2, 3};
        int values[] = new int[]{6, 10, 12};
        int maxWeight = 5;

        int maxValue = kn.findMax(weights, values, maxWeight);
        System.out.println(maxValue);
    }
}