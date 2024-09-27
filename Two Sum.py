""""// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
class Solution:
    def twoSum(self, nums, k):
        dic = {}
        for i in range(len(nums)):
            if k - nums[i] in dic:
                return [dic[k-nums[i]],i]
            else:
                dic[nums[i]] = i
Obj=Solution()
print(Obj.twoSum([2,7,11,15],9))