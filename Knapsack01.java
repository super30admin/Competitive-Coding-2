public class Knapsack01 {
    public static int Knapsack0or1(int[] p, int[] w, int W){

        int n = p.length;
        int[][] dp = new int[n+1][W+1]; // O(n*W)

        for(int i =0; i <= n; i++){
            for(int j = 0; j <= W; j++){ // O(n*W)

                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }

                else if(w[i-1] <= j){

                    /*no choose and take from previous row or choose weight and
                    go to reduced weight capacity column in previous row */
                    dp[i][j] = Math.max(dp[i-1][j], p[i-1] + dp[i-1][j -w[i-1]]);
                }

                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }

    /* Time Complexity = O(n*W)
    Space Complexity = O(n*W)
    */

    public static void main(String[] args){

        Knapsack01 object = new Knapsack01();

        int[] profits = {60, 100, 120};

        int[] weights = {10, 20, 30};

        int capacityWeight = 50;


        int result = object.Knapsack0or1(profits, weights, capacityWeight);

        System.out.println("Maximum profit of knapsack is " + result);

    }
}
