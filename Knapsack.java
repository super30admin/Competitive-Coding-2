/**
 * Time Complexity: O(n*m) where n= size of weights, m = size of capacity   
 * Space Complexity: O(m)
 * 
 */

public class Knapsack {
    public int solve(int[] weights, int[] values, int capacity) {
        int[][] dp = new int[capacity+1][weights.length+1];
        for(int i = 1; i < dp.length; ++i)
        {
            for(int j = 1; j < dp[0].length; ++j)
            {
                if(i >= weights[j-1])
                {
                    int val = values[j-1];
                    int nextC = i - weights[j-1];
                    val += dp[nextC][j-1];
                    dp[i][j] = Math.max(dp[i][j-1], val);
                }
                else
                {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[capacity][weights.length];
    }

    
    public static void main(String args[]){
        Knapsack obj = new Knapsack();
        int[] weights = new int[]{1,2,3,4,6,8};
        int[] values = new int[]{20,30,10,40,5,1}; 
        int capacity = 15;
        System.out.println("max profit = "+obj.solve(weights,values,capacity));

    }
}