//Time complexity : O(#rows * #columns) - #rows = weights.size()+1; #columns = capacity+1
// Space Complexity : O(#rows * #columns)
// Did this code successfully run on Leetcode : Not available on Leetcode
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
/*
    1. Whenever cumulative weight is less than the current column, then max. profit at
    the cell (i,j) is equal to the max. profit on it's left cell(i,j-1).
    2. Whenever current weight is greater than the current column, then max. profit at
    the cell (i,j) is equal to the max. profit on it's upper cell(i-1,j).
 */

#include<iostream>
#include<vector>

using namespace std;
int main() {
    vector<int> weights;
    weights = {1, 2, 3};
    vector<int> profits;
    profits = {6, 10, 12};
    int capacity = 5;
    // # rows = weights.size()+1. here 1 represents zero weight.
    // range of columns - from 0 to capacity
    vector<vector<int>> dp(weights.size()+1, vector<int>(capacity+1, 0));
    int cumWeights = 0; // cumulative weights
    for(int i = 1; i < weights.size()+1; i++){
        cumWeights += weights[i-1];
        cout << "cumWeights: " <<cumWeights << endl;
        for(int j = 1; j < capacity+1; j++) {
            if(cumWeights < j){
                dp[i][j] = dp[i][j-1];
            }
            else if(weights[i-1] > j){
                dp[i][j] = dp[i-1][j];
            }
            else{
                dp[i][j] = max(dp[i-1][j], (profits[i-1] + dp[i][j-weights[i-1]]));
            }
        
            cout << "i = " << i << " j = " << j << " " <<dp[i][j] << endl;
        }
    }
    cout << "Maximum Profit: " << dp[weights.size()][capacity] << endl;
    return 0;
}
