using System;

public class HelloWorld
{
    public static void Main(string[] args)
    {
        int[] profit = new int[]{60,100,120};
        int[] weight = new int[]{10,20,30};
        int capacity = 50;
        var m =  weight.Length;
        var n = capacity;
        int[,] dp = new int[m+1,n+1];
        for(var i=1;i<=m;i++)
        {
            for(var j=1;j<=n;j++)
            {
                if(j<weight[i-1])
                {
                    dp[i,j] = dp[i-1,j];
                }
                else
                {
                    dp[i,j] = Math.Max(dp[i-1,j],profit[i-1] + dp[i-1,j-weight[i-1]]);
                }
            }
        }
        Console.WriteLine(dp[m,n]);
    }
}