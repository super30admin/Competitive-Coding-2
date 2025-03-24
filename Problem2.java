//Given n items where each item has some weight and profit associated with it and also given a bag with capacity W, [i.e., the bag can hold at most W weight in it]. The task is to put the items into the bag such that the sum of profits associated with them is the maximum possible. 

//Note: The constraint here is we can either put an item completely into the bag or cannot put it at all [It is not possible to put a part of an item into the bag].

// Time Complexity :O(n x W)
// Space Complexity :O(n x W)
// Did this code successfully run on GFG : Yes
// Any problem you faced while coding this :



class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        int w=wt.length;
        int[][] dp=new int[w+1][W+1];
      
        for(int i=0;i<=w;i++){
            for(int j=0;j<=W;j++)
                if(i==0||j==0){
                    dp[i][j]=0;   //If no items are available or weight capacity is 0, value is 0.
                }
                else if (wt[i - 1] <= j) {
                    //If the current item weight is less than or equal to remaining capacity (j).
                    //Take max among previous max and the current value added to the prev max.
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - wt[i - 1]]+val[i - 1]  );
                } else {
                    //If the current item weight is more than remaining capacity, its not included, the value is same as previous row.
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[w][W];
        
    }
}
