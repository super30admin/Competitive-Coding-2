public class Main {
    public static void main(String [] args){
        int profit[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };

        int W = 50;
        System.out.println(knapsack(profit, weight, W));
    }
    public static int knapsack(int[] val, int[] wt, int W){
        int n = val.length;
        
        int [][] dp = new int [n+1][W+1];
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j<wt[i-1]) dp[i][j]=dp[i-1][j];
                else dp[i][j]=Math.max(dp[i-1][j],val[i-1]+dp[i-1][j-wt[i-1]]);

                }
            }
        return dp[n][W];
        }
    
    }
