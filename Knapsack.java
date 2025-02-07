// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Knapsack {
    
    public static int findMaxValue(int[] weight, int[] value, int target) {
	int n = weight.length;
	int[][] dp=new int[n+1][target+1];
	//base
	
	//choose
	for(int i=0;i<=n;i++) {
	    for(int j=0;j<=target;j++) {
		
		//base
		if(i==0 || j==0) {
		    dp[i][j]=0;
		    continue;
		}
		
		//choose
		int case1=0;
		if(weight[i-1]<=j) {
		    case1 = value[i-1]+dp[i-1][j-weight[i-1]];
		}
		
		//not choose
		int case2= dp[i-1][j];
		dp[i][j]=Math.max(case1, case2);
		
	    }
	}
	return dp[n][target];
	
    }
    
    public static void main(String args[])
    {
        int profit[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = profit.length;
        System.out.println(findMaxValue( weight, profit,W));
    }
}