# Approach: 1-pass
# Use a hash map to store the number and its index and also keep checking if the difference a = target-b is in the hashmap or not. 

# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        hmap = {}
        
        for i in range(n):
            diff = target - nums[i]
            
            if diff not in hmap:
                hmap[nums[i]] = i
            else:
                return [i,hmap[diff]]
            
            
        