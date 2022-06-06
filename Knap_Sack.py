# Using 2-d array, weights as rows and possible capacities(< given capacity) as columns.
# Time Complexity : O(m*n)
# Space Complexity : O(n), using only 2 arrays.
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
# Using 2-d array, weights as rows and possible capacities(< given capacity) as columns.

class Solution:
    def maxValue(self, value, weight, capacity):
        dp = [0] * (capacity+1)
        dp1 = [0] * (capacity + 1)
        for j in range(len(weight)):
            for i in range(len(dp)):
                if i < weight[j]:
                    dp1[i] = dp1[i]
                else:
                    dp1[i] = max(dp[i], value[j] + dp[i-weight[j]])
            dp = dp1[:]
        return dp[-1]


check = Solution()
weight = [1, 2, 3]
value = [60, 100, 120]
capacity = 4
print(check.maxValue(value, weight, capacity))


# Using 2-d array, weights as rows and possible capacities(< given capacity) as columns.
# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
# Using 2-d array, weights as rows and possible capacities(< given capacity) as columns.

# class Solution:
#     def maxValue(self, value, weight, capacity):
#         dp = []
#         for i in range(len(value)+1):
#             dp.append([0]*(capacity+1))
#         for i in range(1, len(value)+1):
#             for j in range(capacity+1):
#                 if j < weight[i-1]:
#                     dp[i][j] = dp[i-1][j]
#                 else:
#                     dp[i][j] = max(dp[i-1][j], value[i-1] + dp[i-1][j-weight[i-1]])
#         return dp[-1][-1]
#
#
# check = Solution()
# weight = [10, 20, 30]
# value = [60, 100, 120]
# capacity = 40
# print(check.maxValue(value, weight, capacity))


# Recursive Solution.
# class Solution:
#     def helper(self, value, weight, index,  capacity, profit):
#         if index > len(weight) - 1 or capacity < 0:
#             return profit, capacity
#         case1 = self.helper(value, weight, index + 1, capacity, profit)
#         case2 = self.helper(value, weight, index + 1, capacity - weight[index], profit + value[index])
#         if case1[1] >= 0 and case2[1] < 0:
#             return case1
#         elif case1[1] < 0 and case2[1] >= 0:
#             return case2
#         else:
#             return max(case1, case2)
#
#     def maxValue(self, value, weight, capacity):
#         return self.helper(value, weight, 0, capacity, 0)[0]
#
#
# check = Solution()
# weight = [10, 20, 30]
# value = [60, 100, 120]
# capacity = 60
# print(check.maxValue(value, weight, capacity))
