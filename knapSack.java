// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on terminal : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
import java.io.*;
import java.lang.*;
class GFG {
    public static int KnapSack(int[] wt, int[] val, int W){
        if(wt == null || val == null || wt.length == 0 || val.length == 0|| W == 0){
            return 0;
        }
        
        int[][] dp = new int[wt.length+1][W+1];
        
        for(int i=0; i<=wt.length; i++){
            
            for(int j=0; j<=W; j++){
            
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }else if(j < wt[i-1]){
                    dp[i][j] = dp[i-1][j];  
                } 
                else {
                    int temp1 = val[i-1]+ dp[i-1][j-wt[i-1]];
                    int temp2= dp[i-1][j];
                    
                    dp[i][j] = Math.max(temp1, temp2);
                }
                
            }
        }
        return dp[wt.length][W];
    }
    
	public static void main (String[] args) {
		// int[] wt = {1,3,4,5};
		// int[] val = {1,4,5,7};
        // int W = 7;
        int[] wt = {10, 20, 30};
        int[] val = {60, 100, 120};
        int W = 50;
		
		int output = KnapSack(wt,val, W);
		System.out.println("The maximum value is : "+output);
	}
}