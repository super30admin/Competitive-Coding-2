// Time Complexity :O(n*m)
// Space Complexity :O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// "static void main" must be defined in a public class.
public class Main {
    public static int knapSack(int capacity, int[] weight, int[] profit){
        int m = weight.length;
        int[][] dp = new int[m+1][capacity + 1];

        for(int i = 1; i < m+1; i++){
            for(int j = 0; j < capacity + 1; j++){
                if(j < weight[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                }
                else{
                    dp[i][j] = Math.max( dp[i - 1][j], (profit[i - 1] + dp[i - 1][j - weight[i - 1]]));
                }
            }
        }
        return dp[m][capacity];
    }

    public static void main(String[] args) {
        int profit[] = new int[] {5 , 10, 15};
        int weight[] = new int[] {1, 2, 3};
        int capacity = 5;
        System.out.println(knapSack(capacity, weight, profit));
    }
}