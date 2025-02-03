import java.util.*;
public class Knapsack
{
    
    public static int helper(int p[], int w[], int cap, int idx,int[][] dp){
        if(cap<=0 || idx==p.length)
        return 0;
        
        if(dp[idx][cap]!=-1)
        return dp[idx][cap];
        
        int take = Integer.MIN_VALUE;
        int not_take = helper(p,w,cap,idx+1,dp);
        if(w[idx] <=cap)
        take = p[idx]+helper(p,w,cap-w[idx],idx+1,dp);
        
        return dp[idx][cap]=Math.max(take,not_take);
        
    }
	public static void main(String[] args) {
		 int profit[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n= profit.length;
       int dp[][] = new int[n+1][W+1];
       for (int i = 0; i < n; i++) {
    Arrays.fill(dp[i], -1);
}
        System.out.println(helper(profit,weight,W,0,dp));
        
       
	}
}

//tc: O(N x W) where N is the length of the given array(s) and W is the maximum capacity given
//sc: O(N x W) where N is the length of the given array(s) and W is the maximum capacity given