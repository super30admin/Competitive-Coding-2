// Time Complexity: we are creating a matrix and filling it with values of weights for the complexity here is O(wts.length*W)
// Space Complecity: a matrix of size wts.length*W => O(wts.length*W)
// Did you complete it on leet code: Couldn't find on leet code
// Any problems faced: had to figure out value part.

// Write your approach here:
// Idea is to use the subproblems to get the values for later calculations
// we calculate till the max weight which can reach, what is the value we can achieve if we use
// only first item with no repetition, similarly we find if 2nd item with different weight is present
// how much maximum can we achieve with both the items.
// we continue comparing the maximum of previous achieved value and value of current element+ if another element of remaining weight can be taken
// last element of matrix returns the maximum output
public class Solution{
    public static int knapsack(int[] wts, int[] val, int W) {
        int [][] dp = new int [wts.length+1][W+1];
        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                if(j<wts[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1] + dp[i-1][j-wts[i-1]]);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}