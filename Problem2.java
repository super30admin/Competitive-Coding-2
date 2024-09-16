/*
# Recursive
def knap(value, weight, W):
    if len(value) != len(weight) or len(value) == 0 or W < 0:
        return -1

    def helper(value, weight, W, max_value, i):
        if W < 0:
            return -1
        if i == len(value) or W == 0:
            return max_value
        
        case1 = helper(value, weight, W-weight[i], max_value+value[i], i+1)
        case2= helper(value, weight, W, max_value, i+1)
        
        return max(case1, case2)

    return helper(value, weight, W, 0, 0)

# DP
def knap(value, weight, W):
    if len(value) != len(weight) or len(value) == 0 or W < 0:
        return -1
    dp = [[-1] * (W+1)] * (len(value)+1)
    
    def helper(value, weight, W, max_value, i):
        if W < 0:
            return -1
        if i == len(value) or W == 0:
            return max_value
        if dp[i+1][W] == -1:
            case1 = helper(value, weight, W-weight[i], max_value+value[i], i+1)
            case2= helper(value, weight, W, max_value, i+1)
            
            dp[i+1][W] = max(case1, case2)
        return dp[i+1][W]
        
    helper(value, weight, W, 0, 0)
    return dp[len(value)][W]


value = [60, 100, 120]
weight = [10, 20, 30]
W = 50
print(knap(value, weight, W))

*/

// Time - O(W*n) where n is array size and W is given weight
// Space - O(W*n)
// Approach - I maintained the dp array where I stored the results for particular input and avoided recalculating the result again and
// again in case of same recursion tree

class Solution{
    public int knapsack(int[] value, int[]weight, int W){
        if value == null || value.length != weight.length || W < 0{
            return -1;
        }
        int[][] dp = new int[value.length+1][W+1];
        helper(value, weight, W, 0, 0, dp);
        return dp[value.length+1][W+1];
    
    }
    private int helper(int[] value, int[]weight, int W, int max_value, int i, int[][] dp){
        if (W < 0){
            return -1;
        }
        
        if (i == len(value) or W == 0){
            return max_value;
        }
        
        if (dp[i+1][W] == 0){
            case1 = helper(value, weight, W-weight[i], max_value+value[i], i+1);
            case2= helper(value, weight, W, max_value, i+1);
            
            dp[i+1][W] = max(case1, case2);
        }
        
    return dp[i+1][W];
    }
}
