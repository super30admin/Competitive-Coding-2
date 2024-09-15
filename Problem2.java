
// Time Complexity : O(M*N) , M=length of weights array , N= max weight
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


/*0-1 Knapsack Problem | DP-10
we are given weights and values of n items. we need to put these items in a knapsack of capacity W to get maximum value in our knapsack.

or we can say that we are given two integers arrays val[0......n-1] and wt[0.....n-1] which represent values and weights associated with n items respectively. we are also given an integer W  which represents knapsack capacity.

find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. but you cannot break an item, either pick the complete item or dont pick it(known as 0-1 property).

knapsack-problem*/

public class knapsack {
	public static int knapSack(int w,int[] wt,int[] val,int n) {
		int[][] dp = new int[n+1][w+1]; // [4][51]
        for(int i=1;i<=n;i++){  // 1 - 4
            for(int j =1;j<= w;j++){ // 1- 51
                    if(j< wt[i-1]){      // 1<0
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                       dp[i][j] = Math.max(dp[i-1][j],val[i-1]+dp[i][j- wt[i-1]]);   
                    }   
                }            
        }
        return dp[n][w];
	}
	public static void main(String[] args) {
		int val[] = new int[] { 2, 1, 10 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = val.length;
		int max_value = knapSack(W, wt, val, n);
		System.out.println("Weights: " + Arrays.toString(wt));
		System.out.println("Value: " + Arrays.toString(val));
		System.out.println("Weight Capacity: " + W);
		System.out.println("Maximum Value: " + max_value);
	}
}