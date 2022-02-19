# Time Complexity : O(N)
# Space Complexity : O(N)

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        d = {}
        for i in range(len(nums)):
            diff = target - nums[i]
            if nums[i] in d:
                return [i, d[nums[i]]]
            else:
                d[diff] = i
        return -1