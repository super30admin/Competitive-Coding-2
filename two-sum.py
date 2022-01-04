'''
TC: O(n)
SC: O(n)

Intuition: Check if target - curr in hmap, if its there return the result else store the idx

'''
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nlen = len(nums)
        if not nlen:
            return [-1, -1]
        hmap = dict()
        
        for idx in range(nlen):
            rem = target - nums[idx]
            if rem in hmap:
                return [hmap[rem], idx]
            hmap[nums[idx]] = idx
        
        return [-1, -1]
        
        