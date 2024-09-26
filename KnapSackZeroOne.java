// Time Complexity : o(mn)
// Space Complexity : o(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class KnapSackZeroOne {

    public static int knapSackDp(int[] value, int[] weight, int capacity) {
        if (weight == null || weight.length == 0)
            return 0;
        if (value == null || value.length == 0)
            return 0;

        int[][] dp = new int[weight.length + 1][capacity + 1];

        for (int i = 0; i < capacity; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= weight.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (weight[i - 1] <= j) {
                    int choose = value[i - 1] + dp[i - 1][j - weight[i - 1]];
                    int notchoose = dp[i - 1][j];
                    dp[i][j] = Math.max(choose, notchoose);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[weight.length][capacity];
    }


    public static int knapSackRec(int[] value, int[] weight, int capacity) {
        if (weight == null || weight.length == 0)
            return 0;

        return helper(capacity, weight, value, weight.length - 1);
    }

    private static int helper(int capacity, int weight[], int value[], int index) {
        if (capacity <= 0) {
            return 0;
        }

        if (index == 0) {
            return 0;
        }

        // not choose
        int notchoose = helper(capacity, weight, value, index - 1);
        // choose
        int choose = value[index] + helper(capacity - weight[index], weight, value, index - 1);
        return Math.max(choose, notchoose);
    }

    public static void main(String args[]) {
        int value[] = new int[]{60, 100, 120};
        int weight[] = new int[]{10, 20, 30};
        int capacity = 50;
        System.out.println(knapSackRec(value, weight, capacity));
        System.out.println(knapSackDp(value, weight, capacity));
    }
}