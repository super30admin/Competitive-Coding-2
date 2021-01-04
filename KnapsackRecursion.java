// Time Complexity : 2^n
// Space Complexity : 
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this : 

// Notes : Brute force involves, subtracting values from W while accepting or rejecting that value, until W != 0 , if W = 0, add the corresponding weights. If index is out of bound or W < 0 , return -1 

class KnapsackRecursion {

    // Returns the maximum value that can be put in a knapsack of capacity W 
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
        return calculate(W, wt, val, 0, 0);
    } 
    
    private static int calculate(int W, int wt[], int val[], int i, int total){
        if(W == 0)
            return total;

        if(W < 0 || i >= wt.length)
            return -1;
        
        int case1 = calculate( W, wt, val, i+1, total );
        int case2 = calculate( W-val[i], wt, val, i+1, total+wt[i] );
        
        return Math.max(case1, case2);
    }
}