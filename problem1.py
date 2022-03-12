TC:O(n)
SC:O(n)

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        if nums is None:
            return []

        hmap = {}
        for index, num in enumerate(nums):
            hmap[num] = index

        for index, num in enumerate(nums):
            if target - num in hmap and index != hmap[target - num]:
                return [index, hmap[target - num]]
