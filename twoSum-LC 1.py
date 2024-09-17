# Time Complexity = O(n)
# Space Complexity = O(n)

class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        if len(nums) == 0:
            return [-1, -1]
        
        arrDict = {}
        n = len(nums)
        
        for i in range(n):
            elem = nums[i]
            
            arrDict[elem] = i
            
        for i in range(n):
            if target - nums[i] in arrDict and i != arrDict[target - nums[i]]:
                return [i, arrDict[target - nums[i]]]
            
        
        return [-1, -1]