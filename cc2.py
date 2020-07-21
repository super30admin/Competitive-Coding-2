# problem 1 : 1. Two Sum : https://leetcode.com/problems/two-sum/
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        diff_mapping = {}
        for index, num in enumerate(nums) :
            if num in diff_mapping :
	            return [diff_mapping[num], index]
            diff_mapping[target-num] = index
        return False


# problem 2 : 0-1 Knapsack Problem : https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
# Time Complexity : O(n * W) where W is the number of weights and n is capacity
# Space Complexity : O(n * W)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

def maxProfit(profit, weights, capacity):
    n = len(weights)
    res = [[0 for i in range(capacity+1)] for j in range(n+1)]
    for i in range(n+1):
      for j in range(capacity+1):
        if i == 0 or j == 0:
          res[i][j] = 0
        elif weights[i-1] <= j:
          res[i][j] = max(profit[i-1] + res[i-1][j - weights[i-1]], res[i-1][j])
        else:
          res[i][j] = res[i-1][j]
    return res[-1][-1]
p = [1,2,6]
w = [2,3,5]
c = 8
print(maxProfit(p, w, c))