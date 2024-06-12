/*
Time Complexity :  O(n * w) where n is number of length of value and w is the value of the weight.
Space Complextiy: O(n * w) where n is number of length of value and w is the value of the weight.
Test cases passed.
*/

class Solution_knapsack {
    public static void main(String[] args) {

        int value[] = { 160, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int W = 50;

        System.out.println(Solution_knapsack.helper(value, weight, W));

    }

    public static int helper(int[] value, int[] weight, int W) {

        int[][] dp = new int[value.length + 1][W + 1];

        // iterationg from the row

        for (int i = 0; i <= value.length; i++) {

            // iterating from the column
            for (int j = 0; j <= W; j++) {

                // checking the base condition if any if the one is 0 putting 0.
                if (i == 0 || j == 0) {

                    dp[i][j] = 0;
                }
                // checking if the weigth is smaller then the knapsack then we have to case
                // whether choose it or not choose.
                else if (weight[i - 1] <= j) {

                    dp[i][j] = Math.max(value[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
                }
                // weight is biggger so not taking it.

                else {

                    dp[i][j] = dp[i - 1][j];

                }
            }
        }

        return dp[value.length][W];
    }
}
