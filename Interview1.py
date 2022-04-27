'''https://leetcode.com/problems/two-sum/'''

# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hm = {}
        
        for i in range(len(nums)):
            if target-nums[i] in hm:
                return [i, hm[target-nums[i]]]
            hm[nums[i]] = i
        
        return None
        