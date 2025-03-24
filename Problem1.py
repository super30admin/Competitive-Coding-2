'''
Time Complexity:
For loop can run max len(nums) iterations
nums[i] in temp_map is O(1) complexity

Hence Time Complexity = O(N) where N is the length of nums array.

Space Compexity:
Map will have max len(nums) elements. 
Space Complexity = O(N) where N is the number of elements in nums array.
'''

from typing import List

def twoSum(nums: List[int], target: int) -> List[int]:
        temp_map = {}
        for i in range(0, len(nums)):
            if nums[i] in temp_map:
                return[i, temp_map[nums[i]]]
            diff = target-nums[i]
            temp_map[diff] = i