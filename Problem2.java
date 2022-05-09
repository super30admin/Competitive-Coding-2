class Knapsack {

  // Time Complexity : O(N*C), N-Number of Items and C --> Capacity(W).
  // Space Complexity : O(N*C + N) ==> O(N*C).
  // Did this code successfully run on Leetcode : Yes
  // Any problem you faced while coding this :

  // Your code here along with comments explaining your approach
  // I have used DP - Memoization technique to demonstrate optimized solution
  // approach from the brute force to DP Memoized.

  public int solveKnapsack(int[] val, int[] weights, int capacity) {
    Integer[][] dp = new Integer[val.length][capacity + 1];
    return this.knapsackRecursive(dp, val, weights, capacity, 0);
  }

  private int knapsackRecursive(Integer[][] dp, int[] val, int[] weights, int capacity,
      int currentIndex) {

    // base checks
    if (capacity <= 0 || currentIndex >= val.length)
      return 0;

    // if we have already solved a similar problem, return the result from memory
    if (dp[currentIndex][capacity] != null)
      return dp[currentIndex][capacity];

    // recursive call after choosing the element at the currentIndex
    // if the weight of the element at currentIndex exceeds the capacity, we
    // shouldn't process this
    int profit1 = 0;
    if (weights[currentIndex] <= capacity)
      profit1 = val[currentIndex] + knapsackRecursive(dp, val, weights,
          capacity - weights[currentIndex], currentIndex + 1);

    // recursive call after excluding the element at the currentIndex
    int profit2 = knapsackRecursive(dp, val, weights, capacity, currentIndex + 1);

    dp[currentIndex][capacity] = Math.max(profit1, profit2);
    return dp[currentIndex][capacity];
  }

  public static void main(String[] args) {
    Knapsack ks = new Knapsack();
    int[] val = { 60, 100, 120 };
    int[] weights = { 10, 20, 30 };
    int maxProfit = ks.solveKnapsack(val, weights, 50);
    System.out.println("Total knapsack profit ---> " + maxProfit);
  }
}