"""
Problem : 1

Time Complexity : O(n)
Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

We create a hash table to store the number the in input array hashed to their index
we try finding the difference between target and that number in the hash table
if we find the number then returning the index of the current number and the one we found in the hash table

"""


# Two Sum

class Solution(object):
    def twoSum(self, nums, target):
        dct={}
        for i in range(len(nums)):
            diff=target-nums[i]
            if diff in dct:
                return nums.index(diff),i
            dct[nums[i]]=i