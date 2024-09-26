//Time Complexity: O(n*m), where n is number of rows and m is number of columns.
//Space Complexity: O(n*m) , where n is number of rows and m is number of columns.

int knapSack(int k, int W[], int val[], int size){
    int dp[size+1][k+1];

    for(int i=0; i<= size; i++){
        for(int j=0; j<=k; j++){
            if(i==0 || j==0){
                dp[i][j] = 0;
            }
            else if(W[i-1]<=j){
                dp[i][j] = std::max(val[i-1]+dp[i-1][j-W[i-1]], dp[i-1][j]);
            }
            else{
                dp[i][j] = dp[i-1][j];
            }
        }
    }
    return dp[size][k];
}