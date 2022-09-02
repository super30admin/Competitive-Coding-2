'''
1. Two Sum
TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(N)
LEETCODE: YES
DIFFICULTIES: Nope
'''

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        t = {nums[0]: 0}
        n = len(nums)
        
        for i in range(1, n):
            diff = target - nums[i]
            if diff in t.keys():
                return sorted([i, t[diff]])
            else:
                t[nums[i]] = i
            
