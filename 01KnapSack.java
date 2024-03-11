public class KnapSack {
    
    // 2D DP
    // TC -> O(N * M) -> Where N is the length of weights and M is the Capacity of the kanpsack
    //SC -> O(N * M)
    /**
      W  V   0   1   2   3   4   5
      0  0   0   0   0   0   0   0
      1  10  0   10  10  10  10  10
      2  12  0   10  12  22  22  22
      4  2   0   10  12  22  22  22

      when j >= W[i-1] -> max(dp[i-1][j], V[i-1] + dp[i-1][j - W[i-1]])
      for i=2, j=3 -> max(10, 12 + 10)
      for i=3, j=5 -> max(22, 2+10)
    **/
    public static int maxProfit(int[] weights, int[] prices, int cap){
        if(weights.length == 0 || weights == null || prices.length == 0 || prices == null || weights.length != prices.length) return 0;
        
        int[][] dp = new int[weights.length+1][cap+1];
        int res = 0;
        
        // First dummy column = 0
        for(int i=0; i<= weights.length; i++){
            dp[i][0] = 0;
        }
        // First dummy row = 0
        for(int j=0; j<= cap; j++){
            dp[0][j] = 0;
        }
        
        for(int i=1; i <= weights.length; i++){
            for(int j=1; j<= cap; j++){
                if(j >= weights[i-1]){ 
                    dp[i][j] = Math.max(dp[i-1][j], prices[i-1] + dp[i-1][j- weights[i-1]]);
                }else dp[i][j] = dp[i-1][j];
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] weights = {1,2,4};
        int[] prices = {10,12,2};
        int capacity = 5;
        System.out.println("------ Using 2D DP -------");
        System.out.println(maxProfit(weights, prices, capacity));
        
    }
}
