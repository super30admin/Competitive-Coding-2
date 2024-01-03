// Time Complexity : O(m*n), where m is number of items and n is maxCapacity.
// Space Complexity : O(m*n).
// Did this code successfully run on Leetcode : Didn't find it on leetcode
// Any problem you faced while coding this : No

#include <iostream>
#include <vector>

using namespace std;

int maxProfit(vector<int> weights, vector<int> values, int maxCapacity) {
    vector<vector<int>> dp(weights.size()+1, vector<int>(maxCapacity+1, 0));
    for(int i = 1; i <= values.size(); i++) {
        for(int j = 1; j <= maxCapacity; j++) {
            if(weights[i] > j) {
                dp[i][j] = dp[i-1][j];
            } else {
                dp[i][j] = max(dp[i-1][j], dp[i-1][j - weights[i]] + values[i]);
            }
        }
    }
    return dp[weights.size()][maxCapacity];
}

int main()
{
    vector<int> weights = {10,20,30};
    vector<int> values = {60,100,120};
    cout << maxProfit(weights, values, 50) << endl;

    return 0;
}