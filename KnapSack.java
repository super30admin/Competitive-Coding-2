// The approach is that either we chose the weight or we don't.
// if we don't then we don't need to subtract the weight from the amount,else we have to.
// it is given that we have to move forward. we cannot replenish the weights.

// recursion ->
// Time complexity = O(2^(W+N))
// space complexity = O(1)


// dynamic programming -> 2d array
// Time complexity = O(WN)
// space complexity = O(WN)

// dynamic programming -> 1d array
// Time complexity = O(WN)
// space complexity = O(N)

//Input: N = 3, W = 4, profit[] = {1, 2, 3}, weight[] = {4, 5, 1}
//Output: 3
//
// maxmimize the profit.
// and weighti + wei <= W



// W=4, profit=[500,500,600], weight=[2,2,3]
// greedy =600.
// non-greedy = exhaustive = 1000.

// we have to go with exhaustive.
public class KnapSack{
    public static void main(String[] args) {
        // input
        int profit[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int W = 50;
     //   System.out.println("Profit is " + recursion(profit, weight, 0, W));
     System.out.println("Profit is " + dynamicProgramming(profit, weight, 0, W));
    }
/**
    private static int recursion(int[] profit, int[] weight, int idx, int amount) {
       // base
       System.out.println("idx is " + idx);
       if( amount==0 || idx > weight.length-1  ) {// we have breached the amount
        return 0;
       }
       // logic
       if(weight[idx]>amount) {
        return recursion(profit, weight, idx+1, amount);
       }
       int case1 = recursion(profit, weight, idx+1, amount);// stay with my idx.
       int case2 = profit[idx] + recursion(profit, weight, idx+1, amount-weight[idx]);// use the weight.
       return Math.max(case1, case2);
    }
*/


    // private static int dynamicProgramming(int[] profit, int[] weight, int idx, int amount) {
    //     int[][]dp = new int[weight.length+1][amount+1];
    //     for(int i=0;i< weight.length+1;i++) {
    //         for(int j=0;j< amount+1;j++) {
    //             if(i==0 || j==0) {
    //                 dp[i][j] = 0;
    //             } else {
    //                 if(weight[i-1] > j) {
    //                     dp[i][j] = dp[i-1][j];
    //                 } else {
    //                     dp[i][j] = Math.max(dp[i-1][j], profit[i-1] + dp[i-1][j- weight[i-1]]);
    //                 }    
    //             }
    //         }
    //     }
    //     return dp[weight.length][amount];
    // }

    private static int dynamicProgramming(int[] profit, int[] weight, int idx, int amount) {
        int[]dp = new int[amount+1];
        for(int i=0;i< weight.length+1;i++) {
            for(int j=amount;j>=0;j--) {
                if(i==0 || j==0) {
                    dp[j] = 0;
                } else {
                    if(weight[i-1] <= j) {
                        dp[j] = Math.max(dp[j], profit[i-1] + dp[j- weight[i-1]]);
                }
            }
        }

    }
    return dp[amount];
}



}



