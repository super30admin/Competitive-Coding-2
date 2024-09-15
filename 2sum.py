'''
Time Complexity: O(n)
Space Complexity: O(n)
'''
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen_dict={}
        for index, val in enumerate(nums):
            diff=target-val
            if diff in seen_dict:
                return [seen_dict[diff],index]
            seen_dict[val]=index
        
        return [-1,-1]