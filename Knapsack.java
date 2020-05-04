// Time Complexity : O(mn) where m is the capacity and n is the number of weights 
// Space Complexity : O(mn) to maintain a dp matrix where m is the capacity and n is the number of weights 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Finding the pattern took sometime 
/* Your code here along with comments explaining your approach: Store the dp matrix as weights as rows and capacity as columns.
If the value of capacity is lesser than the weights value, put the value gained in the row above. Elsewise, take the maximum of the
value in the row above and val of the current weight  + the value of the row above(previous weight). Display the last element of the dp matrix.
*/
class Knapsack 
{ 
    
    /* BRUTE FORCE:
    public static int knapSack(int W, int[] wt, int[] val, int n){
        int i = 0, profit = 0 , weight = 0;
        return helper(W, wt, val, profit, weight, i);
    }
    private static int helper(int W, int[] wt, int[] val, int profit, int weight, int i){
        //base
        if(weight > W)  { return profit-val[i-1];}
        if(i==wt.length) {return profit;}
        //logic
        int case1 = helper(W, wt, val, profit + val[i], weight + wt[i], i+1);
        int case2 = helper(W, wt, val, profit, weight, i+1);
        return Math.max(case1, case2);
    }
    */

    public static int knapSack(int W, int[] wt, int[] val, int n){
        int[][] dp = new int[wt.length+1][W+1];                     // Maintain a DP Matrix
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(wt[i-1] > j){                                    // If the weight is greater than capacity , take the previous weight's value
                    dp[i][j] =  dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1] + dp[i-1][j-wt[i-1]]); // else take the max of the previous weight's value and curent weights value - those many steps back weight's value
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];                 // Return the last value of dp matrix
    }


  
   // Driver program to test above function 
   public static void main(String args[]) 
   { 
    int val[] = new int[]{60, 100, 120}; 
    int wt[] = new int[]{10, 20, 30}; 
    int  W = 50; 
    int n = val.length; 
    System.out.println(knapSack(W, wt, val, n)); 
    } 
} 