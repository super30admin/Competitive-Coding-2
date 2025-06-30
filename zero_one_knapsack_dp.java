// Zero one knapsack problem solution using dp
// TC: O(n2) 
// SC: O(n2)

class Solution {
    static int knapsack(int W, int val[], int wt[]) {
       // Iterate over each weight while checking whether to 
       // include or not inclue
       int[][] dp = new int[wt.length+1][W+1];
       for(int i=1;i<=wt.length;i++){
           for(int j=1;j<=W;j++){
               int index = i-1;
               // If current weight is less than the total weight we need to fill at this point
               if(wt[index]<=j){
                   // Maximum between previous profit and the profit we get after adding current value to the 
                  // previous value before adding this weight (totalWeight-currentWeight)
                    dp[i][j] = Math.max(dp[i-1][j], 
                    val[index] + dp[i-1][j-wt[index]]);
               }
               else{
                  // Previous total profit value
                   dp[i][j] = dp[i-1][j];
               }
           }
       }
       return dp[wt.length][W]; 
    }
}
