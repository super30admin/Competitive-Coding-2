''' Time Complexity : O(n) 
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

'''
class Solution:
    def twoSum(self, nums, target):
        hashmap = {}

        for i in range(len(nums)):
            diff = target - nums[i]
            if diff in hashmap:
                return [hashmap[diff], i]
            hashmap[nums[i]] = i

        return []