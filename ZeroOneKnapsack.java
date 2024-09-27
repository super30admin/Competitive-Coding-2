// Time Complexity : O(NW) where N is number of values and W is weight
// Space Complexity : O(NW)
// Did this code successfully run on Leetcode : yes (leetcode playground)
// Any problem you faced while coding this : no

/*
Approach:
=========
Here [10,20,30] are given weights and we need to maximize total weight by using these weights. 2 constraints weight blocks and total weight of Knapsack. If recursive tree is drawn, we can observe there are overlapping subproblems. use dp in this case.
1. Initialize dp matrix of N(number of weights) and W(weight of knapsack) 
2. Calculate max value by using these conditions:
    i. If index less than weight of item, copy from previous index
    ii. If not, update knapsack[i][j] with max of weight_value + total_value_weight_steps_back and previous_step
3. Return knapsack max value at the last row, last column of matrix
*/

public class ZeroOneKnapsack {
    private static int dpKnapsack(int weight, int[] wt, int[] val) {
        if( val == null || val.length == 0) return 0;
        int knapsack[][] = new int[val.length+1][weight+1]; //first row initialized with 0s
        
        for(int i = 1; i <= val.length; i++) {
            for(int j = 1; j <= weight; j++) {
                if( j < wt[i-1]) {
                    knapsack[i][j] = knapsack[i-1][j]; // If index less than weight value, copy whatever previous value is
                }
                else {
                    knapsack[i][j] = Math.max(val[i-1] + knapsack[i-1][j-wt[i-1]], knapsack[i-1][j]); //Max of choose and not choose options
                }
            }
        }
        return knapsack[val.length][weight]; 
    }
    public static void main(String[] args) {
        int[] wt = {10,20,30};
        int[] val = {60, 100, 120};
        int weight = 50;
        int result = dpKnapsack(weight, wt, val);
        assert result == 220 : "Result must be 220, but = "+result;
    }
}