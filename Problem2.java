import java.util.*;
import java.lang.*;
import java.io.*;

/*
Time COmplexity -> O(n*w)
Space Complexity -< O(n*w)
*/
// The main method must be in a class named "Main".
class Main {

    public static int getProfit(int[] wt, int[] value, int w)  {
    if(wt == null || wt.length == 0) {
     return 0;
    }
int n = wt.length;
int[][] dp = new int[n+1][w+1];
for(int i = 1 ; i< n+1; i++) {
    for (int j =1; j< w+1; j++) {
        if(j < wt[i-1]) {
            dp[i][j] = dp[i-1][j];
        }else {
            dp[i][j] = Math.max(dp[i-1][j], value[i-1] + dp[i-1][j- wt[i-1]]);
}
    }
}
return dp[n][w];
}
    public static void main(String[] args) {

        int[] wt = {10,20,30};
        int[] value = {120,100,60};
        int W= 50;
         int profit = getProfit(wt, value, W);
        System.out.println(profit);
    }
}