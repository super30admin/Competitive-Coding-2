class ZeroOneKnapsach {
    // Time Complexity : O(NM)
    // Space Complexity : O(NM)
    // Did this code successfully run on Leetcode : yes
    // Any problem you faced while coding this : no

    public int maxProfit(int profits[], int weight[], int capacity) {
        int dp[][] = new int[weight.length + 1][capacity + 1];
        int w =0;
        for (int i = 1; i < dp.length; i++) {
            w+= weight[i-1];
            for (int j = 0; j < dp[0].length; j++) {
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else if( j <=w){
                    dp[i][j] = Math.max(dp[i - 1][j], profits[i-1] + dp[i][j - weight[i - 1]]);
                }
                else{
                    dp[i][j] = dp[i][j-1];
                }
                System.out.print(" " + dp[i][j]);
            }
            System.out.println();

        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
    public static void main(String args[]) {
        ZeroOneKnapsach knap = new ZeroOneKnapsach();
        int profit[] = {10,10,910};
        int weights[] = {10,20,30};
        int capacity = 50;
        System.out.println(knap.maxProfit(profit,weights,capacity));
    }
}