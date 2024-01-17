# Time Complexity: O(n)
# Space Complexity: O(N)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_map = {}
        for idx, n in enumerate(nums):
            counterpart = target - n
            if counterpart in num_map:
                return [idx, num_map[counterpart]]
            else:
              num_map[n] = idx
