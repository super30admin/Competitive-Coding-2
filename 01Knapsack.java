class Main {
  public static void main(String[] args) {
    int val[] = new int[]{60, 100, 120};
    int wt[] = new int[]{10, 20, 30};
    int  W = 50;
    int n = val.length;
    System.out.println(knapSack(W, wt, val, n));
  }

  public static int knapSack(int W, int[] wt, int[] val, int n) {
    //dependent on 2 constarints - so using a dp matrix
    int[][] result = new int[n + 1][W + 1];
    
    //if mo items are present -> 1st row -> max value possiblle is  irrespective of kanpsack capacity
    //if knapsack capacity is 0, them max value is possible is still 0 irrespective of no of items
    for(int i = 1; i < n + 1; i++)
    {
      for(int j = 1; j < W + 1; j++)
      {
        if(wt[i - 1] > j)//if current item weighs more than capacity, dont choose it
        {
          result[i][j] = result[i - 1][j];
        }
        else
        {
          int dontPick = result[i - 1][j];
          int pick = val[i - 1] + result[i - 1][j - wt[i - 1]];
          result[i][j] = Math.max(pick, dontPick);
        }
      }
    }
    return result[n][W];
  }
}
