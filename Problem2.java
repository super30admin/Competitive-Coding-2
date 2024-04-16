//Problem Name: Interview Problem: 0-1 Knapsack Problem
// Approach : We can solve this using recursion or dynamic programming
// Recursion approach - we each index we either choose or not choose each weight and calculate the max value
// Dynamic programming - since it has sub problems to solve we can go with dynamic programminsg
import java.util.*;
import java.io.*;
import java.lang.*;

/**
 *
 *
 * weights	values	0	1	2	            3	            4	            5	(targetWeight=5)
 * 0	    0	    0	0	0	            0	            0	            0
 * 1	    6	    0	6	6	            6	            6	            6
 * 2	    10	    0	6	max(6,10+0)=10	max(6,10+6)=16	max(6,10+6)=16	max(6,10+6)=16
 * 3	    12	    0	6	10	            16,12+0=16	    16,12+6=18	    16,12+10=22
 *
 *
 *
 */
//Time Complexity - O(n * W)
//space complexity - O(W)
class Solution
{
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int dp[] = new int[W+1];

        for(int i=0;i < n;i++) {
            for(int w=W; w>=0; w--){
                if(wt[i] <= w) {
                    dp[w] = Math.max(dp[w],dp[w-wt[i]] + val[i]);
                }
            }
        }
        return dp[W];
    }
}

// Recursive approach - Time complexity is 2^n
// Space complexity is  auxilary stack space + O(n)
class Solution {
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // your code here
        //base case
        if(n == 0 || W == 0) {
            return 0;
        }

        // if wt is > than capacity then not include
        if(wt[n-1] > W) {
            return knapSack(W, wt,val, n-1);
        }else {
            //max of item included and not included
            return Math.max(knapSack(W-wt[n-1], wt,val, n-1)+ val[n-1], knapSack(W,wt,val,n-1));
        }
    }
}

//{ Driver Code Starts
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

