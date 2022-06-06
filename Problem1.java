//https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
/*Given weights and values of n items, put these items in a knapsack of capacity W 
to get the maximum total value in the knapsack. In other words, given two integer arrays 
val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items 
respectively. Also given an integer W which represents knapsack capacity, find out the maximum 
value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
 You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
*/


  static int knapSack(int W, int wt[], int val[], int n)
  {
    // making and initializing dp array
    int []dp = new int[W + 1];
 
 
    for (int i = 1; i < n + 1; i++) {
      for (int w = W; w >= 0; w--) {
 
        if (wt[i - 1] <= w)
           
          // finding the maximum value
          dp[w] = Math.max(dp[w],
                           dp[w - wt[i - 1]] + val[i - 1]);
      }
    }
    return dp[W]; // returning the maximum value of knapsack
  }
   
  //Complexity Analysis:

//Time Complexity: O(N*W).

//Auxiliary Space: O(W)
  
 
