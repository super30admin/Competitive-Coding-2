public class Problem2 {
    public static void main(String[] args) {
        int[] v = { 60, 100, 120 };
        int[] w = { 10, 20, 30 };
        int c = 50;
        System.out.println(knapsack(v, w, c));
    }
    
    public static int knapsack(int[] val, int[] weight, int capacity){
        
        int[][] dp = new int[weight.length+1][capacity+1];
        
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 0;
        }
        
        for(int i=0; i<dp[0].length; i++){
            dp[0][i] = 0;
        }
        
        for(int row=1; row<dp.length; row++){
            for(int col=1; col<dp[0].length; col++){
                if(weight[row-1]>col) {
                    dp[row][col] = dp[row-1][col]; //Not choosing the item to put in knapsack\
                }
                else {
                    dp[row][col] = Math.max(dp[row-1][col], val[row-1]+dp[row-1][col-weight[row-1]]);
                }
            }
        }
        
        return dp[weight.length][capacity];
    }
}
