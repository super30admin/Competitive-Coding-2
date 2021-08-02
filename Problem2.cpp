//Time Complexity = Exponential
//Space Complexity = O(N)
//Where N is the size of the vector weight.

#include<bits/stdc++.h>
using namespace std;

int helper(vector<int> v,vector <int> w, int index, int profit, int c)
{
    if(index==w.size())
        return profit;
    if(c-w[index]<0)
        return profit;
    return max(helper(v,w,index+1,profit,c),helper(v,w,index+1,profit+v[index],c-w[index]));
}
int main()
{
    //vector<int> v{1,2,6},w{2,3,5};
    vector<int> v{60,100,120}, w{10,20,30};

    //int c=8;
    int c = 50;
    cout<<helper(v,w,0,0,c)<<endl;
    return 0;
}
