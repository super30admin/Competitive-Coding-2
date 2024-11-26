/*
0 1 Knapsack Maximum
approach: dynamic programming, maximum at dp[i][j] = max(dp[i-1][j], val[i-1]+dp[i-1][j-weights[i-1]])
time: O(nxm)
space: O(nxm)
 */
public class Problem1 {

    static int maximumKnapsack(int[] weights, int []values, int capacity) {
        int rows = values.length;
        int cols = capacity;

        int[][] dp = new int[rows+1][cols+1];

        for (int i=1;i<dp.length;i++) {
            for (int j=1;j<dp[0].length;j++) {
                if (weights[i-1]>j) dp[i][j] = dp[i-1][j];
                else {
                    dp[i][j] = Math.max(dp[i-1][j], values[i-1]+dp[i-1][j-weights[i-1]]);
                }
            }
        }

        return dp[rows][cols];
    }

    public static void main(String[] args) {
        System.out.println("maximum knapsack "+maximumKnapsack(new int[]{10,20,30}, new int[]{60,100,120}, 50));
    }
}