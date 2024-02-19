//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends

/*
Time Complexity: O(n*w)
Space Complexity: O(n*w)

In each index i, we have two options:
1. Pick the item with value[i] and so the capacity decreases by w[i]
2. Don't pick the item and the capacity stays the same
*/

class Solution
{   
public:
    
    vector< vector<int> > dp;
    
    int call(int w, int pos, int wt[], int val[]){
        if(w<0)  return -1e9;
        if(pos<0)  return 0;
        
        int &mem = dp[w][pos];
        if(mem!=-1)  return mem;
        
        int op1 = call(w,pos-1,wt,val);
        int op2 = val[pos] + call(w-wt[pos],pos-1,wt,val);
        
        return mem = max(op1,op2);
    }
    //Function to return max value that can be put in knapsack of capacity W.
    int knapSack(int w, int wt[], int val[], int n) 
    { 
       dp = vector< vector<int> >(w+1,vector<int>(n,-1));
       return call(w,n-1,wt,val);
    }
};

//{ Driver Code Starts.

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
}
// } Driver Code Ends
