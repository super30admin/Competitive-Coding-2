// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this : 

// Notes :

class Knapsack 
{ 
    // Returns the maximum value that can be put in a knapsack of capacity W 
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        if(wt == null || val == null || wt.length == 0 || val.length == 0){
            return -1;
        }
         
        int[][] matrix = new int[n+1][W+1];
        
        for(int i = 0; i < matrix.length ; i++){
            matrix[i][0] = 0;
        }
        for(int j = 1; j < matrix[0].length ; j++){
            matrix[0][j] = 0;
        }
        
        int sumOfVals = 0;
        for(int i = 1; i < matrix.length ; i++){
            sumOfVals = sumOfVals + val[i - 1]; 
            
            for(int j = 1; j < matrix[0].length; j++){
                if(j < val[i - 1]){
                    matrix[i][j] = matrix[i-1][j];
                } else if(j > sumOfVals){
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], wt[i - 1] + matrix[i][j - val[i - 1]]);
                }
            }
        }

        return matrix[matrix.length - 1][matrix[0].length - 1];
    } 
}