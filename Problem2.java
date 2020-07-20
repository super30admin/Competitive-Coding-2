/**
 * Time Complexity: O(m*n) where m is the number of rows and n is the number of columns of the two dimensional array we are using
 * Space Complexity : O(1) 
 * Any Issues Coding: made mistakes while indexing elements
 * Approach : 1. we use a two dimensional array where the columns represent the remaining capacity of the Knapsack.
 * 2. every cell represents the maximum profit which could be earned with a particular weight and a remaining capacity.
 */

class Knapsack {
    public static int maxProfit(int[] wt,int[] profit,int capacity)
    {
        int[][] dp = new int[wt.length+1][capacity+1];
        for(int j=0;j<=capacity;++j)
        {
            dp[0][j] = 0; // with weight zero and also because it doesnt exist in the weights array, you cant earn any profit
        }
        for(int i=0;i<=wt.length;++i)
        {
            dp[i][0] = 0; //dp[0][0] is zero and for the rest of dp[i][0], weight is more than capacity so we cant choose these weights, hence, progit earned is zero for every dp[i][0]
        }
        for(int i=1;i<=wt.length;++i)
        {
            for(int j=1;j<=capacity;++j)
            {
                if(wt[i-1]>j)  
                {                    dp[i][j] = dp[i-1][j];  //if weight is greater than capacity, we cant choose that weight
                }
                else
                {
                    int remaining_capacity = j - wt[i-1];
                    dp[i][j] = Math.max(dp[i-1][j], profit[i-1] + dp[i-1][remaining_capacity]); 
                    // we need to take max out of the profit when we dont choose a prticular weight(profit will be the cell value above it) and when we choose that weight(in this profit from that weight is taken into account, next we see whats the remaining capacity and the profit which is earned using previous weight and remaining capacity)
                }
            }
        }
        return dp[wt.length][capacity];
    }
    public static void main (String[] args) {	
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 }; 		
        int W = 50;			
        System.out.println(maxProfit(wt,val,W));			
                                                    }
}