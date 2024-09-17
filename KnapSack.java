// Time Complexity : O(n*m) where n is the length of weights, m is the capacity
// Space Complexity : O(n*m), for the 2D matrix
// Did this code successfully run on Leetcode : Dint find the problem
// Any problem you faced while coding this : No

//Recursive solution has exponential time complexity as it has repeating sub problems
//Implemented DP solution, Initialized a 2D matrix with length wights+1 and Capacity+1 for the initial 0th column, row
//when the capacity isgreater than weight at that row, take max between previous row element and current value + value from the dp matrix from capacity-current weight
//else copy the value from the above row
//return the last element at the end of traversing which will give maximum profit

class KnapSack{
    public static void main(String[] args){
        int[] values={20,5,10,40,15,25};
        int[] weights={1,2,3,8,7,4};
        int W=10;
        System.out.println(knapsack(weights,values,W));
    }
    public static int knapsack(int[] weights, int[] values, int W){
        int[][] dp = new int[weights.length+1][W+1];

        for(int i=0;i<=W;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<=weights.length;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<=weights.length;i++){
            for(int j=1;j<=W;j++){
                if(j>=weights[i-1]){
                    dp[i][j]=Math.max(values[i-1]+dp[i-1][j-weights[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[weights.length][W];
    }
}