// Time Complexity :O(m*n) --> beacuse of for loop
// Space Complexity :O(m*n)  ---> because of 2d dp array
public class problem2 {
    public static int helper(int[] weights,int[] values,int W) {
        int[][] dp = new int[weights.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = 0;
        for (int i = 1; i < dp[0].length; i++)
            dp[0][i] = 0;
        for(int i =1;i<dp.length;i++){
            for(int j =1;j<dp[0].length;j++){
                if(j<weights[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(values[i-1]+dp[i-1][j-weights[i-1]],dp[i-1][j]);
            }
        }
        return dp[weights.length][W];
    }
    public static void main(String[] args) {
        int[] weights = new int[]{10, 20, 30};
        int[] values = new int[]{60, 100, 120};
        int W = 50;
        System.out.println(helper(weights,values,W));
    }
}
