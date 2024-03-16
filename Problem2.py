# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        prev = {} #key,value

        for i,n in enumerate(nums):
            diff = target - n
            if diff in prev:
                return [prev[diff], i]
            else:
                prev[n] = i