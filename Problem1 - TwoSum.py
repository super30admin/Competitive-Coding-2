class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        #Time Complexity: O(nums)
        #Space Compllexity: O(nums)
        
        hash_map = {}
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in hash_map:
                return [hash_map[complement], i]
            else:
                hash_map[nums[i]] = i