//Time Complexity - o(N*W)
//Space Complexity - O(N*W)

#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends

class Solution
{
    public:
    //Function to return max value that can be put in knapsack of capacity W.
    int dp[1001][1001];
    int helper(int W, int wt[], int val[], int n){
        if(W==0||n==0){
           return 0;
       }
       if(dp[n][W]!=-1){
           return dp[n][W];
       }
       if(wt[n-1]<=W){
           dp[n][W]=max((val[n-1]+helper(W-wt[n-1],wt,val,n-1)),helper(W,wt,val,n-1));
           return dp[n][W];    
       }
       dp[n][W]=helper(W,wt,val,n-1);
       return dp[n][W];
    }
    int knapSack(int W, int wt[], int val[], int n) 
    { 
       // Your code here
       for(int i=0;i<n+1;i++){
           for(int j=0;j<W+1;j++){
               dp[i][j]=-1;
           }
       }
       return helper(W,wt,val,n);
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