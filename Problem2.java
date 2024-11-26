// Time Complexity : O(n*m) where n is the length of items and m is the capacity
// Space Complexity : O(n*m) where n is the length of items and m is the capacity
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class knapSack {
     static int knapSack(int W,int[]wt,int[]val,int n){
        int[][] dp = new int[wt.length+1][W+1];
        for(int i =1;i<wt.length+1;i++){
            for(int j = 1;j<W+1;j++){
                if(j<wt[i-1])
                    dp[i][j] = dp[i-1][j];
                else{
                    dp[i][j]= Math.max(dp[i-1][j],val[i-1]+dp[i-1][j-wt[i-1]]);
                }
            }
        }
        return dp[wt.length][W];
    }
  public static void main(String args[])
    {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}
  