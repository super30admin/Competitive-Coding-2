// Time Complexity : O(n^2)
// Space Complexity : O(1) no extra space used dp array isn't counted
// Any problem you faced while coding this : No

#include<iostream>
#include<algorithm>

using namespace std;

class Knapsack{
    public:

    int knapSack(int W, int wt[], int val[], int n) {

        int dp[n + 1][W + 1];

        // Greedy
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= W; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (wt[i - 1] <= j){
                    dp[i][j] = std::max(val[i-1] + dp[i-1][j - wt[i - 1]], dp[i-1][j]);
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][W];
    }

};
    int main()
    {
        Knapsack k1;
        int val[] = { 10, 20, 30 };
        int wt[] = { 50, 60, 70 };
        int W = 100;
        int n = sizeof(val)/sizeof(val[0]);
        cout<<"\n\t"<<k1.knapSack(W, wt, val, n);
        return 0;
    }