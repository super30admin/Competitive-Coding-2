// Time Complexity : O(N*W)
// Space Complexity :O(N*W)

#include <iostream>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int knapsack(vector<int>& w, vector<int> val, int total){
    if(w.empty() || val.empty() || w.size() != val.size()){
        return 0;
    }
    vector<vector<int>> matrix(w.size()+1, vector<int> (total+1));
    /*for(int i=1; i<matrix[0].size(); i++){
        matrix[0][i] = 0;
    }
    for(int i=0; i<matrix.size(); i++){
        matrix[i][0] = 0;
    }*/
    for(int i=0; i<matrix.size(); i++){
        for(int j=0; j<matrix[0].size(); j++){
            if(i == 0 || j==0){
                matrix[i][j] = 0;
            }
            else if(j<w[i]){
                matrix[i][j] = matrix[i-1][j];
            }
            else{
                matrix[i][j] = max(matrix[i-1][j], (val[i] + matrix[i-1][j-w[i]]));
            }
        }
    }
    return matrix[matrix.size()-1][matrix[0].size()-1];
}




int main()
{
    vector<int> w = {1,3,4,5};
    vector<int> val = {1,4,5,7};
    int total = 7;
    int max = knapsack(w, val, total);
    cout<<max;

    return 0;
}
