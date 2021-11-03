
# Time Complexity : O(n) 
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        myhash = {}
        for i in range(len(nums)):
            comp = target-nums[i]
            if comp in myhash:
                return i,myhash[comp]
            myhash[nums[i]]=i
