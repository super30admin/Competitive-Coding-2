#Time complexity: O(n)
#Space complexity: O(n)
#Leetcode: Yes

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return -1
        
        h_map = {}
        
        for i in range(len(nums)):
            if (target-nums[i]) in h_map:
                return i,h_map[target-nums[i]]
            else:
                h_map[nums[i]] = i
        return -1