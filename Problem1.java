public class Problem1 {
    public static int maxProfit(int[] weights, int[] profits ,int capacity){
        if(weights.length != profits.length) return -1;
        int dp[][] = new int[weights.length+1][capacity+1];
        for(int i = 1; i <= weights.length; i++){
            for(int j = 1; j <= capacity; j++){
                if(j < weights[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], profits[i-1]+dp[i-1][j-weights[i-1]]);
                }
            }
        }
        return dp[weights.length][capacity];
    }

    public static void main(String[] args) {

        // int w[] = new int[]{10,20,30};
        // int p[] = new int[]{60,100,120};
        int w[] = new int[]{4,5,1};
        int p[] = new int[]{1,2,3};

        System.out.println(maxProfit(w, p, 4));
        // System.out.println("Hello World!");
    }
}
