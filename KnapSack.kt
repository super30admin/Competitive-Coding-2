// In this problem, we use a dynamic programming approach to solve the 0/1 Knapsack problem. We create a 2D array to store the maximum value that can be obtained with a given weight capacity and number of items.
// We iterate through each item and weight capacity, deciding whether to include the current item or not based on which choice yields a higher value.
//Time Complexity: O(n*W) where n is the number of items and W is the maximum weight capacity of the knapsack.
//Space Complexity: O(n*W) for the 2D array used to store the maximum values.

class Solution {
    fun knapsack(W: Int, valArr: IntArray, wt: IntArray): Int {
        val n = wt.size
        val dp = Array(n + 1) { IntArray(W + 1) }

        // Build table dp[][] in bottom-up manner
        for (i in 0..n) {
            for (j in 0..W) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0
                } else {
                    var pick = 0
                    // Pick i-th item if it does not exceed the capacity of knapsack
                    if (wt[i - 1] <= j) {
                        pick = valArr[i - 1] + dp[i - 1][j - wt[i - 1]]
                    }
                    // Don't pick the i-th item
                    val notPick = dp[i - 1][j]

                    dp[i][j] = maxOf(pick, notPick)
                }
            }
        }
        return dp[n][W]
    }
}
