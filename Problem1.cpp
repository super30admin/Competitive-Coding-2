// 0-1 knapsack problem

// Time Complexity : O(n*m) where n is the length of the input weights array and m is the capacity
// Space Complexity : O(m) where m is the capacity
// Did this code successfully run on Leetcode : -
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Decide whether the current item can be included or not.
// If included, update dp[j] as the maximum of:
//    1. The current value stored in dp[j].
//    2. The value obtained by including this item (dp[j - weights[i]] + values[i]).


int maxProfit(vector<int> &values, vector<int> &weights, int n, int w)
{
	// Write your code here
	vector<int> dp(w+1,0);
	for(int i=1; i<=weights.size(); i++){
		for(int j=w; j>=0; j--){
			if(weights[i-1]<=j){
				dp[j] = max(dp[j], dp[j-weights[i-1]]+ values[i-1]);
			}
		}
	}
	return dp[w];
}