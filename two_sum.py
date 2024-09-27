"""
Problem: Two sum
Leetcode: https://leetcode.com/problems/two-sum/
Solution: Use Hashmap to check if (target-nums[i]) is present in keys
Time Complexity: O(n), n is the length of nums array
Space Complexity: O(n) for items stored in the hash table
"""


class Solution(object):
    def twoSum(self, nums, target):
        # Base case
        if nums is None or len(nums) is 0:
            return -1

        # Define a dictionary
        hashmap = {}

        for i in range(len(nums)):
            temp = target - nums[i]
            if temp in hashmap.keys():
                return [hashmap[temp], i]
            else:
                hashmap[nums[i]] = i
        return [-1, -1]


obj = Solution()
print(obj.twoSum([2,7,11,15], 9))
print(obj.twoSum([3,2,4], 6))
print(obj.twoSum([3,3], 6))
print(obj.twoSum([], 6))