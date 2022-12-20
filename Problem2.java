// Time Complexity : O(2^n), n is the length of the wt array.
// Space Complexity : O(2^n)

// Your code here along with comments explaining your approach in three sentences only
/*
 * using the recursion approach, we consider the wt from the the end and reduce till 0.
 * we have 2 options, choose and not choose. choose recursive call gives the call to  previous index and add the value for current wt.
 * For not choose we just change the index to previous index. at the end, return the max out of the 2 cases.
 */
class Problem2 {

    public static int knapSack(int[] value, int[] weight, int capacity) {
        if (weight == null || weight.length == 0)
            return 0;

        return helper(capacity, weight, value, weight.length - 1);
    }

    private static int helper(int capacity, int weight[], int value[], int index) {
        // base
        if (capacity <= 0)
            return 0;

        if (index == 0)
            return 0;

        // logic
        System.out.println(capacity);
        // not choose
        int case1 = helper(capacity, weight, value, index - 1);
        // choose
        int case2 = value[index] + helper(capacity - weight[index], weight, value, index - 1);
        return Math.max(case1, case2);
    }

    // Driver code
    public static void main(String args[]) {
        int value[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int capacity = 50;
        System.out.println(knapSack(value, weight, capacity));
    }
}

// Time Complexity : O(mn), m and n is the weight length and capcity length
// Space Complexity : O(mn)

// Your code here along with comments explaining your approach in three
// sentences only
/*
 * Using the DP approach, we have 2 variables so create 2D matrix named dp of
 * weight and capacity as dimension.
 * the 1st row with 0 weight is 0.
 * For remaining weights , if the weight value is less than the current capacity
 * we have 2 option choose or not choose, take maximum out of them
 * else we just take the previous weight.
 */
class Problem2 {

    public static int knapSack(int[] value, int[] weight, int capacity) {
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

    // Driver code
    public static void main(String args[]) {
        int value[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int capacity = 50;
        System.out.println(knapSack(value, weight, capacity));
    }
}