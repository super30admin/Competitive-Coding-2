// time : 0(c*n) where c is capacity and n is number of weights or values
//space :0(n*c)

#include <iostream>
#include<vector>
using namespace std;

int knapSack(int C, int wt[], int val[], int n) {
	
	vector<vector<int>>dp(n+1,vector<int>(C+1));
	
	
	for(int  i =0;i<=C;i++) {
		dp[0][i] = 0;
	}
	
	//
	for(int  i = 1;i<=n;i++){
		for(int j=1;j<=C;j++) {
			
			if( j < wt[i-1]) {
				dp[i][j] = dp[i-1][j];
			} else {
				dp[i][j] = max(val[i-1] + dp[i-1][j-wt[i-1]],dp[i-1][j]);
			}
		}
	}
	
	return dp[n][C];
	
}

int main() {
	// your code goes here
	
	int val[] = { 60, 100, 120 };
    int wt[] = { 10, 20, 30 };
    int C = 50;
    int n = sizeof(val) / sizeof(val[0]);
      
    cout << knapSack(C, wt, val, n);
	
	return 0;
}