/*********** Intution is it is same like coin change problem instead if minum coins we need to fill the max value for eacj choose of weights*****/
 class Solution {
public:
     int knapsack(int W, vector<int>& wt, vector<int>& val) // GIVEN MAX CAPACITY :W and weights available :Wt and the value associated with it :Val 
     {
        int m = wt.size();
        
        vector<vector<int>>dp(m+1,vector<int>((W+1),0));
        for(int i=1;i<m+1;i++)
        {
            for(int j =1;j<W+1;j++)
            {
                if(j<wt[i-1])
                dp[i][j]=dp[i-1][j];
                else
                dp[i][j]=max(dp[i-1][j],dp[i-1][j-wt[i-1]]+val[i-1]);
            }
        }
        return dp[m][W];

     }
/*********space optimized ********/
class Solution {
public:
    int knapsack(int W, vector<int>& wt, vector<int>& val) {
        int n = wt.size();
        vector<int> dp(W + 1, 0); 

        for (int i = 0; i < n; i++) {
            for (int j = W; j >= wt[i]; j--) {  
                dp[j] = max(dp[j], dp[j - wt[i]] + val[i]);
            }
        }

        return dp[W];
    }
};