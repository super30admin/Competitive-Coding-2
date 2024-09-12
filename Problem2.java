// Knapsack Problem
// Time Complexity : O(n * capacity), where n=no. of weights
// Space Complexity : O(n * capacity)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class Knapsack{
    public static void main(String []args){
        int[] weight = new int[]{3,5,9,6};
        int[] value = new int[]{1,2,3,4};
        int capacity = 9;
        int ret=Knapsack.maxValue(weight, value, capacity);
        System.out.println("Maximum value = "+ret);
    }

    public static int maxValue(int[] weight, int[] value, int capacity) {
        if (weight == null || value == null || weight.length != value.length) return -1;

        int n=weight.length;

        int[][] dp = new int[n+1][capacity+1];

        //case 1: 1st column
        for (int i=0; i<=n; i++) {
            dp[i][0] = 0;
        }

        //case 2: 1st row
        for (int i=0; i<=capacity; i++) {
            dp[0][i] = 0;
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=capacity; j++) {
                //case 3: capacity<weight
                if (j < weight[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    //case 4: Calculate max value between choosing and not choosing a weight
                    dp[i][j] = Math.max(dp[i-1][j], value[i-1] + dp[i][j-weight[i-1]]);
                }
            }
        }
        // The value in final field will contain the max value
        return dp[n][capacity];
    }
}