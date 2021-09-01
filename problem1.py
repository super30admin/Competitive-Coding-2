#time- O(n) traversing once
#space- O(n) using hashmap
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        #hashmap to store two sum
        h={}
        for i in range(0,len(nums)):
            if target-nums[i] in h:
                return [h[target-nums[i]],i]
            h[nums[i]]=i
            
