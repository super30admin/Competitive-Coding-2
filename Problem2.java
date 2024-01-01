import java.util.*;
// Time Complexity : DP: O(N*W), 
// Space Complexity : O(N*W)
class Problem2 {
    public static void main(String args[]) {

        int[] profits = new int[]{1, 2, 3};
        int[] weights = new int[]{4, 5, 1};
        int knapsackCapacity = 4;
        int itemCount = 3;
        int[][] dpTable = new int[itemCount + 1][knapsackCapacity + 1];

        for (int i = 0; i <= itemCount; i++) {
            for (int j = 0; j <= knapsackCapacity; j++) {
                if (i == 0 || j == 0)
                    dpTable[i][j] = 0;
                else if (weights[i - 1] > j)
                    dpTable[i][j] = dpTable[i - 1][j];
                else
                    dpTable[i][j] = Math.max(dpTable[i - 1][j], profits[i - 1] + dpTable[i - 1][j - weights[i - 1]]);
            }
        }

        System.out.println("Maximum Profit: " + dpTable[itemCount][knapsackCapacity]);
    }
}
