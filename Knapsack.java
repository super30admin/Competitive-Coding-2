// Time Complexity : O(n*m) - n=number of elements and m is max capacity
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// "static void main" must be defined in a public class.
public class Knapsack {
    public static void main(String[] args) {
        int[] weights = {1,2,3};
        int[] val = {10,15,40};
        int maxCapacity = 6;
        int n = val.length;
        System.out.println(helper(weights,val,maxCapacity,n));
    }
    
    private static int helper(int[] weights, int[] val, int maxCapacity, int n){
        int dp[][] = new int[weights.length+1][maxCapacity+1];//to calculate multiple same sub problems
        for(int i=0;i<=n;i++){
            for(int j=0;j<=maxCapacity;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                else if(weights[i-1]<=j){
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1]+dp[i-1][j-weights[i-1]]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[weights.length][maxCapacity];
    }
}