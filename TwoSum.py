# Time complexity: O(n)
# Space complexity: O(n)

import collections


class Solution:
    def twoSum(self, nums, target):
        if not nums:
            return []

        hmap = collections.defaultdict(int)

        for i in range(len(nums)):
            complement = target-nums[i]
            if complement in hmap:
                return [i, hmap[complement]]
            hmap[nums[i]] = i

        return [-1, -1]
