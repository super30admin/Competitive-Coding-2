
//0-1 Knapsack
//Time Complexity :O(W * C)  W = length of the weights array, C = capacity length.
// Space Complexity : O(W * C * N) W = length of weights array, C = capacity length, N = length of 2D array
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
//1. Consider a 2D matrix that has the values of weights and the capacity.
//2. Keep comparing the values matrix with the one above the row and the also with the remaining value of 
//the difference between the current weight and the weight at the present row.
//3. The final value in the matrix has the maximum price of the Knapsack.

// Your code here along with comments explaining your approach
class Main {

    public int finProfit(int[] weights, int[] profits, int capacity) {

        int dp[][] = new int[weights.length + 1][capacity + 1];
        for (int i = 0; i <= weights.length; i++)
            dp[i][0] = 0;
        for (int j = 0; j <= capacity; j++)
            dp[0][j] = 0;

        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j < weights[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weights[i - 1]] + profits[i - 1]);

            }
        }

        return dp[weights.length][capacity] > 1 ? dp[weights.length][capacity] : 0;

    }

    public static void main(String[] args) {
        Main obj = new Main();
        int[] weights = { 2, 3, 5 };
        int[] profits = { 1, 2, 6 };
        int capacity = 8;
        System.out.println(obj.finProfit(weights, profits, capacity));

    }
}