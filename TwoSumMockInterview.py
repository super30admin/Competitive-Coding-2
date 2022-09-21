class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        complement_map = {}
        
        for i in range(len(nums)):
            if target - nums[i] not in complement_map:
                complement_map[nums[i]] = i
            else:
                return [complement_map[target-nums[i]], i]
            
        # Time Complexity: O(n)
        # Space ComplexityL O(n)