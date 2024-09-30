"""
Using hmap, time complexity is O(n) and space complexity is O(n).
"""
from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hmap = {}
        for idx, num in enumerate(nums):
            if num not in hmap:
                hmap[num] = 0
            hmap[num] = idx

        for idx, num in enumerate(nums):
            if target - num in hmap:
                return [idx, hmap[target - num]]


obj = Solution()
#obj.twoSum_two_pointer([2,7,11,15], 9)
print(obj.twoSum_two_pointer([2,7,11,15], 9))


