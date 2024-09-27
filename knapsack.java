//Time complexity : O(n*capacity)
//Space complexity: O(n*capacity)

class KnapSackSolution {
    public int knapSack(int[] weights, int[]val, int W, int n)
    {
        int[][] dp = new int[n][W+1];
        for(int i=0; i<dp.length; i++)      //for total capacity = 0, max value = 0
            dp[i][0]=0;
        for(int i=0; i<dp[i].length; i++)   
        {
            if(weights[0]<=W)
                dp[0][i]=val[i];    
        }
        for(int i=1; i < dp.length; i++)
        {
            for(int j=1; j<dp[0].length; j++)
            {
                dp[i][j]=Math.max(dp[i-1][j], val[i]+dp[i-1][j-weights[i]]);
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}



