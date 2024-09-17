from typing import List

# Recursive Solution
# Time Complexity : O(2^n) where n is length of wt or val array
# Space Complexity : O(1) only recursive stack is used
# class Solution:
#     def getMaxValue(self, wt: List[int], val: List[int], W: int) -> int:
#         if wt == None or len(wt) == 0 or val == None or len(val) == 0 or W == 0:
#             return 0
#         return self.helper(wt, val, W, 0, 0)
        

#     def helper(self,wt: List[int], val: List[int], W: int, index: int, earnings: int) -> int:
#         if W == 0:
#             return earnings
#         if W < 0 or index == len(wt):
#             return -1
#         # don't choose
#         case1 = self.helper(wt, val, W , index + 1, earnings)

#         # choose
#         case2 = self.helper(wt, val, W - wt[index], index + 1, earnings + val[index])

#         return max(case1, case2)

class Solution:
    def getMaxValue(self, wt: List[int], val: List[int], W: int) -> int:
        if wt == None or len(wt) == 0 or val == None or len(val) == 0 or W == 0:
            return 0
        dp = [[0 for j in range(W + 1)] for i in range(len(val) + 1)]
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if j < wt[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i-1][j-wt[i-1]] + val[i-1])

        return dp[len(dp)-1][len(dp[0])-1]


obj = Solution()
print(obj.getMaxValue([10,20,30],[60,100,120],50))

# Time Complexity: O(W * n) where n is length of val
# Space Complexity: O(W * n) where n is length of val

