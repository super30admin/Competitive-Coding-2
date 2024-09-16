import java.util.*;

class Problem2 {
    static Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    private static int helper(int[] nums, int[] weights, int weight, int value, int W, int index) {
        /*
         * Time Complexity: O(n * W) Where n = nums.length
         * Space Complexity: O(n)
         */
        if (memo.containsKey(weight)) return memo.get(weight);
        if (weight == W) {
            memo.put(weight, value);
            return value;
        }
        // invalid when out of bounds or weight exceeds capacity
        if (index >= nums.length || weight > W)
            return -1;
        int with = helper(nums, weights, weight + weights[index], value + nums[index], W, index + 1);
        int without = helper(nums, weights, weight, value, W, index + 1);
        // trace back the higher value in available options - with or without
        memo.put(weight, Math.max(with, without));
        return memo.get(weight);
    }

    // 0-1 Knapsack
    public static int knapsack(int[] nums, int[] weights, int W) {
        return helper(nums, weights, 0, 0, W, 0);
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 60, 100, 120 };
        int[] weights = new int[] { 10, 20, 30 };
        System.out.println("Total capacity: " + knapsack(nums, weights, 50));
    }
}