# Two Sum
# Time Complexity - O(n)
# Space Complexity - O(n)

class Solution:
    
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        h = {}
        for i in range(len(nums)):
            if nums[i] not in h:
                h[target-nums[i]] = i
            else:
                return [h[nums[i]],i]
