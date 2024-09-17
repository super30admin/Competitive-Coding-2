//Time complexity - O((n+1)*(W+1))
//Space complexity - O((n+1)*(W+1))

class Solution {
	int profit(vector<int> wt, vector<int> vals, int W) {
		int n = wt.size();
		vector<vector<int>> dp (n+1,vector<int>(W+1,0));

		for(int i=1;i<=n;i++){
			for(int j=1;j<=W;j++){
				if(wt[i-1]>=j)
					dp[i][j] = max(vals[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
			}
		}

		return dp[n][W];
	}
}
