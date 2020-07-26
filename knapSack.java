// Time Complexity : O(n*m) - where n is the number of weights/values and m is the capacity of the knapsack.
// Space Complexity : O(n*m) - where n is the number of weights/values and m is the capacity of the knapsack.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, I was initially confused with the weights and the values and the fact that a weight cannot be used more than once.
// Approach: 1. create a dp array with rows as the weights and colums as the number based on the capacity of the knapsack.
            //2. At every point if the capacity is lesse than the weight import the value from above.
            //3.If greater than or equal to the weight, return the max of the value from the above and the value from the above row dp[i-1][j-wt[i-1]] and add it to the value of this weight.
            //4. Finally, we return the last element of the dp matrix.




import java.util.*;
import java.lang.*;
import java.io.*;

public class GFG {
    static int c;
    public static void knapSack(int W,int wt[],int val[]){
        if(val==null || wt==null || val.length==0 || wt.length==0 ) return;
        int[][] dp=new int[wt.length+1][W+1];
        
        for(int i=0;i<W+1;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<wt.length+1;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<wt.length+1;i++){
            for(int j=1;j<W+1;j++){
                //case 1
                if(j<wt[i-1]){
                    dp[i][j]=dp[i-1][j]; 
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-wt[i-1]]+val[i-1]);
                }
                   
            }
        }
        
        c=dp[val.length][W];
    
    }
	public static void main (String[] args) {
		int val[] = new int[] { 60, 100, 120 }; 
        int wt[] = new int[] { 10, 20, 30 }; 
        int W = 50; 
        int n = val.length; 
        return knapSack(W, wt, val); 
		System.out.println(c);
	}
}