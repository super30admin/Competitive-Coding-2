// Time Complexity o(n*m) Space Comlexity o(n*m);
public class KnapSack {
    public static void main(String[] args) {
        int[] items = {10,40,50,70};
        int[] w = {1,3,4,7};
        int r = items.length;
        int c = 7;
        int[][] dp = new int[r + 1][c + 1];
        
        for (int i = 0; i <= r; i++) {
            dp[i][0] = 0;
        }
        
        for (int i = 0; i <= c; i++) {
            dp[0][i] = 0;
        }
        
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (w[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], items[i - 1] + dp[i - 1][j - w[i - 1]]);
                }
            }
        }
        
        System.out.print(dp[r][c]);  // Output: 90
    }
}
