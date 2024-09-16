/* 
Time Complexity : O(m*n)
Space Complexity : O(m*n)
*/
// Did this code successfully run on Leetcode : no, executed on IDE
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
class kanpsack{
public static int knapSack_func(int capacity, int wt[], int val[], int length){
        //use a 2d array to store the sub-problem results with (n)cols representing the knapsack capacity 
        // and rows(m) representing the weights of individual values
        int dp[][] = new int[length+1][capacity+1];
        //initialize the row 0 with value 0 as its not possible to calculate for weight 0
        for(int i=0;i<dp[0].length;i++){
            dp[0][i] = 0;
        }
        //calculate the profit for m*n
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                //if the weight > capacity then assign the previous value
                if(j<wt[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                //otherwise calculate the profit
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        //return the last element in the matrix which has the max profit
        return dp[dp.length-1][dp[0].length-1];
    }
 public static void main(String args[])
    {
        int val[] = new int[] { 6, 10, 12 };
        int wt[] = new int[] { 1, 2, 3 };
        int W = 5;
        int n = val.length;
        System.out.println(knapSack_func(W, wt, val, n));
    }
}
   