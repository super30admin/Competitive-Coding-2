//Time Complexity : Exponential
//Space Complexity : Worst case O(n) n is the length of wt
// Did this code successfully run on Leetcode : Time limit exceeded
//Approach :
/*
 * We use recurssion,where base case is currW > W, currW == W and index == wt.length.
 * NOT PICK: index+1, profit and weight remains same. 
 * PICK: index+1, profit + current profit and decrease Weight
 * Return max of both case
 */
class KnapSack 
{ 
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        if(n < 1 || W < 1) {
            return 0;
        }
        return recurse(W, wt, val, 0, 0, 0);
    } 
    
    private static int recurse(int W, int wt[], int val[], int index, int profit, int currW) {
        //Base case
        if(currW > W) {
            return 0;
        }
    
        if(currW == W || index == wt.length) {
            return profit;
        }
        
        //Logic: DO NOT CHOOSE CHOOSE 
        int case1 = recurse(W, wt, val, index + 1, profit, currW);
        int case2 = recurse(W, wt, val, index + 1, profit + val[index], currW + wt[index]);
        return Math.max(case1, case2);
    }

    public static void main(String args[]) {
        int W = 4;
        int[] wt = new int[]{4,5,1};
        int[] val = new int[]{1,2,3};
        int n = 3;
        int result = knapSack(W, wt, val, n);
        System.out.println(String.valueOf(result));

    }
}

//Time Complexity : O(n*W)  n is the total number of items, W weight
//Space Complexity : O(n*W) n is the total number of items, W weight
// Did this code successfully run on Leetcode : Yes
//Approach :
/*
 * DP where we consider dimension = length of the deciding factor. We creat dp[][] with n + 1 = row and W + 1 = coloumn
 * Fill 1st row and colum with 0. Fill dp matrix: if j < Weight (As we added extra row we will get weight at 1 lesser index in array)
 * We copy from previous row,  else fill  with Max between previous row(0 notpick case) and 1(pick case) which is in previous row 
 * and coloumn - weight.
 */

class KnapSackDP {
    static int knapSack(int W, int wt[], int val[], int n)  {
        if(n < 1 || W < 1) {
            return 0;
        }
        int[][] dp = new int[n + 1][W + 1];
        for(int i = 0; i < n  +  1;  i++) {
            dp[i][0] =  0;
        }
        for(int i = 0; i < W  +  1;  i++) {
            dp[0][i] =  0;
        }
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < W + 1; j++) {
                if(j < wt[i - 1])  {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                }
            }
        }
        return dp[n][W];
    }
} 

