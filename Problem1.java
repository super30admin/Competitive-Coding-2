//knapsack
public class Main {
    public static void main(String[] args) {
        int value[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int maxCap = 50;
        int n = value.length;
        int[][] dp = new int[n+1][maxCap+1];
        
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= maxCap; j++){
                dp[i][j] = -1;
            }
        }
        
        System.out.println(helper(weight, value, maxCap, 0, 0, dp));
    }
    
    
    private static int helper(int[] weight, int[] value, int maxCap, int i, int val, int[][] dp){
        
        if(i>=weight.length) return val;
        
        if(weight[i]>maxCap)
            return helper(weight, value, maxCap, i+1, val, dp);
        
        if(dp[i][maxCap] != -1) return dp[i][maxCap];
        
        int taken = helper(weight, value, maxCap - weight[i], i+1, val + value[i], dp);
        int nTaken = helper(weight, value, maxCap, i+1, val, dp);
        
        dp[i][maxCap] = Math.max(taken, nTaken);
        
        return Math.max(taken, nTaken);
        
    }
}
