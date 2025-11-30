// Time Complexity : O(n*totalCapacity)
// Space Complexity : O(totalCapacity)
// Did this code successfully run on Leetcode :no
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// loop through the weights and total capacity
// looping through dp in reverse because the initial elements are changed
// for each element the max is dp[j-1] and profit of that element + dp[j-weight[i]] as we have to move weight[i] steps backward
class Solution {

    public static int findMax(int[] weights, int[] profit, int totalCapacity) {
        int n = totalCapacity;
        int m = weights.length;
        int[] dp = new int[n+1];
        for (int i = 0; i < m; i++){
            for (int j = n; j>= weights[i]; j--){
                dp[j] = Math.max(dp[j], profit[i]+dp[j-weights[i]]);
            }
        }
        return dp[n];
    }
}