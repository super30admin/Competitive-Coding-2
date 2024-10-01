# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        prev_map ={}
        for i,j in enumerate(nums):
            diff = target - nums[i]
            print(diff)
            if diff in prev_map:
                return [prev_map[diff],i]
            else:
                prev_map[j]=i
        return []