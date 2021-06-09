"""
https://leetcode.com/problems/two-sum/

Two-pass Hash table

Time Complexity: O(n)
Space Complexity: O(n)
It works on Leetcode.
I encountered errors due to negative inputs as I was using absolute function but as target is always greater than inputs,
no need to use abs().
"""


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashTable = {}
        for i in range(len(nums)):
            hashTable[nums[i]] = i

        for i in range(len(nums)):
            if (target - nums[i]) in hashTable and i != hashTable[target - nums[i]]:
                return [i, hashTable[target - nums[i]]]