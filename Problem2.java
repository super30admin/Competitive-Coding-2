/*
we are given weights and values of n items. we need to put these items in a knapsack of capacity W to get maximum value in our knapsack.

or we can say that we are given two integers arrays val[0......n-1] and wt[0.....n-1] which represent values and weights associated with n items respectively. we are also given an integer W  which represents knapsack capacity.

find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. but you cannot break an item, either pick the complete item or dont pick it(known as 0-1 property).
*/

// Time Complexity : O(n*m), for each wt go over all capacities.
// Space Complexity :O(n) , store all capacities with max wt.

// Any problem you faced while coding this :
  //yes, creating dp base case.

// Your code here along with comments explaining your approach
private int knapSack(int W, int wt[], int val[]){
  int memo = new int[W+1];

  for(int i = 0 ; i < wt.length; i++){ // from 1st wt to last.
    for(int cap = W; cap >= 1; cap++){
      //keep the  max of current memo indx or
      //this weights val + prev sub problems max weight.
      memo[cap] = Math.max(memo[cap], val[i] + memo[cap - wt[i]]);
    }
  }

  return memo[W];
}
