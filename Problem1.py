# Time Complexity : O(n) 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        sumMap = {}
        
        for i in range(len(nums)):
            cmp = target- nums[i]
            if cmp in sumMap:
                return (sumMap[cmp],i)
            sumMap[nums[i]]= i
            
        return -1 