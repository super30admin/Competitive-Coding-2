// Time Complexity : O(M*N)O(N)

// Space Complexity : O(M*N)

#include <bits/stdc++.h>
using namespace std;

int helper(int idx,int cap,vector<int> &weights,vector<int> &values,vector<vector<int>>& dp){
	if(idx < 0 || cap == 0){
		return 0;
	}
	if(dp[idx][cap] != -1) return dp[idx][cap];
	int notTake = 0 + helper(idx-1,cap,weights,values,dp);
	int take = INT_MIN;
	if(weights[idx] <= cap){
		take = values[idx] + helper(idx-1,cap-weights[idx],weights,values,dp);
	}
	return dp[idx][cap] = max(notTake,take);
}


int maxProfit(vector<int> &values, vector<int> &weights, int n, int cap)
{
	vector<vector<int>> dp(n,vector<int>(cap+1,-1));
	return helper(n-1,cap,weights,values,dp);
}