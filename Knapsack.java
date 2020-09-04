// Time Complexity : O(m) + O(n) + O(m*n) where m and n are num of rows and cols
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// knapsack

// we create a 2d dp array with rows as num of available items+1 and no of cols is capacity+1
// dp[i][j] gives the max value we will get using i number of items and j as the capacity.
// the first row and cols are set as 0 since we have max value = 0 if capacity is 0(for first col) and you wehn you can use any item (first row)
// 
// 
// 

public class Main {
    public static void main(String[] args) {
        int weight[] = { 1, 2, 3 };
        int value[] = { 60, 100, 120 };
        int capacity = 5;
        int[][] dp = new int[weight.length + 1][capacity + 1];

        for (int i = 0; i < dp.length; i++)
            dp[i][0] = 0;

        for (int j = 0; j < dp[0].length; j++)
            dp[0][j] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // here we continue not choose(dp[i-1][j]) if the current value>target i.e
                // current value is useless
                if (weight[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else {
                    // if current value<target, ie we can choose it. hence the value will be max of
                    // choose and not choose.
                    dp[i][j] = Math.max(dp[i - 1][j], value[i - 1] + dp[i - 1][j - weight[i - 1]]);
                    // not choose is (dp[i-1][j]).....choose is sum of (value of the current item
                    // chosen + dp[i-1][complement])
                    // here it is i-1 and not i ,which means previous row as we cant choose items
                    // more than once.. hence we go to the complement where current element is
                    // not present i.e i-1
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println(" ");
        }

        System.out.println("The max value in the knapsack is " + dp[weight.length][capacity]);

    }

}