// Time Complexity : Recursion: O(2^n) DP: O(N*W)
// Space Complexity : Recursion O(1) DP:  O(N*W)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
public class knapSack {
    
    public static int knapSackDP(int W, int wt[], int val[], int n){ 
        int i, w; 
        int K[][] = new int[n + 1][W + 1]; 
  
        for (i = 0; i <= n; i++) { 
            for (w = 0; w <= W; w++) { 
                if (i == 0 || w == 0) 
                    K[i][w] = 0; 
                else if (wt[i - 1] <= w) 
                    K[i][w] = Math.max( 
                        val[i - 1] + K[i - 1][w - wt[i - 1]], 
                        K[i - 1][w]); 
                else
                    K[i][w] = K[i - 1][w]; 
            } 
        } 
        return K[n][W]; 
    } 
    
    public static int knapSackRecursion(int W, int wt[],int val[], int n) { 
        // Base Case 
        if (n == 0 || W == 0) 
            return 0; 
  
        if (wt[n - 1] > W) 
            return knapSackRecursion(W, wt, val, n - 1); 

        else
            return Math.max( 
                val[n - 1] + knapSackRecursion(W - wt[n - 1], 
                                      wt, val, n - 1), 
                knapSackRecursion(W, wt, val, n - 1)); 
    }
    
    
    public static void main(String[] args) {
       int val[] = new int[] { 60, 100, 120 }; 
        int wt[] = new int[] { 10, 20, 30 }; 
        int W = 50; 
        int n = val.length; 
        System.out.println(knapSackRecursion(W, wt, val, n)); 
        System.out.println(knapSackDP(W, wt, val, n)); 
    }
}