# Problem 1:  https://leetcode.com/problems/two-sum/
# Time complexity : O(n)
# Space Complexity : O(1)

class Solution:
    def __init__():
    
    def twoSum(self,nums,target):
        hashmap = {}
        for i in range(0,len(nums)):
            diff = target - nums[i]
            if diff in hashmap:
                return [i,hashmap[diff]]
            hashmap[nums[i]] = i
        

# Problem 2: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
# Time complexity : O(mn)
# Space Complexity : O(mn)
## 0-1 knapsack problem was asked during the interview, I followed the same pattern taught in class
## Tried to identify base case , choose and not choose conditions
## called the helper directly without memo to show the iterative approach and then included memo for dp sol
## if choosing  a weight, the total available weight reduces index increases and memo is passed
## if not choose just the index increases
## return the max of both

class Solution:
    def __init__():

    def helper(W,idx,memo):
        ## base case
        if W <= 0 or idx>=len(wt):
            return 0
        if memo[W][idx] != -1:
            return memo[W][idx]
        ## choose a weight
        case1 =0
        if wt[idx] <=W:
            case1 = val[idx] + helper(W-wt[idx], idx+1,memo)
            
        ## dont choose
        case2 = helper(W, idx+1,memo)
        res = max(case1,case2)
        memo[W][idx] = res
        return res
    memo = [[-1] * len(wt) for _ in range(W + 1)]
    res = helper(W,0,memo)
    return res