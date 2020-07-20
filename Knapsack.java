//TC: O(w*c), w: number of weights given, c: capacity
//SC: O(w*c)
// Approach:
//1. Brute force will be to build a tree with two child nodes of every node will be whether we take the first weight in the array or not.
//2. We see repeated subproblems, and hence can optimize it with DP.
//3. 2-D matrix, dp will store the maximum profit possible provided the capacity at any given point of time.
//4. We build dp[][] with size of (number of weights * capacity), capacity varying from 0 to the given capacity in input.
//5. Till the column, where we see the weight is greater than the capacity, we copy the values from the last row.
//6. If the capacity is equal to or greather than the weight, then we take the maximum of the same column last row element from dp[][] (which is the possible profit
// if the current weight is not included at all, and the profit of picking the current weight + the value in dp[][] at index -> [current column(j) - current weight]
// in the last row, (not the current row, because the current weight can only be used once, no duplicate weights are allowed).
//7. Last row last column gives us the maximum profit possible.


class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    int[] weights = new int[]{1,2,5};
    int[] profit = new int[]{2,6,8};
    int capacity = 7;
    int result = getMaxProfit(weights, profit, capacity);
    System.out.print(result);
  }
  public static int getMaxProfit(int[] weights, int[] profit, int capacity){
    int[][] dp = new int[weights.length+1][capacity+1];
    for(int i = 1; i < weights.length+1; i++){
      for(int j = 1; j < capacity + 1; j++){
        if(weights[i-1] > j){
          dp[i][j] = dp[i-1][j];
        }
        else{
          dp[i][j] = Math.max(dp[i-1][j], profit[i-1]+dp[i-1][j-weights[i-1]]);
        }
      }
    }
    return dp[weights.length][capacity];
  }
}
