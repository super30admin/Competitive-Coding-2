// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Any problem you faced while coding this : No
class Knapsack {
 
    // Driver code
    public static void main(String args[])
    {
        int value[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int capacity  = 50;
        System.out.println(knapsack(value, weight, capacity));
    }
    
    private static int knapsack (int value[], int weight[], int capacity){
        int[][] dp = new int[weight.length + 1][capacity + 1];
        for(int i = 1; i < dp.length;i++)
            for(int j = 1; j < dp[0].length; j++){
                //if current weight is not chosen
                if(j < weight[i - 1])
                    dp[i][j] = dp[i - 1][j];
                //if current weight is chosen    
                else
                    dp[i][j] = Math.max(dp[i - 1][j],value[i - 1] + 
                        dp[i - 1][j - weight[i - 1]]);
            }
       return dp[dp.length - 1][dp[0].length - 1];
    }
}