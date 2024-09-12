// Time Complexity - O(n*W), n is the number of elements in wt[] or val[], W is maximum capacity
// Space Complexity - O(n*W)

public class Knapsack { 
  
    
    static int knapSack(int W, int wt[], int val[], int n) 
    { 

        int[][] dp = new int[n + 1][W + 1];

        for(int i = 0; i <= n; i++) {
            for(int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(val[i-1] + dp[i-1][w - wt[i-1]], dp[i-1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][W];
    } 
  
    // Driver program to test above function 
    public static void main(String args[]) 
    { 
        int val[] = new int[] { 6, 10, 12 }; 
        int wt[] = new int[] { 1, 2, 3 }; 
        int W = 5; 
        int n = val.length; 
        System.out.println(knapSack(W, wt, val, n)); 
    } 
} 