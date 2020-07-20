# APPROACH 1
# Time Complexity : O(n), n: length of nums list
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None (Initially tried sorting but would lose the index value)
#
#
# Your code here along with comments explaining your approach
# 1. For each element of the nums list, check if target - element present in hashmap -> means their sum is target, then return their indices
# 2. Else store the current element's value and index in hashmap
# 3. 


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        if not nums:
            return [-1, -1]
        
        hashmap = {}
        
        for ind in range(len(nums)):
            if target - nums[ind] in hashmap:
                return [hashmap[target - nums[ind]], ind]
            else:
                hashmap[nums[ind]] = ind
                
        return [-1, -1]
