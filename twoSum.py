# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Solution(object):
    def twoSum(self, nums, target):
        dictionary = dict()
        for i in range(len(nums)):
            c = target - nums[i]
            if c in dictionary:
                return dictionary[c], i
            dictionary[nums[i]]=i
r = Solution()
nums = [2, 7, 11, 15]
target = 9
print(" indices of the two numbers adding to target are:", r.twoSum(nums, target))

