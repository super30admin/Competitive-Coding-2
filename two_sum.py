
# Time complexity - O(n)
# Space complexity - O(n)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hmap = {}
        for i,each in enumerate(nums):
            diff = target - each
            if diff in hmap:
                return [hmap.get(diff), i]
            hmap[each] = i
        return -1
        
