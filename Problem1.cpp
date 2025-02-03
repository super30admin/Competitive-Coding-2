//Knapsack

// Time Complexity: O(n*W) where n is the number of items and W is the capacity of the knapsack
// Space Complexity: O(n*W) where n is the number of items and W is the capacity of the knapsack
// Code ran on GeeksforGeeks

//Approach: 
//1. Create a 2D array dp of size n+1 and m+1 where n is the number of items and m is the capacity of the knapsack.
//2. Initialize the first row and first column of the dp array to 0.
//3. Traverse through the dp array and check if the weight of the item is greater than the capacity of the knapsack.
//4. If the weight of the item is greater than the capacity of the knapsack, then the value of the knapsack will be the same as the previous row.
//5. If the weight of the item is less than the capacity of the knapsack, then the value of the knapsack will be the maximum of the value of the previous row and the value of the previous row at the capacity - weight of the item + value of the item.
//6. Return the value of the knapsack at the last row and last column.

class Solution {
  public:
    // Function to return max value that can be put in knapsack of capacity.
    int knapSack(int capacity, vector<int> &val, vector<int> &wt) {
        int n = wt.size() + 1;
        int m = capacity + 1;
        vector<vector<int>> dp(n, vector<int> (m));
        for(int  i = 0; i < n; i++){
            dp[i][0] = 0;
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(wt[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                    
                }
                else{
                    dp[i][j] = max(dp[i - 1][j], dp[i-1][j - wt[i - 1]] + val[i - 1]);
                   
                }
                
            }
        }
        return dp[n-1][m-1];
    }
};