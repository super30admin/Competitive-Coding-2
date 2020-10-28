"""
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
We will make a dictionary. While iterating through the array, we will calculate the compliment for the value
and the  target. If the compliment exists in the dictionary, we return the current index as well as the value
 from dict[compliment]. If not, we will insert the number in the dictionary
"""


class Solution(object):
    def twoSum(self, nums, target):
        d = {}
        for i in range(len(nums)):
            temp = target-nums[i]
            if temp in d:
                return([i, d[temp]])
            d[nums[i]] = i
