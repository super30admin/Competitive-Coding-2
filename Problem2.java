class problem2 {

    // Time Complexity : O(N*M) where M is capacity and N is number of weights
    // Space Complexity : O(N*M) where M is capacity and N is number of weights

    // Your code here along with comments explaining your approach
    /*
    */
    public static int knapSack(int[] value, int[] weight, int capacity) {
        
        if(value == null || weight == null || value.length != weight.length) {
            return 0;
        }

        int n = value.length;
        int[][] dp = new int[n+1][capacity+1];

        for(int i=0; i<=value.length; i++) {

            for(int j=0; j<=capacity; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else if(weight[i-1] <= j) {
                    dp[i][j] = Math.max(value[i-1] + dp[i-1][j - weight[i-1]], dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][capacity];
        
    }

    public static void main(String[] args) {
        int[] weight = {5, 3, 2, 1};
        int[] value = {90, 50, 70, 30};
        int capacity = 5;

        System.out.println(knapSack(value, weight, capacity));
    }
}