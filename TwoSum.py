# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to create a hashmap and note all the difference with the target and if the difference is present then return the key and number.

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        d={}
        for i in range(0,len(nums)):
            if nums[i] in d:
                return (d[nums[i]], i)
            else:
                d[target-nums[i]]=i
            
        return [-1,-1]