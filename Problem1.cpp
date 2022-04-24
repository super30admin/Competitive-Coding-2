// Time Complexity                              :  O(n)
// Space Complexity                             :  O(1)
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

// Knapsack problem

// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution
{
    public:
    //Function to return max value that can be put in knapsack of capacity W.
    int knapSack(int W, int wt[], int val[], int n) 
    { 
        if(n == 0) return 0;
        int **dp;
        dp = new int*[n+1];
        for(int i=0;i<=n;i++) {
            dp[i] = new int[W+1];
        }
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
                dp[i][j] = 0;
            }
        }
        // vector<vector<int,int>> dp(n+1,vector<int>(W+1,0));

        for(int i=1;i<=n;i++){
            for(int j=1;j<=W;j++) {
                if(j - wt[i - 1] >=0)
                    dp[i][j] = max(dp[i-1][j], dp[i-1][j - wt[i - 1]]+ val[i-1]);
                else 
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][W];
    }
};

// { Driver Code Starts.

int main()
 {
    //taking total testcases
    int t;
    cin>>t;
    while(t--)
    {
        //reading number of elements and weight
        int n, w;
        cin>>n>>w;
        
        int val[n];
        int wt[n];
        
        //inserting the values
        for(int i=0;i<n;i++)
            cin>>val[i];
        
        //inserting the weights
        for(int i=0;i<n;i++)
            cin>>wt[i];
        Solution ob;
        //calling method knapSack()
        cout<<ob.knapSack(w, wt, val, n)<<endl;
        
    }
	return 0;
}  // } Driver Code Ends