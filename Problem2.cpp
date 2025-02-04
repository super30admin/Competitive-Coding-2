/*Create a 2D vector K to store the solutions to subproblems. K[i][w] represents the maximum value that can be obtained with the first i items and a knapsack capacity of w.
Use a nested loop to iterate over all items and knapsack capacities.
If the weight of the current item (wt[i-1]) is less than or equal to the current knapsack capacity (w), update K[i][w] by considering the maximum value between including and excluding the current item.
Return the maximum value achievable with all items and the given knapsack capacity (K[n][W]).

Time Complexity: O(n * W), where n is the number of items and W is the maximum knapsack capacity. The algorithm fills up a table of size (n + 1) x (W + 1) in a nested loop.
Space Complexity: O(n * W), as the 2D vector K is used to store solutions to subproblems.
*/
#include<bits/stdc++.h>
using namespace std; 
int max(int a, int b) { return (a > b) ? a : b; } 
  
int knapSack(int W, int wt[], int val[], int n) 
{ 
    int i, w; 
    vector<vector<int> > K(n + 1, vector<int>(W + 1)); 
  
    for (i = 0; i <= n; i++) { 
        for (w = 0; w <= W; w++) { 
            if (i == 0 || w == 0) 
                K[i][w] = 0; 
            else if (wt[i - 1] <= w) 
                K[i][w] = max(val[i - 1] 
                                  + K[i - 1][w - wt[i - 1]], 
                              K[i - 1][w]); 
            else
                K[i][w] = K[i - 1][w]; 
        } 
    } 
    return K[n][W]; 
}