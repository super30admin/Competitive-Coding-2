//Brute Force
//Time Complexity : O(2^n)
//Space Complexity: O(n) Recursion Stack
//Run successfully on leetcode
//Problem : No problem

//DP optimization
//Time Complexity : O(m*n) (m = number of weights, n = maximum capacity)
//Space Complexity : O(m*n) Matrix
//Run successfully on leetcode
//Problem: No problem

//DP matrix 0/1 Knapsack

public class Competetive_Coding_2_Problem_2 {

    public static int knapsack(int[] weight,int[] value,int amount)
    {
        if(weight == null || value==null) return 0;
        return helper(weight,value,0,0,0,amount);
    }
    private static int helper(int[] weight,int[] value,int index,int amount,int currentWeight,int maxWeight)
    {
        if(currentWeight>maxWeight)
        {
            return amount-value[index-1];
        }
        else if(index == weight.length)
        {
            return amount;
        }

        int case1 = helper(weight, value, index + 1, amount + value[index],currentWeight + weight[index],maxWeight);
        int case2 = helper(weight,value,index+1,amount,currentWeight,maxWeight);
        return Math.max(case1,case2);
    }

    public static void main(String[] args) {
        int[] weight = {2,3,5};
        int[] value = {1,2,6};
        System.out.println(knapsack(weight,value,8));
        System.out.println(dpknapack(weight,value,8));
    }

    public static int dpknapack(int[] weight,int[] value,int amount)
    {
        if(weight == null || value==null) return 0;
        int[][] dp = new int[value.length + 1][amount+1];
        for(int i = 0 ; i < dp[0].length;i++)
        {
            dp[0][i] = 0;
        }
        for(int i = 1;i < dp.length ; i ++)
        {
            for(int j = 1; j<dp[0].length;j++)
            {
                if(j<weight[i-1])
                {
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
                }
            }
        }

        /*
        for(int i =0 ; i < dp[0].length; i++)
        {
            System.out.print(i+ " ");
        }
        System.out.println();

        for(int i =0 ; i < dp.length ; i++)
        {
            for(int j=0; j < dp[0].length ; j ++)
            {
                System.out.print(dp[i][j] + " " );
            }
            System.out.println();
        }

         */
        return dp[dp.length-1][dp[0].length-1];

    }

}
