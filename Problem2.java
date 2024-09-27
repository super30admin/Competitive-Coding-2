// 0-1 Knapsack Problem | DP-10 -  https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
// Time Complexity - O(MN)
// Space Complexity - O(MN) // No auxilary space used

//import java.io.*;

class Solution {
	
	static int ks(int c, int[] wt, int[] val, int n)
	{
        // data structure
        int[][] dp = new int[wt.length][val.length];
	    // base
	    if(n==0 || c==0) return 0;
	    // fill dp[][] first row with zero's
        for(int i=0;i<wt.length;i++){ dp[i][0]=0;}
	    // logic

	    for(int i=0;i<val.length;i++)
        {
            for(int j=0;j<wt.length;j++)
            {
                // w>c
                if(wt[n-1]>c) return ks(c,wt,val,n-1);
                // w<=c
                else
                {
                int case1 = val[n-1]+ks(c-wt[n-1],wt,val,n-1);
                int case2 = ks(c,wt,val,n-1);
                dp[i][j] = max(case1,case2);
                }
            }
        }
        return dp[wt.length-1][val.length-1];
	}
	
    // max value calculation
	static int max(int a, int b) {return (a>b)? a:b;}

	public static void main (String[] args) {
		int val[] = {60,100,120};
		int wt[] =  {10,20,30};
		int c = 50;
		int n = val.length;
		System.out.println(ks(c,wt,val,n));
	}
}