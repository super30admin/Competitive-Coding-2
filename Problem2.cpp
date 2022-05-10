//TC = O(MN) where M = weights array size +1 , N = capacity +1
//SC = O(MN)

//Note: If the problem was changed to - unlimited weights then its similar to coin change and else condition would be:
// dp[i][j] = std::max(dp[i-1][j], (dp[i][j-weights[i-1]] + profits[i-1]));

#include <iostream>
#include<vector>

int knapSack(std::vector<int> weights,std::vector<int> profits, int capacity){
    int m = weights.size()+1;
    int n = capacity+1;
    std::vector<std::vector<int>> dp(m, std::vector<int>(n));

  std::cout<<dp.size()<<" "<<dp[0].size()<<std::endl;

  //Ignoring 1st row and 1st col since it will be 0
    for(int i=1;i<m;i++){
      for(int j=1;j<n;j++){
          if(j<weights[i-1]){
            dp[i][j] = dp[i-1][j];
          }else{
            dp[i][j] = std::max(dp[i-1][j], dp[i-1][j-weights[i-1]] + profits[i-1]);
            
          }
      }
    }
  return dp[dp.size()-1][dp[0].size()-1];
}
// Driver code
int main()
{

    // std::vector<int> profits = { 5, 3, 2 };
    // std::vector<int> weights= { 2, 4, 6 };
    // int capacity = 8; //ans = 8 //works
    std::vector<int> profits = { 60, 100, 120 };
    std::vector<int> weights= { 10, 20, 30  };
    int capacity = 50; //ans = 220 //Works 
    std::cout << knapSack(weights, profits, capacity);
    return 0;
}

    
