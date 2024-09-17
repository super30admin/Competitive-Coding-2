# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        a = {}
        
        for i in range(len(nums)):
            if nums[i] in a:
                return [a[nums[i]],i]
            else:
                a[target-nums[i]] = i
                
        return [-1,-1]
                
                
                
        