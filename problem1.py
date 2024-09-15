# Time Complexity : O(LogN), Time complexity of 'in'
# Space Complexity :O(1),

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approachclass Solution:

#using in keyword to check if element exist so time complexity will be 'in '
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i,k in enumerate(nums):
            if target -k in nums[i+1:]:
                return(i,i+1+nums[i+1:].index(target-k))