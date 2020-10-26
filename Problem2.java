// Time Complexity : Latest soln O(M*N) - Brute force -// O(M*2^N) - no of elements
// Space Complexity : O(M*N) - No of elements here but for brute force O(M+N)
// Did this code successfully run on Leetcode :Yes,for optimal code but  for Brute force - Yes,but TLE
// Any problem you faced while coding this :No

class Main {
    public static void main(String[] args) {
      int val[] = new int[]{60, 100, 120};
      int wt[] = new int[]{10, 20, 30};
      int  W = 50;
      int n = val.length;
      System.out.println(knapSack(W, wt, val, n));
    }
    public static int knapSack(int W, int[] wt, int[] val, int n) {
        int[] [] dp =new int[wt.length + 1][W+1];
        for(int i=1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                if(j < wt[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1] + dp[i-1][j - wt[i-1]]);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
  }