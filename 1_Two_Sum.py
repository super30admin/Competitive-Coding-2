# Time Complexity : O(n) [n is the size of input list]

# Space Complexity : O(n) [n is the size of input list]

# Did this code successfully run on Leetcode : Yes

# Three line explanation of solution in plain english
# 1. Use a hashmap to save the differene of current num with target and index
# 2. If the num is present in the complement map, then the index from the map and the index of num is the result list
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        complement = {}
        for i, num in enumerate(nums):
            diff = target - num
            if num in complement:
                return [complement[num] ,i]
            else:
                complement[diff] = i