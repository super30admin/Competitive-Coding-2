//
// Created by shazmaan on 7/15/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Solution{
public:
    int prob(vector<int>& val, vector<int>& wt, int weight){
        int arr[val.size()][weight+1];
        for(int x= 0; x<val.size(); x++){
            arr[x][0] = 0;
        }
        for(int x = 1; x<=weight;x++){
            arr[0][x]=val[0];
        }
        for(int i = 1; i<val.size();i++){
            for(int j = 1; j<=weight; j++){
                if(j<wt[i]){
                    arr[i][j] = arr[i-1][j];
                }else{
                    arr[i][j] = max(val[i]+arr[i-1][j-wt[i]],arr[i-1][j]);
                }
            }
        }
        return arr[val.size()-1][weight];
    }
};

int main(){
    Solution s;
    vector<int> val{60,100,120};
    vector<int> wt{10,20,30};
    cout<<s.prob(val,wt,50);
}