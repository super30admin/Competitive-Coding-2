// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
TC: (n * m )
SC: (n * m )
n = numbers of weights
m = Maximum capacity
*/

public class ZeroOneKnapsackProblem {

    public static void main(String args[]) {

        int[] weight = new int[]{1,2,3};
        int[] values = new int[]{60,100,120};

        System.out.println("Maximum value under maximum capacity is:"+ maximumValue(weight, values, 5));
    }

    private static int maximumValue(int[] weight, int[] values, int mc) {
        int n = weight.length+1;
        int m = mc +1;

        // init dp array of row as number of weights and maximum capacity
        int[][] dp = new int[n][m];

        // filled first zero row with zero value because we can max zero value out of zero weight
        for(int i=0;i<m;i++) {
            dp[0][i]= 0;
        }

        // filled first zero column with zero value because we need get max capacity of zero and we can get maximum capacity of zero choosing nothing
        for(int j=0;j<n;j++) {
            dp[1][0]= 0;
        }

        for(int i=1;i<n ;i++) {
            for(int j=1;j<m;j++) {
                if(j < weight[i-1]) {
                    //if capacity is less than my weight, setting max value for that as whatever can get from previous weight
                    dp[i][j]=dp[i-1][j];
                }
                else {
                    // summing weight value and previous weight value because after current max capacity minus current weight, as  we can not use current value more than ones
                    dp[i][j]= values[i-1]+dp[i-1][j - weight[i-1]];
                }
            }
        }

        //maximum value would be last element of DP
        return dp[n-1][m-1];
    }

}