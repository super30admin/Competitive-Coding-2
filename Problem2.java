// Time Complexity : O(weightCapacity * n) 
// Space Complexity : O(weightCapacity)
// Did this code successfully run on GFG : No platform to run this code, works for the test cases
// Any problem you faced while coding this : No

// Approach: I make an array dp which stores max profit for each weight possible from 0 to weightcapacity
// I iterate through each item where in I have two choices - including it or excluding it. I go in reverse from max weight capacity to current weight limit to make sure I do not double count the same value for different weights

public class Problem2 {
    public static void main(String[] args) {
        int weightCapacity = 4;
        int[] profit = new int []{1,2,3};
        int[] weight = new int []{4,5,1};
        System.out.println(maxProfitWithWeights(weightCapacity, profit, weight));
    }
    
    public static int maxProfitWithWeights(int weightCapacity, int[] profit, int [] weight){
        int n = profit.length;
        if(n==0) return 0;
        // since in java the array is initialized with 0s, I can leave it as it is
        int [] dp = new int[weightCapacity+1]; 
        
        for(int i = 0; i<n; i++){
            for(int j = weightCapacity; j>=weight[i]; j--){
                int include = profit[i] + dp[j-weight[i]]; 
                int exclude = dp[j]; 
                dp[j] = Math.max(include, exclude);
            }
        }
        return dp[weightCapacity];
    }
}