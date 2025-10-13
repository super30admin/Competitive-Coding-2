// 0/1 Knapsack Problem
// https://www.geeksforgeeks.org/dsa/0-1-knapsack-problem-dp-10/


// Memoization

/**
 * Time Complexity: O(n * m) since we check all combinations of item wt and bag capacity
 * Space Complexity: O(n * m) 
 */

class Solution{

    int memo[][];

    public int knapsack(int [] weight, int [] prices, int w){

        memo = new int[weight.length][w];

        for(int i = 0 ; i < memo.length ; i++){
            Arrays.fill(memo[i], -1);
        }

        return helper(weight, prices, 0, w);
    }

    private int helper(int weight[], int prices[], int idx, int w){
        // base condition
        if(idx >= weight.length || w == 0){
            return 0;
        }

        if(memo[idx][w - 1] != -1){
            return memo[idx][w - 1];
        }


        // logic

        if(weight[idx] > w){
            return helper(weight, prices, idx + 1, w);
        }

        // 2 Choices. 

        int pick = prices[idx] + helper(weight, prices, idx + 1, w - weight[idx]);
        
        int notPick = helper(weight, prices, idx + 1, w);

        return memo[idx][w - 1] = Math.max(pick, notPick);
    }
}


// Tabulation

/**
 * Time Complexity: O(n * m) since we check all combinations of item wt and bag capacity
 * Space Complexity: O(n * m) 
 */

class Solution{

    public int knapsack(int [] weight, int [] prices, int w){

        int n = weight.length;
        int m = w;

        int dp[][] = new int[n + 1][m + 1];

        for(int i = 1 ; i < n + 1; i++){
            for(int j = 1 ; j < m + 1; j++){
                if(weight[i - 1] <= j){
                    dp[i][j] = Math.max(prices[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
                }
            }
        }

        return dp[n][m];
    }
}