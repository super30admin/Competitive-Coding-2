//Time complexity: O(n*w)= O(n) as weights is constant
//Space complexity:O(n)


import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		//System.out.println("GfG!");
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int weights[]=new int[n];
		for(int i=0;i<n;i++)
		{
		    weights[i]=scan.nextInt();
		}
		int values[]=new int[n];
		for(int i=0;i<n;i++)
		{
		    values[i]=scan.nextInt();
		}
		int weight=scan.nextInt();
		int[][]dp=new int[weights.length+1][weight+1];
		for(int j=0;j<dp[0].length;j++)
		{
		    dp[0][j]=0;
		}
	
		int x=0; int t=0;
		for(int i=1;i<dp.length;i++)
		{
		    x+= weights[i-1];
		    for(int j=0;j<dp[0].length;j++)
		    {
		        if(j>=weights[i-1] && j<=x)
		        {
		            
		            dp[i][j]= Math.max(dp[i-1][j], values[i-1]+dp[i-1][j-weights[i-1]]);
		            t=dp[i][j];
		        }
		        else if(j<weights[i-1]){
		            dp[i][j]=dp[i-1][j];
		        }
		        else if(j>weights[i-1] && j>x){
		            dp[i][j]=t;
		        }
		        
		    }
		}
		System.out.println(dp[dp.length-1][(dp[0].length)-1]);
	}

	
}
