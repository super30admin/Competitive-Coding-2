// here the time complexity is O(m*n) and space of O(m*n)
//here we are at each point checking whether we need to take this weight or not if not taken then we need to take what is calcuated till now else we take that particular
// weight and add its value with what is the value of the weight left after taking that coin and then taking the max from both
// this code works well

import java.util.*;
import java.lang.*;
import java.io.*;

class knapsack
{

    static int knap_Sack(int W,int w[],int val[],int n)
    {
        int [][] dp= new int [n+1][W+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j< W+1;j++)
            {
                if(i==0 || j==0)
                {
                    dp[i][j]=0;
                }
                else if(w[i-1]>j)
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                dp[i][j]=Math.max(val[i-1]+dp[i-1][j-w[i-1]],dp[i-1][j]);
            }
        }
        return dp[n][W];
    }


	public static void main (String[] args) {
	    int val[]=new int[] {2,1,10};
	    int w[] =new int[] {1,2,3};
	    int W=4;
	    int n=val.length;
	    System.out.println(knap_Sack(W,w,val,n));
	}
}
