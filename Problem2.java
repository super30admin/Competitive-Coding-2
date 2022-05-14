// "static void main" must be defined in a public class.
// Time Complexity :O(m*maxWeight)
// Space Complexity :O(m*maxWeight)
// Did this code successfully run on Leetcode :NA
// Any problem you faced while coding this :was unable to further optimize it by space

//we'll memorize the maximum possible value upto maxWeight and values array in dp array
// we will take maximum of value upto previous weight and maxWeight-currentWeight's value+currentValue
//will return value at last row and last column 

public class Main {
    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(wt, val, W));
        System.out.println("Hello World!");
    }

    public static int knapSack(int[] weight, int[] values, int maxWeight) {
        int n = values.length;
        int[][] dp = new int[n + 1][maxWeight + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[n][maxWeight];
    }
}