//TC O(n*m);
//SC O(m*n)

//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int capacity, int weights[], int val[], int n) 
    { 
         // your code here 
         
         //base condition
         if(weights == null || weights.length == 0){
             return 0;
         }
         
         //initilizing dp array
         int [][] dp = new int[weights.length + 1][capacity + 1];
         
         
         for(int i=1; i<weights.length + 1; i++){
             for(int j=1; j<capacity+1; j++){
                 if(j < weights[i-1] )
                 {
                     dp[i][j] = dp[i-1][j];
                 }else{
                 
                 dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weights[i-1]] + val[i-1] );
                 }
             }
         }
         return dp[weights.length][capacity];
         
    } 
}


