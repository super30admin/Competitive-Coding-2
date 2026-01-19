class Solution {
    public static int findMax(int[] weights, int[] profit, int totalCapacity) {
        return helper(weights, profit, 0, totalCapacity);  // Start from index 0 with full capacity
    }

    private static int helper(int[] weights, int[] profit, int i, int capacity) {
        // Base case: if we've considered all items, return 0 profit
        if (i >= weights.length) return 0;

        // Case 0: skip the current item
        int case0 = helper(weights, profit, i + 1, capacity);

        int case1 = 0;
        // Case 1: include the current item if it fits in the remaining capacity
        if (capacity - weights[i] >= 0) {
            case1 = profit[i] + helper(weights, profit, i + 1, capacity - weights[i]);
        }

        // Return the maximum profit between including or excluding the current item
        return Math.max(case0, case1);
    }

    // Main method to test the solution
    public static void main(String args[]) {
        int[] items = {10, 20, 30, 40};       // Weights of the items
        int[] profit = {130, 110, 170, 190};  // Corresponding profits
        int capacity = 50;                    // Total capacity of the knapsack

        // Print the maximum profit that can be obtained
        System.out.println(findMax(items, profit, capacity));  // Expected: 300
    }
}