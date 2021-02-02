// Time complexity-O(m*n)
//Space complexity- O(m*n)

class Knapsack{
    public int solution(int[] weights, int[] profits, int capacity)
    {
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
        return 0;
  
      int n = profits.length;
      int[][] dp = new int[n][capacity + 1];
  
      // populate the capacity=0 columns, with '0' capacity we have '0' profit
      for(int i=0; i < n; i++)
        dp[i][0] = 0;
  
      // if we have only one weight, we will take it if it is not more than the capacity
      for(int c=0; c <= capacity; c++) {
        if(weights[0] <= c)
          dp[0][c] = profits[0];
      }
  
    
      for(int i=1; i < n; i++) {
        for(int c=1; c <= capacity; c++) {
          int profit1= 0, profit2 = 0;
    
          if(weights[i] <= c)
            profit1 = profits[i] + dp[i-1][c-weights[i]];
            profit2 = dp[i-1][c];
       
          dp[i][c] = Math.max(profit1, profit2);
        }
      }
      return dp[n-1][capacity];
    }
    public static void main(String args[])
    {
        Knapsack obj = new Knapsack();
        int[] weights= new int[]{10,20,30};
        int[] price= new int[]{60,100,120};
        int max= 50;
        System.out.println(obj.solution(weights, price, max));
    }
}