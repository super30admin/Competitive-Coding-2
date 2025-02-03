# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen = {}

        for ix, num in enumerate(nums):
            if target - num in seen:
                return [ix, seen[target-num]]
            seen[num] = ix