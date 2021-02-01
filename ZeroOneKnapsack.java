// Time Complexity : O(n*m) n: length of weights array; m: value of capacity
// Space Complexity : O(n*m)

public class ZeroOneKnapsack {

    public static int maxProfit(int[] values, int[] weights, int capacity) {

        int rows = values.length + 1;
        int cols = capacity + 1;

        int[][] dp = new int[rows][cols];

        for(int i=0; i<cols; i++) {
            dp[0][i] = 0;
        }

        for(int i=0; i<rows; i++) {
            dp[i][0] = 0;
        }

        // maintain a cumulative sum at each row as only one unit of weight can be added.
        int cumSum = 0;
        for(int i=1; i<rows; i++) {
            cumSum = cumSum + weights[i-1];
            for(int j=1; j<cols; j++) {

                // if the weight is more than the capacity, take value of the baove row
                if(weights[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                
                // if difference between capacity and cumulative sum is greater than zero, it means all units of weights are included. just take the value from same row, previous column
                } else if((j - cumSum) > 0) {
                    dp[i][j] = dp[i][j-1];
                // else, take the maximum of above row or (profits by including current weight + profits by including (capacity - current weight) )
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], values[i-1] + dp[i][j-weights[i-1]]);
                }

            }
        }
        
        return dp[rows-1][cols-1];

    }

    public static void main(String args[]) {
        System.out.println(maxProfit(new int[]{2,3,1,4}, new int[]{3,4,6,5}, 8));
    }
    
}