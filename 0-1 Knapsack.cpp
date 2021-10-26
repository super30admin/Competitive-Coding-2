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


//Time Complexity = O(M*N)
//Space Complexity = O(M*N)
//Where M is the capacity of knapsack provided and N is the size of the vector weight.
#include<bits/stdc++.h>
using namespace std;

int main()
{
    //vector<int> v{1,2,6},w{2,3,5};
    vector<int> v{60,100,120}, w{10,20,30};
    int i,j;
    //int c=8;
    int c = 50;
    int row = w.size();
    int col = c;
    int dp[row+1][col+1];
    for(i=0;i<=row;i++)
        dp[i][0] = 0;
    for(j=0;j<=col;j++)
        dp[0][j] = 0;
    
    for(i=1;i<=row;i++)
    {
        for(j=1;j<=col;j++)
        {
            if(j<w[i-1])
                dp[i][j] = dp[i-1][j];
            else
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-w[i-1]]+v[i-1]);       //In dp[i-1][j-w[i-1]]+v[i-1] we are taking i-1 beacause we are not allowed to repeat the weight in the 0/1 knapsack.
        }
    }
    cout<<dp[1][2]<<endl;
    for(i=1;i<=row;i++)
    {
        for(j=1;j<=col;j++)
            cout<<dp[i][j]<<" ";
        cout<<endl;
    }
    cout<<dp[row][col]<<endl;
    return 0;
}


