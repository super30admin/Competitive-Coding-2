// https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
// We use top-down recursion with memoization to explore all combinations of including or excluding each item.
// A 2D memo[i][w] table caches the best value for item index i and remaining capacity w.
// This avoids redundant subproblems and ensures optimal substructure is used efficiently.


// TC O(n * W)
// SC O(n * W)


class Solution {
  public:
  
  vector<vector<int>> memo;
    int helper(int w, vector<int> &val, vector<int> &wt, int i ){
        
        if(i >= val.size()) return 0;
        if(w == 0) return 0;
        if(memo[i][w] != -1) return memo[i][w];
        
        int case1 = 0;
        if(w-wt[i] >= 0) 
            case1 = helper(w-wt[i],val,wt,i+1)+val[i];
        int case2 = helper(w,val,wt,i+1);
    
        memo[i][w] = max(case1,case2);
        
        return memo[i][w];
        
    }
    int knapsack(int W, vector<int> &val, vector<int> &wt) {
        // code here
        memo = vector<vector<int>>(val.size(),vector<int>(W+1,-1));
        return helper(W,val,wt,0);
    }
};
