"""
https://leetcode.com/problems/two-sum/description/
Problem 1: Two Sum
TC: O(n)
SC: O(n)
Approach: Use a hashmap to store the element and the index of the element. Iterate through the array and check if the
target - element is present in the hashmap. If present, return the indices of the element and the target - element.
If not present, add the element to the hashmap.
"""
from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if not nums or len(nums) == 0:
            return

        hashmap = {}
        for i in range(len(nums)):
            if (target - nums[i]) in hashmap:
                return [hashmap[target - nums[i]], i]
            hashmap[nums[i]] = i

        return []
