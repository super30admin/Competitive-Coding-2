//Time complexity - O(n*W)
//Space complexity - O(n*W)
//Able to execute the code - yes

//Approach
//use 2D array to store the number od items and total capacity given
//to get max profit we either select the current item or skip the current
//store the recursive subarrays in memo array
class Main {
    public int knapSack(int[] weights, int[] profits, int W) {
        int n = weights.length;
        int[][] memo = new int[n][W+1];
        for (int i = 0; i < n; i++) {
            for (int w = 0; w <= W; w++) {
             memo[i][w] = -1;
            }
        }
        return helper(weights, profits, W, 0, memo);
    }
    
    private int helper(int[] weights, int[] profits, int W, int i, int[][] memo) {
        //base
        if(i==weights.length || W==0) return 0;
        //Memo check
        if(memo[i][W]!=-1) return memo[i][W];
        //logic
        int case0, case1;
        //Skip the current
        if(weights[i] <= W) {
        case0= helper(weights, profits, W, i+1, memo);
        
        //take current
        case1=profits[i] + helper(weights, profits,(W - weights[i]), i+1, memo);
        memo[i][W] = Math.max(case0, case1);
        return memo[i][W];
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] weights = {1, 3, 4, 5};
        int[] profits = {1, 4, 5, 7};
        int W = 7;

        Main obj = new Main();
        int maxProfit = obj.knapSack(weights, profits, W);
        System.out.println("Maximum Profit = " + maxProfit);
    }
}
