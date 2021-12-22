Time Complexity- O(n*m)
Space Complexity-O(n*m)
Executed on Leetcode - Yes

class Knapsack {



    static int knapSack(int W, int wt[], int val[], int n)
    {
    	int[][] dp=new int[wt.length+1][W+1];
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is
        // more than Knapsack capacity W,
        // then this item cannot be included
        // in the optimal solution
      //  if (wt[n - 1] > W)
          //  return knapSack(W, wt, val, n - 1);

        // Return the maximum of two cases:
        // (1) nth item included
        // (2) not included

        for(int i=0;i<wt.length+1;i++){
            dp[i][0]=0;
        }
        for(int j = 0;j<W+1;j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<wt.length+1;i++) {
        	for(int j=1;j<W+1;j++) {
        		if(j<wt[i-1])
        			dp[i][j]=dp[i-1][j];
        		else
        		dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-wt[i-1]]+val[i-1]);
        	}
        }


        return dp[wt.length][W];

    }

    // Driver code
    public static void main(String args[])
    {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}



