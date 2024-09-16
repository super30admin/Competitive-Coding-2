//Time complexity: O(n*m) where n is the length of the weights array and m is target weight/max capacity of the Knapsack
//Space complexity: O(n*m) where n is the length of the weights array and m is target weight/max capacity of the Knapsack
public class MaxProfitKnapSack {
    private int[][] dp;
    public MaxProfitKnapSack()
    {

    }
    public int getMaxProfit(int[] weights, int[] profits, int target){

        //validations
        if(weights == null || profits == null || target < 0) {
            return -1;
        }
        dp = new int[weights.length+1][target+1];
        return helper(weights, profits, target);
    }

    private int helper(int[] weights, int[] profits, int target)
    {
        for(int i =1; i< weights.length+1; i++ ){
            for(int j =1; j <target+1; j++){

                if(weights[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    //don't choose
                    int case0 = dp[i-1][j];
                    //choose
                    int case1 = profits[i-1] + dp[i-1][j - weights[i-1]];
                    dp[i][j] = Math.max(case0, case1);
                }
            }
        }
        return dp[weights.length][target];
    }

    public static void main(String[] args) {
        MaxProfitKnapSack obj = new MaxProfitKnapSack();
        int[] weights = {1, 1, 1};
        int[] profits = {10, 20, 30};
        int target = 2;

        System.out.println(obj.getMaxProfit(weights, profits, target));
    }
}
