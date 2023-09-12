class Solution:
    def twoSum(self, nums, target):
        dict = {}

        for i,v in enumerate(nums):
            if target-v in dict:
                return [dict[target-v],i]
            else:
                dict[v] = i

        return []
    
# TC: O(n)
# SC: O(n)
        