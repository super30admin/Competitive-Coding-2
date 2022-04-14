public class KnapSack{
    

    public static int knap(int[] weights,int[] values, int maxWeight)
    {
        if(weights==null || weights.length==0 || values == null || values.length==0)
        {
            return 0;
        }

        int[][] dp = new int[values.length+1][maxWeight+1];

       for(int i = 0;i<dp.length;i++)
       {
           for(int j = 0;j<=maxWeight;j++)
           {
               if(i==0 || j == 0)
               {
                   dp[i][j]=0;
               }
               else if(weights[i - 1] <= j)
               dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]],dp[i - 1][j]);
               else
               {
                   dp[i][j]=dp[i-1][j];
               }
           }
       }

       return dp[values.length][maxWeight];
    }

    public static void main(String args[])
    {
        int[] weights  = {10,20,30};
        int[] values = {60,100,120};
        int maxWeight = 50;
        System.out.println(knap(weights, values, maxWeight));
    }
}