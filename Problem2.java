// GeeksforGeeks KnapSack 0/1
// Time Complexity : O(2^N)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    // Capacity, Weight, Value, Length
    private static int knapSack(int capacity, int weight[], int value[], int len){
        // Base case
        if (len == 0 || capacity == 0){
            return 0;
        }
        // Logic
        // Don't Include
        int case1 = knapSack(capacity, weight, value, len-1);
        // Include
        int case2 = value[len-1] + knapSack(capacity - weight[len-1], weight, value, len-1);
        return Math.max(case1, case2);
    }
}

// GeeksforGeeks KnapSack 0/1
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    // Capacity, Weight, Value, Length
    private static int knapSack(int capacity, int[] weight, int[] value, int len) {
        int[][] dp = new int[len+1][capacity+1];
        for (int i = 0; i <= len; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weight[i-1] <= w) {
                    dp[i][w] = Math.max(dp[i-1][w], value[i-1] + dp[i-1][w-weight[i-1]]);
                } else {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        return dp[len][capacity];
    }
}

// GeeksforGeeks KnapSack 0/1
// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    // Capacity, Weight, Value, Length
    private static int knapSack(int capacity, int weight[], int value[], int len) {
        int[] dp = new int[capacity + 1];
        for (int i = 1; i < len + 1; i++) {
            for (int w = capacity; w >= 0; w--) {
                if (weight[i - 1] <= w)
                    dp[w] = Math.max(dp[w], dp[w-weight[i-1]] + value[i-1]);
            }
        }
        return dp[capacity];
    }
}