public class Problem1 {
    ///Knapsack Problem
    /*
    time complexity - O(N*W)
    Space complexity - O(N*w) because of the dp array
    */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] value = {60,100,120};
        int[] weight = {10,20,30};
        int W = 50;
        
        System.out.println(knapsack(W,weight, value));


    }
    public static int knapsack(int W, int[] wt, int[] values){
        //dp[]
        /*
        Let weight elements = {1, 2, 3}
        Let weight values = {10, 15, 40}
        Capacity=6
        weights
        0 1 2 3 4 5 6 
    0   0 0 0 0 0 0 0 
    1   0 10 10 10 10 10 10
    2   0 10 max(10,15)= 15
    3   0
        
        */
        int n = values.length;
        int[][] dp = new int[n+1][W+1];
        for(int i = 0;i<= n ; i++){
            for(int j = 0 ;j<=W; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                    
                else if(wt[i-1] <=j){
                    dp[i][j] = Math.max(dp[i-1][j- wt[i-1]]+values[i-1], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                    
                }
            }
        }
        return dp[n][W];
        
    }
}