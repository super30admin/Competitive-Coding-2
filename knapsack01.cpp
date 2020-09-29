//Time complexity:  O(Weight*number of items)
//space complexity: O(Weight*number of items)
#include<iostream>
using namespace std;

//long long int max(long long int a, long long int b) {(a > b)? return a : return b; } 
int knapsack(int n,int maxi,int wt[],int value[])
{
long long int k[n+1][maxi+1];
long long int i,w;
for(i=0;i<=n;i++)
{
    for(w=0;w<=maxi;w++)
    {
        if(i==0||w==0)
        {
        k[i][w]=0;}
        else if(wt[i-1]<=w){
        k[i][w]=max(value[i-1]+k[i-1][w-wt[i-1]],k[i-1][w]);}
        else{
        k[i][w]=k[i-1][w];}
    }
}

return k[n][maxi];
}

int main() {
	int test,n,maxi;
	cin>>test;
	for(int i=0;i<test;i++)
	{
	    cin>>n>>maxi;
	    int wt[n],value[n];
	    for(int j=0;j<n;j++)
	    {
	        cin>>value[j];
	    }
	     for(int k=0;k<n;k++)
	    {
	        cin>>wt[k];
	    }
	    cout<<knapsack(n,maxi,wt,value)<<endl;
	}
}