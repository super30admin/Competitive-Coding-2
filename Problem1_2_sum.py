# Time Complexity: O(N)
# Space Complexity: O(N)

class Solution:
    def twoSum(self, nums,target):
                
        hmap = {}
        
        for r in range(len(nums)):
            req = target-nums[r]
            
            if req in hmap:
                return [hmap[req],r]
            
            if nums[r] not in hmap:
                hmap[nums[r]] = r