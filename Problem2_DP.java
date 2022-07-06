//Time Complexity: O(m*n)
//Space Complexity : O(m*n);
//Code accepted and submitted.


public class Problem2_DP {
	
	static int knapSack(int W, int wt[], int val[], int n) 
    { 
         if(n == 0)
        	 return -1;
         
         int[][] dp = new int[n+1][W+1];
         
         for(int i =1; i < n+1; i++) {
        	 for(int j =1; j <W+1; j++) {
        		 
        		 if(j < wt[i -1])
        			 dp[i][j] = dp[i-1][j];
        		 else 
        		 {
        			 dp[i][j] = Math.max(dp[i-1][j], val[i-1]+ dp[i-1][j - wt[i-1]]);
        		 }
        	 }
         }
         
         return dp[n][W];
    }
	
	public static void main(String[] args) {
		
		int[] wt = new int[] {1,5,4};
		int[] val = new int[] {3,2,1};
		
		int ans = Problem2_DP.knapSack(4, wt, val, 3);
		System.out.println(ans);
	}

}
