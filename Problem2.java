// Time Complexity: O(n * W) where n is the number of items (length of the wt and profit arrays) and W is the target capacity
// Space Complexity: O(n * W) where n is the number of items (length of the wt and profit arrays) and W is the target capacity

class Problem2{
    public static int knapSack(int[] wt, int[] profit, int target){

        int[][] dp = new int[wt.length+1][target+1];

        dp[0][1] = profit[0];

        for(int i = 1; i < wt.length + 1; i++)
        {
            for(int j = 0; j < target + 1; j++)
            {
                if(j < wt[i-1])
                {
                    dp[i][j] = dp[i-1][j];
                }

                else
                {

                    dp[i][j] = Math.max(dp[i-1][j], profit[i-1] + dp[i-1][j-wt[i-1]]);

                }
            }
        }

        return dp[wt.length][target];

    }

    public static void main(String[] args){
        int profit[] = new int[] {4, 5, 3, 7};
        int weight[] = new int[] {2, 3, 1, 4};
        int maxWeight = 5;
        int n = profit.length;
        System.out.println(knapSack(weight, profit,maxWeight));
    }
}