// Time Complexity : O(n^2)
// Space Complexity :O(n^2)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// same as coin chain problem, once we are done with weight in the value, we will compare it with the one above, and profit of that row (p[i-1]) + last value dp[i-1][j - w[i-1]]
// Your code here along with comments explaining your approach
// O-1 knapsack
// dp[i][j] = Math.max( dp[i-1][j], p[i-1] + dp[i-1][j - w[i-1]])
class KnapSack {
    public static void main(String[] args) {
        int [] p = { 60, 100, 120 };
        int [] w = { 10, 20, 30 };
        int a = 50;
        int ans = KnapSack(p, w, a);
        System.out.println("Ans: "+ans);
    }
    static private int KnapSack(int [] p, int [] w, int a){
        int m = w.length+1;
        int n = a+1;
        int [][] dp = new int [m][n];
        for(int i = 1; i < m; i++){
            for( int j = 1; j < n; j++){
                if( j < w[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i-1]] + p[i-1]);
                }
            }
        }
        return dp[m-1][n-1];
    }
}