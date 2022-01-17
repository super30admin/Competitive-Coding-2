# Time Complexity - O(n)
# Space Complexity - O(n)

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hash_map = {}
        for i, val in enumerate(nums):
            if val in hash_map.keys():                
                return [hash_map[val], i]
            hash_map[target-val] = i
        
            