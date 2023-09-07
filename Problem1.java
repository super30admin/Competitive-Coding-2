//Knapsack Problem
// Time Complexity : O(n*W) 
// Space Complexity : O(n*W)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this:  Took some time to create the 2D Matrix and finding the formula to calculate dp[r][c]
// Your code here along with comments explaining your approach: 

We will find the maximum value returned between (value received from previous row, same column) and (value of wt[row]+value found until previous row and column=Capacity-weight)

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         if ((n==0)||(n==1 && wt[0]>W)) return 0;
         if(n==0 && wt[0]<=W) return val[0];
         
         //the size of the row is the length of weights array +1 and column is Capacity+1
         int[][] dp = new int[n + 1][W + 1];

//We will be starting from row=1 and column=1 since all the values in weight=0 and capacity=0 is 0
        for (int r = 1; r <= n; r++) 
        {
            for (int c = 1; c <= W; c++) 
            {
// If the element in the weight array is greater than the capacity, 
//then the matrix will take the value from the previous row same column.               
                if (wt[r - 1] > c) 
                {
                    dp[r][c] = dp[r - 1][c];
                } 
// else we take the max value between the current row and column and value +dp of previous row, but capacity-weight of the previous row                
                else 
                {
                    dp[r][c] = Math.max(dp[r - 1][c], val[r - 1] + dp[r - 1][c - wt[r - 1]]);
                }
            }
        }

//The final answer is the last element of the dp array        

        return dp[n][W];
    } 
    
}


/*Recursive
//Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         if ((n==0)||(n==1 && wt[0]>W)) return 0;
         if(n==0 && wt[0]<=W) return val[0];
         
         return helper(W,wt,val,n-1);
          
         //wt[]={1,2,3} val[]={4,5,1}
    } 
    
    private static int helper(int W,int wt[],int val[],int i)
    {
        //base
        if(i==0 || W==0) return 0;
        else if(W<wt[i]) 
        {return helper(W,wt,val,i-1);}
        
        else{
        //logic
        //not choose
        int case0=helper(W,wt,val,i-1);
        //choose
        int case1=val[i]+helper(W-wt[i],wt,val,i-1);
        
        
        return Math.max(case0,case1);}
   
    }
}
 */