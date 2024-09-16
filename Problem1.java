// TIME: O(n^2)
// SPACE: O(n^2)
// SUCCESS

class Knapsack {
    public int findMax(int[] weightArr, int[] valuesArr, int capacity) {
        int[][] dp = new int[valuesArr.length+1][capacity+1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < weightArr[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(valuesArr[i-1] + dp[i-1][j-weightArr[i-1]], dp[i-1][j]);
                }
            }
        }

        return dp[valuesArr.length][capacity];
    }
}


public class Main {
    public static void main(String[] args) {
        int[] weightArr = new int[]{1,2,3};
        int[] valuesArr = new int[]{6,10,12};
        Knapsack knapsack = new Knapsack();
        System.out.println(knapsack.findMax(weightArr, valuesArr, 5));
    }
}