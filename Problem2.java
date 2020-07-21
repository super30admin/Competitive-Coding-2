// Time Complexity : O(NT) where N is the weight/value array length
// Space COmplexity : O(N)


/**
 *
 * @author sarthakgoel
 */
public class Solution {
    public int maxValue(int[] weight, int[] value, int target){
        int n = weight.length;
        private int[][] dp = new int[n+1][target+1];

        for(int i =0; i<n+1; i++){
            dp[i][0] = 0;
        }

        for(int j = 1; j<=target; j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i<dp.length; i++){
            for(int j =1 ; j<dp[0].length; j++){
                if(j<weight[i-1]) dp[i][j] = dp[i-1][j];
                else{
                    dp[i][j] = Math.max((value[i-1]+dp[i-1][j-weight[i-1]]), dp[i-1][j]);
                }
            }
        }
        return dp[weight.length][target];
    }    
}