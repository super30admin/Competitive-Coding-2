// This problem solves the zero one knapsack problem using recursion 
// First Solution: Using recursion - exhaustive approach
// TC: exponential
// SC: exponential stack calls
class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        // Start recursion with totalProfit = 0
        return new Solution().recursion(wt, val, W, 0, 0, 0);
    }
    
    private int recursion(int[] wt, int[] val, int W, int index, 
      int totalProfit, int totalWeight) {
        // Base case
       // If we arrived at out of bounds, we will only return the current totalProfit
        if (index >= wt.length) {
            return totalProfit;
        }
        if(totalWeight > W){
            return 0;
        }
        
        // Do not pick
        // Here, we are not picking the value so totalProfit remains the same
        int case1 = recursion(wt, val, W, index + 1, totalProfit, 
        totalWeight);
        
        // Pick - only if the totalWeight is not greater 
        // than targetWeight  
        int case2 = 0;
        int weight = totalWeight + wt[index];
        int profit = totalProfit + val[index];
        if(weight <= W){
            case2 = recursion(wt, val, W, index + 1, profit, 
            weight);
        }
        // Else continue with current totalProfit itself
        else {
            case2 = recursion(wt, val, W, index + 1, totalProfit, 
            totalWeight);
        }
        
        int maxProfit = totalProfit;
        
        maxProfit = Math.max(case1, totalProfit);
        
        maxProfit = Math.max(maxProfit, case2);
            
        return maxProfit;
    }
}
