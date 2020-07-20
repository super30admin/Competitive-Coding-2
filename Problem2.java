//Time complexity: O(N*W) where n is the no. of weight elements and W is capacity.
//Space complexity: O(N*W) 2D array. 
class Solution{
	static int knapSack(int W, int wt[], int val[], int n){
        //edge case
	if(val == null || n == 0) return 0;
	    int i,w;
	    int dp[][] = new int[n+1][W+1];
	    
	    for(i=1; i <= n; i++){
	        for(w=0; w <= W; w++){
	            if(i==0 || w==0){
	                dp[i][w] = 0;
	            }
	            else if(wt[i-1] <= w){
	                dp[i][w] = Math.max(dp[i-1][w], val[i-1] + dp[i-1][w-wt[i-1]]);
	            }
	            else{
	                dp[i][w]= dp[i-1][w];
	            }
	        }
	    }
	    return dp[n][W];
	}	
	public static void main (String[] args) {
		//code
		int val[]= new int[]{6,10,12};
		int wt[] = new int[]{1,2,3};
		int W = 5;
		int n = val.length;
		System.out.println(knapSack(W,wt,val,n));
		
	}
}