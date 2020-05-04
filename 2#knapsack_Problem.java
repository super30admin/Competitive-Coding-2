Time : O(n*capacity) - n is size of the array and capacity is constant == O(n)
Space: O(n*capacity) - n is size of the array and capacity is constant == O(n)

// given profit, weight and capacity array find the max profit 
   static int knapSack(int capacity, int weight[], int profit[]) 
    { 
     
     int size = weight.length(); //size is size of given array
     int dp[][] = new int[size+1][capacity+1]; 

    // filling take in bottom up approach   
     for (i = 0; i <= size; i++)  // iterating over the array elements
     { 
         for (int c = 0; c <= capacity ; c++) // iterating over given capacity for each weight 
         { 
             if (i==0 || c==0) // if capacity is zero else if i == 0 then put value zero
                  dp[i][c] = 0; 

             else if (weight[i-1] >= c) else max  of profit of the current value + weight left or value of above cell
                   dp[i][c] = Math.max(profit[i-1] + dp[i-1][c-weight[i-1]],  dp[i-1][c]); 

             else // if current capacity is less than actual weight then put the value in above cell of that cell
                   dp[i][c] = dp[i-1][c]; 
         } 
      } 
       
      return dp[size][capacity]; 
    } 