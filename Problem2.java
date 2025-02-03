// knapsack problem: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/#
// Time: O(m*n) m = weights.length, n = capacity
// Space Complexity: O(m*n) m = weights.length, n = capacity
// Approach: Dynamic Programming
// 1. Create a 2D array dp of size m+1 and n+1.
// 2. Initialize the first row and first column with 0.
// 3. Iterate over the dp array and fill the values based on the following conditions:
//    a. If the weight of the item is greater than the capacity, then we cannot choose the item. So, the value will be the same as the previous row.
//    b. If the weight of the item is less than or equal to the capacity, then we have two options:
//       i. Choose the item: In this case, the value will be the sum of the value of the item and the value of the remaining capacity.
//       ii. Do not choose the item: In this case, the value will be the same as the previous row.
class Problem2{
    public int solve(int[] weights, int[] values, int capacity){
        int m = weights.length;
        int n = capacity;

        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(weights[i-1] > j){
                    // no choose option
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], values[i-1] + dp[i-1][j-weights[i-1]]);
                }
            }
        }

        return dp[m][n];
    }
}