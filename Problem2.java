class Knap {
    static int[][] cost = new int[4+1][8+1];
  
    public static int knapsack(int n, int W, int wi[], int pi[]) {

      for(int i=1; i<=n; i++) {
        for(int w=1; w<=W; w++) {
          if(wi[i] > w) {
            cost[i][w] = cost[i-1][w];
          }
          else {
            if (pi[i]+cost[i-1][w-wi[i]] > cost[i-1][w]) {
              cost[i][w] = pi[i] + cost[i-1][w-wi[i]];
            }
            else {
              cost[i][w] = cost[i-1][w];
            }
          }
        }
      }
      return cost[n][W];
    }
  
    public static void main(String[] args) {
      // element at index 0 is fake. matrix starting from 1.
      int wi[] = {0, 2, 3, 4, 5};
      int pi[] = {0, 1, 2, 5, 6};
      System.out.println(knapsack(4, 8, wi, pi));
    }
  }

  /* time complexity
  o(n) 
  Space complexity 
  o(n)

  */
