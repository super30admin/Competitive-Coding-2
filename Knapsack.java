// Time Complexity: O( n * W)
//Space Complexity: O(n * W)
// 0-1 Knapsack problem
// Source: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

public int getMaxValue(int[] val, int[] wt, int W)
    {
        int n=val.length;
        if(n==0)
            return 0;
        int[][] dp=new int[n+1][W+1];
        
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=W;j++)
            {
                // j=0 means capacity, W==0 => our profit will be zero
                //At i=0 dp[i][0]=0=> indicates an empty wt array=> profit will be zero
                if(i==0 || j==0)
                    dp[i][j]=0;
                else
                {
                    if( j < wt[i-1])
                    {
                        dp[i][j]=dp[i-1][j];
                    }
                    else
                    {
                        dp[i][j]= Math.max(dp[i-1][j], val[i-1]+dp[i-1][j-wt[i-1]]);

                    }
                    
                }
                
            }
        }
        
        return dp[n][W];
    }