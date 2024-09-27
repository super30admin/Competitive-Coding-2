package S30.CompetitiveCoding_2;

/*DP Solution
Time Complexity : Put: O(mn),
Space Complexity : O(mn),  m is weights length, n is capacity

Recursive Solution
Time Complexity : Put: O(2^n) - making 2 choices at each level, n is capacity
Space Complexity : O(n) - Recursive stack space

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class Problem2 {

    public int knapsackRecursive(int[] weights, int[] values, int capacity){

        if(weights.length == 0 || values.length == 0 || weights == null || values == null) return 0;

        return helper(weights,values,capacity,0,0);
    }

    private int helper(int[] weights, int[] values, int capacity, int index, int maxValue){

        if(capacity == 0) return maxValue;

        if(index >= weights.length || capacity < 0) return -1;

        //don't choose an item
        int case1 = helper(weights,values,capacity,index+1,maxValue);

        //choose an item
        int case2 = helper(weights,values,capacity - weights[index], index+1,maxValue + values[index]);

        return Math.max(case1, case2);
    }

    public int knapsackDP(int[] weights, int[] values, int capacity){

        if(weights.length == 0 || values.length == 0 || weights == null || values == null) return 0;


        int[][] dp = new int[weights.length+1][capacity+1];
        int m = dp.length;
        int n = dp[0].length;

        //weight available is 0 - empty weights array. Maximum value which can be formed is 0
        for(int j = 0; j < n; j++){
            dp[0][j] = 0;
        }

        //capacity is 0, maximum value which can be formed is 0
        for(int i = 0; i < m; i++){
            dp[i][0] = 0;
        }

        for(int w = 1; w < m; w++){
            for(int c = 1; c < n; c++){

                //don't choose
                int case1 = dp[w-1][c];

                int case2 = 0;
                //choose
                if(c - weights[w-1] >= 0)
                    case2 = values[w-1] +  dp[w-1][c - weights[w-1]];

                dp[w][c] = Math.max(case1,case2);
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Knapsack01 test = new Knapsack01();
        System.out.println(test.knapsackRecursive(new int[]{10,20,30}, new int[]{60,100,120}, 50));
        System.out.println(test.knapsackDP(new int[]{10,20,30}, new int[]{60,100,120}, 50));

    }
}
