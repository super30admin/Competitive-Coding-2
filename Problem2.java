//Problem 2 : 0/1 Knapsack problem

import java.util.*;

class Solution {

    static int knapsack(int W, int[] val, int[] wt) {
        int m = W+1;// col : Representing the max weight
        int n = val.length + 1; // row : representing the profit 
        int dp[][] = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                
                //if either the profit or weight is 0 we will put 0 at that place
                if(i==0 || j ==0){
                    dp[i][j] = 0;
                }
                //If weight or profit is not 0 we will make a choice to choose or not choose
                else{

                    int pick = 0;
                    //To choose we will check if we are exceeding the weight limit or not(and if we are not exceeding the weight limit we will pick the item)
                    if(wt[i-1] <= j){
                        pick = val[i-1] + dp[i-1][j-wt[i-1]];
                    }
                    //Do not pick the ith item if it exceeds the weight limit
                    int notPick = dp[i-1][j];

                    dp[i][j] = Math.max(pick, notPick);

                }
            }
        }


        return dp[val.length][W];
    }

    public static void main(String[] args) {
        int[] val = {1, 2, 3};
        int[] wt = {4, 5, 1};
        int W = 4;

        System.out.println(knapsack(W, val, wt));
    }
}