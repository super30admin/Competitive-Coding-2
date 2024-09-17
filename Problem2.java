// "static void main" must be defined in a public class.

/**
 * TC : O(n * m) where n is weight length + 1 and m is capacity + 1
 * SC: O(n * m) where n is weight length + 1 and m is capacity + 1
 */
public class Main {

    public int getMaxValue(int[] wt, int[] values, int capacity) {
        int row = wt.length + 1;
        int column = capacity + 1;

        int[][] dp = new int[row][column];

        for(int i = 1; i < row; i++) {
            for(int j = 1; j < column; j++) {
                if(wt[i -1] > j) { // when wt is greater than capacity take above value
                    dp[i][j] = dp[i -1][j];
                } else {
                    dp[i][j] = Math.max(dp[i -1][j], values[i -1] + dp[i-1][j - wt[i -1]]);
                }
            }
        }
        return dp[row - 1][column - 1];
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Main m = new Main();

        int[] wt = {1,2,3};
        int[] values = {6,10,12};
        int capacity = 5;

        System.out.println(getMaxValue(wt, values, capacity));


    }
}