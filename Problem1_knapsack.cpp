/*
time Complexity -> O(N*k)where N is the size of wt array and k is the value of w
space complexity -> O(N*k)where N is the size of wt array and k is the value of w

*/



#include <iostream>
#include<vector>

using namespace std;


int knapsack(vector<int>wt,vector<int>val,int w){
  int rows = wt.size()+1;
  int cols = w+1;
  int t[rows][cols];
  for(int i = 0; i < cols;i++)t[0][i]=0;
  for(int i = 0; i < rows;i++)t[i][0]=0;

  for(int i = 1; i < rows;i++){
    for(int j = 1; j < cols;j++){
      if(wt[i-1] <= j)t[i][j] = max(val[i-1]+t[i-1][j-wt[i-1]],t[i-1][j]);
      else t[i][j] = t[i-1][j];
    }
  }
  return t[rows-1][cols-1];
}

int main() {
  vector<int>wt = {1,3,4,5};
  vector<int>val = {1,4,5,7};
  int w = 7;
  cout << knapsack(wt,val,w);


}