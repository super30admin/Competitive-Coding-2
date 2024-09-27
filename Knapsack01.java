//  Problem: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
// Time Complexity :O(nm) n - weight array m - capacity
// Space Complexity : O(nm) 

public class Knapsack01 {

    public int maxProfit(int[] weights, int[] costs, int capacity)
    {
        if(weights == null || weights.length == 0)
            return 0;
        
        int dp[][] = new int [weights.length+1][capacity+1]; // row+1 for 0 weight col+1 because idx starts for 0

        //dp[0][c] = 0 as 0 weight any capacity cost is 0
        //dp[r][0] = 0 as 0 capactiy any weight cost is 0

        for(int i = 1; i < weights.length+1; i ++)
        {
            for(int j = 1; j < capacity + 1; j++)// since we need to see idx == capacity
            {
                if(j < weights[i-1]) // capacity is less than the weight we have
                {
                    dp[i][j] = dp[i-1][j];// do not select current weight use previous weight
                }
                else
                    dp[i][j] = Math.max(dp[i-1][j], costs[i-1] + dp[i-1][j-weights[i-1]]);
            }
        }
    
        return dp[weights.length][capacity];
    }

    public static void main(String[] args) {
        Knapsack01 obj = new Knapsack01();
        int weights[] = new int[]{10,20,30};
        int costs[] = new int[]{60,100,120};
        int capacity = 50;

        int profit = obj.maxProfit(weights, costs, capacity);

        System.out.println(profit);
    }
}