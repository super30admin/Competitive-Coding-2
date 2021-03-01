//TC: O(n*w) where n is number of items, and w is the knapsack size
//SC: O(n*w)

#include <iostream>

using namespace std;


int maxval(int a, int b){
  if(a >= b) 
   return a;  
  else return b;

}


int ks(int W, int wt[], int val[]){

  int n = 3;

  int dp[n+1][W+1];

  for(int i=0; i<n+1; i++){

    for(int j=0; j<W+1; j++){

      if(i==0 || j==0)
        dp[i][j] = 0;
      
      else if(j>=wt[i-1]){
        dp[i][j] = maxval(val[i-1] + dp[i-1][j - wt[i-1]], dp[i-1][j]);
      } 
      
      else{
        dp[i][j] = dp[i-1][j];
      }

    }
  }

  return dp[n][W];
}


int main() {
  
  int wt[]={10, 20, 30};
  int val[] ={60, 200, 120};
  int W = 5;

  int maxval = 0;

  maxval = ks(W, wt, val);
  cout<<"maxval:"<<maxval;

  return 0;
}