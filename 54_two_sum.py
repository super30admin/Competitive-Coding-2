# Time complexity - O(n)
# Space complexity - O(n)

# Approach - Maintain a hashmap with (num : idx) pair, and keep looking till we find
# (target - num) in hashmap

from typing import List
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashMap = {}

        for i in range(len(nums)):
            if (target - nums[i]) in hashMap:
                return [hashMap[target - nums[i]], i]
            else:
                hashMap[nums[i]] = i