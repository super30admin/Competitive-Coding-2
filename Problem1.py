#Time Complexity : O(n)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode :Yes

class Solution:
    def twoSum(self, nums, target):
        n = len(nums)

        for i in range(n):
            for j in range(i + 1, n):
                if nums[i] + nums[j] == target:
                    return [i, j]

        return [-1, -1]
