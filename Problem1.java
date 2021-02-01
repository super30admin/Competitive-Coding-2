public class Knapsack_0_1 {
    public static void main(String[] args) {
        //Find the maximum profit, cannot put multiple weights in the sack
        int[] profits = new int[]{1,2,5,6};
        int[] weights = new int[]{2,3,4,5};
        int capacity = 8; //expected output 8

        // Example 2:
        // profits = new int[]{60,100,120};
        // weights = new int[]{10,20,30};
        //capacity = 50; // expected output 220

        int maxProfit = knapsack01(weights,profits,capacity);
        System.out.println(maxProfit);

    }
    public static int knapsack01(int[] weights,int[] profits, int capacity){
        int n = weights.length+1;
        int m =capacity+1;
        int profitSum = 0;
        int[][] dp = new int[n][m]; // weights x capcaity matrix
        for(int j=0;j<m;j++){
            dp[0][j] = 0; // 0 weight => cant make any profit
        }
        for(int i=0;i<n;i++){
            dp[i][0] = 0; // if capacity is 0 => cant make any profit
        }


        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(j < weights[i-1]){ // extra row has been addded to weights
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-weights[i-1]]+profits[i-1],dp[i-1][j]);
                }
            }
        }

        return dp[n-1][m-1];

    }
}


