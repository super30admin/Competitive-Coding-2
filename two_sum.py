# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def twoSum(self, nums: List[int], target: int):
        res = {}

        for i in range(len(nums)):
            k = target - nums[i]

            if k in res:
                return [res[k], i]
            res[nums[i]] = i

sc = Solution()
nums = [2,7,5,6]
target = 9
print(sc.twoSum(nums, target))