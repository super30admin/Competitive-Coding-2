# Time Complexity: O(n) where n is the length of the array.
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0: return []
        hash_map = dict()       # Initialize the hash map.
        for i in range(len(nums)):
            diff = target - nums[i]
            if diff not in hash_map:
                hash_map[nums[i]] = i   # value, index pair
            else:
                return [hash_map[diff], i]
        return []