int knapSack(int W, vector<int> wt, vector<int> val)
{

    // TC - O(W*wt.size())
    // SC - O(W*wt.size())
    int i, w;
    int n = wt.size();
    vector<vector<int>> result(n + 1, vector<int>(W + 1));
 
      for (w = 1; w <= W; w++) {
                result[0][w] = 0;
      }
    
    for (i = 0; i <= n; i++) {
        for (w = 0; w <= W; w++) {
            if ( w-wt[i - 1] >=0){
                result[i][w] = max(val[i - 1]  + result[i - 1][w - wt[i - 1]], result[i - 1][w]);
            }
            else  result[i][w] = result[i - 1][w];
        }
    }
    return result[n][W];
}