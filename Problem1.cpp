//Knapsack 0-1
#include <iostream>
#include <vector>

using namespace std;

//Time Complexity : O (weights * W)
//Space Complexity : O (weights * W)

//Approach :
//            Calculate maximum possible value for each weight by including and excluding each weight
//            Return maximum value with all possible weights which follow the constraint of maximum weight
int main() {
    vector<int> weights{1  , 2 , 3};
    vector<int> values{10 , 15 , 40};
    int W = 6;
    vector<vector<int>> dp(weights.size() + 1, vector<int>(W + 1, 0));
    for(int i = 1; i < weights.size() + 1; i++)
    {
        for(int j = 0; j  < W + 1 ; j++)
        {
            if(j < weights[i - 1])
            {
                dp[i][j] = dp[i - 1][j];
            }
            else
            {
                dp[i][j] = max(dp[i-1][j] , dp[i - 1][j - weights[i - 1]] + values[i - 1]);
            }
        }
    }
    cout << dp[weights.size()][W] << endl;
}