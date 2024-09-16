// Time Complexity : O(n*W)
// Space Complexity : O(n*W)
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class Knapsack{
	public static int findMax(int[] values, int[] weights, int W) {
		int[][] dp=new int[values.length+1][W+1];
		for(int i=0;i<dp.length;i++) {
			dp[i][0]=0;
		}
		for(int i=0;i<dp[0].length;i++) {
			dp[0][i]=0;
		}
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(j<weights[i-1]){
					dp[i][j]=dp[i-1][j];
				}else {
					int taken=values[i-1]+dp[i-1][j-weights[i-1]];
					int notTaken=dp[i-1][j];
					dp[i][j]=Math.max(taken, notTaken);
				}
			}
		}
		
		
		return dp[dp.length-1][dp[0].length-1];
	}
	
	 public static void main(String args[])
	    {
	        int val[] = new int[] { 60, 100, 120 };
	        int wt[] = new int[] { 10, 20, 30 };
	        int W = 50;
	        int n = val.length;
	        System.out.println(findMax(val,wt,W));
	    }
}