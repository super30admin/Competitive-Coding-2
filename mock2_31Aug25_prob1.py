'''
Two Sum Problem: We iterate over the array and check if target-curr_element
is present in map. Maintain a map to store {element:idx} 
Time Complexity : O(N)
Space Complexity : O(N)
'''
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nums_map = {} # {nums : idx}
        for i in range(len(nums)):
            if (target - nums[i]) in nums_map:
                return [nums_map[target-nums[i]], i] # found the answer
            nums_map[nums[i]] = i

        return [-1,-1] # in case not found

