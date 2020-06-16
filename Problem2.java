
 
//0-1 Knapsack Problem | DP-10

//we are given weights and values of n items. we need to put these items in a knapsack of capacity W to get maximum value in our knapsack.

//or we can say that we are given two integers arrays val[0......n-1] and wt[0.....n-1] which represent values and weights associated with n items respectively. we are also given an integer W  which represents knapsack capacity.

//find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. but you cannot break an item, either pick the complete item or dont pick it(known as 0-1 property).


class Knapsack {
 
    static int knapSack(int capacity, int weight[], int profit[], int n) 
      { 
        
      return helper(capacity,weight, profit, n, 0, 0);
      }
    
     private static int helper(int capacity, int[] weight, int[] profit,int n,int i,int max_profit)
     {
       //base
       if(i>=n || capacity==0)
         return max_profit;
       
       //logic
       if(weight[i] > capacity) // can't choose weights[i] as it exceeds the remaining capacity
         helper(capacity,weight, profit, n, i+1, max_profit); // only increase index as can't choose the value
       
       //choose
       int case0 = helper(capacity - weight[i],weight, profit, n, i+1, max_profit+profit[i]);
       
       
       //not choose
         int case1 =  helper(capacity,weight, profit, n, i+1, max_profit);
       
       return Math.max(case0,case1);
       
     }
    
     public static void main(String args[]) 
      { 
          int profit[] = new int[] { 60, 100, 120 }; 
          int weight[] = new int[] { 10, 20, 30 }; 
          int capacity = 50; 
          int n = profit.length; 
          System.out.println(knapSack(capacity, weight, profit, n)); 
      } 
    
  }
  

  class Knapsack {
 
    static int knapSack(int capacity, int weight[], int profit[], int n) 
    {
     int dp[][] = new int[n+1][capacity+1];
    
      int r = dp.length;
      int c = dp[0].length;
      
      for(int i=1;i<r;i++)
      {
        for(int j=1;j<c;j++)
        {
          if(j<weight[i-1])
            dp[i][j] = dp[i-1][j];
          else
            dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]]+ profit[i-1]);
         
            
        }
      }
      
      return dp[r-1][c-1];
     }
    
     public static void main(String args[]) 
      { 
          int profit[] = new int[] { 60, 100, 120 }; 
          int weight[] = new int[] { 10, 20, 30 }; 
          int capacity = 50; 
          int n = profit.length; 
          System.out.println(knapSack(capacity, weight, profit, n)); 
      } 
    
  }
  
    