// Time Complexity : O(n*m); where n = length of weights array and m= Weight capacity.
// Space Complexity : O(n*m)
class Problem2 {
	public int zeroOneKnapsack(int[] weight, int[] value, int capacity) {  
		if(weight==null || weight.length==0) return 0;
		
		//Create DP Matrix
		int[][] dp= new int[weight.length+1][capacity+1];
		
		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp[0].length; j++) {
				//zero case
				if(weight[i-1] > j) {
					dp[i][j]= dp[i-1][j];
				}else {
					dp[i][j]= Math.max(dp[i-1][j], value[i-1]+dp[i-1][j-weight[i-1]]); 
				}
			}
		}		
		//Result is last item in DP Matrix
		return dp[dp.length-1][dp[0].length-1];
	}
	
	// Driver code to test above 
    public static void main(String args[]) { 
    	Problem2 ob = new Problem2();  
    	int[] wt= {10,20,30};
    	int[] val= {60,100,120};
    	int W=50;
        System.out.println("Max value that can be put into knapsack of weight capacity "+W+" is: "+ob.zeroOneKnapsack(wt, val, W));
    } 
}