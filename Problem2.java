package com.interview.sthirty;

public class KnapSack
{
    private int capacity = 40;
    private int weight[] = { 10, 20, 30 };
    private int profit[] = { 2, 1, 10 };

    int currentCapacity[] = {0,10,20,30,40};
    int weights[] = {0,10,20,30};
    int profits[] = { 0, 2, 1, 10, 0 };

    private int maxProfit(int index, int currentCapacity, int currentProfit)
    {

        if(index == weight.length || currentCapacity == capacity)
        {
            return currentProfit;
        }

        if(currentCapacity > capacity)
            return 0;


        int choose = maxProfit(index, currentCapacity + weight[index], currentProfit + profit[index]);
        int dontChoose = maxProfit(index+1, currentCapacity, currentProfit);

        return Math.max(choose, dontChoose);

    }

    private int maxProfitOptimised()
    {
        int dp[][] = new int[4][5];
        int maxProfit = 0;

        for(int i =1 ; i < weights.length; i++)
        {
            for(int j = 1; j < currentCapacity.length ; j++)
            {
                if(weights[i] > currentCapacity[j])
                {
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    System.out.println(i + " " + j);
                    int currentProfit = Math.max(dp[i-1][j], profits[j] + dp[i][(currentCapacity[j]-weights[i])/10]);
                    dp[i][j] = currentProfit;
                    maxProfit = Math.max(currentProfit, maxProfit);

                }

            }
        }


        return maxProfit;
    }


    public static void main(String argv[])
    {
        KnapSack knp = new KnapSack();
        int maxProfit1 = knp.maxProfit(0, 0, 0);
        int maxProfit2 = knp.maxProfitOptimised();

        System.out.println("Max profit 1 is: "+ maxProfit1);
        System.out.println("Max profit 2 is: "+ maxProfit2);

    }

}
