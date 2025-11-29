// 0-1 Knapsack problem
// Time complexity: O(weights.length * capacity)
// Space complexity: O(capacity) for dp array
public class Problem1 {
    public int maxProfit(int[] profits, int[] weights, int capacity) {
        int[] dp = new int[capacity + 1];
        for (int row = 1; row < weights.length + 1; row ++) {
            // Iterating backwards to avoid using modified dp value.
            for (int col = capacity; col >= 1; col --) {
                if (col >= weights[row - 1]) { // col is the max capacity
                    // Consider maximum between previous profit and sum of current weight's profit and maximum profit from the remaining weight.
                    dp[col] = Math.max(dp[col], profits[row - 1] + (dp[col - weights[row - 1]]));
                }
            }
        }
        return dp[capacity];
    }
    public static void main(String[] args) {
        Problem1 ob = new Problem1();
        int[] profits = new int[] {1, 2, 3};
        int[] weights = new int[] {4, 5, 1};
        int capacity = 4;
        System.out.println(ob.maxProfit(profits, weights, capacity));
        capacity = 5;
        System.out.println(ob.maxProfit(profits, weights, capacity));
    }
}