// Time Complexity : O(2^n) ; where n is length of wt or val array
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
// Recursive approach

class Solution {

    static int knapSack(int wt[], int val[], int C) 
    { 
        return helper(wt, val, C, 0, 0);
    } 
    
    private static int helper(int wt[], int val[], int C, int i, int maxProfit){

        // if capacity becomes 0, then return maximum profit
        if(C == 0)
            return maxProfit;

        // if capacity becomes negative or index goes out of bound, return -1
        if(C < 0 || i >= wt.length)
            return -1;
        
        // choose weight
        int case1 = helper( wt, val, C - wt[i], i + 1, maxProfit + wt[i] );

        // don't choose weight
        int case2 = helper( wt, val, C, i + 1, maxProfit );

        
        return Math.max(case1, case2);
    }
}