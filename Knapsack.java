// Time Complexity : O(n*c) where n is length of the weights array and c is the capacity
// Space Complexity : O(n*c) creating a 2d array of n*c
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this : No

//Approach: Followed the bottom-up approach. creating a dp 2d array. 
import java.util.*;
public class Knapsack {
    static int knapSack(int[] w, int[] values, int c, int n){
       int dp[][] = new int[n+1][c+1];
       for(int i=0;i<=n;i++){
          for(int j=0;j<=c;j++){ 
             if(i==0 || j==0){
                 dp[i][j] = 0;
             }
             else if(w[i-1]<=j){
                 dp[i][j] = Math.max(values[i-1]+dp[i-1][j-w[i-1]], dp[i-1][j]);
                }
             else{
                 dp[i][j] = dp[i-1][j];
            }
          }
       }
       return dp[n][c];
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length");
        int n = sc.nextInt();
        int w[] = new int[n];
        int values[] = new int[n];
         System.out.println("Enter weights");
        for(int i=0;i<n;i++){
            w[i] = sc.nextInt();
        }
         System.out.println("Enter values");
        for(int i=0;i<n;i++){
            values[i] = sc.nextInt();
        }
         System.out.println("Enter capacity");
        int c = sc.nextInt();
        System.out.println(knapSack(w,values,c,n));
    }
}
