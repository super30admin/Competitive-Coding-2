#include<iostream>
#include<vector>
using namespace std;
/*
We use a 1D array to keep track of max profit for every capacity.
For each item, we go backward to avoid overwriting previous states.
In the end, the last cell gives the best profit for full capacity
*/
class Solution{
public:
    static int findMax(vector<int>& weights, vector<int>& profit, int totalCapacity) {
        int n = totalCapacity;
        int m = weights.size();
        vector<int> dp(n + 1, 0);

        for (int i = 0; i < m; i++) {
            for (int j = n; j >= weights[i]; j--) {
                dp[j] = max(dp[j], profit[i] + dp[j - weights[i]]);
            }
        }

        return dp[n];
    }
};
