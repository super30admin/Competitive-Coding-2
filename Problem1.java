//Time complexity : N*C (C = capacity)
//space complexity: N*C
//Any doubts : No
// https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
//0-1 Knapsack Problem | DP-10
public class Problem1 {
    public static int maxSum(int[] value, int[] weight,int capacity){
        if(value==null || value.length ==0)return 0;
        if(capacity == 0) return 0;
         int[][] dp = new int[value.length+1][capacity+1];
         for(int i =0;i<dp.length;i++){
             dp[i][0] = 0;
         }
         for(int j=0;j<dp[0].length;j++){
             dp[0][j]=0;
         }
         for(int i =1;i<dp.length;i++){
             for(int j =1;j<dp[0].length;j++){
                 if(j<weight[i-1]){
                     dp[i][j]= dp[i-1][j];
                 }else{
                     dp[i][j]= Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+ value[i-1]);
                 }
                 
             }
         }
         return dp[dp.length-1][dp[0].length-1];
     }
}
