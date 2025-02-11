'''
// Time complexity:
Problem 1 - O(m*n)
Problem 2 - O(n)
// Space Complexity:
Problem 1 - O(m*n)
Problem 2 - O(n)
'''
## Problem: Knapsack problem
# As the problem is divided into sub problems which are solved repeatedly we use dynamic programming. 
# We decide whether to pick a weight or not.
# Case 0: When we don't choose the weight we use the value from the cell above.
# Case 1: When we choose the weight we take the MAX of values from the cell above and compare previous 
# row value
# Return the last value in the dp matrix.
class Solution(object):
    def knapsack(self, profit, weights, capacity):
        m = len(weights)
        n = capacity
        dp = [[0 for i in range(capacity + 1)] for j in range(m + 1)]
        for i in range(0, m):
            for j in range(0, capacity):
                if j <= weights[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = max(dp[i-1][j], profit[i-1] + dp[i-1][j - weights[i-1]])
        return dp[m][n]

    def solution(self, profit, weights, capacity):
        profit = [60, 100, 120]
        weights = [10, 20, 30]
        capacity = 50
        result = self.knapsack(profit, weights, capacity)
        print(result)
        return result   

## Problem: Two Sum
# Create a map to store the element & index of the array, in case we have duplicates we will store the 
# element in a second map along with its index.
# Take the difference of the target and the current number, if the difference exists we will return the
# indices for both elements from the first map
# If the current number and the difference is the same then we look for it in the second map and return
# index of the first number from first map and second number from second map.
# If it doesn't exist we return [-1,-1]
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if len(nums) == 0 or nums == 0: return [-1,-1]
        map_1 = {}
        map_2 = {}
        n = len(nums)
        for i in range(0,n):
            if nums[i] not in map_1:
                map_1[nums[i]] = i
            else:
                map_2[nums[i]] = i

        for i in range(0,n):
            comp = target - nums[i]
            if comp in map_1 and comp != nums[i]:
                return [map_1[nums[i]], map_1[target - nums[i]]]
            elif comp == nums[i] and comp in map_2 :
                return [map_1[nums[i]], map_2[comp]]
        return [-1, -1]  

