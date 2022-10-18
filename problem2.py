# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Solution:
    def twoSum(self, nums, target: int):
        hashMap = {}
        for i in range(len(nums)):
            diff = target - nums[i]
            if diff in hashMap:
                return [hashMap[diff],i]
            else:
                hashMap[nums[i]] = i    