import java.util.Arrays;

// Bounded Knapsack
public class Problem1 {

    public static void main() {
        int target = 4;
        int[] weights = {4, 5, 1};
        int[] profits = {1, 2, 3};

        int max = knapsackTabulation(target, weights, profits); //
        System.out.println(max);

        max = knapsackRecursive(target, weights, profits, 0); //
        System.out.println(max);
    }


    public static int knapsackTabulation(int target, int[] weights, int[] profits) {
        // Time Complexity : O(N^2)
        // Space Complexity : O(N^2)
        int rows = weights.length + 1;
        int cols = target + 1;

        int[][] table = new int[rows][cols];
        for (int i = 1; i < rows; i++) {
            int currentWeight = weights[i - 1];
            for (int j = 1; j < cols; j++) {
                if (currentWeight <= j) {
                    table[i][j] = profits[i - 1] + table[i - 1][j - currentWeight];
                } else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }

        return table[rows - 1][cols - 1];
    }

    static int knapsackRecursive(int target, int[] weights, int[] profits, int index) {
        // Time Complexity : O(2^N), where N is the number of weights, at every recursion, we need to make choice whether to include weight or exclude weight
        // Space Complexity : O(N)
        if (index >= weights.length) return 0;
        if (target <= 0) return 0;

        int choose = 0;
        if (weights[index] <= target) {
            // choose the item only once and move the index to next item
            choose = profits[index] + knapsackRecursive(target - weights[index], weights, profits, index + 1);
        }

        int notChoose = knapsackRecursive(target, weights, profits, index + 1);

        return Math.max(choose, notChoose);
    }

}