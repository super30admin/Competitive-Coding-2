//Time complexity: O(N)
//Space complexity: O(N*N)
public class Main {
    public static void main(String[] args) {
      int N = 3;
      int W = 4;
      int values[] = {1,2,3};
      int weight[] = {4,5,1};
      System.out.println(helperMethod(values, weight, W));
    }

    private static int helperMethod(int[] values, int[] weight, int W) {
        int[][] dp = new int[values.length + 1][W + 1];
        dp[0][0] = 0;
        for(int i = 1; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(j < weight[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else if(weight[i-1] <= W) {
                    dp[i][j] = Math.max(dp[i-1][j], values[i-1] + dp[i-1][j-weight[i-1]]);  
                }
            }
        }
        return dp[dp.length - 1][dp[0].length-1];
    }