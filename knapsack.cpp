// Time Complexity : O(m*n)
// Space Complexity :  O(m*n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this - Had some confusion with the implementation. Took reference from Geeks for Geeks link.

#include<iostream>
#include<math.h>

using namespace std;

int knap_sack(int W, int wt[], int val[], int n)
{
    int i, w;
    int K[n+1][W+1];

    for(i = 0; i <= n; i++)
    {
    for(w = 0; w <= W; w++)
    {
        if(i == 0 || w == 0)
        {
            K[i][w] = 0;
        }
        else if(wt[i-1] <= w)
        {
            K[i][w] = max(val[i-1] + K[i-1][w - wt[i-1]], K[i-1][w]);
        }

    }
    }

    return K[n][W];
}

int main()
{
    int val[] = {60,100,120};
    int wt[] = {10,20,30};
    int W = 50;

    int n = 3;

    cout << knap_sack(W, wt, val, n) << endl;

    return 0;
}