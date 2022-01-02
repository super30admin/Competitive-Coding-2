// Time Complexity : O(n*c) where n = number of weights and c = capacity
// Space Complexity : O(n*c)

// Your code here along with comments explaining your approach

class Solution {
    public int knapsack(int[] wt, int[] val, int capacity) {
        
        // check if weights or values array is null or empty
        if(wt == null || val == null || wt.length == 0 || val.length == 0){
            return 0;
        }
        
        // initialize dp matrix
        int [][] dp = new int [wt.length + 1][capacity + 1];


        // set the elements of first row of dp matrix as 0
        for(int j = 0; j < dp[0].length; j++){
            dp[0][j] = 0;
        }
        
        // set the elements of first column of dp matrix as 0
        for(int i = 1; i < dp.length; i++){
            dp[i][0] = 0;
        }

        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                
                // for each cell of matrix, check if capacity is less than weight,
                if(j < wt[i - 1]){
                    // if the capacity is less than weight,
                    // then fill the element with value of element just above
                    dp[i][j] = dp[i - 1][j];
                }else{
                    // if the capacity is not less than weight,
                    // then take the max value between the element just above
                    // and (the element present in the same row, the value of element columns before + profits associated with it)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                }
            }
        }

        int lastElement = dp[dp.length - 1][dp[0].length -1];
        return lastElement;
    }
}


// // Recursive approach
// // Time Complexity : O(2^n) ; where n is length of wt or val array
// // Space Complexity : O(1) 

// // Your code here along with comments explaining your approach


// class Solution {

//     static int knapSack(int wt[], int val[], int C) 
//     { 
//         return helper(wt, val, C, 0, 0);
//     } 
    
//     private static int helper(int wt[], int val[], int C, int i, int maxProfit){

//         // if capacity becomes 0, then return maximum profit
//         if(C == 0)
//             return maxProfit;

//         // if capacity becomes negative or index goes out of bound, return -1
//         if(C < 0 || i >= wt.length)
//             return -1;
        
//         // choose weight
//         int case1 = helper( wt, val, C - wt[i], i + 1, maxProfit + wt[i] );

//         // don't choose weight
//         int case2 = helper( wt, val, C, i + 1, maxProfit );

        
//         return Math.max(case1, case2);
//     }
// }





