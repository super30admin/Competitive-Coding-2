# Time Complexity : O(len(nums))
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No


class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dictn={}
        ans=[]
        for i in range(len(nums)):
            diff=target-nums[i]
            if diff in dictn:
                ans.append(i)
                ans.append(dictn[diff])
            else:
                dictn[nums[i]] = i
        return ans