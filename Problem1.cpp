// Time Complexity : O(N*M) n is #of weights and M is weight given
// Space Complexity : O(N*M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Got error when used INT_MIN 


// Your code here along with comments explaining your approach:
// 1. Create matrix to check maximum if weight considered or not. 
// 2. find max between value gained if considered and not considered.
// 3. As we check for each weight [0-W] answer is last element of matrix

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    int knapsack(int W, vector<int> &val, vector<int> &wt) {
        // code here
        int n=wt.size();
        int dp[n+1][W+1];
        for(int i=0;i<=W;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=0;j<=(W);j++){
                if(j==0){dp[i][j]=0;continue;}
                int a=dp[i-1][j],b=INT_MIN;
                if(j>=wt[i-1]){
                    b=(dp[i-1][j-wt[i-1]] + (val[i-1]));
                }
                //cout<<a<<' '<<b<<'\n';
                if(a>b){
                    dp[i][j]=a;
                }else{
                    dp[i][j]=b;
                }
                //cout<<dp[i][j]<<' ';
            }    
            //cout<<'\n';
        }
        
        return dp[n][W];
    }
};


//{ Driver Code Starts.

int main() {
    // Taking total test cases
    int testCases;
    cin >> testCases;
    cin.ignore();
    while (testCases--) {
        // Reading number of items and capacity
        int numberOfItems, capacity;
        vector<int> weights, values;
        string input;
        int number;

        // Read capacity and number of items
        getline(cin, input);
        stringstream ss(input);
        ss >> capacity;      // The first number is the capacity
        ss >> numberOfItems; // The second number is the number of items

        // Read values
        getline(cin, input);
        ss.clear();
        ss.str(input);
        while (ss >> number) {
            values.push_back(number);
        }

        // Read weights
        getline(cin, input);
        ss.clear();
        ss.str(input);
        while (ss >> number) {
            weights.push_back(number);
        }

        Solution solution;
        cout << solution.knapsack(capacity, values, weights) << endl;
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends