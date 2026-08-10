# https://leetcode.com/problems/two-sum/description/

# Time complexity: O(n) 
# Space complexity: O(n)
# Explanation: Instead of two traversal we can use a HashMap to store indices of different integer values; when we find a "complement" we can simply return the indices.

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nums_map = {}
        for i in range(0, len(nums)):
            comp = target - nums[i]
            if comp in nums_map:
                return [i, nums_map[comp]]
            nums_map[nums[i]] = i
