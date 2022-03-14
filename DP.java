// Time Complexity : Approach 1: O(n*W), Approach 2: O(n*W) where n = length of value array, W = capacity of knapsack
// Space Complexity : Approach 1: O(n*W), Approach 2: O(W) where n = length of value array, W = capacity of knapsack
// Did this code successfully run on Leetcode : Didn't find on Leetcode
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;
public class Problem2 {

    // Memoization Approach (Top-Down)

    private static int[][] dp;

    public static int KnapSack01_1(int[] value, int[] weight, int W) {
        // dp[row][col] == -1 represents that the calculation has not been done via recursion yet
        dp = new int[value.length][W+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return KnapSack01_1(value, weight, W, 0);
    }

    private static int KnapSack01_1(int[] value, int[] weight, int W, int index) {
        if (W == 0) {
            return 0;
        }
        if (W < 0) {
            return Integer.MIN_VALUE;
        }

        if (index == value.length) {
            return 0;
        }

        if (dp[index][W] != -1) {
            return dp[index][W];
        }
        
        // If I don't select the current element, increment index by 1
        int notselect = KnapSack01_1(value, weight, W, index+1);

        // If I select the current element, decrease W by weight[index] and increment index by 1.
        // If the value of select is not -infinity, increment select by value[index]
        int select = KnapSack01_1(value, weight, W-weight[index], index+1);
        if (select != Integer.MIN_VALUE) {
            select += value[index];
        }

        // Set the calculated value (max of select and notselect) at corresponmding row and column in the dp array
        dp[index][W] = Math.max(notselect, select);
        return dp[index][W];
    }


    // Iterative Approach (Bottom-up)

    public static int KnapSack01_2(int[] value, int[] weight, int W) {
        
        int[] prev = new int[W + 1];
        for (int index = value.length-1; index >= 0; index--) {
            int[] curr = new int[W + 1];
            for (int i = 1; i <= W; i++) {
                // If I don't select the current element, the value is equal to the value at index i in prev array
                int notselect = prev[i];
                // If I select the current denomination, decrease i by weight[index-1] and the value is equal to the value at index i-weight[index] in the prev array
                // If the value of select is not -infinity, increase select by value[index]
                int select = i >= weight[index] ? prev[i-weight[index]] : Integer.MIN_VALUE;
                select = select == Integer.MIN_VALUE ? Integer.MIN_VALUE : value[index] + select;
                // Set the calculated value (max of select and notselect) at corresponmding index in the curr array
                curr[i] = Math.max(notselect, select);
            }
            // Set prev to curr
            prev = curr;
        }
        return prev[W];
    }

    public static void main(String[] args) {
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int W = 50;
        int ans1 = KnapSack01_1(value, weight, W);
        int ans2 = KnapSack01_2(value, weight, W);
        System.out.println("Answer for Approach-1(Top-down approach) is : " + ans1);
        System.out.println("Answer for Approach-2(Bottom-up approach) is : " + ans2);
    }
