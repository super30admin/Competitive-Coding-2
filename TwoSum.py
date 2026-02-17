# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : If complement already in map then return the index else store complement.

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = dict()

        for i, num in enumerate(nums):
            if target-num in map:
                return [i, map[target-num]]
            
            map[num] = i

        return [-1, -1]       