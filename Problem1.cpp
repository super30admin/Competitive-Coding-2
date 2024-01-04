// complexity:
// time and space : O(W*n)

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution
{
public:
    // Function to return max value that can be put in knapsack of capacity W.
    int knapSack(int W, int wt[], int val[], int n)
    {
        // Your code here
        vector<pair<int, int>> items;

        for (int index = 0; index < n; index++)
        {
            items.push_back({wt[index], val[index]});
        }

        sort(items.begin(), items.end());

        vector<vector<int>> dp(n + 1, vector<int>(W + 1, 0));

        for (int index = 1; index <= n; index++)
        {
            for (int weight = 0; weight <= W; weight++)
            {

                int itemWeight = items[index - 1].first;

                if (weight < itemWeight)
                    dp[index][weight] = max(dp[index - 1][weight], dp[index][weight]);

                else
                    dp[index][weight] = max(dp[index - 1][weight],
                                            items[index - 1].second + dp[index - 1][weight - itemWeight]);
            }
        }

        return dp[n][W];
    }
};

//{ Driver Code Starts.

int main()
{
    // taking total testcases
    int t;
    cin >> t;
    while (t--)
    {
        // reading number of elements and weight
        int n, w;
        cin >> n >> w;

        int val[n];
        int wt[n];

        // inserting the values
        for (int i = 0; i < n; i++)
            cin >> val[i];

        // inserting the weights
        for (int i = 0; i < n; i++)
            cin >> wt[i];
        Solution ob;
        // calling method knapSack()
        cout << ob.knapSack(w, wt, val, n) << endl;
    }
    return 0;
}
// } Driver Code Ends