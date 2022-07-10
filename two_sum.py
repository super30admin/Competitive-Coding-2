# Time Complexity : O(N) where N is numbers in the array
# Space Complexity : O(N) where N is numbers in the array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        for i in range(len(nums)):
            c = target - nums[i]
            if c in hashmap:
                return [hashmap[c], i]
            else:
                hashmap[nums[i]] = i