# Time Complexity :O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        aid = {}
        #check if you found a number that is equals to target - the on you are at 
        for index,val in enumerate(nums):
            if (target-val) in aid:
                return [aid[target-val],index]
        #else save that number and its index
            else:
                aid[val] = index
                