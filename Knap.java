// Overall Time Complexity : O(n×m)) . The n is number of items and m is the capacity  in the matrix.
// Overall Space Complexity : O(n*m) . The space complexity is the size of the matrix.
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No issues faced during implementation


// This solution calculates the maximum value that can be obtained in a knapsack without exceeding its capacity.
// At each step we consider two choices by comparing the item's weight with the capacity.
// If weight of the item is more we consider not include the value for the corresponding weight. 
// If weight of the item is less than knapsack then include the value for the corresponding weight 
// along with the best value was without this item but with the reduced capacity.

class Knap {
    public static int knapSack(int capacity, int[] val, int[] wt) {
        int n = wt.length;
        int [][]dp = new int[n+1][capacity+1];

        for(int i =1; i<=n; i++){
            for(int j = 0; j<=capacity; j++){
                if(wt[i-1]>j){ 
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