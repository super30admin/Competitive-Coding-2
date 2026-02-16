// Time Complexity : O(m * n)
// Space Complexity : O(n)
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
This problem cant be solved in greedy,so while solving recursively, we see a lot of repetitive subproblems
to be solved.This can be done through DP. We take a DP array to respectively handle choose and no choose
cases of weights and match with capacity, thereby compute the max profit at every step
 */
class Solution {

    public static int findMax(int[] weights, int[] profit, int totalCapacity) {
       int m = weights.length;
       int n = totalCapacity;

       int[] dp = new int[n + 1];

       for(int i = 0 ; i < m ; i++)  {
           for(int j = n ; j >= weights[i] ; j--) {
               dp[j] = Math.max(dp[j], profit[i] + dp[j - weights[i]]);
           }
       }
       return dp[n];
    }

    public static void main(String args[]) {
        int[] items = {10, 20, 30, 40};
        int[] profit = {130, 110, 170, 190};
        int capacity = 50;

        System.out.println(findMax(items, profit, capacity));
    }
}
