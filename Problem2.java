// Interview Problem : Two elements sum to target

// Time Complexity : O(nxm) n is length of wt array and m is capacity
// Space Complexity : O(nxm)
// Did this code successfully run on GFG : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, I used dynamic programming to store the maximum value by selecting a weight. I traversed along the weights and when weight at index is 
 * less than capacity then above row values are copied and when they are equal and higher, maximum between previous rows element at same index
 * and value + element at index of previous row at column capacity-weight of row is calculated. The last element of dp is returned. 
 */

class Solution {
    static int knapSack(int capacity, int val[], int wt[]) {
        int n = wt.length;
        int [][]dp = new int[n+1][capacity+1];
        for(int i = 0; i<n;i++){
            dp[i][0] = 0;
        }
        for(int i = 1;i<=n;i++){
            for(int j=1;j<=capacity;j++){
                if(wt[i]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1]+dp[i-1][j-wt[i-1]]);
                }
            }
        }
        return dp[n][capacity];
        
    }
}
