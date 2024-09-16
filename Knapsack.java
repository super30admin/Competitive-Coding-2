// Time Complexity : O(m*n) where n is the total number of bags(profits/wts) and n is the Capacity
// Space Complexity : O(m*n) where n is the total number of bags(profits/wts) and n is the Capacity
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Knapsack{

    public int knapsack(int[] profits, int[] wts, int capacity, int index){

        int [][] dp = new int[wts.length+1][capacity+1];

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length; j++){
                //The first row and column will be filled with 0 value
                //now if the weight is less than wts
                if(j<wts[i-1]){//we take i-1 because there are wts.length+1 rows;
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], profits[i-1]+dp[i-1][j-wts[i-1]]);
                }
            }
        }
        return dp[wts.length][capacity];
    }

    public static void main(String[] args){
        int [] profits = new int[]{60,120,100};
        int [] wts = new int[]{10,30,20};
        int capacity = 50;

        int index = wts.length-1;
        Knapsack k = new Knapsack();
        System.out.println(k.knapsack(profits, wts, capacity, index));
    }
}