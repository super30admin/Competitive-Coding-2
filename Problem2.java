
class Knapsack {
    // Recursive solution
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        return helper(W,wt,val,0, 0);
        
    }
    public static int helper(int capacity, int[]wt,int[]val,int profit,int index){


        //base
        if(index==val.length)
        return profit;

        //logic
        if(wt[index]>capacity)
         return helper(capacity,wt,val,profit,index+1);

         int choose=helper(capacity-wt[index],wt,val,profit+val[index],index+1);
         int notchoose=helper(capacity,wt,val,profit,index+1);
         return Math.max(choose,notchoose);
    }

    // DP solution
    static int knapSack2(int W, int wt[], 
                        int val[], int n)
    {
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) 
        {
            for (int j = 0; j <= W; j++) 
            {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (j>=wt[i-1])
                    dp[i][j]
                        = Math.max(val[i - 1]
                         + dp[i - 1][j - wt[i - 1]],
                         dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][W];
    }

    // Driver code
    public static void main(String args[])
    {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
        System.out.println(knapSack2(W, wt, val, n));
    }
}