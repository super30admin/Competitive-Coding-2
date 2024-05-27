// Knapsack Problem
// You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. 
// Note that we have only one quantity of each item.
// In other words, given two integer arrays val[0..N - 1] and wt[0..N - 1] which represent valuesand weights associated with N items respectively.
// Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
// You cannot break an item, either pick the complete item or dont pick it(0 - 1 property).

// Time Complexity : O(n*m), where n is the size of the weights, and m is the value of the maximum weight of the knapsack W
// Space Complexity : O(n*m)

#include <iostream>
#include <vector>
#include <algorithm>
class Solution {
public:
    static int knapSack(int W, int wt[], int val[], int n) {
        // Create a 2D array to store the maximum value that can be obtained
        std::vector<std::vector<int>> dp(n + 1, std::vector<int>(W + 1, 0));

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= W; ++j) {
                if (wt[i - 1] > j) {
                    // If weight is greater than the allowed weight, keep the above value
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = std::max(dp[i - 1][j - wt[i - 1]] + val[i - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][W];
    }
};

int main() {
    // Example usage
    Solution solution;

    // Example 1
    int W1 = 15;
    int val1[] = { 10, 4, 7, 2, 12, 8, 3 };
    int wt1[] = { 5, 3, 4, 2, 8, 6, 1 };
    int n1 = sizeof(val1) / sizeof(val1[0]);

    std::cout << "Example 1 - Maximum value: " << solution.knapSack(W1, wt1, val1, n1) << std::endl;

    // Example 2
    int W2 = 20;
    int val2[] = { 3, 4, 5, 8, 10, 7, 9, 6, 5, 4 };
    int wt2[] = { 2, 3, 4, 5, 9, 7, 8, 6, 4, 3 };
    int n2 = sizeof(val2) / sizeof(val2[0]);

    std::cout << "Example 2 - Maximum value: " << solution.knapSack(W2, wt2, val2, n2) << std::endl;

    // Example 3
    int W3 = 30;
    int val3[] = { 6, 9, 7, 8, 5, 4, 10, 3, 8, 7, 9, 5 };
    int wt3[] = { 4, 2, 7, 8, 3, 5, 6, 2, 4, 7, 9, 8 };
    int n3 = sizeof(val3) / sizeof(val3[0]);

    std::cout << "Example 3 - Maximum value: " << solution.knapSack(W3, wt3, val3, n3) << std::endl;

    // Example 4
    int W4 = 25;
    int val4[] = { 15, 10, 9, 5, 12, 8, 6, 7 };
    int wt4[] = { 7, 4, 3, 2, 6, 5, 4, 3 };
    int n4 = sizeof(val4) / sizeof(val4[0]);

    std::cout << "Example 4 - Maximum value: " << solution.knapSack(W4, wt4, val4, n4) << std::endl;

    return 0;
}