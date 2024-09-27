//Name: 0-1 Knapsack
//Question:  https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
//Time Complexity: O(n*w) N=number of elements and W = capacity
//Space Complexity: O(n*w) N=number of elements and W = capacity

//Code: 

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
/*
we are doing  `max(including this element, excluding this)` at each syep

including this element = W-wt[ele]>=0?dp[W=wt[ele][col-1]
excluding this(W-wt[ele]) + val[ele]: excluding this[W]
*/
        int[][] dp = new int[W+1][n+1];
        
        for(int w = 1; w <= W; w++) {
            for (int col = 1; col <= n; col++) {
                int incl = w-wt[col-1] >= 0 ?
                            dp[w-wt[col-1]][col-1] + val[col-1] :   // including the current element
                            dp[w][col-1];                       // excluding the current element
                int excl = dp[w][col-1];
                dp[w][col] = Math.max(incl, excl); //keeping the maximum of the two values
            }
        }
        
        return dp[W][n];
    } 
}
