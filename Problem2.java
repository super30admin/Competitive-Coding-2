// Time Complexity: O(n * maxWeight) // because we want to compute all possible cases for n length and 0....maxWeight in our DP array
// Space Complexity: O(n * maxWeight)

// We use a DP array, try to compute the best solution for each weight, with available elements

public class Main {
    public static void main(String[] args) {
        int[] val = { 1, 2, 3 };
        int[] wt = { 4, 5, 1 };
        int W = 4;

        System.out.println("\n\n\n\nExpected output: 3, Actual: " + knapsack(W, val, wt) + "\n\n\n\n");
        
        val = new int[]{ 1, 2, 3 };
        wt = new int[]{ 4, 5, 6 };
        W = 3;

        System.out.println("\n\n\n\nExpected output: 0, Actual: " + knapsack(W, val, wt) + "\n\n\n\n");
        
        val = new int[]{ 10, 40, 30, 50 };
        wt = new int[]{ 5,4,2,3 };
        W = 5;

        System.out.println("\n\n\n\nExpected output: 80, Actual: " + knapsack(W, val, wt) + "\n\n\n\n");
        
        wt = new int[]{ 95, 4, 60, 32, 23, 72, 80, 62, 65, 46};
        val = new int[]{ 55,10,47,5,4,50,8,61,85,87 };
        W = 269;

        System.out.println("\n\n\n\nExpected output: 295, Actual: " + knapsack(W, val, wt) + "\n\n\n\n");
    }
    
    public static int knapsack(int W, int[] val, int[] wt) {
        
        if (val == null || wt == null || val.length == 0 || wt.length == 0 || val.length != wt.length) return 0;
        
        int dp[][] = new int[val.length + 1][W + 1];
        
        for (int i=0; i<val.length; i++) {
            int currProfit = val[i];
            int currWeight = wt[i];
            
            int dpIndex = i+1;
            
            for (int j=1; j<=W; j++) {
                if (j >= currWeight) {
                    dp[dpIndex][j] = Math.max(dp[dpIndex-1][j], currProfit + dp[dpIndex - 1][j - currWeight]);
                } else {
                    dp[dpIndex][j] = dp[dpIndex-1][j];
                }
            }
        }
        
        
        return dp[val.length][W];
        
    }
}
