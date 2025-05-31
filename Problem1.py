# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hmap = {}

        for i in range(len(nums)):
            if target - nums[i] not in hmap:
                hmap[nums[i]] = i
            else:
                return [hmap[target - nums[i]], i]
