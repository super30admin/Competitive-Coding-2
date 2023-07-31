// Time Complexity : O(n*m) where n is the number of items and m is the capacity
// Space Complexity : O(n*m) where n is the number of items and m is the capacity
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
/**
 * 1. Implemented a bottom up approach to solve the problem, this approach was built using recursive solution.
 * 2. The base condition is when the capacity is 0 or the number of items is 0, the value is 0.
 * 3. If the weight of the item is greater than the capacity, then we cannot pick the item, so we take the value from the previous row.
 * 4. If the weight of the item is less than the capacity, then we have two options, either we pick the item or we don't pick the item.
 * 5. If we pick the item, then we add the value of the item to the value of the item in the previous row and the remaining capacity is reduced by the weight of the item.
 * 6. If we don't pick the item, then we take the value from the previous row.
 * 7. We take the maximum of the two options.
 */

class Solution {
    public int solve(int[] values, int[] weights, int capacity) {
        int n = values.length;
        int[][] dp = new int[n+1][capacity+1];
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=capacity; j++){
                if(j < weights[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(values[i-1] + dp[i-1][j - weights[i-1]], dp[i-1][j]);
                }
            }
        }
        return dp[n][capacity];
    }
}