# TC: O(N) where N is the length of the input array.
# SC: O(N) to store the mappings of numbers in array and its index.

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if not nums or len(nums) == 0:
            return [-1,-1]
        
        hmap = {}
        for i in range(len(nums)):
            diff = target - nums[i]
            if diff in hmap:
                num2 = hmap.get(diff)
                return (num2, i)
            else:
                hmap[nums[i]] = (i)
        
        return [-1,-1]
                
