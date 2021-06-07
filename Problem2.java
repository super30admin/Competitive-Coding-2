/**
 * we are given weights and values of n items. we need to put these items in a knapsack of capacity W to get maximum value in our knapsack.
 * or we can say that we are given two integers arrays val[0......n-1] and wt[0.....n-1] which represent values and weights associated with n items respectively. we are also given an integer W  which represents knapsack capacity.
 * find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. but you cannot break an item, either pick the complete item or dont pick it(known as 0-1 property).

 * Source Link: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 */

 // Approach

 /**
  * In this approach, we have to make a decision if we have to choose the current element of not.
  * If we do not choose the current element, we recusively call the method with rest of the weights array with capacity unchanged
  * If we choose the current element, we recursively call the same methof with rest of the weights array with capacity = capacity - weights[index]
  * we return the current_profit when the weight[index] is greater than the capacity left
  * Finally, we return the maximum of the choose and not_choose cases
  */

  /**
   * Time Complexity : O(m * n) where m is the length of weight array and n is the capacity iof the Knapsack
   * Space Complexity : O(m * n) where m is the length of weight array and n is the capacity iof the Knapsack
   * Any problem you faced while coding this : No
   */

class Solution {
    public static void main(String[] args) {
        
        int[] weights = {20,30,35,10};
        int[] value = {100,120,200,60};
        int totalWeight = 50;
        System.out.println(getMaximum(weights, value, totalWeight));
        
    }
    
    public static int getMaximum(int[] weights, int[] value, int totalWeight) {
        return helper(weights, value, totalWeight, 0, 0);
    }
    
    public static int helper(int[] weights, int[] value, int totalWeight, int index, int currentValue) {
        
        // base case
        if(index == weights.length || weights[index] > totalWeight) {
            return currentValue;
        }
        
        // Logic
        // Don't choose case
        int not_choose = helper(weights , value, totalWeight, index+1, currentValue);
        
        // choose case
        int choose = helper(weights , value, totalWeight - weights[index], index+1, currentValue + value[index]);
        
        return Math.max(choose, not_choose);
    }
}

// Dynamic programming Approach

/**
 * This approach follows the above recursive approach but storing the already calculated results in matrix.
 * Finally we return the last row and last column stored result.
 */

class Knapsack_01 {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {

        int[][] dp = new int[weights.length + 1][capacity + 1];

        // fill first row with 0s
        for(int i=0;i<dp[0].length;i++) {
            dp[0][i] = 0;
        }

        // fill first column with 0s
        for(int i=0;i<dp.length;i++) {
            dp[i][0] = 0;
        }

        for(int i=1;i<dp.length;i++) {
            for(int j=1;j<dp[0].length;j++) {

                if(weights[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], profits[i-1] + dp[i-1][j - weights[i-1]]);
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        Knapsack_01 ks = new Knapsack_01();
        int[] profits = {1, 6, 10, 17};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}