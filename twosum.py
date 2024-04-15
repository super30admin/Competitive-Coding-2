# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution(object):
    def twoSum(self, nums, target):
        dic = {}
        for i, num in enumerate(nums):
            diff = target - num
            if diff in dic:
                return [dic[diff], i]
            dic[num]=i
        return [-1, -1]

obj = Solution()
input= [2,11,15,7]
target = 9
indices = obj.twoSum(input,target)
print(indices)