# Time COmplexity : O(n)
# Space COmplexity : O(n)
# Leetocode successful run: yes


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
#         if length(nums) == None:
#             return [-1, -1]

#         if length(nums)<2:
# 		    return [-1,-1]
        map={}
	
        for i in range(len(nums)):

            if target - nums[i] in map:
                return [map[target-nums[i]], i]
            else:
                map[nums[i]] = i  

        return [-1, -1]