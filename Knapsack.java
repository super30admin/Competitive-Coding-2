// 0-1 Knapsack Problem

// Problem Statement: we are given weights and values of n items. 
// we need to put these items in a knapsack of capacity W to get maximum value in our knapsack.
// or we can say that we are given two integers arrays val[0......n-1] and wt[0.....n-1] which 
// represent values and weights associated with n items respectively. 
// we are also given an integer W  which represents knapsack capacity.
// find out the maximum value subset of val[] such that sum of the weights of this subset 
// is smaller than or equal to W. but you cannot break an item, 
// either pick the complete item or dont pick it(known as 0-1 property).


// Brute force Solution
// Time Complexity - O(2^n) 
// Space Complexity: O(1)
class Knapsack {
    public int knapSack(int W, int wt[], int val[], int n) {
        if(n==0 || W==0) return 0;
        // If weight of nth item is more than capacity, then we cant include that item
        if(wt[n-1] > W) {
            return knapSack(W, wt, val, n-1);
        }
        else {
            // nth item included
            int case1 = val[n-1]+knapSack(W-wt[n-1], wt, val, n-1);
            // not included
            int case2 = knapSack(W, wt, val, n-1);
            return Math.max(case1,case2);
        }
    }
}

// DP Solution

// Time Complexity - O(n*W) n=number of weight elements W =  capacity
// Space Complexity - O(n*W)

class Knapsack {
    public int knapSack(int W, int wt[], int val[], int n) {
        int dp[][] = new int[n+1][W+1];
        for(int i=0;i<=n;i++) {
            for(j=0;j<=W;j++) {
                if(i==0 || j==0) dp[i][j]=0;
                else if(wt[i-1] > w) { // greater than capacity
                    dp[i][j] = dp[i-1][w];
                }
                // if we do not fill ‘ith’ weight in ‘jth’ column then DP[i][j] state will 
                // be same as DP[i-1][j] but if we fill the weight, DP[i][j] will be equal 
                // to the value of ‘wi’+ value of the column weighing ‘j-wi’ in the previous row.
                else {
                    dp[i][j] = Math.max(dp[i-1][j],val[i-1]+dp[i-1][j-wt[i-1]]);
                }
            }
        }
        return dp[n][W];
    }
}