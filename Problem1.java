class Main {

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,7,8};
        int[] profits = {20,5,10,25,15,40};
        int maxCap = 10;
        System.out.println(getKnapsackExhaustive(weights, profits, maxCap));
        System.out.println(getKnapsackDp(weights, profits, maxCap));
        System.out.println(getKnapsackDpSpaceOptimized(weights, profits, maxCap));
    }



            // Exhaustive Approach
    // Time Complexity : O(2^n)
    // Space Complexity : O(n)
        // n is the number of weights
        
    // Your code here along with comments explaining your approach
        //We use a helper function to explore every possibility, that is we recursively call the helper function over a set of weights, we keep adding more weights to our set.
        //With every set of the weights, we either choose or don't choose the weight. Once we reach the capacity or left with no more weights to check, we terminate further calls and return the maximum of both the decisions to the parent call.
        //The maximum profit is found out at the leaf nodes of the search tree. In the parent function we return the maximum and pass it on to its parent. The answer is returned in the root call.

    //Exhaustive Approach
    private static int getKnapsackExhaustive(int[] weights, int[] profits, int maxCap)
    {
        return helper(0, weights, profits, maxCap, 0);
    }
    
    private static int helper(int index, int[] weights, int[] profits, int capRemaining, int totalProfit)
    {
        //base
        if (capRemaining<0)
        {
            return -1;
        }
        if (index==weights.length)
        {
            return totalProfit;
        }
        //choose
        int case1 = helper(index+1, weights, profits, capRemaining-weights[index], totalProfit+profits[index]);
        //don't choose
        int case2 = helper(index+1, weights, profits, capRemaining, totalProfit);
        if (case1==-1)
        {
            return case2;
        }
        if (case2==-1)
        {
            return case1;
        }
        return Math.max(case1, case2);
    }



            // Dynamic Programming
    // Time Complexity : O(n*m)
    // Space Complexity : O(n*m)
        // n is the number of weights
        // m is the maximum capacity of the bag
    // Your code here along with comments explaining your approach
        //We can greatly minimize the number of calls by maintaining a 2D array, where each set of weights corresponds to each row, and the capacities of the knapsack are put pn the columns.
        //At every cell, we calculate the maximum of both decisions, that is by choosing "dp[i-1][j-currentWeight]+profitOfCurrentWeight" and not choosing "dp[i-1][j]"
        //As we iterate over the rows, we keep finding the most profit with given set of weights. When we reach the last row and last column, we get our answer.

    //Dynamic Programming
    private static int getKnapsackDp(int[] weights, int[] profits, int maxCap)
    {
        int n = weights.length;
        int[][] dp = new int[n+1][maxCap+1];
        for (int i=1; i<=n; i++)
        {
            int currentWeight = weights[i-1];
            int profitOfCurrentWeight = profits[i-1];
            int j = 1;
            while (j<=maxCap&&j<currentWeight)
            {
                dp[i][j] = dp[i-1][j];
                j++;
            }
            while(j<=maxCap)
            {
                //choose
                int case1 = dp[i-1][j-currentWeight]+profitOfCurrentWeight;
                //don't choose
                int case2 = dp[i-1][j];
                dp[i][j] = Math.max(case1, case2);
                j++;
            }
        }
        return dp[n][maxCap];
    }


    
            // Space Optimized Dynamic Programming
    // Time Complexity : O(n*m)
    // Space Complexity : O(m)
        // n is the number of weights
        // m is the maximum capacity of the bag

    // Your code here along with comments explaining your approach
        //In the previous approach, at every step, we are just using the data present in the previous row of the 2D array. So, we can say that we can also solve the problem with just one array.
        //But to not overlap the dp array, that is to not consider duplicates of weights, we reverse the direction when it comes to finding the most profit with different capacities at each new weight.
        //At every cell, we calculate the maximum of both decisions, that is by choosing "dp[j-currentWeight]+profitOfCurrentWeight" and not choosing "dp[j]". At the last column, last row, we have our answer.
    
    //Space Optimized Dynamic Programming
    private static int getKnapsackDpSpaceOptimized(int[] weights, int[] profits, int maxCap)
    {
        int n = weights.length;
        int[] dp = new int[maxCap+1];
        for (int i=1; i<=n; i++)
        {
            int currentWeight = weights[i-1];
            int profitOfCurrentWeight = profits[i-1];
            int j = maxCap;
            while(j-currentWeight>=0)
            {
                //choose
                int case1 = dp[j-currentWeight]+profitOfCurrentWeight;
                //don't choose
                int case2 = dp[j];
                dp[j] = Math.max(case1, case2);
                j--;
            }
        }
        return dp[maxCap];
    }
}