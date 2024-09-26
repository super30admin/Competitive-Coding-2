/*
Time Complexity: O(n)
Space Complexity: O(n)
*/
#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int dp[1000][1000];
int maxv(std::vector<int> weight, std::vector<int> value, int maxcap, int index)
{
    //base
    if(maxcap<=0 || index==weight.size()){
        return 0;
    }
    //r
    if(dp[maxcap][index]==0){
    if(weight[index]<=maxcap){
    int sel = value[index] + maxv(weight, value, maxcap-weight[index],index+1);
    int notsel = maxv(weight, value, maxcap, index+1);
    dp[maxcap][index] = max(sel,notsel);
    }
    }
    return dp[maxcap][index];
    
}
int maxval(std::vector<int> weight, std::vector<int> value, int maxcap){
    int ans= maxv(weight, value, maxcap, 0);
    return ans;
}
int main(){
    int mv = 40;
    std::vector<int> w = {20,20,30};
    std::vector<int> v = {30,40,40};
    int aa= maxval(w,v,mv);
    cout<<aa;
    return aa;
}