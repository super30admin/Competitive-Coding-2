//
//  0-1Knapsack.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/20/26.
//

/*
 greedy wouldn't work.
 so, have exhaustive approach. come up with all the possibilities of choose and not choose
 weight array - [10, 20, 30]. Weightts can be chosend only once
 profit array = [60, 100, 120]
 weight allowed = 50
 achieve maximum profit while putting elements within the capacity.
 greedy -> first choose 30 to get max profit 120, then choose 20 to have 100 more. profit - 220 greedy works for capacity 50.
 If capacity is changed to 30 -> I choose 30, profit attained - 120. Now can't choose any other.
 But if I decide to choose 10 and 20 -> total profit - 160.
 So, greedy doesn;t work. Chooseing the maximum profit element wouldn't always give us the maximum profit.
 
 If greedy doesn;t work, we have to be exhaustive.
 Have all the possibilities of choose and not choose.
 
 eg [10, 20, 30, 40]
 At every node, we have 2 options - choose and don't choose.
 If we choose an element, then add it's weight and we will be left with rest of the elements.
 time complexity - 2^(m + n) -> m -> no of elements in the weight array, n -> capacity
 space complexity - (m + n) recursive stack space
 
 We will be encountering repeated subproblems. So, can use DP. We have two input parameters - weights array and the capacity. So, use 2D matrix
 In matrix, at each place, choose maximum between choose and no choose scenario.
 time complexity - O(m * n)
 space complexity - O(m * n)
 
 
 */
class ZeroOneKnapsack {
    
    var profit = [60, 100, 120]
    var weight = [10, 20, 30]
    let capacity = 50
    
    init() {
        let totalProfit = helper(profit: [60, 100, 120], weight: [10, 20, 30], capacity: 50, i: 0, totalProfit: 0)
        print("ZeroOneKnapsack totalProfit \(totalProfit)")
        
        let profit = findMaximumProfitUsingDP()
        print("profit using DP \(profit)")
    }
    
    //i - index on weight
    func helper(profit: [Int], weight: [Int], capacity: Int, i: Int, totalProfit: Int) -> Int {
        //base case
        if (i >= weight.count) {
            return totalProfit
        }
        
        //logic
        //no choose
        let case0 = helper(profit: profit, weight: weight, capacity: capacity, i: i + 1, totalProfit: totalProfit)
        
        //choose case
        var case1 = 0
        //only if the current weight is smaller than the capacity
        if (weight[i] <= capacity) {
            case1 = helper(profit: profit, weight: weight, capacity: capacity - weight[i], i: i + 1, totalProfit: totalProfit + profit[i])
        }
        
        return max(case0, case1)
        
    }
    
    func findMaximumProfitUsingDP() -> Int {
        
        let m = weight.count
        let n = capacity
        var dp = Array(repeating: Array(repeating: 0, count: n + 1), count: m + 1)
        
        for i in 1...m {
            for j in 1...n {
                if (j < weight[i-1]) {
                    dp[i][j] = dp[i-1][j]
                } else {
                    dp[i][j] = max(dp[i-1][j], profit[i-1] + dp[i-1][j-weight[i-1]])
                }
            }
        }
        
        return dp[m][n]
    }
}
