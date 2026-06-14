import java.util.Arrays;

public class Problem1 {
    public static void main(String[] args) {
        int[] val = {1, 2, 3};
        int[] wt = {4, 5, 1};
        int maxWt = 4;
        int[][] memo = new int[val.length][maxWt + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        System.out.println(recur(val, wt, maxWt, 0, 0, memo));
    }
    
    private static int recur(int[] val, int[] wt, int maxWt, int index, int totalWt, int[][] memo) {
        if (index == val.length || totalWt == maxWt) {
            return 0;
        }
        
        if (memo[index][totalWt] != -1) {
            return memo[index][totalWt];
        }

        if (totalWt + wt[index] > maxWt) {
            memo[index][totalWt] = recur(val, wt, maxWt, index + 1, totalWt, memo);
            return memo[index][totalWt];
        }
        
        memo[index][totalWt] = Math.max(
            recur(val, wt, maxWt, index + 1, totalWt, memo),
            recur(val, wt, maxWt, index + 1, totalWt + wt[index], memo) + val[index]
        );

        return memo[index][totalWt];
    }
}